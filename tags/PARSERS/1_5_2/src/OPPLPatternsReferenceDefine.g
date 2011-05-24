tree grammar OPPLPatternsReferenceDefine;

options {
  language = Java;
  tokenVocab = OPPLPatternScript; 
  ASTLabelType = OPPLSyntaxTree;
  filter=true;
  output= AST;
}


@members{
  private  OPPLPatternsSymbolTable symtab;
  private  ErrorListener errorListener;
  private PatternConstraintSystem constraintSystem;
  private PatternReferenceResolver patternReferenceResolver;
  public OPPLPatternsReferenceDefine(TreeNodeStream input, OPPLPatternsSymbolTable symtab, ErrorListener errorListener,PatternReferenceResolver patternReferenceResolver, PatternConstraintSystem constraintSystem) {
    this(input);
    if(symtab==null){
    	throw new NullPointerException("The symbol table cannot be null");
    }
    if(errorListener == null){
    	throw new NullPointerException("The error listener cannot be null");
    }
    if(constraintSystem == null){
      throw new NullPointerException("The constraint system cannot be null");
    }
    if(patternReferenceResolver == null){
      throw new NullPointerException("The pattern reference resolver cannot be null");
    }
    this.symtab = symtab;
    this.errorListener = errorListener;
    this.constraintSystem = constraintSystem;
    this.patternReferenceResolver = patternReferenceResolver;
  }
  
  public PatternReferenceResolver getPatternReferenceResolver(){
  	return patternReferenceResolver;
  }
  
  public PatternConstraintSystem getConstraintSystem(){
    return this.constraintSystem;
  }
  
  public ErrorListener getErrorListener(){
  	return this.errorListener;
  }
  
  public OPPLPatternsSymbolTable getSymbolTable(){
  	return this.symtab;
  }
  
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        getErrorListener().recognitionException(e, tokenNames);
  }
  
  protected void mismatch (IntStream input, int ttype, BitSet follow) throws RecognitionException {
    throw new MismatchedTokenException(ttype,input);
  }
  

  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException{
    throw e;
  }
  
}

@rulecatch{
  catch(RecognitionException exception){
    if(errorListener!=null){
      errorListener.recognitionException(exception);
    }
  }
  
  catch(RewriteEmptyStreamException exception){
    if(errorListener!=null){
      errorListener.rewriteEmptyStreamException(exception);
    }
  }
}

@header {
  package org.coode.parsers.oppl.patterns;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
  import org.coode.oppl.function.Adapter;
  import org.coode.oppl.function.Aggregandum;
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.Symbol;
  import org.coode.parsers.ManchesterOWLSyntaxTree;
  import org.coode.patterns.PatternConstraintSystem;
  import org.semanticweb.owlapi.model.OWLObject;
  import org.coode.oppl.Variable;    
  import org.coode.patterns.OPPLPatternParser.PatternReferenceResolver;
}

bottomup  : 
	patternReference
  ;


patternReference
	:
	 ^(pr =IDENTIFIER PATTERN_REFERENCE args= arguments? )
	 {
	   if(args==null){
	     getPatternReferenceResolver().resolvePattern(pr, $PATTERN_REFERENCE.getText(),getConstraintSystem(),getSymbolTable());
	   }else{
	     getPatternReferenceResolver().resolvePattern(pr, $PATTERN_REFERENCE.getText(),getConstraintSystem(),getSymbolTable(), args.args.toArray(new List[args.args.size()]));
	   } 
	 }
	 ->
	 ^($pr)
	;


arguments returns [List<List<Object>> args]
@init{
	 $args = new ArrayList<List<Object>>();
}
	:
		^(ARGUMENTS (arg=argument{
			$args.add(arg.argObjects);
		})+)
	;
	
argument returns [List<Object> argObjects]
@init{
  $argObjects = new ArrayList<Object>();
}
  : 
	^(ARGUMENT  ^(EXPRESSION   ^(IDENTIFIER VARIABLE_NAME DOT  VALUES))){
		Aggregandum<?> aggregandum = Adapter.buildSingletonAggregandum(getSymbolTable().defineValuesAttributeReferenceSymbol($VARIABLE_NAME,getConstraintSystem()));
		$argObjects.add(aggregandum);
  	}
	| ^(ARGUMENT (a=.{
    		OWLObject owlObject = a.getOWLObject();
	    	if(owlObject!=null){
    			$argObjects.add(owlObject);
	    	}else{
    			Variable<?> v = getConstraintSystem().getVariable(a.getText());
    			if(v!=null){
    				$argObjects.add(v);
	    		}else{
    				
    				getErrorListener().illegalToken(a,"Invalid argument");
    			}
    		}
    })+) 
  ;