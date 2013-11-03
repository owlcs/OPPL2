tree grammar OPPLTypeEnforcement;

options {
  language = Java;
  tokenVocab = OPPLScript; 
  ASTLabelType = OPPLSyntaxTree;
  filter=true;
}

 

@members{
  private  SymbolTable symtab;
  private TypesEnforcer typesEnforcer;
  private  ErrorListener errorListener;
  public OPPLTypeEnforcement(TreeNodeStream input, SymbolTable symtab,TypesEnforcer typesEnforcer, ErrorListener errorListener) {
    this(input);
    if(symtab==null){
    	throw new NullPointerException("The symbol table cannot be null");
    }
    if(errorListener == null){
    	throw new NullPointerException("The error listener cannot be null");
    }
    if(typesEnforcer == null){
      throw new NullPointerException("The type enforcer listener cannot be null");
    }
    this.symtab = symtab;
    this.typesEnforcer = typesEnforcer;
    this.errorListener = errorListener;
  }
  
  
  public TypesEnforcer getTypesEnforcer(){
    return this.typesEnforcer;
  }
  
  public ErrorListener getErrorListener(){
  	return this.errorListener;
  }
  
  public SymbolTable getSymbolTable(){
  	return this.symtab;
  }
  
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        getErrorListener().recognitionException(e, tokenNames);
  }
  
  protected void mismatch (IntStream input, int ttype, BitSet follow) throws RecognitionException {
    throw new MismatchedTokenException(ttype,input);
  }
  

  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException{
    throw e;
  }
  
}

@rulecatch{
  catch(RecognitionException exception){
    if(errorListener!=null){
      errorListener.recognitionException(exception);
    }
  }
  
  catch(RewriteEmptyStreamException exception){
    if(errorListener!=null){
      errorListener.rewriteEmptyStreamException(exception);
    }
  }
}

@header {
  package org.coode.parsers.oppl;
  import org.semanticweb.owlapi.model.OWLObject;
  import org.semanticweb.owlapi.model.OWLAxiom;
  import org.coode.parsers.oppl.TypesEnforcer;
  import org.coode.parsers.SymbolTable;
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.oppl.TypesEnforcer;
  import org.coode.parsers.ManchesterOWLSyntaxTree;
  import org.coode.parsers.Type;
  import org.coode.parsers.Symbol;
  import org.coode.parsers.OWLType;
}



// START: root
bottomup // match subexpressions innermost to outermost
    :   expressionRoot // only match the start of expressions (root EXPRESSION) 	   
    | 	axiom     
    ;
 
expressionRoot // invoke type computation rule after matching EXPRESSION
    :   ^(EXPRESSION expression) {$EXPRESSION.setEvalType($expression.type);} // annotate AST
    ;
// END: root 


axiom returns  [Type type, ManchesterOWLSyntaxTree node] 
@after 
			{
				$start.setEvalType($type); 
				$node = $start;				
			} // do after any alternative
