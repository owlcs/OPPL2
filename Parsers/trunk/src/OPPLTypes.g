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
  public OPPLTypes(TreeNodeStream input, OPPLSymbolTable symtab, ErrorListener errorListener, OPPLAbstractFactory opplFactory) {
    this(input);
    if(symtab==null){
    	throw new NullPointerException("The symbol table cannot be null");
    }
    if(errorListener == null){
    	throw new NullPointerException("The error listener cannot be null");
    }
    if(opplFactory == null){
      throw new NullPointerException("The OPPL Factory cannot be null");
    }
    this.symtab = symtab;
    this.errorListener = errorListener;
    this.opplFactory = opplFactory;
    this.constraintSystem = getOPPLFactory().createConstraintSystem();
    
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
  import org.coode.oppl.exceptions.OPPLException;
  import org.coode.oppl.OPPLAbstractFactory;
  import org.coode.oppl.variablemansyntax.generated.RegExpGenerated;
  import org.coode.oppl.variablemansyntax.generated.RegExpGeneratedValue;
  import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedValue;
  import org.coode.oppl.variablemansyntax.generated.StringGeneratedValue;
  import org.coode.oppl.variablemansyntax.generated.ConcatGeneratedValues;
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
	:
		^(OPPL_STATEMENT variableDefinitions query actions)
		{
			$start.setOPPLContent(getOPPLFactory().buildOPPLScript(getConstraintSystem(),
									$variableDefinitions.variables, $query.query,
									$actions.actions));
		}
	;

variableDefinitions returns [List<Variable> variables]
@init{
	List<Variable> toReturn = new ArrayList<Variable>();
}
@after{
	$variables = toReturn;
}
	:
		^(VARIABLE_DEFINITIONS (vd = variableDefinition {toReturn.add(vd.variable);})+)		
	;
	
query returns [OPPLQuery query]
@init{
		$query = getOPPLFactory().buildNewQuery(getConstraintSystem());
}
	:
		^(QUERY (selectClause 
		{
			if($selectClause.asserted){
				$query.addAssertedAxiom($selectClause.axiom);
			}else{
				$query.addAxiom($selectClause.axiom);
			}
		}
		)+ (constraint
				{
					$query.addConstraint($constraint.constraint);
				}
		)?)
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
	:
		^(ACTIONS (action {$actions.add($action.change);})+)
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
		  ^(INPUT_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE vs = variableScope?)
		  {
		  try {
		      $variable = getConstraintSystem().createVariable($IDENTIFIER.getToken().getText(), symtab.getVaribaleType($VARIABLE_TYPE));
		      if(vs !=null){
		        $variable.setVariableScope(vs.variableScope, getOPPLFactory().getVariableScopeChecker());
		      }
		   } catch(OPPLException e){
		      getErrorListener().reportThrowable(e, $INPUT_VARIABLE_DEFINITION.token.getLine(), $INPUT_VARIABLE_DEFINITION.token.getCharPositionInLine(),$INPUT_VARIABLE_DEFINITION.token.getText().length());
		   }
		  }
	  | ^(GENERATED_VARIABLE_DEFINITION IDENTIFIER generatedVariableAssignment)
	    {
	       VariableExpressionGeneratedVariable variableExpressionGeneratedVariable = new VariableExpressionGeneratedVariable(
        $IDENTIFIER.getText(), $generatedVariableAssignment.owlObject, getConstraintSystem());
        getConstraintSystem().importVariable(variableExpressionGeneratedVariable);
        $variable = variableExpressionGeneratedVariable;
	    }
	  |  ^(GENERATED_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE ^(MATCH se = stringOperation ))
	     {
	       org.coode.oppl.variablemansyntax.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType($VARIABLE_TYPE.getText()).getOPPLVariableType();
	       Set<? extends OWLObject> referencedValues = type
              .getReferencedValues(constraintSystem.getOntologyManager()
                  .getOntologies());
          OWLEntityRenderer renderer = getOPPLFactory().getOWLEntityRenderer(getConstraintSystem());
          RegExpGeneratedValue val = new RegExpGeneratedValue(referencedValues,
             se, renderer);
          RegExpGenerated v = type.instantiateRegexpVariable($IDENTIFIER.getText(), val);
          constraintSystem.importVariable(v);
          $variable = v;
	     }
	  | ^(GENERATED_VARIABLE_DEFINITION IDENTIFIER VARIABLE_TYPE ^(CREATE_OPPL_FUNCTION  value = stringOperation))
	     {
	       org.coode.oppl.variablemansyntax.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType($VARIABLE_TYPE.getText()).getOPPLVariableType();
	       $variable = constraintSystem.createStringGeneratedVariable($IDENTIFIER.getText(),type, value);
	     }
    | ^(GENERATED_VARIABLE_DEFINITION name = IDENTIFIER VARIABLE_TYPE ^(CREATE_INTERSECTION va = IDENTIFIER))
       {
         org.coode.oppl.variablemansyntax.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType($VARIABLE_TYPE.getText()).getOPPLVariableType();
         AbstractCollectionGeneratedValue<OWLClass> collection = symtab.getCollection($start,va, getConstraintSystem());
         $variable = constraintSystem.createIntersectionGeneratedVariable(name.getText(),type,collection);         
       }
      | ^(GENERATED_VARIABLE_DEFINITION name = IDENTIFIER VARIABLE_TYPE ^(CREATE_DISJUNCTION va = IDENTIFIER))
       {
         org.coode.oppl.variablemansyntax.VariableType type = org.coode.parsers.oppl.VariableType.getVariableType($VARIABLE_TYPE.getText()).getOPPLVariableType();
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
    | ^(IDENTIFIER (^(ATTRIBUTE_SELECTOR i = INTEGER))?)
      {
        $value = i==null? symtab.getStringGeneratedValue($IDENTIFIER, getConstraintSystem()) : symtab.getStringGeneratedValue($IDENTIFIER,i, getConstraintSystem());
      }
  ;
  
  
  
generatedVariableAssignment returns [Type type, OWLObject owlObject]
@after 
  { 
    $start.setEvalType($type);     
  } // do after any alternative
  : 
    ^(CLASS ^(EXPRESSION classExpression=.))
    {
      $type = symtab.getClassGeneratedVariable($start, classExpression);
      $owlObject = classExpression.getOWLObject();
    }
  | ^(OBJECTPROPERTY ^(EXPRESSION objectPropertyExpression=.))
    {
      $type = symtab.getObjectPropertyGeneratedVariable($start, objectPropertyExpression);
      $owlObject = objectPropertyExpression.getOWLObject();
    }
  | ^(DATAPROPERTY ^(EXPRESSION dataPropertyExpression=.))
    {
      $type = symtab.getDataPropertyGeneratedVariable($start, dataPropertyExpression);
      $owlObject = dataPropertyExpression.getOWLObject();
    }
  | ^(INDIVIDUAL ^(EXPRESSION individualExpression=.))
    {
      $type = symtab.getIndividualGeneratedVariable($start, individualExpression);
      $owlObject = individualExpression.getOWLObject();
    }
  | ^(CONSTANT ^(EXPRESSION constantExpression=.))
    {
      $type = symtab.getConstantGeneratedVariable($start, constantExpression);
      $owlObject = constantExpression.getOWLObject();
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
       $variableScope = VariableScopes.buildSubPropertyVariableScope((OWLPropertyExpression<?,?>) propertyExpression);
     }     
   | ^(VARIABLE_SCOPE (INSTANCE_OF | TYPES)  individualExpression=.)
     {
       $type = symtab.getIndividualVariableScopeType($start, individualExpression);
       $variableScope = VariableScopes.buildIndividualVariableScope((OWLDescription) individualExpression);
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
		| ^(IN_SET_CONSTRAINT v = IDENTIFIER ^(ONE_OF (i = IDENTIFIER {identifiers.add(i);})+)){
			$constraint = symtab.getInSetConstraint($start,v,constraintSystem,identifiers.toArray(new OPPLSyntaxTree[identifiers.size()]));
		}
;