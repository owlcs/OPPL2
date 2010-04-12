grammar ManchesterOWLSyntaxAutoCompleteCombined;

options {
  output = AST;              // build trees
  ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes
  language = Java;
}
import  MOWLLexer,  ManchesterOWLSyntaxAutoCompleteBase;  

@header {
  package org.coode.parsers;
}
@lexer::header{
	package org.coode.parsers;  
}
  
main: 
(   
  options {backtrack=true;}:  
    standaloneExpression -> ^(standaloneExpression)
  | axiom EOF -> ^(axiom)
  | incompleteAxiom EOF -> ^(incompleteAxiom)
  | incompleteExpression EOF -> ^(incompleteExpression)
 )
; 
