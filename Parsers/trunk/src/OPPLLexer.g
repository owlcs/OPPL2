lexer grammar OPPLLexer; 

options {
  language = Java;
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
    'createDisjunction'
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

