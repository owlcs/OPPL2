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

AT
	:
		'@'
	;

WHITESPACE  : (' '| '\t'| '\n' | '\r') {$channel= HIDDEN;}
  ;

AND : ('A'|'a')('N'|'n')('D'|'d') ;
OR : ('O'|'o')('R'|'r') ;
NOT : ('N'|'n')('O'|'o')('T'|'t') ;
SOME  : ('S'|'s')('O'|'o')('M'|'m')('E'|'e') ;
ONLY : ('O'|'o')('N'|'n')('L'|'l')('Y'|'y') ;
MIN : ('M'|'m')('I'|'i')('N'|'n') ;
MAX : ('M'|'m')('A'|'a')('X'|'x') ;
EXACTLY : ('E'|'e')('X'|'x')('A'|'a')('C'|'c')('T'|'t')('L'|'l')('Y'|'y') ;
VALUE : ('V'|'v')('A'|'a')('L'|'l')('U'|'u')('E'|'e') ;
INVERSE : ('I'|'i')('N'|'n')('V'|'v') ;
SUBCLASS_OF : ('S'|'s')('U'|'u')('B'|'b')('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')('O'|'o')('F'|'f') ;
SUB_PROPERTY_OF : ('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('Y'|'y')('O'|'o')('F'|'f') ;
EQUIVALENT_TO : ('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('V'|'v')('A'|'a')('L'|'l')('E'|'e')('N'|'n')('T'|'t')('T'|'t')('O'|'o') ;
SAME_AS : ('S'|'s')('A'|'a')('M'|'m')('E'|'e')('A'|'a')('S'|'s') ;
DIFFERENT_FROM  : ('D'|'d')('I'|'i')('F'|'f')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('T'|'t')('F'|'f')('R'|'r')('O'|'o')('M'|'m') ;
INVERSE_OF:   ('I'|'i')('N'|'n')('V'|'v')('E'|'e')('R'|'r')('S'|'s')('E'|'e')('O'|'o')('F'|'f') ;
DISJOINT_WITH : ('D'|'d')('I'|'i')('S'|'s')('J'|'j')('O'|'o')('I'|'i')('N'|'n')('T'|'t')('W'|'w')('I'|'i')('T'|'t')('H'|'h') ;
DOMAIN  :('D'|'d')('O'|'o')('M'|'m')('A'|'a')('I'|'i')('N'|'n') ;
RANGE  :('R'|'r')('A'|'a')('N'|'n')('G'|'g')('E'|'e') ;
HAS_KEY	: ('H'|'h')('A'|'a')('S'|'s')('K'|'k')('E'|'e')('Y'|'y');
FUNCTIONAL : ('F'|'f')('U'|'u')('N'|'n')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l')':'?;
SYMMETRIC : ('S'|'s')('Y'|'y')('M'|'m')('M'|'m')('E'|'e')('T'|'t')('R'|'r')('I'|'i')('C'|'c')':'?; 
ANTI_SYMMETRIC : ('A'|'a')'nti'?('S'|'s')'ymmetric'':'?;
TYPES : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e')('S'|'s')? ;
REFLEXIVE : ('R'|'r')('E'|'e')('F'|'f')('L'|'l')('E'|'e')('X'|'x')('I'|'i')('V'|'v')('E'|'e')':'?;
IRREFLEXIVE : ('I'|'i')('R'|'r')('R'|'r')('E'|'e')('F'|'f')('L'|'l')('E'|'e')('X'|'x')('I'|'i')('V'|'v')('E'|'e')':'?;
TRANSITIVE  : ('T'|'t')('R'|'r')('A'|'a')('N'|'n')('S'|'s')('I'|'i')('T'|'t')('I'|'i')('V'|'v')('E'|'e')':'?; 
INVERSE_FUNCTIONAL:  ('I'|'i')('N'|'n')('V'|'v')('E'|'e')('R'|'r')('S'|'s')('E'|'e')('F'|'f')('U'|'u')('N'|'n')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l')':'?;
INSTANCE_OF : ('I'|'i')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('C'|'c')('E'|'e')('O'|'o')('F'|'f') ;
POW : '^'
  ;
  
COMMA :
    ','
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

IRI
	:
	LESS_THAN(LETTER | DIGIT |'-'|'_' | ':' |'/'|'#' |'\\'|'\?' |'.' )+ GREATER_THAN
	{
		//Proper parsing of the IRI should happen elsewhere
		String txt = getText(); 
                // Remove delimiters
                if (txt.startsWith("<")){
                   txt = txt.substring(1);
                } 
                if (txt.endsWith(">")){                 
                  txt = txt.substring(0,txt.length() - 1);
                }
                setText(txt);
                
	}
	;
	
LESS_THAN_EQUAL
	:
		LESS_THAN EQUAL
	;
LESS_THAN	
	:
		'<'
	;	

GREATER_THAN_EQUAL
	:
		GREATER_THAN EQUAL
	;    
GREATER_THAN
	:
		'>'
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
