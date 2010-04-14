lexer grammar MOWLIdentifiers;

options {
  language = Java;
}

INTEGER: DIGIT+ ;
fragment LETTER : ('a'..'z' | 'A'..'Z');	
fragment DIGIT: '0' .. '9';

IDENTIFIER : LETTER (LETTER  | DIGIT |'-'|'_' | ':')*;
ENTITY_REFERENCE :
		'\'' IDENTIFIER+ '\''
		;
