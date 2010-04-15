tree grammar OPPLSimplify;
options{
	tokenVocab = OPPLScript;
	filter=true;
	  output= AST;
}





@header {
  package org.coode.parsers.oppl;
}

bottomup  : 
    conjunction 
    |	disjunction
  
  ;
   
conjunction :
  ^(CONJUNCTION single= expression) -> ^($single)
  ;
 
disjunction  :
	^(DISJUNCTION single= expression) -> ^($single) 
	; 
 
 expression	:
 	.|
 	; 