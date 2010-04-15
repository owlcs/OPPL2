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

// Identifiers need to take into account variables now.
IDENTIFIER
  :
   QUESTION_MARK? LETTER (LETTER  | DIGIT |'-'|'_')*
   
  ;
ENTITY_REFERENCE :
		'\'' IDENTIFIER+ '\''
		;
