parser grammar OPPLParser;
options {
  output = AST;              // build trees  
  language = Java;
  ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes
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
 }
 
 
 variableDefinitions
  :
    variableDefinition (COMMA variableDefinition)* -> ^(VARIABLE_DEFINITIONS variableDefinition+)
  ;
  
 variableDefinition
  :
      
      IDENTIFIER COLON VARIABLE_TYPE  EQUAL expression -> ^(GENERATED_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE ^(EXPRESSION expression))
    | IDENTIFIER COLON VARIABLE_TYPE  EQUAL opplFunction -> ^(GENERATED_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE ^(OPPL_FUNCTION opplFunction))
    | IDENTIFIER COLON VARIABLE_TYPE (variableScope)? -> ^(INPUT_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE variableScope?)
  ;
  


variableScope
  :
    OPEN_SQUARE_BRACKET variableScopeSpecification = (SUBCLASS_OF | SUBPROPERTY_OF | SUPER_CLASS_OF | SUPER_PROPERTY_OF) expression CLOSED_SQUARE_BRACKET -> ^(VARIABLE_SCOPE $variableScopeSpecification expression)
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
      WHERE first = VARIABLE_IDENTIFIER NOT_EQUAL second = expression -> ^(INEQUALITY_CONSTRAINT $first $second)
    | WHERE VARIABLE_IDENTIFIER IN oneOf -> ^(IN_SET_CONSTRAINT VARIABLE_IDENTIFIER oneOf)
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
      CREATE OPEN_PARENTHESYS DBLQUOTE (PLUS DBLQUOTE)* CLOSED_PARENTHESYS -> ^(CREATE_OPPL_FUNCTION DBLQUOTE+)
    | CREATE_INTERSECTION variableAttribute -> ^(CREATE_INTERSECTION variableAttribute)
    | CREATE_DISJUNCTION variableAttribute -> ^(CREATE_INTERSECTION variableAttribute)
  ;

variableAttribute
  :
    VARIABLE_IDENTIFIER DOT IDENTIFIER -> ^(VARIABLE_ATTRIBUTE VARIABLE_IDENTIFIER IDENTIFIER)
  ;

