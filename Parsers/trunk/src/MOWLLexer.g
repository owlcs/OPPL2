lexer grammar MOWLLexer;

options {
  language = Java;
  tokenVocab = MOWLLexer;
}



COMPOSITION :
  'o'
  ;

OPEN_PARENTHESYS  :
  '('
;

OPEN_CURLY_BRACES :
    '{'
  ;

CLOSED_CURLY_BRACES :
    '}'
  ;

CLOSED_PARENTHESYS  :
  ')'
;

WHITESPACE  : (' '| '\t'| '\n' | '\r') {$channel= HIDDEN;}
  ;

AND : 'and'
  ;
OR  : 'or'
  ; 
NOT : 'not' | 'NOT' | 'Not'
  ;
SOME  : 'some'
  ;
ONLY  : 'only'
  ;
MIN   : 'min'
  ;
MAX   : 'max'
  ;
EXACTLY   : 'exactly'
  ;
VALUE : 'value'
  ;
INVERSE : 'INV'
  ;

SUBCLASS_OF : 'subClassOf'
  ;

SUB_PROPERTY_OF : 'subPropertyOf'
  ;
EQUIVALENT_TO : 'equivalentTo'
  ; 

SAME_AS :'sameAs' | 'SameAs'
  ;

DIFFERENT_FROM  : 'differentFrom' | 'DifferentFrom'
  ;

INVERSE_OF:   'InverseOf' | 'inverseOf'
  ;
DISJOINT_WITH : 'DisjointWith' | 'disjointWith'
  ;
  
DOMAIN  :
    'Domain' | 'domain'  
  ;
RANGE  :
    'Range' | 'range'   
  ;  
  

  
 FUNCTIONAL : 		'Functional'
 		| 	'functional'
  ;
 SYMMETRIC : 	'Symmetric'
 		| 'symmetric'	
  ; 
 ANTI_SYMMETRIC : 'AntiSymmetric'
 			| 'antiSymmetric'
 			| 'antisymmetric'
  ;
 REFLEXIVE : 'Reflexive'
 		| 'reflexive'
  ;
 IRREFLEXIVE : 'Irreflexive'
 		| 'irreflexive'
  ;
 TRANSITIVE  : 'Transitive'
 		| 'transitive'
  ; 

INVERSE_FUNCTIONAL:   'InverseFunctional'
			| 'inverseFunctional'
			| 'inversefunctional'
  ;   
  POW : '^'
  ;
  
COMMA :
    ','
  ;
  
INSTANCE_OF : 'InstanceOf' | 'instanceOf' 
  ;

TYPES : 'types' | 'Types'
  ;  

    


DBLQUOTE :  
      '"'
      (~'"' | '""')*
      '"'
      {
                 
                String quote, dblDblQuote, cont; 
                 
                char quoteChr = 34;                                   
                quote = "\n"; 
                String txt = getText(); 
                        
                // Remove first and last double-quote 
                if (txt.startsWith("\"")){
                   txt = txt.substring(1);
                } 
                if (txt.endsWith("\"")){                 
                  txt = txt.substring(0,txt.length() - 1);
                }
                setText(txt);                                
      }
   ;


INTEGER: DIGIT+ ;
fragment LETTER : ('a'..'z' | 'A'..'Z');  
fragment DIGIT: '0' .. '9';

IDENTIFIER : LETTER (LETTER  | DIGIT |'-'|'_' | ':')*;
ENTITY_REFERENCE :
    '\'' IDENTIFIER+ '\''
    ;
