tree grammar ManchesterOWLSyntaxAutoComplete;

options {
  language = Java;
  tokenVocab = ManchesterOWLSyntax;
  ASTLabelType = ManchesterOWLSyntaxTree;
  filter=true;
}

@members{
  private  SymbolTable symtab;
  
  public ManchesterOWLSyntaxAutoComplete(TreeNodeStream input, SymbolTable symtab) {
    this(input);
    if(symtab==null){
    	throw new NullPointerException("The symbol table cannot be null");
    }
    
    this.symtab = symtab;
  
  }
  
  
  
  public SymbolTable getSymbolTable(){
  	return this.symtab;
  }
  
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    
  }
  
  protected void mismatch (IntStream input, int ttype, BitSet follow) throws RecognitionException {
    
  }
  

  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException{
    return null;
  }
  
}

@rulecatch{
  catch(RecognitionException exception){
   
  }
  
  catch(RewriteEmptyStreamException exception){
  
  }
}

@header {
  package org.coode.parsers;
  import java.util.Collections;
  import org.semanticweb.owl.model.OWLObject;
  import org.semanticweb.owl.model.OWLAxiom;
}



// START: root
bottomup // match subexpressions innermost to outermost
    :   expressionRoot // only match the start of expressions (root EXPRESSION) 	   
    | 	axiom     
    ;

expressionRoot // invoke type computation rule after matching EXPRESSION
    :   ^(EXPRESSION expression) {$EXPRESSION.setCompletions($expression.completions);} // annotate AST
    ;
// END: root 


axiom returns [List<String> completions] 
@after 
			{ 
			$start.setCompletions($completions);
			} // do after any alternative
