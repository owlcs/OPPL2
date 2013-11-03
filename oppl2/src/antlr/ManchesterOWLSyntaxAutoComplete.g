tree grammar ManchesterOWLSyntaxAutoComplete;

options {
  language = Java;
  tokenVocab = ManchesterOWLSyntaxAutoCompleteCombined;
  ASTLabelType = ManchesterOWLSyntaxTree; 
  filter=true;
}
 
@members{
  private  SymbolTable symtab;
  private boolean newWord= false;
  
  public ManchesterOWLSyntaxAutoComplete(TreeNodeStream input, SymbolTable symtab) {
    this(input);
    if(symtab==null){
    	throw new NullPointerException("The symbol table cannot be null");
    }
    
    this.symtab = symtab;
  
  }
  
  
  public boolean isNewWord(){
  	return this.newWord;
  }
  
  public void setNewWord(boolean b){
  	this.newWord = b;
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
  import org.semanticweb.owlapi.model.OWLObject;
  
}
 


// START: root
bottomup // match subexpressions innermost to outermost
    :   
    |	standaloneExpression
    | 	expressionRoot // only match the start of expressions (root EXPRESSION) 
    |   incompleteAxiom
    |   incompleteExpression
    | 	axiom        
    ;

expressionRoot // invoke type computation rule after matching EXPRESSION
    :   ^(EXPRESSION e = expression) {$EXPRESSION.setCompletions(e.node.getCompletions());} // annotate AST
    ;
// END: root 


standaloneExpression
		: ^(STANDALONE_EXPRESSION ^(EXPRESSION e= expression))  
			{ 
			    List<String> completions = new ArrayList<String>();
			    if(!isNewWord()){
					   completions.addAll(e.node.getCompletions());
					}else{
					   if(e.node.getEvalType()!=null){
						    completions.addAll(AutoCompleteStrings.getStandaloneExpressionCompletions(e.node.getEvalType()));
					   }
					}
					$STANDALONE_EXPRESSION.setCompletions(completions);
			} // annotate AST
		;

expression returns [ManchesterOWLSyntaxTree node]
@after{
	$node = $start;
}
	: 
		 ^(DISJUNCTION  ( c = conjunction{
		 			$start.setCompletions(c.node.getCompletions());
		 		})+) 
		|  ^(PROPERTY_CHAIN  (chainItem = expression {
								$start.setCompletions(chainItem.node.getCompletions());
							})+)
		  
		| conj = conjunction  
		{
			$start.setCompletions(conj.node.getCompletions());
		}
		| cpe =complexPropertyExpression 
		{
			$start.setCompletions(cpe.node.getCompletions());
		}
		
	; 

conjunction  returns [ManchesterOWLSyntaxTree node]
@after 
			{ 
				$node = $start;
			} // do after any alternative
	:
	^(CONJUNCTION  (conjunct=unary {
					$start.setCompletions(conjunct.node.getCompletions());
				})+)	
	| u = unary {
		$start.setCompletions(u.node.getCompletions());
	}
;

unary returns [ManchesterOWLSyntaxTree node]
@after 
			{ 
				$node = $start;
			} // do after any alternative
:
		IDENTIFIER 
			{
				$start.setCompletions(this.getSymbolTable().match($IDENTIFIER.getText()));
				
			}
		| ^(NEGATED_EXPRESSION e = expression) 
			{
				$start.setCompletions(e.node.getCompletions());
			}	
		| qualifiedRestriction 	
			{
				$start.setCompletions($qualifiedRestriction.node.getCompletions());
			} 
		| ENTITY_REFERENCE 
			{
				$start.setCompletions(this.getSymbolTable().match($ENTITY_REFERENCE.getText()));
			}
	;


propertyExpression  
returns [Type type, ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after 
			{ 
				$node = $start;
			} // do after any alternative
:
      IDENTIFIER
      {
		$start.setCompletions(this.getSymbolTable().match($IDENTIFIER.getText()));
      }
      | ENTITY_REFERENCE 
			{
				$start.setCompletions(this.getSymbolTable().match($ENTITY_REFERENCE.getText()));
			}
    | complexPropertyExpression
      {
        	$start.setCompletions(this.getSymbolTable().match($complexPropertyExpression.node.getText()));
      }
    ;

complexPropertyExpression returns  [ManchesterOWLSyntaxTree node]
@after { 
          $node = $start;
       } // do after any alternative
:
	^(INVERSE_OBJECT_PROPERTY_EXPRESSION p = complexPropertyExpression)
	{
        	$start.setCompletions(p.node.getCompletions());
	}
	| ^(INVERSE_OBJECT_PROPERTY_EXPRESSION IDENTIFIER)
	{
        	$start.setCompletions(this.getSymbolTable().match($IDENTIFIER.getText()));
	}
	| ^(INVERSE_OBJECT_PROPERTY_EXPRESSION ENTITY_REFERENCE)
	{
        	$start.setCompletions(this.getSymbolTable().match($ENTITY_REFERENCE.getText()));
	}
	;

qualifiedRestriction returns [ManchesterOWLSyntaxTree node]
@after { 
          $node = $start;
        } // do after any alternative
	:
					^(SOME_RESTRICTION p= propertyExpression  f= expression) 
					{
						$start.setCompletions(f.node.getCompletions());
					}				
				|	^(ALL_RESTRICTION  p = propertyExpression f= expression) 
				{
						$start.setCompletions(f.node.getCompletions());
				}
				| cardinalityRestriction 
					{
						$start.setCompletions($cardinalityRestriction.node.getCompletions());
					}
				| oneOf 
					{
						$start.setCompletions($oneOf.node.getCompletions());
					}
				| valueRestriction 
					{
						$start.setCompletions($valueRestriction.node.getCompletions());
					}
		;


 
cardinalityRestriction	returns [ ManchesterOWLSyntaxTree node]
@after { 
          $node = $start; 
        } // do after any alternative
:
		  ^(CARDINALITY_RESTRICTION  MIN  i=INTEGER p = unary  filler = expression?) 
		{
			$start.setCompletions(filler==null? p.node.getCompletions() : filler.node.getCompletions());			
		}
		|  ^(CARDINALITY_RESTRICTION  MAX i=INTEGER p = unary  filler = expression?) 
    		{
			$start.setCompletions(filler==null? p.node.getCompletions() : filler.node.getCompletions());
    		}
		|  ^(CARDINALITY_RESTRICTION  EXACTLY i= INTEGER  p = unary  filler = expression?) 
		{
			$start.setCompletions(filler==null? p.node.getCompletions() : filler.node.getCompletions());
		}
		;
		
oneOf	returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject]
@after { 
          $node = $start;
        }
	:
		^(ONE_OF (individual=unary{
			$start.setCompletions(individual.node.getCompletions());
		} )+) 
		
	;

valueRestriction	returns [Type type , ManchesterOWLSyntaxTree node, OWLObject owlObject] 
@after { 
          $node = $start;
        }
	:  
		^(VALUE_RESTRICTION  p = unary  value = unary) 
		{
		  	$start.setCompletions(value.node.getCompletions());
		}
	;



axiom returns [List<String> completions] 
@after 
{ 
	if($completions!=null){          
		$start.setCompletions($completions);
	}
} // do after any alternative
:
		^(SUB_CLASS_AXIOM  ^(EXPRESSION  subClass = expression) ^( EXPRESSION  superClass = expression))
		{			
			if(!isNewWord()){
			 $completions = new ArrayList<String>(superClass.node.getCompletions());
			}else{
			 $completions = new ArrayList<String>(AutoCompleteStrings.getStandaloneExpressionCompletions(superClass.node.getEvalType()));
			}
		}
	|  ^(EQUIVALENT_TO_AXIOM ^(EXPRESSION lhs = expression) ^(EXPRESSION  rhs = expression))
	   {	    
	    if(!isNewWord()){
		 $completions = new ArrayList<String>(rhs.node.getCompletions());
      }else{
       $completions = Collections.<String>emptyList();
      }
	   }	
	| ^(INVERSE_OF ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION anotherProperty = IDENTIFIER))
	{	   
	    if(!isNewWord()){
       $completions = anotherProperty.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
	}
  | ^(DISJOINT_WITH_AXIOM ^(EXPRESSION lhs =  expression) ^(EXPRESSION rhs = expression)){     
     if(!isNewWord()){
		$completions = new ArrayList<String>(rhs.node.getCompletions());
      }else{
       $completions = Collections.<String>emptyList();
      }
  }	  
	|	^(SUB_PROPERTY_AXIOM ^(EXPRESSION  subProperty = expression) ^(EXPRESSION superProperty = unary))
		{			
			if(!isNewWord()){
		$completions = new ArrayList<String>(superProperty.node.getCompletions());
      }else{
       $completions = Collections.<String>emptyList();
      }
		}		
	| ^(ROLE_ASSERTION ^(EXPRESSION  subject = IDENTIFIER) ^(EXPRESSION  predicate = propertyExpression) ^(EXPRESSION object = unary)){	   
	   if(!isNewWord()){
		$completions = new ArrayList<String>(object.node.getCompletions());
      }else{
       $completions = Collections.<String>emptyList();
      }
	 }
	|  ^(TYPE_ASSERTION ^(EXPRESSION  description = expression) ^(EXPRESSION subject = IDENTIFIER))
	{
	   if(!isNewWord()){
       $completions = subject.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
	} 
	| ^(DOMAIN ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION domain = expression))
	 {
	    if(!isNewWord()){
		$completions = new ArrayList<String>(domain.node.getCompletions());
      }else{
       $completions = Collections.<String>emptyList();
      }
	 }
	 | ^(RANGE ^(EXPRESSION p = IDENTIFIER) ^(EXPRESSION range = expression))
   {
      if(!isNewWord()){
		$completions = new ArrayList<String>(range.node.getCompletions());
      }else{
       $completions = Collections.<String>emptyList();
      }
   }
   | ^(SAME_AS_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
     if(!isNewWord()){
       $completions = anotherIndividual.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
   }
    | ^(DIFFERENT_FROM_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER) ^(EXPRESSION anotherIndividual = IDENTIFIER))
   {
     if(!isNewWord()){
       $completions = anotherIndividual.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
   }
	 | ^(UNARY_AXIOM FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
	 {
	    if(!isNewWord()){
       $completions = p.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
	 }
	 | ^(UNARY_AXIOM INVERSE_FUNCTIONAL ^(EXPRESSION p = IDENTIFIER))
   {
      if(!isNewWord()){
       $completions = p.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
   }
    | ^(UNARY_AXIOM IRREFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {     
     if(!isNewWord()){
       $completions = p.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
   }
   | ^(UNARY_AXIOM REFLEXIVE ^(EXPRESSION p = IDENTIFIER))
   {
			if(!isNewWord()){
       $completions = p.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }   
	 }
   | ^(UNARY_AXIOM SYMMETRIC ^(EXPRESSION p = IDENTIFIER))
   {
			if(!isNewWord()){
       $completions = p.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
   } 
    | ^(UNARY_AXIOM TRANSITIVE ^(EXPRESSION p = IDENTIFIER))
   {
     if(!isNewWord()){
       $completions = p.getCompletions();
      }else{
       $completions = Collections.<String>emptyList();
      }
   }
   | ^(NEGATED_ASSERTION a =axiom){
     if(!isNewWord()){
       $completions = a.completions;
      }else{
       $completions = Collections.<String>emptyList();
      }
   }     
;



	
// AUTO-COMPLETIONS FOR INCOMPLETE AXIOMS

incompleteAxiom returns [List<String> completions] 
@after 
       { 
        if($completions!=null){
          $start.setCompletions($completions);
        }
      } // do after any alternative
:
   
    ^(INCOMPLETE_SUB_CLASS_AXIOM  ^(EXPRESSION  subClass = .) (^(INCOMPLETE_EXPRESSION superClass = incompleteExpression))?)
    {     
       // class expression completions
     $completions = superClass== null ? new ArrayList<String>(symtab.getOWLClassCompletions()): new ArrayList<String>(superClass.completions);
    }  
  |  ^(INCOMPLETE_EQUIVALENT_TO_AXIOM ^(EXPRESSION lhs = expression) (^(INCOMPLETE_EXPRESSION  rhs = incompleteExpression))?)
     {      
      $completions = rhs==null?  new ArrayList<String>(symtab.getCompletions(lhs.node.getEvalType())) : new ArrayList<String>(rhs.completions);
     }  
  | ^(INCOMPLETE_INVERSE_OF ^(EXPRESSION p = IDENTIFIER) (^(INCOMPLETE_EXPRESSION q = incompleteExpression))?)
  {    
     // object property expression completions
     $completions = q==null? new ArrayList<String>(symtab.getOWLObjectPropertyCompletions()): new ArrayList<String>(q.completions);
  }
  | ^(INCOMPLETE_DISJOINT_WITH_AXIOM ^(EXPRESSION lhs =  expression) (^(INCOMPLETE_EXPRESSION rhs = incompleteExpression))?){     
	$completions = rhs==null?  new ArrayList<String>(symtab.getCompletions(lhs.node.getEvalType())) : new ArrayList<String>(rhs.completions);
  }   
  | ^(INCOMPLETE_SUB_PROPERTY_AXIOM ^(EXPRESSION  subProperty = expression) (^(INCOMPLETE_EXPRESSION superProperty = incompleteExpression))?)
    {     
      // property expression completions
 	$completions = superProperty== null ? new ArrayList<String>(symtab.getOWLPropertyCompletions(subProperty.node.getEvalType())): new ArrayList<String>(superProperty.completions);    
    }   
  | ^(INCOMPLETE_ROLE_ASSERTION ^(EXPRESSION IDENTIFIER) ^(EXPRESSION propertyExpression)){    
     // individual expression completions
     $completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());
   }
  |  ^(INCOMPLETE_TYPE_ASSERTION  ^(EXPRESSION IDENTIFIER))
  {
     // class expression completions
     $completions = new ArrayList<String>(symtab.getOWLClassCompletions());
  }
  | ^(INCOMPLETE_DOMAIN ^(EXPRESSION p = IDENTIFIER))
   {
     // class expression completions
     $completions = new ArrayList<String>(symtab.getOWLClassCompletions());
   } 
  | ^(INCOMPLETE_DOMAIN ^(EXPRESSION p = IDENTIFIER) ^(INCOMPLETE_EXPRESSION domain = incompleteExpression))
   {
     $completions = domain.completions;
   }
   | ^(INCOMPLETE_RANGE ^(EXPRESSION p = IDENTIFIER)){
    // class expression completions
    $completions = new ArrayList<String>(symtab.getOWLClassCompletions());
   }
   | ^(INCOMPLETE_RANGE ^(EXPRESSION p = IDENTIFIER) ^(INCOMPLETE_EXPRESSION range = incompleteExpression))
   {
     $completions = range.completions;;
   }
   | ^(INCOMPLETE_SAME_AS_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER))
   {
    // individual expression completions
    $completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());
   }
    | ^(INCOMPLETE_DIFFERENT_FROM_AXIOM ^(EXPRESSION anIndividual =IDENTIFIER))
   {
    // individual expression completions
    $completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());
   }
   | ^(INCOMPLETE_UNARY_AXIOM FUNCTIONAL)
   {
     // property expression completions
     $completions =  new ArrayList<String>(symtab.getAllCompletions(OWLType.OWL_OBJECT_PROPERTY,OWLType.OWL_DATA_PROPERTY));
   }
   | ^(INCOMPLETE_UNARY_AXIOM INVERSE_FUNCTIONAL)
   {
     // object property expression completions
     $completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
   }
    | ^(INCOMPLETE_UNARY_AXIOM IRREFLEXIVE)
   {     
     // object property expression completions
     $completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
   }
   | ^(INCOMPLETE_UNARY_AXIOM REFLEXIVE)
   {
      // object property expression completions   
      $completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
   }
   | ^(INCOMPLETE_UNARY_AXIOM SYMMETRIC)
   {
      // object property expression completions
      $completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
   } 
    | ^(INCOMPLETE_UNARY_AXIOM TRANSITIVE)
   {
     // object property expression completions
     $completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
   }    
;

incompleteExpression  returns [List<String> completions] 
@after 
       { 
        if($completions!=null){
          $start.setCompletions($completions);
        }
      } // do after any alternative
:
  ^(INCOMPLETE_PROPERTY_CHAIN  .+)
  {
    // object property expression completions
    $completions = new ArrayList<String>(symtab.getOWLObjectPropertyCompletions());
  }
  
  | ^(INCOMPLETE_DISJUNCTION  ic = incompleteConjunction)
  {
      if(e!=null){
      	$completions = ic.completions;
      }else{
      	$completions = new ArrayList<String>(symtab.getOWLClassCompletions());
      }
  }  
  | ^(INCOMPLETE_EXPRESSION ^(EXPRESSION  e = expression) IDENTIFIER){  
  		Type type = e.node.getEvalType();
  		$completions = type==null? Collections.<String>emptyList(): AutoCompleteStrings.getIncompleteExpressionCompletions($IDENTIFIER.text, type);
  }
  | ^(INCOMPLETE_EXPRESSION  iu = incompleteUnary){
  	$completions = new ArrayList<String>($incompleteUnary.completions);
  }	  		

   
;


incompleteConjunction  returns [List<String> completions] 
@after 
       { 
        if($completions!=null){
          $start.setCompletions($completions);
        }
      } // do after any alternative
:
    ^(INCOMPLETE_CONJUNCTION  e = incompleteUnary?)
    {
    	if(e!=null){
      	$completions = e.completions;
      }else{
      	$completions = new ArrayList<String>(symtab.getOWLClassCompletions());
      } 
    }
;	

incompleteUnary returns [List<String> completions] 
@after 
       { 
        if($completions!=null){
          $start.setCompletions($completions);
        }
      } // do after any alternative
:   
    ^(INCOMPLETE_NEGATED_EXPRESSION .?){
      // class expression completions
      $completions = new ArrayList<String>(symtab.getOWLClassCompletions());
    }                  
    | incompleteQualifiedRestriction{
      $completions = $incompleteQualifiedRestriction.completions;
    }         
  ;

  
incompleteQualifiedRestriction  returns [List<String> completions] 
@after 
       { 
        if($completions!=null){
          $start.setCompletions($completions);
        }
      } // do after any alternative
:   
          ^(INCOMPLETE_SOME_RESTRICTION propertyExpression)
        {
          // class expression completions
          $completions = new ArrayList<String>(symtab.getOWLClassCompletions());
        }                   
        | ^(INCOMPLETE_ALL_RESTRICTION propertyExpression)
        {
          // class expression completions
          $completions = new ArrayList<String>(symtab.getOWLClassCompletions());
        }
        | incompleteCardinalityRestriction
        {
          $completions = $incompleteCardinalityRestriction.completions;
        }
        | incompleteOneOf
        {
          $completions = $incompleteOneOf.completions;
        }
        | incompleteValueRestriction
        {
          $completions = $incompleteValueRestriction.completions;
        }
    
    ;
 
incompleteCardinalityRestriction  returns [List<String> completions] 
@after 
       { 
        if($completions!=null){
          $start.setCompletions($completions);
        }
      } // do after any alternative
:   
        ^(INCOMPLETE_CARDINALITY_RESTRICTION  . INTEGER propertyExpression)
        {
          // class expression completions
          $completions = new ArrayList<String>(symtab.getOWLClassCompletions());
        }
;


incompleteOneOf  returns [List<String> completions] 
@after 
      { 
        if($completions!=null){
          $start.setCompletions($completions);
        }
      } // do after any alternative
: 
    ^(INCOMPLETE_ONE_OF IDENTIFIER+)
    {
      // individual expression completions
      $completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());  
    }
 ;
 
 incompleteValueRestriction returns [List<String> completions] 
 @after 
      { 
        if($completions!=null){
          $start.setCompletions($completions);
        }
      } // do after any alternative
:  
      ^(INCOMPLETE_VALUE_RESTRICTION p = propertyExpression)
      {
        // individual expression completions
        Type type = p.type;
        if(OWLType.isObjectPropertyExpression(type)){
        	$completions = new ArrayList<String>(symtab.getOWLIndividualCompletions());
        }
      }
 ; 