parser grammar MOWLParser;




options {
  output = AST;              // build trees
  ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes
  language = Java;
  tokenVocab = MOWLParser;
 }


 
tokens {
  SUB_CLASS_AXIOM; 
  EQUIVALENT_TO_AXIOM;
  DISJOINT_WITH_AXIOM ;
  SUB_PROPERTY_AXIOM; 
  SAME_AS_AXIOM;  
  DIFFERENT_FROM_AXIOM;
  UNARY_AXIOM;
  DISJUNCTION;
  CONJUNCTION;
  PROPERTY_CHAIN;
  NEGATED_EXPRESSION;
  NEGATED_ASSERTION;
  INVERSE_PROPERTY;
  SOME_RESTRICTION;
  ALL_RESTRICTION;
  VALUE_RESTRICTION;
  CARDINALITY_RESTRICTION;
  ONE_OF;
  TYPE_ASSERTION;
  ROLE_ASSERTION;
  INVERSE_OBJECT_PROPERTY_EXPRESSION;
  EXPRESSION;
  CONSTANT; 
}  
//@header {
//  package org.coode.parsers;
//}

@members{
public void displayRecognitionError(String[] tokenNames,
										RecognitionException e){
	}
	
}

@rulecatch{
  catch(RecognitionException e){
    throw e;
  }
  
  catch(RewriteEmptyStreamException e){
    throw e;
  }
}



axiom	    	options {backtrack=true;}:
		binaryAxiom -> ^(binaryAxiom)
		| unaryAxiom -> ^(unaryAxiom)
		| assertionAxiom -> ^(assertionAxiom)
	;



assertionAxiom:
  i = IDENTIFIER (INSTANCE_OF | TYPES) expression -> ^(TYPE_ASSERTION ^(EXPRESSION expression) ^(EXPRESSION $i))
  |  IDENTIFIER propertyExpression  value -> ^(ROLE_ASSERTION ^(EXPRESSION IDENTIFIER) ^(EXPRESSION propertyExpression) ^(EXPRESSION value))
  
  | NOT assertionAxiom -> ^(NEGATED_ASSERTION assertionAxiom)
;



binaryAxiom     	

options {backtrack=true;}: 
	lhs =  expression SUBCLASS_OF  superClass = expression -> ^(SUB_CLASS_AXIOM  ^(EXPRESSION $lhs) ^(EXPRESSION $superClass))
        | lhs =  expression EQUIVALENT_TO rhs = expression -> ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $rhs))
        | lhs =  expression DISJOINT_WITH disjoint = expression -> ^(DISJOINT_WITH_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $disjoint))
        | lhs =  expression SUB_PROPERTY_OF superProperty = propertyExpression -> ^(SUB_PROPERTY_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $superProperty))
        | lhsID =  atomic INVERSE_OF rhsAtomic = atomic -> ^(INVERSE_OF ^(EXPRESSION $lhsID) ^(EXPRESSION $rhsAtomic))  
	|lhsID =  atomic SAME_AS  rhsID = atomic -> ^(SAME_AS_AXIOM ^(EXPRESSION  $lhsID) ^(EXPRESSION $rhsID))
        | lhsID =  atomic DIFFERENT_FROM  rhsID = atomic -> ^(DIFFERENT_FROM_AXIOM ^(EXPRESSION $lhsID) ^(EXPRESSION $rhsID))
        | lhsID =  atomic  DOMAIN expression -> ^(DOMAIN ^(EXPRESSION $lhsID) ^(EXPRESSION expression))
        | lhsID =  atomic RANGE expression -> ^(RANGE ^(EXPRESSION $lhsID) ^(EXPRESSION expression))              
                
   ;
 
unaryAxiom  :       
   unaryCharacteristic   unary -> ^(UNARY_AXIOM unaryCharacteristic ^(EXPRESSION unary))                
  ;

unaryCharacteristic :
    FUNCTIONAL -> ^(FUNCTIONAL)
    | INVERSE_FUNCTIONAL -> ^(INVERSE_FUNCTIONAL)
    | SYMMETRIC -> ^(SYMMETRIC)
    | ANTI_SYMMETRIC -> ^(ANTI_SYMMETRIC)
    | REFLEXIVE -> ^(REFLEXIVE)
    | IRREFLEXIVE -> ^(IRREFLEXIVE)
    | TRANSITIVE -> ^(TRANSITIVE)
  ;

expression:
    (		
    	options {backtrack=true;}: 
			| conjunction (OR conjunction)* -> ^(DISJUNCTION  conjunction+)
			| complexPropertyExpression -> ^(complexPropertyExpression)
			| OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(expression)

		)
		
	; 
	

	
conjunction	:
			 unary (AND unary)* -> ^(CONJUNCTION unary+)
	;

complexPropertyExpression:
	INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^(INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression)
	|	INVERSE OPEN_PARENTHESYS atomic CLOSED_PARENTHESYS-> ^(INVERSE_OBJECT_PROPERTY_EXPRESSION atomic)
	;
	
unary	 options{backtrack = true;}:
		
		 head = propertyExpression (COMPOSITION rest+=propertyExpression )+ -> ^(PROPERTY_CHAIN  $head $rest)
		| NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(NEGATED_EXPRESSION expression)
		| NOT atomic -> ^(NEGATED_EXPRESSION atomic) 				 			
		| qualifiedRestriction -> ^(qualifiedRestriction)
		| constant
		| atomic		
	;

atomic	:
		IDENTIFIER 
		| ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
	;
	
qualifiedRestriction:
        (
          options{backtrack = true;}:
				  propertyExpression  SOME   expression  -> ^(SOME_RESTRICTION propertyExpression expression)				 					
				|	propertyExpression ONLY  expression  -> ^(ALL_RESTRICTION propertyExpression expression)
				| cardinalityRestriction -> ^(cardinalityRestriction)
				| oneOf -> ^(oneOf)
				| valueRestriction -> ^(valueRestriction)
				)
		;
		
propertyExpression  :
      atomic -> ^(atomic)
    | complexPropertyExpression -> ^(complexPropertyExpression)
    ;
		
cardinalityRestriction	          
	options{backtrack = true;}:
	propertyExpression  restrictionKind INTEGER unary? -> ^(CARDINALITY_RESTRICTION  restrictionKind INTEGER propertyExpression  unary?)
;
		
restrictionKind :
    MIN -> ^(MIN)
    | MAX -> ^(MAX)
    | EXACTLY -> ^(EXACTLY)
    ;


oneOf	:
		OPEN_CURLY_BRACES IDENTIFIER (COMMA IDENTIFIER)* CLOSED_CURLY_BRACES -> ^(ONE_OF IDENTIFIER+)
	;
	
valueRestriction	: propertyExpression VALUE value -> ^(VALUE_RESTRICTION propertyExpression value)
	;

value:
      IDENTIFIER -> ^(IDENTIFIER) 
    | constant -> ^(constant)
  ;
  
constant  :  constantValue = DBLQUOTE ( POW type = IDENTIFIER)? ->^(CONSTANT $constantValue $type?) 
  ;