:
		^(SUB_CLASS_AXIOM  ^(EXPRESSION  subClass = expression) ^( EXPRESSION  superClass = expression))
		{
			$type = this.getSymbolTable().getSubClassAxiomType($start, subClass.node, superClass.node);
			getTypesEnforcer().enforceSubClassOfAxiomTypes($start,subClass.node, superClass.node);
		}
	|  ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION lhs = expression) ^(EXPRESSION  rhs = expression))
	   {
	    $type = this.getSymbolTable().getEquivalentAxiomType($start, lhs.node, rhs.node);
	    getTypesEnforcer().enforceEquivalentToAxiomTypes($start,lhs.node, rhs.node);
	   }	
	| ^(INVERSE_OF ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION anotherProperty = IDENTIFIER))
	{
	   $type = this.getSymbolTable().getInverseOfAxiomType($start, p, anotherProperty);
	   getTypesEnforcer().enforceIverserOfAxiomTypes($start,p, anotherProperty);
	}
  | ^(DISJOINT_WITH_AXIOM ^(EXPRESSION lhs =  expression) ^(EXPRESSION rhs = expression)){
     $type = this.getSymbolTable().getDisjointAxiomType($start, lhs.node, rhs.node);
     getTypesEnforcer().enforceDisjointWithAxiomTypes($start,lhs.node, rhs.node);
  }	  
	|	^(SUB_PROPERTY_AXIOM ^(EXPRESSION  subProperty = expression) ^(EXPRESSION superProperty = unary))
		{
			$type = this.getSymbolTable().getSubPropertyAxiomType($start, subProperty.node, superProperty.node);
			getTypesEnforcer().enforceSubPropertyAxiomTypes($start,subProperty.node, superProperty.node);
		}		
	| ^(ROLE_ASSERTION ^(EXPRESSION  subject = IDENTIFIER) ^(EXPRESSION  predicate = propertyExpression) ^(EXPRESSION object = unary)){
	   $type = this.getSymbolTable().getRoleAssertionAxiomType($start, subject, predicate.node, object.node);
	   getTypesEnforcer().enforceRoleAssertionAxiomTypes($start,subject, predicate.node, object.node);
	 }
	|  ^(TYPE_ASSERTION ^(EXPRESSION  description = expression) ^(EXPRESSION subject = IDENTIFIER))
	{
	   $type = this.getSymbolTable().getClassAssertionAxiomType($start,description.node, subject);
	   getTypesEnforcer().enforceTypeAssertionAxiomTypes($start,description.node,subject);
	} 
	| ^(DOMAIN ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION domain = expression))
	 {
	   $type = this.getSymbolTable().getDomainAxiomType($start, p, domain.node);
	   getTypesEnforcer().enforceDomainAxiomTypes($start,p,domain.node);
	 }
	 | ^(RANGE ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION range = expression))
   {
     $type = this.getSymbolTable().getRangeAxiomType($start, p, range.node);
     getTypesEnforcer().enforceRangeAxiomTypes($start,p,range.node);
   }
   | ^(SAME_AS_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
    $type = this.getSymbolTable().getSameIndividualsAxiomType($start, anIndividual, anotherIndividual);
    getTypesEnforcer().enforceSameIndividualsAxiomTypes($start,anIndividual,anotherIndividual);
   }
    | ^(DIFFERENT_FROM_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
    $type = this.getSymbolTable().getDifferentIndividualsAxiomType($start, anIndividual, anotherIndividual);
    getTypesEnforcer().enforceDifferentIndividualsAxiomTypes($start,anIndividual,anotherIndividual);
   }
	 | ^(UNARY_AXIOM FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
	 {
	   $type = this.getSymbolTable().getFunctionalPropertyType($start, p);
	   getTypesEnforcer().enforceFunctionalPropertyAxiomTypes($start,p);
	 }
	 | ^(UNARY_AXIOM INVERSE_FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getInverseFunctionalPropertyType($start, p);
     getTypesEnforcer().enforceInverseFunctionalPropertyAxiomTypes($start,p);
   }
    | ^(UNARY_AXIOM IRREFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getIrreflexivePropertyType($start, p);
     getTypesEnforcer().enforceIrreflexivePropertyAxiomTypes($start,p);
   }
   | ^(UNARY_AXIOM REFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getReflexivePropertyType($start, p);
     getTypesEnforcer().enforceReflexivePropertyAxiomTypes($start,p);
   }
   | ^(UNARY_AXIOM SYMMETRIC ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getSymmetricPropertyType($start, p);
     getTypesEnforcer().enforceSymmetricPropertyAxiomTypes($start,p);
   } 
    | ^(UNARY_AXIOM TRANSITIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getTransitivePropertyType($start, p);
     getTypesEnforcer().enforceTransitivePropertyAxiomTypes($start,p);
   }
   | ^(NEGATED_ASSERTION a =axiom){
     $type = this.getSymbolTable().getNegatedAssertionType($start, a.node);
     getTypesEnforcer().enforceNegatedAssertionTypes($start,a.node);
   }     
;

expression returns  [Type type, ManchesterOWLSyntaxTree node]
@after 
		{ 
			$start.setEvalType($type); 
			$node = $start;
			
		} // do after any alternative
	: 
		 ^(DISJUNCTION  disjuncts +=conjunction+) 
		 {	
		 		List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_disjuncts.size());
		 	 	for(Object node :list_disjuncts){
		 	 		nodes.add(((conjunction_return) node).node);
		 	 	}
		 		$type = this.getSymbolTable().getDisjunctionType($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 		getTypesEnforcer().enforceDisjunctionTypes($start,nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 	}
		|  ^(PROPERTY_CHAIN  chainItems+=expression+)
		  {
		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_chainItems.size());
        for(Object item  :list_chainItems){
          nodes.add(((expression_return) item).node);
        }
		    $type = this.getSymbolTable().getPropertyChainType($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		    getTypesEnforcer().enforcePropertyChainTypes($start,nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		  }
		| conjunction  
		{
			$type = $conjunction.type;
			
		}
		| complexPropertyExpression 
		{
			$type = $complexPropertyExpression.type;
			
		}
		
	; 

conjunction  returns [Type type, ManchesterOWLSyntaxTree node]
@after 
			{ 
				$start.setEvalType($type); 
				$node = $start;				
			} // do after any alternative
	:
	^(CONJUNCTION  conjuncts+=unary+)	
	{	
		 		List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_conjuncts.size());
		 	 	for(Object node :list_conjuncts){
		 	 		nodes.add(((unary_return) node).node);
		 	 	}
		 		$type = this.getSymbolTable().getConjunctionType($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 		getTypesEnforcer().enforceConjunctionTypes($start,nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()])); 
	}
	| unary {
		$type = $unary.type;
		
	}
;

unary returns [Type type, ManchesterOWLSyntaxTree node]
@after 
			{ 
				$start.setEvalType($type); 
				$node = $start;
				
			} // do after any alternative
:
		IDENTIFIER 
			{
				Symbol symbol = this.getSymbolTable().resolve($IDENTIFIER);
				$type = symbol==null ? null: symbol.getType();
				
			}
		| ^(NEGATED_EXPRESSION e = expression) 
			{
				$type = this.getSymbolTable().getNegatedClassExpressionType($start,e.node);
		    getTypesEnforcer().enforceNegatedClassExpression($start,e.node);
			}	
		| qualifiedRestriction 	
			{
				$type = $qualifiedRestriction.type;
			
			} 
		| ENTITY_REFERENCE 
			{
				Symbol symbol = this.getSymbolTable().resolve($ENTITY_REFERENCE);
				$type = symbol==null ? null: symbol.getType();
				
			}
		| ^(CONSTANT  value=. constantType = IDENTIFIER?) {
				$type = OWLType.OWL_CONSTANT;
								
			}
	;


propertyExpression  
returns [Type type, ManchesterOWLSyntaxTree node]
@after 
			{ 
				$start.setEvalType($type); 
				$node = $start;			
			} // do after any alternative
:
      IDENTIFIER
      {
        Symbol symbol = this.getSymbolTable().resolve($IDENTIFIER);
        $type = symbol==null ? null: symbol.getType();
        
      }
    | complexPropertyExpression
      {
        $type = $complexPropertyExpression.type;
        
      }
    ;

complexPropertyExpression
returns [Type type, ManchesterOWLSyntaxTree node]
@after { 
          $start.setEvalType($type); 
          $node = $start;
       } // do after any alternative
:
	^(INVERSE_OBJECT_PROPERTY_EXPRESSION p = complexPropertyExpression)
	{
		$type = this.getSymbolTable().getInversePropertyType($start, p.node);
		getTypesEnforcer().enforceInverseObjectPropertyTypes($start,p.node);
	}
	| ^(INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER)
	{
				Symbol symbol = this.getSymbolTable().resolve($IDENTIFIER);
				$type = this.getSymbolTable().getInversePropertyType($start, $IDENTIFIER);
				getTypesEnforcer().enforceInverseObjectPropertyTypes($start,$IDENTIFIER);
	}
	;

qualifiedRestriction returns [Type type , ManchesterOWLSyntaxTree node]
@after { 
          $start.setEvalType($type); 
          $node = $start;
        } // do after any alternative
	:
					^(SOME_RESTRICTION p= propertyExpression  f= expression) 
					{
						$type = this.getSymbolTable().getSomeValueRestrictionType($start,p.node,f.node);
						getTypesEnforcer().enforceSomeValueRestrictionTypes($start,p.node,f.node);
					}				
				|	^(ALL_RESTRICTION  p = propertyExpression f= expression) 
				{
					$type = this.getSymbolTable().getAllValueRestrictionType($start,p.node,f.node);
					getTypesEnforcer().enforceAllValueRestrictionTypes($start,p.node,f.node);
				}
				| cardinalityRestriction 
					{
						$type = $cardinalityRestriction.type;						
					}
				| oneOf 
					{
						$type = $oneOf.type;						
					}
				| valueRestriction 
					{
						$type = $valueRestriction.type;						
					}
		;


 
cardinalityRestriction	returns [Type type , ManchesterOWLSyntaxTree node]
@after { 
          $start.setEvalType($type); 
          $node = $start; 
        } // do after any alternative
:
		  ^(CARDINALITY_RESTRICTION  MIN  i=INTEGER p = unary  filler = expression?) 
		{
			$type =  this.getSymbolTable().getMinCardinalityRestrictionType($start,p.node, filler==null?null:filler.node);
			int cardinality = Integer.parseInt(i.token.getText());
      getTypesEnforcer().enforceMinCardinalityRestrictionTypes($start,p.node,filler.node);
			
		}
		|  ^(CARDINALITY_RESTRICTION  MAX i=INTEGER p = unary  filler = expression?) 
    {
      $type = this.getSymbolTable().getMaxCardinalityRestrictionType($start,p.node, filler==null?null:filler.node);
      int cardinality = Integer.parseInt(i.token.getText());
      getTypesEnforcer().enforceMaxCardinalityRestrictionTypes($start,p.node,filler.node);
    }
    |  ^(CARDINALITY_RESTRICTION  EXACTLY i= INTEGER  p = unary  filler = expression?) 
    {
      $type = this.getSymbolTable().getExactCardinalityRestrictionType($start,p.node, filler==null?null:filler.node);
      int cardinality = Integer.parseInt(i.token.getText());
      getTypesEnforcer().enforceExactCardinalityRestrictionTypes($start,p.node,filler.node);
    }
		;
		
oneOf	returns [Type type , ManchesterOWLSyntaxTree node]
@after { 
          $start.setEvalType($type); 
          $node = $start;
        }
	:
		^(ONE_OF individuals+=IDENTIFIER+) 
		{
		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_individuals.size());
        for(Object node :list_individuals){
          nodes.add((ManchesterOWLSyntaxTree)node);
        }
		    $type = this.getSymbolTable().getOneOfType($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		    getTypesEnforcer().enforceOneOfTypes($start,nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		}
	;

valueRestriction	returns [Type type , ManchesterOWLSyntaxTree node] 
@after { 
          $start.setEvalType($type); 
          $node = $start;          
        }
	:  
		^(VALUE_RESTRICTION  p = unary  value = unary) 
		{
		  $type = this.getSymbolTable().getValueRestrictionType($start,p.node, value.node);
		  getTypesEnforcer().enforceValueRestrictionTypes($start,p.node,value.node);		  
		 }
	;
	

	
