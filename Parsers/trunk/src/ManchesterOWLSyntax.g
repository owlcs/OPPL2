grammar ManchesterOWLSyntax;




options {
  output = AST;              // build trees
  ASTLabelType = ManchesterOWLSyntaxTree; // use custom tree nodes
  language = Java;
}


tokens {
  SUB_CLASS_AXIOM;
  EQUIVALENT_TO_AXIOM;
  DISJOINT_WITH_AXIOM ;
  SUB_PROPERTY_AXIOM; 
  SAME_AS_AXIOM;  
  DIFFERENT_FROM_AXIOM;
  UNARY_AXIOM;
  DISJUNCTION;
  CONJUNCTION;
  PROPERTY_CHAIN;
  NEGATED_EXPRESSION;
  NEGATED_ASSERTION;
  INVERSE_PROPERTY;
  SOME_RESTRICTION;
  ALL_RESTRICTION;
  VALUE_RESTRICTION;
  CARDINALITY_RESTRICTION;
  ONE_OF;
  TYPE_ASSERTION;
  ROLE_ASSERTION;
  INVERSE_OBJECT_PROPERTY_EXPRESSION;
  EXPRESSION;
  CONSTANT;  
}  
@header {
  package org.coode.oppl.syntax;
}

@lexer::header {
   package org.coode.oppl.syntax; 
}

@members {

  private  ErrorListener errorListener;
  
      public ManchesterOWLSyntaxParser(TokenStream input, ErrorListener errorListener) {
        this(input, new RecognizerSharedState(),errorListener);
      }
      public ManchesterOWLSyntaxParser(TokenStream input, RecognizerSharedState state, ErrorListener errorListener) {
        super(input, state);
        if(errorListener==null){
           throw new NullPointerException("The error listener cannot be null");
        }
          this.errorListener = errorListener; 
      }
  
  
  protected void mismatch (IntStream input, int ttype, BitSet follow) throws RecognitionException {
    throw new MismatchedTokenException(ttype,input);
  }
  
  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException{
    throw e;
  }
}

@rulecatch{
  catch(RecognitionException e){
    if(errorListener!=null){
      errorListener.recognitionException(e);
    }
  }
  
  catch(RewriteEmptyStreamException e){
    if(errorListener!=null){
      errorListener.rewriteEmptyStreamException(e);
    }
  }
}



main:
	axiom EOF -> ^(axiom)
	;

axiom	:
		binaryAxiom -> ^(binaryAxiom)
		| unaryAxiom -> ^(unaryAxiom)
		| assertionAxiom -> ^(assertionAxiom)
	;


assertionAxiom:
  i = IDENTIFIER (INSTANCE_OF | TYPES) expression -> ^(TYPE_ASSERTION ^(EXPRESSION expression) ^(EXPRESSION $i))
  |  IDENTIFIER propertyExpression  value -> ^(ROLE_ASSERTION ^(EXPRESSION IDENTIFIER) ^(EXPRESSION propertyExpression) ^(EXPRESSION value))
  
  | NOT assertionAxiom -> ^(NEGATED_ASSERTION assertionAxiom)
;



binaryAxiom :
    lhs =  expression (  
                SUBCLASS_OF  superClass = expression -> ^(SUB_CLASS_AXIOM  ^(EXPRESSION $lhs) ^(EXPRESSION $superClass))
                | EQUIVALENT_TO rhs = expression -> ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $rhs))
                | DISJOINT_WITH disjoint = expression -> ^(DISJOINT_WITH_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $disjoint))
                | SUB_PROPERTY_OF superProperty = propertyExpression -> ^(SUB_PROPERTY_AXIOM ^(EXPRESSION $lhs) ^(EXPRESSION $superProperty))                
                )
    |
    lhsID = IDENTIFIER  (
                    SAME_AS  rhsID = IDENTIFIER -> ^(SAME_AS_AXIOM ^(EXPRESSION  $lhsID) ^(EXPRESSION $rhsID))
                  | DIFFERENT_FROM  rhsID = IDENTIFIER -> ^(DIFFERENT_FROM_AXIOM ^(EXPRESSION $lhsID) ^(EXPRESSION $rhsID))
                  | DOMAIN expression -> ^(DOMAIN ^(EXPRESSION $lhsID) ^(EXPRESSION expression))
                  | RANGE expression -> ^(RANGE ^(EXPRESSION $lhsID) ^(EXPRESSION expression))
                  | INVERSE_OF rhsID = IDENTIFIER -> ^(INVERSE_OF ^(EXPRESSION $lhsID) ^(EXPRESSION $rhsID))
                  )    
                
   ;

