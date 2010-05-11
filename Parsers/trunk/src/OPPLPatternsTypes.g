tree grammar OPPLPatternsTypes;
options {
  language = Java;
  tokenVocab = OPPLPatternScript; 
  ASTLabelType = OPPLSyntaxTree;
  filter=true;
}


@members{
  private  OPPLPatternsSymbolTable symtab;
  private  ErrorListener errorListener;
  private PatternConstraintSystem constraintSystem;
  private AbstractPatternModelFactory patternModelFactory;
  
  public OPPLPatternsTypes(TreeNodeStream input, OPPLPatternsSymbolTable symtab, ErrorListener errorListener, PatternConstraintSystem constraintSystem, AbstractPatternModelFactory patternModelFactory) {
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
    if(patternModelFactory == null){
      throw new NullPointerException("The OPPL Pattern Factory cannot be null");
    }
    this.symtab = symtab;
    this.errorListener = errorListener;
    this.patternModelFactory = patternModelFactory;
    this.constraintSystem = constraintSystem;
    
  }
  
  public ErrorListener getErrorListener(){
  	return this.errorListener;
  }
  
  public PatternConstraintSystem getConstraintSystem(){
    return this.constraintSystem;
  }
  
  public OPPLPatternsSymbolTable getSymbolTable(){
  	return this.symtab;
  }
  
  public AbstractPatternModelFactory getPatternModelFactory(){
    return this.patternModelFactory;
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
  import org.coode.parsers.ErrorListener;
  import org.coode.patterns.PatternModel;
  import org.coode.patterns.PatternConstraintSystem;
  import org.coode.patterns.AbstractPatternModelFactory;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
  import org.coode.oppl.OPPLScript;
  import org.coode.oppl.variablemansyntax.Variable;
  import org.coode.patterns.UnsuitableOPPLScriptException;
}

// START: root
bottomup // match subexpressions innermost to outermost
    :  
    	pattern
    ;


pattern
	:
		^(OPPL_PATTERN ^(s = OPPL_STATEMENT .*) ren = rendering? rc = returnClause?)
		{
		  if(s.getOPPLContent() instanceof OPPLScript){
		    try {
          PatternModel patternModel = this.getPatternModelFactory().createPatternModel(
                                (OPPLScript) s.getOPPLContent());
          if(rc!=null){                                
            patternModel.setReturnVariable(rc);
          }
          if(ren!=null){
            patternModel.setRendering(ren);
          }
          $start.setOPPLContent(patternModel);
        } catch (UnsuitableOPPLScriptException e) {
          getErrorListener().illegalToken($OPPL_STATEMENT, "Unsuitable OPPL statement for a pattern "+e.getMessage());              
        }
		  }  
		}		
  ;

rendering returns [String string]
  :
    ^(RENDERING .*)
    {
      $string = $RENDERING.getText();
    }
  ;

returnClause returns [Variable variable]
  :
      ^(RETURN VARIABLE_NAME)
      {
        $variable = getConstraintSystem().getVariable($VARIABLE_NAME.getText());
        if(variable==null){
          if(getErrorListener()!=null){
            getErrorListener().illegalToken($VARIABLE_NAME, "Undefined variable");
          }
        }
      }
    | ^(RETURN THIS_CLASS)
      {
        $variable = getConstraintSystem().getThisClassVariable();
      } 
  ;  
  