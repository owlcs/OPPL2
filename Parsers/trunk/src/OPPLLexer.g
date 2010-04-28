lexer grammar OPPLLexer; 

options {
  language = Java;
  tokenVocab = OPPLLexer;
}

import OWLGeneralLexer, OPPLIdentifiers;




VARIABLE_TYPE
  :
      'CLASS'
    | 'OBJECTPROPERTY'
    | 'DATAPROPERTY'
    | 'INDIVIDUAL'
    | 'CONSTANT'
  ;





  
 ADD
  :
    'ADD'
  ;
  
 REMOVE
  :
    'REMOVE'
  ;
 
 WHERE
  :
    'WHERE'
  ;

NOT_EQUAL
  :
    '!='  
  ;

EQUAL
  :
    '='
  ;

IN
  :
    'IN'
  ;

SELECT
  :
    'SELECT'
  ;

ASSERTED
  :
    'ASSERTED'
  ;
  
COLON
  :
    ':'
  ;
  
DOT
  :
    '.'
  ;



PLUS
  :
    '+'
  ;

 // OPPL functions
 
 CREATE
  :
    'create'
  ;
   
 CREATE_INTERSECTION
  :
    'createIntersection'
  ;

 CREATE_DISJUNCTION
  :
    'createUnion'
  ;
 
 BEGIN
  :
    'BEGIN'
  ;
 
 END
  :
    'END;'
  ;
  
OPEN_SQUARE_BRACKET
  :
    '['
  ;

CLOSED_SQUARE_BRACKET
  :
    ']'
  ;


SUPER_CLASS_OF
  :
    'superClassOf'
  ;  

SUPER_PROPERTY_OF
  :
    'superPropertyOf'
  ;

MATCH
  :
  	'MATCH'
  ;

fragment  
VALUES
  :
    'VALUES'
  ;	

fragment
RENDERING
  :
    'RENDERING'
  ;

fragment
GROUPS
  :
    'GROUPS'
  ;
  
VARIABLE_ATTRIBUTE
  :
    VALUES
  | RENDERING
  | GROUPS 
  ;