/*
  Lexer grammar providing tokens for OPPL OWL lint. Please notice that the code generator 
  generates errouneous code. The code compiles, but raises a NullPointerException when run.
  This is because the member org.coode.parsers.oppl.lint.OPPLLintLexer.gMOWLLexer is never initialised therefore 
  each call to its memebers will raise the exception. 
  This can be corrected by hand by replacing all the refrences to org.coode.parsers.oppl.patterns.OPPLPatternLexer.gMOWLLexer 
   with refernces to  org.coode.parsers.oppl.lint.OPPLLintLexer.gOPPLLexer
*/
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

 WS       :           (' '|'\t'|'\f'|'\n'|'\r')+{ $channel=HIDDEN; };
 
 INFERENCE
 	:
 		('I'|'i')('N'|'n')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e') SEMICOLON
 	;



