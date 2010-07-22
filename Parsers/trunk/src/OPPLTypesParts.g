tree grammar OPPLTypesParts;
options {
  language = Java;
  tokenVocab = OPPLScript; 
  ASTLabelType = OPPLSyntaxTree;
  filter=true;
}


@members{
  private  OPPLSymbolTable symtab;
  private  ErrorListener errorListener;
  private ConstraintSystem constraintSystem;
  private OPPLAbstractFactory opplFactory;
  private Variable variable = null;

  
  public OPPLTypesParts(TreeNodeStream input, OPPLSymbolTable symtab, ErrorListener errorListener, ConstraintSystem constraintSystem, OPPLAbstractFactory opplFactory) {
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
    if(opplFactory == null){
      throw new NullPointerException("The OPPL Factory cannot be null");
    }
    this.symtab = symtab;
    this.errorListener = errorListener;
    this.opplFactory = opplFactory;
    this.constraintSystem = constraintSystem;
    
  }
  
  public void setVariable(Variable variable){
  	this.variable = variable;
  }
  
  public Variable getVariable(){
  	return variable;
  }
  
  public ErrorListener getErrorListener(){
  	return this.errorListener;
  }
  
  public ConstraintSystem getConstraintSystem(){
    return this.constraintSystem;
  }
  
  public OPPLSymbolTable getSymbolTable(){
  	return this.symtab;
  }
  
  public OPPLAbstractFactory getOPPLFactory(){
    return this.opplFactory;
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
  package org.coode.parsers.oppl;
  import org.coode.oppl.variablemansyntax.Variable;
  import org.coode.oppl.variablemansyntax.ConstraintSystem;
  import org.coode.oppl.variablemansyntax.generated.VariableExpressionGeneratedVariable;
  import org.coode.oppl.variablemansyntax.VariableScope;
  import org.coode.oppl.variablemansyntax.VariableScopes;
  import org.coode.oppl.entity.OWLEntityRenderer;
  import org.coode.oppl.variablemansyntax.generated.AbstractCollectionGeneratedValue;
  import org.coode.oppl.AbstractConstraint;
  import org.coode.oppl.OPPLQuery;
  import org.coode.oppl.variablemansyntax.Variable;  
  import org.coode.oppl.exceptions.OPPLException;
  import org.coode.oppl.OPPLAbstractFactory;
  import org.coode.oppl.variablemansyntax.generated.RegExpGenerated;
  import org.coode.oppl.variablemansyntax.generated.RegExpGeneratedValue;
  import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
  import org.coode.oppl.variablemansyntax.generated.StringGeneratedValue;
  import org.coode.oppl.variablemansyntax.generated.ConcatGeneratedValues;
  import org.coode.oppl.InCollectionRegExpConstraint;
  import org.semanticweb.owl.model.OWLAxiom;
  import org.semanticweb.owl.model.OWLObject;
  import org.semanticweb.owl.model.OWLClass;
  import org.semanticweb.owl.model.OWLAxiomChange;
  import org.semanticweb.owl.model.OWLPropertyExpression;
  import org.semanticweb.owl.model.OWLDescription;
  import org.semanticweb.owl.model.RemoveAxiom;
  import org.semanticweb.owl.model.AddAxiom;    
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.Type;
  import org.coode.parsers.oppl.OPPLSymbolTable;
  import org.coode.parsers.ManchesterOWLSyntaxTree;
  import java.util.Set;
}

// START: root
bottomup // match subexpressions innermost to outermost
    :  
    	constraint
    	| opplFunction
    ;

stringOperation returns [SingleValueGeneratedValue<String> value]
@init
  {
    List<SingleValueGeneratedValue<String>> values = new ArrayList<SingleValueGeneratedValue<String>>();
  }
  :
    ^(STRING_OPERATION  (valuesToAggregate= stringExpression {values.add(valuesToAggregate);})+)
    {
      $value = new ConcatGeneratedValues(values); 
    }
  ;
  

stringExpression returns [SingleValueGeneratedValue<String> value]
  :
      DBLQUOTE
      {
        $value = new StringGeneratedValue($DBLQUOTE.getText());
      }
    | IDENTIFIER
      {
        $value=symtab.getStringGeneratedValue($IDENTIFIER, getConstraintSystem());
      }

  ;

opplFunction returns [Variable variable]
@after
	{
		$start.setOPPLContent($variable);
	} 
	:
	 ^(CREATE_OPPL_FUNCTION  value = stringOperation)
	     {
	       if(getVariable()!=null){
		       $variable = constraintSystem.createStringGeneratedVariable(getVariable().getName(),getVariable().getType(), value);
		}else{
			getErrorListener().illegalToken($start, "No variable type to evaluate this OPPL Function");
		}
	     }
    |^(CREATE_INTERSECTION va = IDENTIFIER)
       {
       if(getVariable()!=null){
         
         AbstractCollectionGeneratedValue<OWLClass> collection = symtab.getCollection($start,va, getConstraintSystem());
         $variable = constraintSystem.createIntersectionGeneratedVariable(getVariable().getName(),getVariable().getType(),collection);         
        }else{
			getErrorListener().illegalToken($start, "No variable type to evaluate this OPPL Function");
		}
       }
      | ^(CREATE_DISJUNCTION va = IDENTIFIER)
       {
       if(getVariable()!=null){
         AbstractCollectionGeneratedValue<OWLClass> collection = symtab.getCollection($start,va, getConstraintSystem());
         $variable = constraintSystem.createUnionGeneratedVariable(getVariable().getName(),getVariable().getType(),collection);         
       } 
       else{
			getErrorListener().illegalToken($start, "No variable type to evaluate this OPPL Function");
		}
	}
;

constraint returns [AbstractConstraint constraint]
@init
  {
    List<OPPLSyntaxTree> identifiers = new ArrayList<OPPLSyntaxTree>();
  }
@after
	{
		$start.setOPPLContent($constraint);
	}  
:
		^(INEQUALITY_CONSTRAINT IDENTIFIER ^(EXPRESSION expression=.)){
			$constraint = symtab.getInequalityConstraint($start, $IDENTIFIER,expression, getConstraintSystem());
		}
		| ^(IN_SET_CONSTRAINT v = IDENTIFIER ^(ONE_OF (i = IDENTIFIER {identifiers.add(i);})+)){
			$constraint = symtab.getInSetConstraint($start,v,constraintSystem,identifiers.toArray(new OPPLSyntaxTree[identifiers.size()]));
		}
		| ^(REGEXP_CONSTRAINT IDENTIFIER se = stringOperation)
		{
			Variable variable = symtab.getVariable($IDENTIFIER,getConstraintSystem());
			$constraint =   new InCollectionRegExpConstraint(variable, se, getConstraintSystem());
		}
;
