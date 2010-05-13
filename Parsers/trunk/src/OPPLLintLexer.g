
lexer grammar OPPLLintLexer; 

options {
  language = Java;
  tokenVocab = OPPLLintLexer;
}

import OPPLLexer;

DOLLAR
  :
    '$'
  ;

RETURN
  :
    'RETURN'
  ;

SEMICOLON
	:
		';'
	;


