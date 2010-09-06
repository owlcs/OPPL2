lexer grammar OPPLTestCaseLexer;

options {
  language = Java;
  tokenVocab = OPPLTestCaseLexer;
}
import OPPLLexer;

ASSERT	:
		('A'|'a')('S'|'s')('S'|'s')('E'|'e')('R'|'r')('T'|'t')
	;

COUNT
	:
		('C'|'c')('O'|'o')('U'|'u')('N'|'n')('T'|'t')
	;
	

SEMICOLON
	:
		';'
	;	

CONTAINS : 
	('C'|'c')('O'|'o')('N'|'n')('T'|'t')('A'|'a')('I'|'i')('N'|'n')('S'|'s') 
	;



	
 INFERENCE
 	:
 		('I'|'i')('N'|'n')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e') SEMICOLON
 	;	