lexer grammar OPPLLexer; 

options {
  language = Java;
  tokenVocab = OPPLLexer;
}

import MOWLLexer;




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
    'createIntersection' | 'CreateIntersection'
  ;

 CREATE_DISJUNCTION
  :
    'createUnion' | 'CreateUnion'
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
  	|	'Match'
  ;

FAIL
	:
		'FAIL' 
		| 'fail'
		| 'Fail'
	;

VALUES
  :
    'VALUES'
  ;	


RENDERING
  :
    'RENDERING'
  ;


GROUPS
  :
    'GROUPS'
  ;
 
fragment  
QUESTION_MARK
  :
    '?'
  ;

ESCLAMATION_MARK
  :
    '!'
  ;

VARIABLE_NAME
  :
    QUESTION_MARK LETTER (LETTER  | DIGIT |'-'|'_')*
  ;
