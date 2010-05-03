parser grammar OPPLParser;
options {
  output = AST;              // build trees  
  language = Java;
  ASTLabelType = OPPLSyntaxTree; // use custom tree nodes
 }

 
 import MOWLParser;

 tokens{
    ASSERTED_CLAUSE;
    PLAIN_CLAUSE;
    INEQUALITY_CONSTRAINT;
    IN_SET_CONSTRAINT;
    INPUT_VARIABLE_DEFINITION;
    GENERATED_VARIABLE_DEFINITION;
    CREATE_OPPL_FUNCTION;
    VARIABLE_ATTRIBUTE;
    OPPL_FUNCTION;
    ACTIONS;
    VARIABLE_DEFINITIONS;
    QUERY;
    VARIABLE_SCOPE;
    ATTRIBUTE_SELECTOR;
    STRING_OPERATION;
 }
 
 
 variableDefinitions
  :
    variableDefinition (COMMA variableDefinition)* -> ^(VARIABLE_DEFINITIONS variableDefinition+)
  ;
  
 variableDefinition
  :

      VARIABLE_NAME COLON VARIABLE_TYPE  EQUAL opplFunction -> ^(GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(opplFunction))      
    | VARIABLE_NAME COLON VARIABLE_TYPE  EQUAL expression -> ^(GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(EXPRESSION expression))
    | VARIABLE_NAME COLON VARIABLE_TYPE  EQUAL MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^(GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(MATCH stringOperation))
    | VARIABLE_NAME COLON VARIABLE_TYPE (variableScope)? -> ^(INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE variableScope?)    
  ;
  


variableScope
  :
    OPEN_SQUARE_BRACKET (variableScopeSpecification = SUBCLASS_OF | variableScopeSpecification = SUBPROPERTY_OF | variableScopeSpecification = SUPER_CLASS_OF |  variableScopeSpecification =SUPER_PROPERTY_OF |  variableScopeSpecification = INSTANCE_OF | variableScopeSpecification = TYPES) expression CLOSED_SQUARE_BRACKET -> ^(VARIABLE_SCOPE $variableScopeSpecification ^(EXPRESSION expression))
  ; 



 query
  :
    SELECT selectClause (COMMA selectClause)* constraint? -> ^(QUERY selectClause+ constraint?)
  ;
 
 selectClause
  :
      ASSERTED axiom -> ^(ASSERTED_CLAUSE axiom)
    | axiom -> ^(PLAIN_CLAUSE axiom)
  ;
 
 constraint
  :
      WHERE first = VARIABLE_NAME NOT_EQUAL second = expression -> ^(INEQUALITY_CONSTRAINT $first ^(EXPRESSION $second))
    | WHERE VARIABLE_NAME IN oneOf -> ^(IN_SET_CONSTRAINT VARIABLE_NAME oneOf)
  ; 
 
 actions
  :
    BEGIN action (COMMA action)* END -> ^(ACTIONS action+)
  ;
 
 action	
  : 
      ADD axiom -> ^(ADD axiom)
  |   REMOVE axiom -> ^(REMOVE axiom)
  ;
 

 
 
opplFunction
  :
      CREATE OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^(CREATE_OPPL_FUNCTION stringOperation)
    | CREATE_INTERSECTION  OPEN_PARENTHESYS unary  CLOSED_PARENTHESYS -> ^(CREATE_INTERSECTION unary)
    | CREATE_DISJUNCTION OPEN_PARENTHESYS unary CLOSED_PARENTHESYS -> ^(CREATE_INTERSECTION unary)
  ;

stringOperation
  :
    stringExpression (PLUS stringExpression)* -> ^(STRING_OPERATION stringExpression+)
  ;
  
stringExpression
	:
		DBLQUOTE -> ^(DBLQUOTE)
	    |	variableAttributeReference -> ^(variableAttributeReference)
	;



unary 
  :
    IDENTIFIER
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])     
    | createIdentifier -> ^(createIdentifier)
    | variableAttributeReference -> ^(variableAttributeReference)
    | NOT OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(NEGATED_EXPRESSION expression)
    | NOT IDENTIFIER -> ^(NEGATED_EXPRESSION IDENTIFIER)
    | NOT VARIABLE_NAME -> ^(NEGATED_EXPRESSION ^(IDENTIFIER[$VARIABLE_NAME]))          
    | ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
    | qualifiedRestriction -> ^(qualifiedRestriction)
    | constant    
  ;

propertyExpression  :
      IDENTIFIER -> ^(IDENTIFIER)
    | complexPropertyExpression -> ^(complexPropertyExpression)
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])
    | createIdentifier -> ^(createIdentifier)
    ;

value:
      IDENTIFIER -> ^(IDENTIFIER) 
    | constant -> ^(constant)
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])
  ;

filler: 
    IDENTIFIER -> ^(IDENTIFIER)
    | createIdentifier -> ^(createIdentifier)
    | OPEN_PARENTHESYS expression CLOSED_PARENTHESYS -> ^(expression)
    | VARIABLE_NAME -> ^(IDENTIFIER[$VARIABLE_NAME])
 ;


createIdentifier 
  :
   ESCLAMATION_MARK IDENTIFIER  -> ^(IDENTIFIER[$ESCLAMATION_MARK.getText()+ $IDENTIFIER.getText()])  
  ;

variableAttributeReference
  :
    VARIABLE_NAME DOT (a = VALUES | a = RENDERING)   ->^(IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $a.getText()] VARIABLE_NAME DOT $a)
    | VARIABLE_NAME DOT GROUPS attributeSelector  ->^(IDENTIFIER[$VARIABLE_NAME.getText()+$DOT.getText() + $GROUPS.getText()+$attributeSelector.selectorText]  VARIABLE_NAME DOT GROUPS attributeSelector)        
  ;


  
attributeSelector returns [String selectorText]
  :
    OPEN_PARENTHESYS i = INTEGER CLOSED_PARENTHESYS
    {
      $selectorText = $OPEN_PARENTHESYS.getText() + $i.getText() + $CLOSED_PARENTHESYS.getText();
    } 
    ->  ^(ATTRIBUTE_SELECTOR INTEGER)
    
  ;