unaryAxiom  :       
   unaryCharacteristic   IDENTIFIER -> ^(UNARY_AXIOM unaryCharacteristic ^(EXPRESSION IDENTIFIER))                
  ;

unaryCharacteristic :
    FUNCTIONAL -> ^(FUNCTIONAL)
    | INVERSE_FUNCTIONAL -> ^(INVERSE_FUNCTIONAL)
    | SYMMETRIC -> ^(SYMMETRIC)
    | ANTI_SYMMETRIC -> ^(ANTI_SYMMETRIC)
    | REFLEXIVE -> ^(REFLEXIVE)
    | IRREFLEXIVE -> ^(IRREFLEXIVE)
    | TRANSITIVE -> ^(TRANSITIVE)
  ;

expression:
    (		
    	options {backtrack=true;}: 
			head = propertyExpression ('o' rest+=propertyExpression )+ -> ^(PROPERTY_CHAIN  $head $rest)
			| conjunction (OR conjunction)* -> ^(DISJUNCTION  conjunction+)
			| complexPropertyExpression -> ^(complexPropertyExpression)
		)
		
	;
	

	
conjunction	:
			 unary (AND unary)* -> ^(CONJUNCTION unary+)
	;

complexPropertyExpression:
	INVERSE '(' complexPropertyExpression ')' -> ^(INVERSE_OBJECT_PROPERTY_EXPRESSION complexPropertyExpression)
	|	INVERSE '(' IDENTIFIER ')'-> ^(INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER)
	;
	
unary	:
		IDENTIFIER 
		| NOT '('expression')' -> ^(NEGATED_EXPRESSION expression)
		| NOT IDENTIFIER -> ^(NEGATED_EXPRESSION IDENTIFIER) 				 	
		| ENTITY_REFERENCE -> ^(ENTITY_REFERENCE)
		| qualifiedRestriction -> ^(qualifiedRestriction)
		| constant		
	;
	
qualifiedRestriction:
        (
          options{backtrack = true;}:
				  propertyExpression  SOME   filler  -> ^(SOME_RESTRICTION propertyExpression filler)				 					
				|	propertyExpression ONLY  filler  -> ^(ALL_RESTRICTION propertyExpression filler)
				| cardinalityRestriction -> ^(cardinalityRestriction)
				| oneOf -> ^(oneOf)
				| valueRestriction -> ^(valueRestriction)
				)
		;
		
propertyExpression  :
      IDENTIFIER -> ^(IDENTIFIER)
    | complexPropertyExpression -> ^(complexPropertyExpression)
    ;
		
cardinalityRestriction	:
					propertyExpression  restrictionKind INTEGER filler? -> ^(CARDINALITY_RESTRICTION  restrictionKind INTEGER propertyExpression  filler?)
		;
		
restrictionKind :
    MIN -> ^(MIN)
    | MAX -> ^(MAX)
    | EXACTLY -> ^(EXACTLY)
    ;
filler: 
    IDENTIFIER -> ^(IDENTIFIER)
    | '(' expression ')' -> ^(expression)
 ;

oneOf	:
		'{' IDENTIFIER (',' IDENTIFIER)*'}' -> ^(ONE_OF IDENTIFIER+)
	;
	
valueRestriction	: propertyExpression VALUE value -> ^(VALUE_RESTRICTION propertyExpression value)
	;

value:
      IDENTIFIER -> ^(IDENTIFIER)
    | constant -> ^(constant)
  ;

INTEGER: DIGIT+ ;
fragment LETTER : ('a'..'z' | 'A'..'Z');	
fragment DIGIT: '0' .. '9';

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


	
INSTANCE_OF : 'InstanceOf'  
  ;

TYPES : 'types'
  ;  
IDENTIFIER : LETTER (LETTER  | DIGIT |'-'|'_' | ':')*;
ENTITY_REFERENCE :
		'\'' IDENTIFIER+ '\''
		;
		
constant  :  constantValue = DBLQUOTE ('^'type = IDENTIFIER)? ->^(CONSTANT $constantValue $type?) 
  ;

DBLQUOTE :  
      '"'
      (~'"' | '""')*
      '"'
   ;
