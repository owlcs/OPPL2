tree grammar ManchesterOWLSyntaxTypes;

options {
  language = Java;
  tokenVocab = ManchesterOWLSyntax;
  ASTLabelType = ManchesterOWLSyntaxTree;
  filter=true;
}

@members{
  SymbolTable symtab;
  public ManchesterOWLSyntaxTypes(TreeNodeStream input, SymbolTable symtab) {
    this(input);
    this.symtab = symtab;
  }
}
 
@header {
  package org.coode.oppl.syntax;
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
			$type = symtab.getSubClassAxiomType($start.token, subClass.node, superClass.node);
			$owlAxiom = symtab.getSubClassAxiom($start.token, subClass.node, superClass.node);
		}
	|  ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION lhs = expression) ^(EXPRESSION  rhs = expression))
	   {
	    $type = symtab.getEquivalentAxiomType($start.token, lhs.node, rhs.node);
	    $owlAxiom = symtab.getEquivalentAxiom($start.token, lhs.node, rhs.node);
	   }	
	| ^(INVERSE_OF ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION anotherProperty = IDENTIFIER))
	{
	   $type = symtab.getInverseOfAxiomType($start.token, p, anotherProperty);
	   $owlAxiom = symtab.getInverseOfAxiom($start.token, p, anotherProperty);
	}
  | ^(DISJOINT_WITH_AXIOM ^(EXPRESSION lhs =  expression) ^(EXPRESSION rhs = expression)){
     $type = symtab.getDisjointAxiomType($start.token, lhs.node, rhs.node);
     $owlAxiom = symtab.getDisjointAxiom($start.token, lhs.node, rhs.node);
  }	  
	|	^(SUB_PROPERTY_AXIOM ^(EXPRESSION  subProperty = expression) ^(EXPRESSION superProperty = unary))
		{
			$type = symtab.getSubPropertyAxiomType($start.token, subProperty.node, superProperty.node);
			$owlAxiom = symtab.getSubPropertyAxiom($start.token, subProperty.node, superProperty.node);
		}		
	| ^(ROLE_ASSERTION ^(EXPRESSION  subject = IDENTIFIER) ^(EXPRESSION  predicate = propertyExpression) ^(EXPRESSION object = unary)){
	   $type = symtab.getRoleAssertionAxiomType($start.token, subject, predicate.node, object.node);
	   $owlAxiom = symtab.getRoleAssertionAxiom($start.token, subject, predicate.node, object.node);
	 }
	|  ^(TYPE_ASSERTION ^(EXPRESSION  description = expression) ^(EXPRESSION subject = IDENTIFIER))
	{
	   $type = symtab.getClassAssertionAxiomType($start.token,description.node, subject);
	   $owlAxiom = symtab.getClassAssertionAxiom($start.token,description.node, subject);
	} 
	| ^(DOMAIN ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION domain = expression))
	 {
	   $type = symtab.getDomainAxiomType($start.token, p, domain.node);
	   $owlAxiom =  symtab.getDomainAxiom($start.token, p, domain.node);
	 }
	 | ^(RANGE ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION range = expression))
   {
     $type = symtab.getRangeAxiomType($start.token, p, range.node);
     $owlAxiom =  symtab.getRangeAxiom($start.token, p, range.node);
   }
   | ^(SAME_AS_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
    $type = symtab.getSameIndividualsAxiomType($start.token, anIndividual, anotherIndividual);
    $owlAxiom =  symtab.getSameIndividualsAxiom($start.token, anIndividual, anotherIndividual);
   }
    | ^(DIFFERENT_FROM_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
    $type = symtab.getDifferentIndividualsAxiomType($start.token, anIndividual, anotherIndividual);
    $owlAxiom =  symtab.getDifferentIndividualsAxiom($start.token, anIndividual, anotherIndividual);
   }
	 | ^(UNARY_AXIOM FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
	 {
	   $type = symtab.getFunctionalPropertyType($start.token, p);
	   $owlAxiom =  symtab.getFunctionalProperty($start.token, p);
	 }
	 | ^(UNARY_AXIOM INVERSE_FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
   {
     $type = symtab.getInverseFunctionalPropertyType($start.token, p);
     $owlAxiom =  symtab.getInverseFunctionalProperty($start.token, p);
   }
    | ^(UNARY_AXIOM IRREFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = symtab.getIrreflexivePropertyType($start.token, p);
     $owlAxiom =  symtab.getIrreflexiveProperty($start.token, p);
   }
   | ^(UNARY_AXIOM REFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = symtab.getReflexivePropertyType($start.token, p);
     $owlAxiom =  symtab.getReflexiveProperty($start.token, p);
   }
   | ^(UNARY_AXIOM SYMMETRIC ^(EXPRESSION p = IDENTIFIER))
   {
     $type = symtab.getSymmetricPropertyType($start.token, p);
     $owlAxiom =  symtab.getSymmetricProperty($start.token, p);
   } 
    | ^(UNARY_AXIOM TRANSITIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $type = symtab.getTransitivePropertyType($start.token, p);
     $owlAxiom =  symtab.getTransitiveProperty($start.token, p);
   }
   | ^(NEGATED_ASSERTION a =axiom){
     $type = symtab.getNegatedAssertionType($start.token, a.node);
     $owlAxiom =  symtab.getNegatedAssertion($start.token, a.node);
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
		 		$type = symtab.getDisjunctionType($start.token, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 		$owlObject = symtab.getDisjunction($start.token, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 	}
		|  ^(PROPERTY_CHAIN  chainItems+=expression+)
		  {
		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_chainItems.size());
        for(Object item  :list_chainItems){
          nodes.add(((expression_return) item).node);
        }
		    $type = symtab.getPropertyChainType($start.token, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		    $owlObject = symtab.getPropertyChain($start.token, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
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
		 		$type = symtab.getConjunctionType($start.token, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		 		$owlObject = symtab.getConjunction($start.token, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()])); 
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
				Symbol symbol = this.symtab.resolve($IDENTIFIER);
				$type = symbol==null ? null: symbol.getType();
				$owlObject = symtab.getOWLEntity($IDENTIFIER);
			}
		| ^(NEGATED_EXPRESSION e = expression) 
			{
				$type = symtab.getNegatedClassExpressionType($start.token,e.node);
				$owlObject = symtab.getNegatedClassExpression($start.token,e.node);
			}	
		| qualifiedRestriction 	
			{
				$type = $qualifiedRestriction.type;
				$owlObject = $qualifiedRestriction.owlObject;
			} 
		| ENTITY_REFERENCE 
			{
				Symbol symbol = this.symtab.resolve($ENTITY_REFERENCE);
				$type = symbol==null ? null: symbol.getType();
				$owlObject = symtab.getOWLEntity($ENTITY_REFERENCE);
			}
		| ^(CONSTANT  value=. constantType = IDENTIFIER?) {
				$type = OWLType.OWL_CONSTANT;
				$owlObject = constantType ==null ? symtab.getOWLUntypedConstant($start.token,value) : symtab.getOWLTypedConstant($start.token,value, constantType);				
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
        Symbol symbol = this.symtab.resolve($IDENTIFIER);
        $type = symbol==null ? null: symbol.getType();
        $owlObject = symtab.getOWLEntity($IDENTIFIER);
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
		$type = symtab.getInversePropertyType($start.token, p.node);
		$owlObject = symtab.getInverseProperty($start.token, p.node);
	}
	| ^(INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER)
	{
				Symbol symbol = this.symtab.resolve($IDENTIFIER);
				$type = symtab.getInversePropertyType($start.token, $IDENTIFIER);
				$owlObject = symtab.getInverseProperty($start.token, $IDENTIFIER);
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
						$type = symtab.getSomeValueRestrictionType($start.token,p.node,f.node);
						$owlObject = symtab.getSomeValueRestriction($start.token,p.node,f.node);
					}				
				|	^(ALL_RESTRICTION  p = propertyExpression f= expression) 
				{
					$type = symtab.getAllValueRestrictionType($start.token,p.node,f.node);
					$owlObject = symtab.getAllValueRestriction($start.token,p.node,f.node);
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
			$type =  symtab.getMinCardinalityRestrictionType($start.token,p.node, filler==null?null:filler.node);
			int cardinality = Integer.parseInt(i.token.getText());
      $owlObject = symtab.getMinCardinalityRestriction($start.token,cardinality,p.node, filler==null?null:filler.node);
			
		}
		|  ^(CARDINALITY_RESTRICTION  MAX i=INTEGER p = unary  filler = expression?) 
    {
      $type = symtab.getMaxCardinalityRestrictionType($start.token,p.node, filler==null?null:filler.node);
      int cardinality = Integer.parseInt(i.token.getText());
      $owlObject = symtab.getMaxCardinalityRestriction($start.token,cardinality,p.node, filler==null?null:filler.node);
    }
    |  ^(CARDINALITY_RESTRICTION  EXACTLY i= INTEGER  p = unary  filler = expression?) 
    {
      $type = symtab.getExactCardinalityRestrictionType($start.token,p.node, filler==null?null:filler.node);
      int cardinality = Integer.parseInt(i.token.getText());
      $owlObject = symtab.getExactCardinalityRestriction($start.token,cardinality,p.node, filler==null?null:filler.node);
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
		    $type = symtab.getOneOfType($start.token, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
		    if($type!=null){
          $owlObject = symtab.getOneOf($start.token, nodes.toArray(new ManchesterOWLSyntaxTree[nodes.size()]));
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
		  $type = symtab.getValueRestrictionType($start.token,p.node, value.node);
		  if($type!=null){
		    $owlObject = symtab.getValueRestriction($start.token,p.node, value.node);
		   }
		 }
	;
	

	
