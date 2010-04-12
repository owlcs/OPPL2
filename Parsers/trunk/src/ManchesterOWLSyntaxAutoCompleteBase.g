parser grammar ManchesterOWLSyntaxAutoCompleteBase;

options {
  language = Java;
  output = AST;
  ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes
  
}



import MOWLParser;



tokens {
  STANDALONE_EXPRESSION;
  INCOMPLETE_TYPE_ASSERTION;
  INCOMPLETE_ROLE_ASSERTION;
  INCOMPLETE_UNARY_AXIOM;
  INCOMPLETE_SUB_CLASS_AXIOM;
  INCOMPLETE_EQUIVALENT_TO_AXIOM;
  INCOMPLETE_DISJOINT_WITH_AXIOM;
  INCOMPLETE_SUB_PROPERTY_AXIOM;
  INCOMPLETE_SAME_AS_AXIOM;
  INCOMPLETE_DIFFERENT_FROM_AXIOM;
  INCOMPLETE_DOMAIN;
  INCOMPLETE_RANGE;
  INCOMPLETE_INVERSE_OF;
  INCOMPLETE_PROPERTY_CHAIN;
  INCOMPLETE_DISJUNCTION;
  INCOMPLETE_CONJUNCTION;
  INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION;
  INCOMPLETE_NEGATED_EXPRESSION;
  INCOMPLETE_SOME_RESTRICTION;
  INCOMPLETE_ALL_RESTRICTION;
  INCOMPLETE_CARDINALITY_RESTRICTION;
  INCOMPLETE_ONE_OF;
  INCOMPLETE_VALUE_RESTRICTION;
  INCOMPLETE_EXPRESSION;
}

@header {
  package org.coode.parsers;
}




standaloneExpression  :
    expression EOF ->^(STANDALONE_EXPRESSION ^(EXPRESSION expression))
  ;

incompleteAxiom :
    incompleteBinaryAxiom -> ^(incompleteBinaryAxiom)
    | incompleteUnaryAxiom   -> ^(incompleteUnaryAxiom)
    | incompleteAssertionAxiom -> ^(incompleteAssertionAxiom)
  ;

incompleteAssertionAxiom  :
  i = IDENTIFIER (INSTANCE_OF | TYPES)  -> ^(INCOMPLETE_TYPE_ASSERTION  ^(EXPRESSION $i))
 // |  IDENTIFIER propertyExpression  -> ^(INCOMPLETE_ROLE_ASSERTION ^(EXPRESSION IDENTIFIER) ^(EXPRESSION propertyExpression))
;

incompleteUnaryAxiom  :       
   unaryCharacteristic  -> ^(INCOMPLETE_UNARY_AXIOM unaryCharacteristic)                
  ;

  
