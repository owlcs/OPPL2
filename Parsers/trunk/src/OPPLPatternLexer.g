/*
  Lexer grammar providing tokens for OPPL patterns. Please notice that the code generator 
  generates errouneous code. The code compiles, but raises a NullPointerException when run.
  This is because the member org.coode.parsers.oppl.patterns.OPPLPatternLexer.gMOWLLexer is never initialised therefore 
  each call to its memebers will raise the exception. 
  This can be corrected by hand by replacing all the refrences to org.coode.parsers.oppl.patterns.OPPLPatternLexer.gMOWLLexer 
   with refernces to  org.coode.parsers.oppl.patterns.OPPLPatternLexer.gOPPLLexer
*/
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


