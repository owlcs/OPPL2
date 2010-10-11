tree grammar OPPLTestCaseTypes;
options {
  language = Java;
  tokenVocab = OPPLTestCaseCombined; 
  ASTLabelType = OPPLSyntaxTree;
  filter=true;
}


@members{
  private OPPLTestCaseSymbolTable symtab;
  private ErrorListener errorListener;
  private ConstraintSystem constraintSystem;
  private AbstractOPPLTestCaseFactory testCaseFactory;
  
  public OPPLTestCaseTypes(TreeNodeStream input, OPPLTestCaseSymbolTable symtab, ErrorListener errorListener, ConstraintSystem constraintSystem, AbstractOPPLTestCaseFactory testCaseFactory) {
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
    if(testCaseFactory == null){
      throw new NullPointerException("The OPPL Lint Factory cannot be null");
    }
    this.symtab = symtab;
    this.errorListener = errorListener;
    this.testCaseFactory = testCaseFactory;
    this.constraintSystem = constraintSystem;
    
  }
  
  public ErrorListener getErrorListener(){
  	return this.errorListener;
  }
  
  public ConstraintSystem getConstraintSystem(){
    return this.constraintSystem;
  }
  
  public OPPLTestCaseSymbolTable getSymbolTable(){
  	return this.symtab;
  }
  
  public AbstractOPPLTestCaseFactory getTestCaseFactory(){
    return this.testCaseFactory;
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
  package org.coode.parsers.oppl.testcase;
  import org.coode.parsers.ErrorListener;
  import org.coode.parsers.oppl.OPPLSyntaxTree;
  import org.coode.oppl.OPPLScript;
  import org.coode.oppl.bindingtree.Assignment;  
  import org.coode.oppl.Variable;
  import org.coode.oppl.bindingtree.BindingNode;
  import org.coode.oppl.ConstraintSystem;
  import org.coode.parsers.oppl.testcase.OPPLTestCaseSymbolTable;
  import org.semanticweb.owlapi.model.OWLAxiomChange;
  import java.util.Collections;
  import org.coode.oppl.OPPLQuery;
  import org.coode.parsers.oppl.testcase.assertions.Assertion;
  import org.coode.parsers.oppl.testcase.assertions.AssertionExpression;
  import org.semanticweb.owlapi.model.OWLObject;  
}

// START: root
bottomup // match subexpressions innermost to outermost
    :  
    	testCase
    	| textVariableRef
    ;


testCase
	:
		^(OPPL_TEST_CASE IDENTIFIER INFERENCE? s = statement someTests = tests) 
		{
		  if(s.statementTree.getOPPLContent() instanceof OPPLScript){
		  	if(!someTests.isEmpty()){
				OPPLTestCase testCase = this.getTestCaseFactory().buildOPPLTestCase($IDENTIFIER.text,
				(OPPLScript) s.statementTree.getOPPLContent(), someTests, $INFERENCE!=null);
				$start.setOPPLContent(testCase);
			}else{
				getErrorListener().illegalToken($start,"No Valid Tests");
			}
		  }else{
		  		getErrorListener().illegalToken($start,"Invalid OPPL statement");
		  }  
		}		
  ;
  
tests returns  [List<Test> tests]
@init{
	tests = new ArrayList<Test>();
}

	:
		( t = test{
			if(t!=null){
				tests.add(t);
			}
		})+
	;

statement returns [OPPLSyntaxTree statementTree]
@init{
	List<Variable> vds = new ArrayList<Variable>();
	
}
@after{
	$statementTree = $start;
}
	:
		^(OPPL_STATEMENT  (^(vd = VARIABLE_DEFINITIONS .*))? ^(query =QUERY .*))
		{
				if(vd!=null){
				vds.addAll((List<Variable>)$vd.getOPPLContent());
			}
			
			 if($query.getOPPLContent()!=null){
			    $start.setOPPLContent(getTestCaseFactory().getOPPLFactory().buildOPPLScript(getConstraintSystem(),
				    					vds,(OPPLQuery) $query.getOPPLContent(),
					    				Collections.<OWLAxiomChange>emptyList()));
			 }else{
			    getErrorListener().illegalToken($start,"Invalid query content");
			 }		  
		}
	;

test returns [Test t]
	:
	^(TEST anAssertion = assertion (^(MESSAGE .*))? )
	{
		if(anAssertion.a!=null){
			$t = ($MESSAGE==null)? new Test(anAssertion.a): new Test($MESSAGE.text,anAssertion.a);
		}
	}
	;


assertion returns [Assertion a]
@init{
	List<OPPLSyntaxTree> containedAssertionExpressions = new ArrayList<OPPLSyntaxTree>();
}
	:
		^(ASSERT_EQUAL left=assertionExpression right =assertionExpression){
			 $a = getSymbolTable().getAssertEqual(left.ae,left.node,right.ae, right.node,$start);
		}
		| ^(ASSERT_NOT_EQUAL left=assertionExpression right =assertionExpression){
			 $a = getSymbolTable().getAssertNotEqual(left.ae,left.node,right.ae, right.node,$start);
		}
		| ^(ASSERT_LESS_THAN left=assertionExpression right =assertionExpression){
			 $a = getSymbolTable().getAssertLessThan(left.ae,left.node,right.ae, right.node,$start);
		}
		| ^(ASSERT_LESS_THAN_EQUAL left=assertionExpression right =assertionExpression){
			 $a = getSymbolTable().getAssertLessThanEqualtTo(left.ae,left.node,right.ae, right.node,$start);
		}
		| ^(ASSERT_GREATER_THAN left=assertionExpression right =assertionExpression){
			 $a = getSymbolTable().getAssertGreaterThan(left.ae,left.node,right.ae, right.node,$start);
		}
		| ^(ASSERT_GREATER_THAN_EQUAL left=assertionExpression right =assertionExpression){
			 $a = getSymbolTable().getAssertGreaterThanEqualTo(left.ae,left.node,right.ae, right.node,$start);
		}
		| ^(CONTAINS VARIABLE_NAME (expr= assertionExpression {containedAssertionExpressions.add(expr.node); })+){
			$a = getSymbolTable().getAssertContains($VARIABLE_NAME,containedAssertionExpressions, getConstraintSystem(), getTestCaseFactory(), $start);
		}
		| ^(NOT anAssertion= assertion){
			$a = getSymbolTable().getAssertionComplement(anAssertion.a);
		}
		
	;

assertionExpression returns  [AssertionExpression ae, OPPLSyntaxTree node]
@init{
	BindingNode bindingNode = BindingNode.createNewEmptyBindingNode();
	boolean allFine = true;
}
@after{
	$node = $start;
}	
	:
		^(COUNT VARIABLE_NAME){
			$ae = getSymbolTable().getCountAssertionExpression($VARIABLE_NAME, getConstraintSystem());
		}
		| ^(COUNT STAR){
			$ae = getSymbolTable().getCountStarAssertionExpression();
		}
		| ^(COUNT (bn = bindingDescription {
			if(bn.v!=null && bn.exp !=null){
				bindingNode.addAssignment(new Assignment(bn.v,bn.exp));
			}else{
				allFine = false;
			}
		})+){
			if(allFine){
				$ae = getSymbolTable().getBindingNodeCount(bindingNode,getConstraintSystem(), getTestCaseFactory());
			}
		}
		| INTEGER {
			$ae = getSymbolTable().getIntegerAssertionExpression($INTEGER);
		}
		| ^(EXPRESSION .*){
			$ae = getSymbolTable().getOWLExpressionAssertionExpression($EXPRESSION,getConstraintSystem(), getTestCaseFactory());			
		}	
	;

bindingDescription returns [Variable v, OWLObject exp]
	:
		^(BINDING VARIABLE_NAME  ^(EXPRESSION .*)){
			$v = getConstraintSystem().getVariable($VARIABLE_NAME.getText());
		        if($v == null){
          			if(getErrorListener()!=null){
			            getErrorListener().illegalToken($VARIABLE_NAME, "Undefined variable");
          			}
			}else{
				$exp = $EXPRESSION.getOWLObject();
				if($exp == null){
				        if(getErrorListener()!=null){
          					getErrorListener().illegalToken($EXPRESSION, "Null expression");
          				}
				}
			}
		}
	;

  
 
  
  
 textVariableRef 
 	:
 		^(TEXT  VARIABLE_NAME)
 		{
 	 Variable variable = getConstraintSystem().getVariable($VARIABLE_NAME.getText());
        if(variable==null){
          if(getErrorListener()!=null){
            getErrorListener().illegalToken($VARIABLE_NAME, "Undefined variable");
          }
        }
 		}	
 	;
   
  