incompleteBinaryAxiom :
    lhs =  expression

                (                  
                SUBCLASS_OF   -> ^(INCOMPLETE_SUB_CLASS_AXIOM  ^(EXPRESSION $lhs))
                | SUBCLASS_OF superClass = incompleteExpression -> ^(INCOMPLETE_SUB_CLASS_AXIOM  ^(EXPRESSION $lhs) ^(INCOMPLETE_EXPRESSION $superClass))
                | EQUIVALENT_TO  -> ^(INCOMPLETE_EQUIVALENT_TO_AXIOM ^(EXPRESSION $lhs))
                | EQUIVALENT_TO rhs = incompleteExpression -> ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION $lhs) ^(INCOMPLETE_EXPRESSION $rhs))
                | DISJOINT_WITH -> ^(INCOMPLETE_DISJOINT_WITH_AXIOM ^(EXPRESSION $lhs))
                | DISJOINT_WITH disjoint = incompleteExpression -> ^(DISJOINT_WITH_AXIOM ^(EXPRESSION $lhs) ^(INCOMPLETE_EXPRESSION $disjoint))
                | SUB_PROPERTY_OF  -> ^(INCOMPLETE_SUB_PROPERTY_AXIOM ^(EXPRESSION $lhs))                       
                )
    |
    lhsID = IDENTIFIER  (
                    SAME_AS   -> ^(INCOMPLETE_SAME_AS_AXIOM ^(EXPRESSION  $lhsID))
                  | DIFFERENT_FROM  -> ^(INCOMPLETE_DIFFERENT_FROM_AXIOM ^(EXPRESSION $lhsID))
                  | DOMAIN  -> ^(INCOMPLETE_DOMAIN ^(EXPRESSION $lhsID))
                  | DOMAIN incompleteDomain = incompleteExpression  -> ^(INCOMPLETE_DOMAIN ^(EXPRESSION $lhsID) ^(INCOMPLETE_EXPRESSION $incompleteDomain))
                  | RANGE  -> ^(INCOMPLETE_RANGE ^(EXPRESSION $lhsID))
                  | RANGE  incompleteRange = incompleteExpression -> ^(INCOMPLETE_RANGE ^(EXPRESSION $lhsID) ^(INCOMPLETE_EXPRESSION $incompleteRange))
                  | INVERSE_OF -> ^(INCOMPLETE_INVERSE_OF ^(EXPRESSION $lhsID))                  
                  )    
                
   ; 

incompleteExpression:
    (   
      options {backtrack=true;}: 
      head = propertyExpression (COMPOSITION rest+=propertyExpression )+ COMPOSITION  -> ^(INCOMPLETE_PROPERTY_CHAIN  $head $rest)
      | (conjunction (OR .)*) OR  incompleteConjunction?  -> ^(INCOMPLETE_DISJUNCTION  ^(incompleteConjunction)?)
      | incompleteConjunction -> ^(INCOMPLETE_DISJUNCTION  ^(incompleteConjunction)?) 
      | incompleteUnary -> ^(incompleteUnary)
      | expression IDENTIFIER ->^(INCOMPLETE_EXPRESSION ^(EXPRESSION expression) IDENTIFIER)  
    )    
  ;  
 
incompleteConjunction  : 
       	(unary (AND   .)*) AND incompleteUnary? -> ^(INCOMPLETE_CONJUNCTION  ^(incompleteUnary)?)      
  ;  
 
incompleteComplexPropertyExpression:
   INVERSE OPEN_PARENTHESYS -> ^(INCOMPLETE_INVERSE_OBJECT_PROPERTY_EXPRESSION)
  ;
  
incompleteUnary :    
    NOT OPEN_PARENTHESYS  -> ^(INCOMPLETE_NEGATED_EXPRESSION)                  
    | incompleteQualifiedRestriction -> ^(incompleteQualifiedRestriction)         
  ;

incompleteQualifiedRestriction:
        (
          options{backtrack = true;}:
          propertyExpression  SOME -> ^(INCOMPLETE_SOME_RESTRICTION propertyExpression)                 
        | propertyExpression ONLY -> ^(INCOMPLETE_ALL_RESTRICTION propertyExpression)
        | incompleteCardinalityRestriction -> ^(incompleteCardinalityRestriction)
        | incompleteOneOf -> ^(incompleteOneOf)
        | incompleteValueRestriction -> ^(incompleteValueRestriction)
        )
    ;

incompleteCardinalityRestriction  :
          propertyExpression  restrictionKind INTEGER  -> ^(INCOMPLETE_CARDINALITY_RESTRICTION  restrictionKind INTEGER propertyExpression)
    ;

incompleteOneOf :
    OPEN_CURLY_BRACES IDENTIFIER (COMMA IDENTIFIER)* COMMA -> ^(INCOMPLETE_ONE_OF IDENTIFIER+)
  ;

incompleteValueRestriction  : propertyExpression VALUE  -> ^(INCOMPLETE_VALUE_RESTRICTION propertyExpression)
  ;