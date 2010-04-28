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
  import org.coode.parsers.ManchesterOWLSyntaxTree;
}

  

statement
  :
    variableDefinitions query actions -> ^(OPPL_STATEMENT variableDefinitions query actions)
  ;

  

  