tree grammar ManchesterOWLSyntaxTypes;

options {
  language = Java;
  tokenVocab = ManchesterOWLSyntax;
  ASTLabelType = ManchesterOWLSyntaxTree;
  filter=true;
}

 

@members{
  private  SymbolTable symtab;
  private  ErrorListener errorListener;
  public ManchesterOWLSyntaxTypes(TreeNodeStream input, SymbolTable symtab, ErrorListener errorListener) {
    this(input);
    if(symtab==null){
    	throw new NullPointerException("The symbol table cannot be null");
    }
    if(errorListener == null){
    	throw new NullPointerException("The error listener cannot be null");
    }
    this.symtab = symtab;
    this.errorListener = errorListener;
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
  package org.coode.parsers;
  import org.semanticweb.owl.model.OWLObject;
  import org.semanticweb.owl.model.OWLAxiom;
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


axiom returns  [Type type, ManchesterOWLSyntaxTree node, OWLAxiom owlAxiom] 
@after 
			{ 
				$start.setEvalType($type); 
				$node = $start;
				$start.setOWLObject($owlAxiom); 
			} // do after any alternative
:
		^(SUB_CLASS_AXIOM  ^(EXPRESSION  subClass = expression) ^( EXPRESSION  superClass = expression))
		{
			$type = this.getSymbolTable().getSubClassAxiomType($start, subClass.node, superClass.node);
			$owlAxiom = this.getSymbolTable().getSubClassAxiom($start, subClass.node, superClass.node);
		}
	|  ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION lhs = expression) ^(EXPRESSION  rhs = expression))
	   {
	    $type = this.getSymbolTable().getEquivalentAxiomType($start, lhs.node, rhs.node);
	    $owlAxiom = this.getSymbolTable().getEquivalentAxiom($start, lhs.node, rhs.node);
	   }	
	| ^(INVERSE_OF ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION anotherProperty = IDENTIFIER))
	{
	   $type = this.getSymbolTable().getInverseOfAxiomType($start, p, anotherProperty);
	   $owlAxiom = this.getSymbolTable().getInverseOfAxiom($start, p, anotherProperty);
	}
  | ^(DISJOINT_WITH_AXIOM ^(EXPRESSION lhs =  expression) ^(EXPRESSION rhs = expression)){
     $type = this.getSymbolTable().getDisjointAxiomType($start, lhs.node, rhs.node);
     $owlAxiom = this.getSymbolTable().getDisjointAxiom($start, lhs.node, rhs.node);
  }	  
	|	^(SUB_PROPERTY_AXIOM ^(EXPRESSION  subProperty = expression) ^(EXPRESSION superProperty = unary))
		{
			$type = this.getSymbolTable().getSubPropertyAxiomType($start, subProperty.node, superProperty.node);
			$owlAxiom = this.getSymbolTable().getSubPropertyAxiom($start, subProperty.node, superProperty.node);
		}		
	| ^(ROLE_ASSERTION ^(EXPRESSION  subject = IDENTIFIER) ^(EXPRESSION  predicate = propertyExpression) ^(EXPRESSION object = unary)){
	   $type = this.getSymbolTable().getRoleAssertionAxiomType($start, subject, predicate.node, object.node);
	   $owlAxiom = this.getSymbolTable().getRoleAssertionAxiom($start, subject, predicate.node, object.node);
	 }
	|  ^(TYPE_ASSERTION ^(EXPRESSION  description = expression) ^(EXPRESSION subject = IDENTIFIER))
	{
	   $type = this.getSymbolTable().getClassAssertionAxiomType($start,description.node, subject);
	   $owlAxiom = this.getSymbolTable().getClassAssertionAxiom($start,description.node, subject);
	} 
	| ^(DOMAIN ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION domain = expression))
	 {
	   $type = this.getSymbolTable().getDomainAxiomType($start, p, domain.node);
	   $owlAxiom =  this.getSymbolTable().getDomainAxiom($start, p, domain.node);
	 }
	 | ^(RANGE ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION range = expression))
   {
     $type = this.getSymbolTable().getRangeAxiomType($start, p, range.node);
     $owlAxiom =  this.getSymbolTable().getRangeAxiom($start, p, range.node);
   }
   | ^(SAME_AS_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
    $type = this.getSymbolTable().getSameIndividualsAxiomType($start, anIndividual, anotherIndividual);
    $owlAxiom =  this.getSymbolTable().getSameIndividualsAxiom($start, anIndividual, anotherIndividual);
   }
    | ^(DIFFERENT_FROM_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
    $type = this.getSymbolTable().getDifferentIndividualsAxiomType($start, anIndividual, anotherIndividual);
    $owlAxiom =  this.getSymbolTable().getDifferentIndividualsAxiom($start, anIndividual, anotherIndividual);
   }
	 | ^(UNARY_AXIOM FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
	 {
	   $type = this.getSymbolTable().getFunctionalPropertyType($start, p);
	   $owlAxiom =  this.getSymbolTable().getFunctionalProperty($start, p);
	 }
	 | ^(UNARY_AXIOM INVERSE_FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getInverseFunctionalPropertyType($start, p);
     $owlAxiom =  this.getSymbolTable().getInverseFunctionalProperty($start, p);
   }
    | ^(UNARY_AXIOM IRREFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getIrreflexivePropertyType($start, p);
     $owlAxiom =  this.getSymbolTable().getIrreflexiveProperty($start, p);
   }
   | ^(UNARY_AXIOM REFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getReflexivePropertyType($start, p);
     $owlAxiom =  this.getSymbolTable().getReflexiveProperty($start, p);
   }
   | ^(UNARY_AXIOM SYMMETRIC ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getSymmetricPropertyType($start, p);
     $owlAxiom =  this.getSymbolTable().getSymmetricProperty($start, p);
   } 
    | ^(UNARY_AXIOM TRANSITIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = this.getSymbolTable().getTransitivePropertyType($start, p);
     $owlAxiom =  this.getSymbolTable().getTransitiveProperty($start, p);
   }
   | ^(NEGATED_ASSERTION a =axiom){
     $type = this.getSymbolTable().getNegatedAssertionType($start, a.node);
     $owlAxiom =  this.getSymbolTable().getNegatedAssertion($start, a.node);
   }     
;

expression returns  [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after 
		{ 
			$start.setEvalType($type); 
			$node = $start;
			$start.setOWLObject($owlObject); 
		} // do after any alternative
	: 
		 ^(DISJUNCTION  disjuncts +=conjunction+) 
		 {	
		 		List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_disjuncts.size());
		 	 	for(Object node :list_disjuncts){
		 	 		nodes.add(((conjunction_return) node).node);
		 	 	}
		 		$type = this.getSymbolTable().getDisjunctionType($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 		$owlObject = this.getSymbolTable().getDisjunction($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 	}
		|  ^(PROPERTY_CHAIN  chainItems+=expression+)
		  {
		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_chainItems.size());
        for(Object item  :list_chainItems){
          nodes.add(((expression_return) item).node);
        }
		    $type = this.getSymbolTable().getPropertyChainType($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		    $owlObject = this.getSymbolTable().getPropertyChain($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		  }
		| conjunction  
		{
			$type = $conjunction.type;
			$owlObject = $conjunction.owlObject;
		}
		| complexPropertyExpression 
		{
			$type = $complexPropertyExpression.type;
			$owlObject = $complexPropertyExpression.owlObject;
		}
		
	; 

conjunction returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after 
			{ 
				$start.setEvalType($type); 
				$node = $start;
				$start.setOWLObject($owlObject);
			} // do after any alternative
	:
	^(CONJUNCTION  conjuncts+=unary+)	
	{	
		 		List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_conjuncts.size());
		 	 	for(Object node :list_conjuncts){
		 	 		nodes.add(((unary_return) node).node);
		 	 	}
		 		$type = this.getSymbolTable().getConjunctionType($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 		$owlObject = this.getSymbolTable().getConjunction($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()])); 
	}
	| unary {
		$type = $unary.type;
		$owlObject = $unary.owlObject;
	}
;

unary returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after 
			{ 
				$start.setEvalType($type); 
				$node = $start;
				$start.setOWLObject($owlObject);
			} // do after any alternative
:
		IDENTIFIER 
			{
				Symbol symbol = this.getSymbolTable().resolve($IDENTIFIER);
				$type = symbol==null ? null: symbol.getType();
				$owlObject = this.getSymbolTable().getOWLEntity($IDENTIFIER);
			}
		| ^(NEGATED_EXPRESSION e = expression) 
			{
				$type = this.getSymbolTable().getNegatedClassExpressionType($start,e.node);
				$owlObject = this.getSymbolTable().getNegatedClassExpression($start,e.node);
			}	
		| qualifiedRestriction 	
			{
				$type = $qualifiedRestriction.type;
				$owlObject = $qualifiedRestriction.owlObject;
			} 
		| ENTITY_REFERENCE 
			{
				Symbol symbol = this.getSymbolTable().resolve($ENTITY_REFERENCE);
				$type = symbol==null ? null: symbol.getType();
				$owlObject = this.getSymbolTable().getOWLEntity($ENTITY_REFERENCE);
			}
		| ^(CONSTANT  value=. constantType = IDENTIFIER?) {
				$type = OWLType.OWL_CONSTANT;
				$owlObject = constantType ==null ? this.getSymbolTable().getOWLUntypedConstant($start,value) : this.getSymbolTable().getOWLTypedConstant($start,value, constantType);				
			}
	;


propertyExpression  
returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after 
			{ 
				$start.setEvalType($type); 
				$node = $start;
				$start.setOWLObject($owlObject);
			} // do after any alternative
:
      IDENTIFIER
      {
        Symbol symbol = this.getSymbolTable().resolve($IDENTIFIER);
        $type = symbol==null ? null: symbol.getType();
        $owlObject = this.getSymbolTable().getOWLEntity($IDENTIFIER);
      }
    | complexPropertyExpression
      {
        $type = $complexPropertyExpression.type;
        $owlObject = $complexPropertyExpression.owlObject;
      }
    ;

complexPropertyExpression
returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after { 
          $start.setEvalType($type); 
          $node = $start;
          $start.setOWLObject($owlObject);
       } // do after any alternative
:
	^(INVERSE_OBJECT_PROPERTY_EXPRESSION p = complexPropertyExpression)
	{
		$type = this.getSymbolTable().getInversePropertyType($start, p.node);
		$owlObject = this.getSymbolTable().getInverseProperty($start, p.node);
	}
	| ^(INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER)
	{
				Symbol symbol = this.getSymbolTable().resolve($IDENTIFIER);
				$type = this.getSymbolTable().getInversePropertyType($start, $IDENTIFIER);
				$owlObject = this.getSymbolTable().getInverseProperty($start, $IDENTIFIER);
	}
	;

qualifiedRestriction returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after { 
          $start.setEvalType($type); 
          $node = $start;
          $start.setOWLObject($owlObject);
        } // do after any alternative
	:
					^(SOME_RESTRICTION p= propertyExpression  f= expression) 
					{
						$type = this.getSymbolTable().getSomeValueRestrictionType($start,p.node,f.node);
						$owlObject = this.getSymbolTable().getSomeValueRestriction($start,p.node,f.node);
					}				
				|	^(ALL_RESTRICTION  p = propertyExpression f= expression) 
				{
					$type = this.getSymbolTable().getAllValueRestrictionType($start,p.node,f.node);
					$owlObject = this.getSymbolTable().getAllValueRestriction($start,p.node,f.node);
				}
				| cardinalityRestriction 
					{
						$type = $cardinalityRestriction.type;
						$owlObject = $cardinalityRestriction.owlObject;
					}
				| oneOf 
					{
						$type = $oneOf.type;
						$owlObject = $oneOf.owlObject;
					}
				| valueRestriction 
					{
						$type = $valueRestriction.type;
						$owlObject = $valueRestriction.owlObject;
					}
		;


 
cardinalityRestriction	returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after { 
          $start.setEvalType($type); 
          $node = $start; 
          $start.setOWLObject($owlObject);
        } // do after any alternative
:
		  ^(CARDINALITY_RESTRICTION  MIN  i=INTEGER p = unary  filler = expression?) 
		{
			$type =  this.getSymbolTable().getMinCardinalityRestrictionType($start,p.node, filler==null?null:filler.node);
			int cardinality = Integer.parseInt(i.token.getText());
      $owlObject = this.getSymbolTable().getMinCardinalityRestriction($start,cardinality,p.node, filler==null?null:filler.node);
			
		}
		|  ^(CARDINALITY_RESTRICTION  MAX i=INTEGER p = unary  filler = expression?) 
    {
      $type = this.getSymbolTable().getMaxCardinalityRestrictionType($start,p.node, filler==null?null:filler.node);
      int cardinality = Integer.parseInt(i.token.getText());
      $owlObject = this.getSymbolTable().getMaxCardinalityRestriction($start,cardinality,p.node, filler==null?null:filler.node);
    }
    |  ^(CARDINALITY_RESTRICTION  EXACTLY i= INTEGER  p = unary  filler = expression?) 
    {
      $type = this.getSymbolTable().getExactCardinalityRestrictionType($start,p.node, filler==null?null:filler.node);
      int cardinality = Integer.parseInt(i.token.getText());
      $owlObject = this.getSymbolTable().getExactCardinalityRestriction($start,cardinality,p.node, filler==null?null:filler.node);
    }
		;
		
oneOf	returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after { 
          $start.setEvalType($type); 
          $node = $start;
          $start.setOWLObject($owlObject);
        }
	:
		^(ONE_OF individuals+=IDENTIFIER+) 
		{
		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_individuals.size());
        for(Object node :list_individuals){
          nodes.add((ManchesterOWLSyntaxTree)node);
        }
		    $type = this.getSymbolTable().getOneOfType($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		    if($type!=null){
          $owlObject = this.getSymbolTable().getOneOf($start, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
        }
		}
	;

valueRestriction	returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] 
@after { 
          $start.setEvalType($type); 
          $node = $start;
          $start.setOWLObject($owlObject);
        }
	:  
		^(VALUE_RESTRICTION  p = unary  value = unary) 
		{
		  $type = this.getSymbolTable().getValueRestrictionType($start,p.node, value.node);
		  if($type!=null){
		    $owlObject = this.getSymbolTable().getValueRestriction($start,p.node, value.node);
		   }
		 }
	;
	

	
