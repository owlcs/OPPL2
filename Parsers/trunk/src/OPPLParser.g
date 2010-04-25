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
      
      IDENTIFIER COLON VARIABLE_TYPE  EQUAL expression -> ^(GENERATED_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE ^(EXPRESSION expression))
    | IDENTIFIER COLON VARIABLE_TYPE  EQUAL opplFunction -> ^(GENERATED_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE ^(opplFunction))
    | IDENTIFIER COLON VARIABLE_TYPE  EQUAL MATCH OPEN_PARENTHESYS stringOperation CLOSED_PARENTHESYS -> ^(GENERATED_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE ^(MATCH stringOperation))
    | IDENTIFIER COLON VARIABLE_TYPE (variableScope)? -> ^(INPUT_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE variableScope?)    
  ;
  


variableScope
  :
    OPEN_SQUARE_BRACKET variableScopeSpecification = (SUBCLASS_OF | SUBPROPERTY_OF | SUPER_CLASS_OF | SUPER_PROPERTY_OF | INSTANCE_OF | TYPES) expression CLOSED_SQUARE_BRACKET -> ^(VARIABLE_SCOPE $variableScopeSpecification ^(EXPRESSION expression))
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
      WHERE first = IDENTIFIER NOT_EQUAL second = expression -> ^(INEQUALITY_CONSTRAINT $first ^(EXPRESSION $second))
    | WHERE IDENTIFIER IN oneOf -> ^(IN_SET_CONSTRAINT IDENTIFIER oneOf)
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
    | CREATE_INTERSECTION IDENTIFIER -> ^(CREATE_INTERSECTION IDENTIFIER)
    | CREATE_DISJUNCTION IDENTIFIER -> ^(CREATE_INTERSECTION IDENTIFIER)
  ;

stringOperation
  :
    stringExpression (PLUS stringExpression)* -> ^(STRING_OPERATION stringExpression+)
  ;
  
stringExpression
	:
		DBLQUOTE -> ^(DBLQUOTE)
	    |	IDENTIFIER attributeSelector? -> ^(IDENTIFIER attributeSelector?)
	;



attributeSelector
	:
		OPEN_PARENTHESYS INTEGER CLOSED_PARENTHESYS ->  ^(ATTRIBUTE_SELECTOR INTEGER)
	;




