tree grammar OPPLTypes;
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
  
  public OPPLTypes(TreeNodeStream input, OPPLSymbolTable symtab, ErrorListener errorListener, ConstraintSystem constraintSystem, OPPLAbstractFactory opplFactory) {
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
     import org.coode.oppl.entity.OWLEntityRenderer;
  import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
  import org.coode.oppl.OPPLQuery;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableScope;
import org.coode.oppl.VariableScopes;
  import org.coode.oppl.exceptions.OPPLException;
  import org.coode.oppl.NAFConstraint;
import org.coode.oppl.generated.AbstractCollectionGeneratedValue;
import org.coode.oppl.generated.ConcatGeneratedValues;
import org.coode.oppl.generated.RegExpGenerated;
import org.coode.oppl.generated.RegExpGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.oppl.generated.StringGeneratedValue;
import org.coode.oppl.generated.VariableExpressionGeneratedVariable;
  import org.coode.oppl.OPPLAbstractFactory;
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
    	statement
    ;


statement
@init{
	List<Variable> vds = new ArrayList<Variable>();
}
	:
		^(OPPL_STATEMENT vd = variableDefinitions? q=query? actions)
		{
			if(vd!=null){
				vds.addAll($vd.variables);
			}
			if(!$actions.actions.isEmpty()){
			 if(q!=null){
			    $start.setOPPLContent(getOPPLFactory().buildOPPLScript(getConstraintSystem(),
				    					vds, $query.query,
					    				$actions.actions));
			 }else{
			    $start.setOPPLContent(getOPPLFactory().buildOPPLScript(getConstraintSystem(),
                    vds, null,
                    $actions.actions));
			 }
		  } 
		}
	;

variableDefinitions returns [List<Variable> variables]
@init{
	List<Variable> toReturn = new ArrayList<Variable>();
}
@after{
	$variables = toReturn;
	$start.setOPPLContent($variables);
}
	:
		^(VARIABLE_DEFINITIONS (vd = variableDefinition {toReturn.add(vd.variable);})+)		
	;
	
query returns [OPPLQuery query]
@init{
		$query = getOPPLFactory().buildNewQuery(getConstraintSystem());
}
@after{
		// No asserted axioms and plains axioms means no query at all.
		if($query.getAssertedAxioms().isEmpty() && $query.getAxioms().isEmpty()){
			$query=null;
		}
		$start.setOPPLContent($query);
}
	:
		^(QUERY (selectClause 
		{
		  if($selectClause.axiom!=null){
			   if($selectClause.asserted){
				  $query.addAssertedAxiom($selectClause.axiom);
			   }else{
				  $query.addAxiom($selectClause.axiom);
			   }
			}
		}
		)+ (constraint
				{
				  if($constraint.constraint!=null){
					 $query.addConstraint($constraint.constraint);
					}
				}
		)*)
	;

selectClause returns [OWLAxiom axiom, boolean asserted]
	:
		^(ASSERTED_CLAUSE a = .)
		{
			OWLObject object = a.getOWLObject();
			if(object instanceof OWLAxiom){
				$axiom = (OWLAxiom) a.getOWLObject();
			}else{
				getErrorListener().illegalToken(a,"OWL Axiom needed here");
			}			
			
			$asserted= true;
		}
		| ^(PLAIN_CLAUSE a = .)
		{
			OWLObject object = a.getOWLObject();
			if(object instanceof OWLAxiom){
				$axiom = (OWLAxiom) a.getOWLObject();
			}else{
				getErrorListener().illegalToken(a,"OWL Axiom needed here");
			}
			$asserted= false;
		}
	;

actions returns [List<OWLAxiomChange> actions]
@init{
	$actions = new ArrayList<OWLAxiomChange>();
}
@after{
	$start.setOPPLContent($actions);
}
	:
		^(ACTIONS (action 
		{
		  if($action.change!=null){
		    $actions.add($action.change);
		  }
		}
		)+)
	;
	

action returns [OWLAxiomChange change]
	:
		^(ADD a = .){
			OWLObject object = a.getOWLObject();
			if(object instanceof OWLAxiom){
				$change = new AddAxiom(getConstraintSystem().getOntology(), (OWLAxiom)object);
			}else{
				getErrorListener().illegalToken(a,"OWL Axiom needed here");
			}	
		}
		| ^(REMOVE a = .){
			OWLObject object = a.getOWLObject();
			if(object instanceof OWLAxiom){
				$change = new RemoveAxiom(getConstraintSystem().getOntology(), (OWLAxiom)object);
			}else{
				getErrorListener().illegalToken(a,"OWL Axiom needed here");
			}
		}
	;
		
variableDefinition returns [Variable variable]
	:
		  ^(INPUT_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE vs = variableScope?)
		  {
		  try {
		      $variable = getConstraintSystem().createVariable($VARIABLE_NAME.getToken().getText(), symtab.getVaribaleType($VARIABLE_TYPE));
		      if(vs !=null){
		        $variable.setVariableScope(vs.variableScope, getOPPLFactory().getVariableScopeChecker());
		      }
		   } catch(OPPLException e){
		      getErrorListener().reportThrowable(e, $INPUT_VARIABLE_DEFINITION.token.getLine(), $INPUT_VARIABLE_DEFINITION.token.getCharPositionInLine(),$INPUT_VARIABLE_DEFINITION.token.getText().length());
		   }
		  }
			| ^(GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^( expr = EXPRESSION .*))
	    	{
	    		Type type = getSymbolTable().getExpressionGeneratedVariableType($start,$VARIABLE_TYPE, expr);
	    		if(type!=null){
		       		VariableExpressionGeneratedVariable variableExpressionGeneratedVariable = new VariableExpressionGeneratedVariable(
        								$VARIABLE_NAME.getText(), expr.getOWLObject(), getConstraintSystem());
								        getConstraintSystem().importVariable(variableExpressionGeneratedVariable);
			        $variable = variableExpressionGeneratedVariable;
				}else{
					getErrorListener().reportThrowable(new NullPointerException("The type of the generated variable is null"), $start.token.getLine(), $start.token.getCharPositionInLine(),$start.token.getText().length());
				}
			}
	  |  ^(GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(MATCH se = stringOperation ))
	     {
	       org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType($VARIABLE_TYPE.getText()).getOPPLVariableType();

          OWLEntityRenderer renderer = getOPPLFactory().getOWLEntityRenderer(getConstraintSystem());
	  RegExpGenerated<?> v = type.getRegExpGenerated(
							$VARIABLE_NAME.getText(),
							renderer,
							se,
							this.getConstraintSystem().getOntologyManager().getOntologies());
					this.constraintSystem.importVariable(v);
          constraintSystem.importVariable(v);
          $variable = v;
	     }
	  | ^(GENERATED_VARIABLE_DEFINITION VARIABLE_NAME VARIABLE_TYPE ^(CREATE_OPPL_FUNCTION  value = stringOperation))
	     {
	       org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType($VARIABLE_TYPE.getText()).getOPPLVariableType();
	       $variable = constraintSystem.createStringGeneratedVariable($VARIABLE_NAME.getText(),type, value);
	     }
    | ^(GENERATED_VARIABLE_DEFINITION name = VARIABLE_NAME VARIABLE_TYPE ^(CREATE_INTERSECTION va = IDENTIFIER))
       {
         org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType($VARIABLE_TYPE.getText()).getOPPLVariableType();
         AbstractCollectionGeneratedValue<OWLClass> collection = symtab.getCollection($start,va, getConstraintSystem());
         $variable = constraintSystem.createIntersectionGeneratedVariable(name.getText(),type,collection);         
       }
      | ^(GENERATED_VARIABLE_DEFINITION name = VARIABLE_NAME VARIABLE_TYPE ^(CREATE_DISJUNCTION va = IDENTIFIER))
       {
         org.coode.oppl.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType($VARIABLE_TYPE.getText()).getOPPLVariableType();
         AbstractCollectionGeneratedValue<OWLClass> collection = symtab.getCollection($start,va, getConstraintSystem());
         $variable = constraintSystem.createUnionGeneratedVariable(name.getText(),type,collection);         
       }    	     	    
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
  
  
  



variableScope returns [Type type, VariableScope variableScope]
@after 
	{ 
		$start.setEvalType($type); 
	} // do after any alternative
	: 
	   ^(VARIABLE_SCOPE SUBCLASS_OF   classExpression=.)
	   {
		   $type = symtab.getClassVariableScopeType($start, classExpression);
		   $variableScope = VariableScopes.buildSubClassVariableScope((OWLDescription)classExpression.getOWLObject());
	   }
   |  ^(VARIABLE_SCOPE SUPER_CLASS_OF  classExpression=.)
     {
       $type = symtab.getClassVariableScopeType($start, classExpression);
       $variableScope = VariableScopes.buildSuperClassVariableScope((OWLDescription)classExpression.getOWLObject());
     }	   
	 | ^(VARIABLE_SCOPE SUPER_PROPERTY_OF  propertyExpression=.)
	   {
       $type = symtab.getPropertyVariableScopeType($start, propertyExpression);
       $variableScope = VariableScopes.buildSuperPropertyVariableScope((OWLPropertyExpression<?,?>) propertyExpression.getOWLObject());
     }
   | ^(VARIABLE_SCOPE SUBPROPERTY_OF propertyExpression=.)
     {
       $type = symtab.getPropertyVariableScopeType($start, propertyExpression);
       $variableScope = VariableScopes.buildSubPropertyVariableScope((OWLPropertyExpression<?,?>) propertyExpression.getOWLObject());
     }     
   | ^(VARIABLE_SCOPE (INSTANCE_OF | TYPES)  individualExpression=.)
     {
       $type = symtab.getIndividualVariableScopeType($start, individualExpression);
       $variableScope = VariableScopes.buildIndividualVariableScope((OWLDescription) individualExpression.getOWLObject());
     }
	;
	
	

constraint returns [AbstractConstraint constraint]
@init
  {
    List<OPPLSyntaxTree> identifiers = new ArrayList<OPPLSyntaxTree>();
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
			$constraint =   new InCollectionRegExpConstraint(variable, se, getConstraintSystem());
		}
		| ^(NAF_CONSTRAINT a = .){
			OWLObject axiom = a.getOWLObject();
			if(axiom instanceof OWLAxiom){
				$constraint =   new NAFConstraint((OWLAxiom) axiom, getConstraintSystem());
			}
			
		}
;
