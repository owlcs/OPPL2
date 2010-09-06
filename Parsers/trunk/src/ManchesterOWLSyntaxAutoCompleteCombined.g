grammar ManchesterOWLSyntaxAutoCompleteCombined;

options {
  output = AST;              // build trees
  ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes
  language = Java;
}
import   MOWLLexer,  ManchesterOWLSyntaxAutoCompleteBase;  

@header {
  package org.coode.parsers;
}

  
main: 
(   
  options {backtrack=true;}:  
    expression -> ^(STANDALONE_EXPRESSION expression)
  | axiom  -> ^(axiom)
  | incompleteAxiom  -> ^(incompleteAxiom)
  | incompleteExpression  -> ^(incompleteExpression)
 )
; 
 