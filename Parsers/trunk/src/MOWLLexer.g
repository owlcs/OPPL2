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
INVERSE : ('I'|'i')('N'|'n')('V'|'v')
  ;

SUBCLASS_OF : ('S'|'s')'ubClassOf'
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
  
HAS_KEY
	:
		('H'|'h')('A'|'a')('S'|'s')('K'|'k')('E'|'e')('Y'|'y')
	;
  
 FUNCTIONAL : 		('F'|'f')'unctional'':'?
  ;
 SYMMETRIC : 	('S'|'s')'ymmetric'':'?
	
  ; 
 ANTI_SYMMETRIC : ('A'|'a')'nti'('S'|'s')'ymmetric'':'?

  ;
 REFLEXIVE : ('R'|'r')'eflexive'':'?
  ;
 IRREFLEXIVE : ('I' |'i')'rreflexive'':'?
  ;
 TRANSITIVE  : ('T'|'t')'ransitive'':'?
  ; 

INVERSE_FUNCTIONAL:   ('I'|'i')'nverse'('F'|'f')'unctional'':'?

  ;   
  POW : '^'
  ;
  
COMMA :
    ','
  ;
  
INSTANCE_OF : ('I'|'i')'nstance'('O'|'o')'f'
  ;

TYPES : ('T'|'t')'ypes'
  ;  


OPEN_SQUARE_BRACKET
  :
    '['
  ;

CLOSED_SQUARE_BRACKET
  :
    ']'
  ;

EQUAL
  :
    '='
  ;

LESS_THAN	
	:
		'<'
	;
LESS_THAN_EQUAL
	:
		LESS_THAN EQUAL
	;
GREATER_THAN
	:
		'>'
	;
GREATER_THAN_EQUAL
	:
		GREATER_THAN EQUAL
	;    


DBLQUOTE :  
      '"'
      (~'"' | '""')*
      '"'
      {
 
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
    '\'' (~'\'' | '\'\'')* '\''
    {
                 

                String txt = getText(); 
                        
                // Remove first and last quote 
                if (txt.startsWith("'")){
                   txt = txt.substring(1);
                } 
                if (txt.endsWith("'")){                 
                  txt = txt.substring(0,txt.length() - 1);
                }
                setText(txt);                                
      }
    ;
