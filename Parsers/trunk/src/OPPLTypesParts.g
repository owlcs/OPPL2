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
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.regex.Pattern;
	import org.coode.oppl.AbstractConstraint;
	import org.coode.oppl.ConstraintSystem;
	import org.coode.oppl.NAFConstraint;
	import org.coode.oppl.OPPLAbstractFactory;
	import org.coode.oppl.RegExpConstraint;
	import org.coode.oppl.Variable;
	import org.coode.oppl.function.Adapter;
	import org.coode.oppl.function.Aggregandum;
	import org.coode.oppl.function.Aggregation;
	import org.coode.oppl.function.Constant;
	import org.coode.oppl.function.OPPLFunction;
	import org.coode.oppl.generated.RegexpGeneratedVariable;
	import org.coode.parsers.ErrorListener;
	import org.coode.parsers.oppl.variableattribute.CollectionVariableAttributeSymbol;
	import org.semanticweb.owlapi.model.OWLAxiom;
	import org.semanticweb.owlapi.model.OWLClassExpression;
	import org.semanticweb.owlapi.model.OWLObject;
}

// START: root
bottomup // match subexpressions innermost to outermost
    :  
    	constraint
    	| opplFunction
    	| regexp
    ;

stringOperation returns [OPPLFunction<String> value]
@init
  {
    List<Aggregandum<String>> values = new ArrayList<Aggregandum<String>>();
  }
  :
    ^(STRING_OPERATION  (valuesToAggregate= stringExpression {values.add(Adapter.buildSingletonAggregandum(valuesToAggregate));})+)
    {
      $value = Aggregation.buildStringConcatenation(values);
    }
  ;
  

stringExpression returns [OPPLFunction<String> value]
  :
      DBLQUOTE
      {
        $value = new Constant<String>($DBLQUOTE.getText());
      }
    |    ^(IDENTIFIER VARIABLE_NAME DOT GROUPS ^(ATTRIBUTE_SELECTOR INTEGER)) 
    {
      $value = getSymbolTable().defineGroupAttributeReferenceSymbol($VARIABLE_NAME,$INTEGER, getConstraintSystem());
    } 
    | ^(IDENTIFIER  VARIABLE_NAME DOT   RENDERING)
    {
      $value = getSymbolTable().defineRenderingAttributeReferenceSymbol($VARIABLE_NAME,getConstraintSystem());
    }
  ;
  
regexp returns [Variable variable]  
@after
	{
		$start.setOPPLContent($variable);
	} 
	:
  ^(MATCH se = stringOperation )
	     {	
		if(getVariable()!=null){	
          		Pattern pattern = Pattern.compile(se.render(getConstraintSystem()));
			RegexpGeneratedVariable<?> v = getConstraintSystem().createRegexpGeneratedVariable(getVariable().getName(), getVariable().getType(), pattern);
	        	$variable = v;
	        }else{
			getErrorListener().illegalToken($start, "No variable type to evaluate this OPPL Function");
		}
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
        	CollectionVariableAttributeSymbol<?> symbol = this.getSymbolTable().getCollectionVariableAttributeSymbol(org.coode.oppl.VariableType.CLASS,va);
		if (symbol != null) {
			$variable = getConstraintSystem().createIntersectionGeneratedVariable(
								getVariable().getName(),
								org.coode.oppl.VariableType.CLASS,
								Collections.singleton((OPPLFunction<? extends OWLClassExpression>) symbol.getVariableAttribute()));
		} else {
			this.getErrorListener().illegalToken(va, "Unknown symbol");
		}         
        }else{
		getErrorListener().illegalToken($start, "No variable name to build this OPPL Function");
	}
       }
      | ^(CREATE_DISJUNCTION va = IDENTIFIER)
       	{
       if(getVariable()!=null){
        	CollectionVariableAttributeSymbol<?> symbol = this.getSymbolTable().getCollectionVariableAttributeSymbol(org.coode.oppl.VariableType.CLASS,va);
		if (symbol != null) {
			$variable = getConstraintSystem().createUnionGeneratedVariable(
								getVariable().getName(),
								org.coode.oppl.VariableType.CLASS,
								Collections.singleton((OPPLFunction<? extends OWLClassExpression>) symbol.getVariableAttribute()));
		} else {
			this.getErrorListener().illegalToken(va, "Unknown symbol");
		}         
        }else{
		getErrorListener().illegalToken($start, "No variable name to build this OPPL Function");
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
		| ^(IN_SET_CONSTRAINT v = IDENTIFIER  (i = IDENTIFIER {identifiers.add(i);})+){
			$constraint = symtab.getInSetConstraint($start,v,constraintSystem,identifiers.toArray(new OPPLSyntaxTree[identifiers.size()]));
		}
		| ^(REGEXP_CONSTRAINT IDENTIFIER se = stringOperation)
		{
			Variable variable = symtab.getVariable($IDENTIFIER,getConstraintSystem());
			OPPLFunction<Pattern> adapted = Adapter.buildRegexpPatternAdapter(se);
			$constraint =   new RegExpConstraint(variable, adapted, getConstraintSystem());
		}
		| ^(NAF_CONSTRAINT a = .){
			OWLObject axiom = a.getOWLObject();
			if(axiom instanceof OWLAxiom){
				$constraint =   new NAFConstraint((OWLAxiom) axiom, getConstraintSystem());
			}
			
		}
;

aggregandums returns [Set<Aggregandum> aggregandums]
@init
{
	$aggregandums = new HashSet<Aggregandum>();
}
	:
		(a = aggregandum{
			$aggregandums.add(a);
		})+
	;

aggregandum return [Aggregandum aggregandum]
	:
	^(IDENTIFIER  VARIABLE_NAME DOT  VALUES)
    	{
      		$value = getSymbolTable().defineValuesAttributeReferenceSymbol($VARIABLE_NAME,getConstraintSystem());
    	}
    	| ^(IDENTIFIER)
    	{
    		
    	}
	;

