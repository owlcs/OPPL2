lexer grammar OPPLIdentifiers;

options {
  language = Java;
}

INTEGER: DIGIT+ ;
fragment LETTER : ('a'..'z' | 'A'..'Z');	
fragment DIGIT: '0' .. '9';
fragment QUESTION_MARK
  :
    '?'
  ;

fragment ESCLAMATION_MARK
  :
    '!'
  ;


// Identifiers need to take into account variables now.
fragment
VARIABLE_IDENTIFIER
  :
   QUESTION_MARK LETTER (LETTER  | DIGIT |'-'|'_')*   
  ;
fragment
CREATE_IDENTIFIER
  :
   ESCLAMATION_MARK LETTER (LETTER  | DIGIT |'-'|'_')*   
  ;
fragment
PLAIN_IDENTIFIER
  :
    LETTER (LETTER  | DIGIT |'-'|'_')*   
  ;
    
IDENTIFIER
  :
  	PLAIN_IDENTIFIER
  	|	CREATE_IDENTIFIER
  	|	VARIABLE_IDENTIFIER (DOT VARIABLE_ATTRIBUTE)?  	   	   
  ;  
  
ENTITY_REFERENCE :
		'\'' IDENTIFIER+ '\''
		;
