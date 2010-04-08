parser grammar MOWLParser;




options {
  output = AST;              // build trees
  ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes
  language = Java;
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
@header {
  package org.coode.parsers;
}











axiom	:
		binaryAxiom -> ^(binaryAxiom)
		| unaryAxiom -> ^(unaryAxiom)
		| assertionAxiom -> ^(assertionAxiom)
	;



assertionAxiom:
  i = IDENTIFIER (INSTANCE_OF | TYPES) expression -> ^(TYPE_ASSERTION ^(EXPRESSION expression) ^(EXPRESSION $i))
  |  IDENTIFIER propertyExpression  value -> ^(ROLE_ASSERTION ^(EXPRESSION IDENTIFIER) ^(EXPRESSION propertyExpression) ^(EXPRESSION value))
  
  | NOT assertionAxiom -> ^(NEGATED_ASSERTION assertionAxiom)
;



binaryAxiom :
    lhs =  expression

                (                  
                SUBCLASS_OF  superClass = expression -> ^(SUB_CLASS_AXIOM  ^(EXPRESSION $lhs) ^(EXPRESSION $superClass))
                | EQUIVALENT_TO rhs = expression -> ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $rhs))
                | DISJOINT_WITH disjoint = expression -> ^(DISJOINT_WITH_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $disjoint))
                | SUB_PROPERTY_OF superProperty = propertyExpression -> ^(SUB_PROPERTY_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $superProperty))                
                )
    |
    lhsID = IDENTIFIER  (
                    SAME_AS  rhsID = IDENTIFIER -> ^(SAME_AS_AXIOM ^(EXPRESSION  $lhsID) ^(EXPRESSION $rhsID))
                  | DIFFERENT_FROM  rhsID = IDENTIFIER -> ^(DIFFERENT_FROM_AXIOM ^(EXPRESSION $lhsID) ^(EXPRESSION $rhsID))
                  | DOMAIN expression -> ^(DOMAIN ^(EXPRESSION $lhsID) ^(EXPRESSION expression))
                  | RANGE expression -> ^(RANGE ^(EXPRESSION $lhsID) ^(EXPRESSION expression))
                  | INVERSE_OF rhsID = IDENTIFIER -> ^(INVERSE_OF ^(EXPRESSION $lhsID) ^(EXPRESSION $rhsID))
                  )    
                
   ;
 
unaryAxiom  :       
   unaryCharacteristic   IDENTIFIER -> ^(UNARY_AXIOM unaryCharacteristic ^(EXPRESSION IDENTIFIER))                
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
			head = propertyExpression (COMPOSITION rest+=propertyExpression )+ -> ^(PROPERTY_CHAIN  $head $rest)
			| conjunction (OR conjunction)* -> ^(DISJUNCTION  conjunction+)
			| complexPropertyExpression -> ^(complexPropertyExpression)
		)
		
	; 
	

	
conjunction	:
			 unary (AND unary)* -> ^(CONJUNCTION unary+)
	;

complexPropertyExpression:
	INVERSE OPEN_PARENTHESYS complexPropertyExpression CLOSED_PARENTHESYS -> ^(INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression)
	|	INVERSE OPEN_PARENTHESYS IDENTIFIER CLOSED_PARENTHESYS-> ^(INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER)
	;
	
unary	:
		IDENTIFIER 
		| NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(NEGATED_EXPRESSION expression)
		| NOT IDENTIFIER -> ^(NEGATED_EXPRESSION IDENTIFIER) 				 	
		| ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
		| qualifiedRestriction -> ^(qualifiedRestriction)
		| constant		
	;
	
qualifiedRestriction:
        (
          options{backtrack = true;}:
				  propertyExpression  SOME   filler  -> ^(SOME_RESTRICTION propertyExpression filler)				 					
				|	propertyExpression ONLY  filler  -> ^(ALL_RESTRICTION propertyExpression filler)
				| cardinalityRestriction -> ^(cardinalityRestriction)
				| oneOf -> ^(oneOf)
				| valueRestriction -> ^(valueRestriction)
				)
		;
		
propertyExpression  :
      IDENTIFIER -> ^(IDENTIFIER)
    | complexPropertyExpression -> ^(complexPropertyExpression)
    ;
		
cardinalityRestriction	:
					propertyExpression  restrictionKind INTEGER filler? -> ^(CARDINALITY_RESTRICTION  restrictionKind INTEGER propertyExpression  filler?)
		;
		
restrictionKind :
    MIN -> ^(MIN)
    | MAX -> ^(MAX)
    | EXACTLY -> ^(EXACTLY)
    ;
filler: 
    IDENTIFIER -> ^(IDENTIFIER)
    | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(expression)
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

