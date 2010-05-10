/*
  Grammar that defines an OPPL statement. It imports its components from the OPPLParser grammar and
  its tokens from OPPL Lexer. Please notice that when ANTLR generates the corresponding code, it 
  inserts compilation errors. Such errors correspond to the rules in OPPLParser that 
  override those in MOWLParser. In other words, the code generator gets confused and tries to invoke 
  those rules on the MOWLParser delegate, rather than on the OPPLParser one. These can be easily
  amended by hand after the code genration.     
*/
grammar OPPLScript;

options {
  language = Java;
  output = AST;
  ASTLabelType = OPPLSyntaxTree; // use custom tree nodes
  tokenVocab = OPPLScript;
}

import OPPLLexer, OPPLParser;

tokens{
  OPPL_STATEMENT;
}
 
@header {
  package org.coode.parsers.oppl;
}

  

statement
  :
    variableDefinitions? query actions -> ^(OPPL_STATEMENT variableDefinitions? query actions)
  ;

  

  