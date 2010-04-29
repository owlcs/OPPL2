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
NOT : 'not' 
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

SAME_AS :'sameAs'
  ;

DIFFERENT_FROM  : 'differentFrom'
  ;

INVERSE_OF:   'InverseOf'
  ;
DISJOINT_WITH : 'DisjointWith'
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

INVERSE_FUNCTIONAL:   'InverseFunctional'
  ;   
  POW : '^'
  ;
  
COMMA :
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
