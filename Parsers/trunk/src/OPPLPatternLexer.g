lexer grammar OPPLPatternLexer; 

options {
  language = Java;
  tokenVocab = OPPLPatternLexer;
}

import OPPLLexer;

DOLLAR
  :
    '$'
  ;


// Identifiers need to take into account variables and external pattern references and $thisClass.

THIS_CLASS
  :
    '$thisClass' 
  ;

RETURN
  :
    'RETURN'
  ;

SEMICOLON
	:
		';'
	;


