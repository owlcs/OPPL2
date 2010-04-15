lexer grammar OWLGeneralLexer;
 


//@header {
//  package org.coode.parsers; 
//}




COMPOSITION	:
	'o'
	;

OPEN_PARENTHESYS	:
	'('
;

OPEN_CURLY_BRACES	:
		'{'
	;

CLOSED_CURLY_BRACES	:
		'}'
	;

CLOSED_PARENTHESYS	:
	')'
;

WHITESPACE  : (' '| '\t'| '\n' | '\r') {$channel= HIDDEN;}
  ;

AND : 'and'
	;
OR	:	'or'
	;	
NOT	: 'not' 
	;
SOME	: 'some'
	;
ONLY	: 'only'
	;
MIN		: 'min'
	;
MAX		: 'max'
	;
EXACTLY		: 'exactly'
	;
VALUE	: 'value'
	;
INVERSE	: 'INV'
	;

SUBCLASS_OF	: 'subClassOf'
	;

SUB_PROPERTY_OF	: 'subPropertyOf'
	;
EQUIVALENT_TO	: 'equivalentTo'
	;	

SAME_AS	:'sameAs'
	;

DIFFERENT_FROM	: 'differentFrom'
	;

INVERSE_OF: 	'InverseOf'
	;
DISJOINT_WITH	: 'DisjointWith'
	;
	
DOMAIN  :
    'Domain'   
  ;
RANGE  :
    'Range'   
  ;  
  

  
 FUNCTIONAL : 'Functional'
	;
 SYMMETRIC : 'Symmetric'
	;	
 ANTI_SYMMETRIC : 'AntiSymmetric'
	;
 REFLEXIVE : 'Reflexive'
	;
 IRREFLEXIVE : 'Irreflexive'
	;
 TRANSITIVE  : 'Transitive'
  ;	

INVERSE_FUNCTIONAL: 	'InverseFunctional'
	;		
	POW : '^'
	;
	
COMMA	:
		','
	;
	
INSTANCE_OF : 'InstanceOf'  
  ;

TYPES : 'types'
  ;  

		


DBLQUOTE :  
      '"'
      (~'"' | '""')*
      '"'
   ;

