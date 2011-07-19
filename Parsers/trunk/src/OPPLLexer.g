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
	| 'ANNOTATIONPROPERTY'
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
  
DISJOINT_CLASSES 
	: 
	('D'|'d')('I'|'i')('S'|'s')('J'|'j')('O'|'o')('I'|'i')('N'|'n')('T'|'t')('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')('E'|'e')('S'|'s')':'? 
	;

DISJOINT_PROPERTIES 
	: 
	('D'|'d')('I'|'i')('S'|'s')('J'|'j')('O'|'o')('I'|'i')('N'|'n')('T'|'t')('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('I'|'i')('E'|'e')('S'|'s')':'? 
	;

SAME_INDIVIDUAL 
	: ('S'|'s')('A'|'a')('M'|'m')('E'|'e')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('V'|'v')('I'|'i')('D'|'d')('U'|'u')('A'|'a')('L'|'l')':'? 
	;

DIFFERENT_INDIVIDUALS 
	: ('D'|'d')('I'|'i')('F'|'f')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('T'|'t')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('V'|'v')('I'|'i')('D'|'d')('U'|'u')('A'|'a')('L'|'l')('S'|'s')':'? 
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

SET
	:
		('S' |'s')('E'|'e')('T'|'t')
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
  
IRI_ATTRIBUTE_NAME
	:
		'IRI'
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

TO_LOWER_CASE
   :
   	('T'|'t')('O'|'o')('L'|'l')('O'|'o')('W'|'w')('E'|'e')('R'|'r')('C'|'c')('A'|'a')('S'|'s')('E'|'e') 
   ;		
TO_UPPER_CASE 
	:	 
	('T'|'t')('O'|'o')('U'|'u')('P'|'p')('P'|'p')('E'|'e')('R'|'r')('C'|'c')('A'|'a')('S'|'s')('E'|'e') 
	;
   	

