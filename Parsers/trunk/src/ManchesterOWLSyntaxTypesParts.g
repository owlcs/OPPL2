tree grammar ManchesterOWLSyntaxTypesParts;

options {
  language = Java;
  tokenVocab = ManchesterOWLSyntax; 
  ASTLabelType = ManchesterOWLSyntaxTree;
  filter=true;
}

 

@members{
  private  SymbolTable symtab;
  private  ErrorListener errorListener;
  public ManchesterOWLSyntaxTypesParts(TreeNodeStream input, SymbolTable symtab, ErrorListener errorListener) {
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
  import org.semanticweb.owlapi.model.OWLObject;
  import org.semanticweb.owlapi.model.OWLAxiom;
}



// START: root
bottomup // match subexpressions innermost to outermost

    :   expression // only match the start of expressions (root EXPRESSION) 
  
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

conjunction  returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject]
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
				$owlObject = this.getSymbolTable().getOWLObject($IDENTIFIER);
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
				$owlObject = this.getSymbolTable().getOWLObject($ENTITY_REFERENCE);
			}
		| ^(CONSTANT  value=. ( ^(AT language = IDENTIFIER))? constantType = IDENTIFIER?) {
				$type = OWLType.OWL_CONSTANT;
				$owlObject = constantType ==null ? this.getSymbolTable().getOWLUntypedConstant($start,value, language) : this.getSymbolTable().getOWLTypedConstant($start,value, constantType);				
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
        $owlObject = this.getSymbolTable().getOWLObject($IDENTIFIER);
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
	

	