:
		^(SUB_CLASS_AXIOM  ^(EXPRESSION  subClass = expression) ^( EXPRESSION  superClass = expression))
		{			
			$completions = superClass.completions;
		}
	|  ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION lhs = expression) ^(EXPRESSION  rhs = expression))
	   {	    
	    $completions = rhs.completions;
	   }	
	| ^(INVERSE_OF ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION anotherProperty = IDENTIFIER))
	{	   
	   $completions = anotherProperty.getCompletions();
	}
  | ^(DISJOINT_WITH_AXIOM ^(EXPRESSION lhs =  expression) ^(EXPRESSION rhs = expression)){     
     $completions = rhs.completions;
  }	  
	|	^(SUB_PROPERTY_AXIOM ^(EXPRESSION  subProperty = expression) ^(EXPRESSION superProperty = unary))
		{			
			$completions = superProperty.completions;
		}		
	| ^(ROLE_ASSERTION ^(EXPRESSION  subject = IDENTIFIER) ^(EXPRESSION  predicate = propertyExpression) ^(EXPRESSION object = unary)){	   
	   $completions = object.completions;
	 }
	|  ^(TYPE_ASSERTION ^(EXPRESSION  description = expression) ^(EXPRESSION subject = IDENTIFIER))
	{
	   $completions = subject.getCompletions();
	} 
	| ^(DOMAIN ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION domain = expression))
	 {
	   $completions = domain.completions;
	 }
	 | ^(RANGE ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION range = expression))
   {
     $completions = range.completions;;
   }
   | ^(SAME_AS_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
    $completions = anotherIndividual.getCompletions();
   }
    | ^(DIFFERENT_FROM_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
    $completions = anotherIndividual.getCompletions();
   }
	 | ^(UNARY_AXIOM FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
	 {
	   $completions = p.getCompletions();
	 }
	 | ^(UNARY_AXIOM INVERSE_FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
   {
     $completions = p.getCompletions();
   }
    | ^(UNARY_AXIOM IRREFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {     
     $completions = p.getCompletions();
   }
   | ^(UNARY_AXIOM REFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {
			$completions = p.getCompletions();   
	 }
   | ^(UNARY_AXIOM SYMMETRIC ^(EXPRESSION p = IDENTIFIER))
   {
			$completions = p.getCompletions();
   } 
    | ^(UNARY_AXIOM TRANSITIVE ^(EXPRESSION p = IDENTIFIER))
   {
     $completions = p.getCompletions();
   }
   | ^(NEGATED_ASSERTION a =axiom){
     $completions = a.completions;
   }     
;

expression returns [List<String> completions]
@after 
		{ 
			$start.setCompletions($completions);
		} // do after any alternative
	: 
		 ^(DISJUNCTION  head+=.+  lastDisjunct  =conjunction) 
		 {	
				$completions = lastDisjunct.completions;
		 	}
		|  ^(PROPERTY_CHAIN  .*  last =expression)
		  {
		    $completions = last.completions;
		  }
		| conjunction  
		{
			$completions = $conjunction.completions;
		}
		| complexPropertyExpression 
		{
			$completions = $complexPropertyExpression.completions;		
		}		
; 

conjunction returns [List<String> completions]

@after 
			{ 
				$start.setCompletions($completions);
			} // do after any alternative
	:
	^(CONJUNCTION  head+=.+  last = unary)	
	{	
	  
		$completions = last.completions;     
	}
	| unary {
		$completions = $unary.completions;
	}
;




unary returns [List<String> completions]
@after 
			{ 
				$start.setCompletions($completions);
			} // do after any alternative
:
		IDENTIFIER 
			{
				
				$completions = new ArrayList<String>(this.getSymbolTable().match($IDENTIFIER.getText()));
			}
		| ^(NEGATED_EXPRESSION e = expression) 
			{
				$completions = e.completions;
			}	
		| qualifiedRestriction 	
			{
				$completions = $qualifiedRestriction.completions;
			} 
		| ENTITY_REFERENCE 
			{
				
				$completions = new ArrayList<String>(this.getSymbolTable().match($ENTITY_REFERENCE.getText()));
			}
		| ^(CONSTANT  value=. constantType = IDENTIFIER?) {
		    if(constantType==null){
				  $completions = Collections.emptyList();
				}else{
				  $completions = new ArrayList<String>(this.getSymbolTable().match(constantType.getText()));
				}				
			}
	;


propertyExpression  returns [List<String> completions]
@after 
			{ 
				$start.setCompletions($completions);
			} // do after any alternative
:
      IDENTIFIER
      {
        
        $completions = new ArrayList<String>(this.getSymbolTable().match($IDENTIFIER.getText()));
      }
    | complexPropertyExpression
      {
        $completions = $complexPropertyExpression.completions;
      }
    ;

complexPropertyExpression returns [List<String> completions]
@after { 
          	$start.setCompletions($completions);
       } // do after any alternative
:
	^(INVERSE_OBJECT_PROPERTY_EXPRESSION p = complexPropertyExpression)
	{
		$completions = p.completions;
	}
	| ^(INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER)
	{
								
				$completions = new ArrayList<String>(this.getSymbolTable().match($IDENTIFIER.getText()));
	}
	;

qualifiedRestriction returns [List<String> completions]
@after { 
				$start.setCompletions($completions);
        } // do after any alternative
	:
					^(SOME_RESTRICTION p= propertyExpression  f= expression) 
					{						
						$completions = f.completions;
					}				
				|	^(ALL_RESTRICTION  p = propertyExpression f= expression) 
				{
					
					$completions = f.completions;
				}
				| cardinalityRestriction 
					{
						$completions = $cardinalityRestriction.completions;
					}
				| oneOf 
					{						
						$completions = $oneOf.completions;
					}
				| valueRestriction 
					{						
						$completions = $valueRestriction.completions;
					}
		;


 
cardinalityRestriction	returns [List<String> completions]
@after { 
					$start.setCompletions($completions);
        } // do after any alternative
:
		  ^(CARDINALITY_RESTRICTION  MIN  i=INTEGER p = unary  filler = expression?) 
		{
			if(filler==null){
      	$completions= $unary.completions;
      }else{
      	$completions= filler.completions;
      }
		}
		|  ^(CARDINALITY_RESTRICTION  MAX i=INTEGER p = unary  filler = expression?) 
    {
      if(filler==null){
      	$completions= $unary.completions;
      }else{
      	$completions= filler.completions;
      }
    }
    |  ^(CARDINALITY_RESTRICTION  EXACTLY i= INTEGER  p = unary  filler = expression?) 
    {
      if(filler==null){
      	$completions= $unary.completions;
      }else{
      	$completions= filler.completions;
      }
      
    }
		;
		
oneOf	returns  [List<String> completions]
@after { 
          $start.setCompletions($completions);
        }
	:
		^(ONE_OF individuals+=IDENTIFIER+) 
		{
		    List<ManchesterOWLSyntaxTree> nodes = new ArrayList<ManchesterOWLSyntaxTree>(list_individuals.size());
        for(Object node :list_individuals){
          nodes.add((ManchesterOWLSyntaxTree)node);
        }		    
		    if(!nodes.isEmpty()){
          $completions = nodes.get(nodes.size()-1).getCompletions();
        }
		}
	;

valueRestriction	returns [List<String> completions] 
@after {           
          $start.setCompletions($completions);
        }
	:  
		^(VALUE_RESTRICTION  p = unary  value = unary) 
		{
		  $completions=$value.completions;
		 }
	;
	

	
