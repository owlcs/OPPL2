lexer grammar OPPLPatternLexer; 

options {
  language = Java;
  tokenVocab = OPPLPatternLexer;
}

import OPPLLexer;

fragment  DOLLAR
  :
    '$'
  ;


// Identifiers need to take into account variables and external pattern references and $thisClass.

fragment  THIS_CLASS
  :
    '$thisClass' 
  ;

RETURN
  :
    'RETURN'
  ;

IDENTIFIER
  :
    PLAIN_IDENTIFIER
    | CREATE_IDENTIFIER
    | VARIABLE_IDENTIFIER (DOT VARIABLE_ATTRIBUTE)?
    | THIS_CLASS               
  ;


// Remember to add the following lines in the constructor 
/* 

this.gOPPLIdentifiers = new OPPLPatternLexer_OPPLLexer_OPPLIdentifiers(input, state, this,
        this.gOPPLLexer);
    this.gOWLGeneralLexer = new OPPLPatternLexer_OPPLLexer_OWLGeneralLexer(input, state, this,
        this.gOPPLLexer);
*/