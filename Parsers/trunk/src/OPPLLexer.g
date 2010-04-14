lexer grammar OPPLLexer;

options {
  language = Java;
}

import MOWLLexer;





VARIABLE_IDENTIFIER
	: 
		QUESTION_MARK IDENTIFIER
	;

QUESTION_MARK
	:
		'?'
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

VARIABLE_TYPE
  :
      'CLASS'
    | 'OBJECTPROPERTY'
    | 'DATAPROPERTY'
    | 'INDIVIDUAL'
    | 'CONSTANT'
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