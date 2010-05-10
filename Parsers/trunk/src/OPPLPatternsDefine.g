tree grammar OPPLPatternsDefine;
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
  public OPPLPatternsDefine(TreeNodeStream input, OPPLPatternsSymbolTable symtab, ErrorListener errorListener, PatternConstraintSystem constraintSystem) {
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
    this.symtab = symtab;
    this.errorListener = errorListener;
    this.constraintSystem = constraintSystem;
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
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.ManchesterOWLSyntaxTree;
  import org.coode.patterns.PatternConstraintSystem;
}

bottomup  : 
      patternReference
    | thisClass
  ;

patternReference
	:
	 ^(pr =IDENTIFIER PATTERN_REFERENCE args= arguments? )
	 {
	   if(args==null){
	     symtab.resolvePattern(pr, $PATTERN_REFERENCE.getText(),getConstraintSystem());
	   }else{
	     symtab.resolvePattern(pr, $PATTERN_REFERENCE.getText(),getConstraintSystem(), args.argStrings.toArray(new String[args.argStrings.size()]));
	   } 
	 }
	 ->
	 ^($pr)
	;
	
arguments returns [List<String> argStrings]
@init{
  $argStrings = new ArrayList<String>();
}
  :
    ^(ARGUMENTS (argument=.{$argStrings.add(argument.getText());})+) 
  ;

thisClass
  : 
    ^(i=IDENTIFIER THIS_CLASS)
    {
      symtab.resolveThisClass($THIS_CLASS,getConstraintSystem());
    }
    ->
    ^($i)
  ;