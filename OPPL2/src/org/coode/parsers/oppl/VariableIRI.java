package org.coode.parsers.oppl;

import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.Variable;
import org.coode.oppl.function.AttributeName;
import org.coode.oppl.function.IRIVariableAttribute;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationSubjectVisitor;
import org.semanticweb.owlapi.model.OWLAnnotationSubjectVisitorEx;
import org.semanticweb.owlapi.model.OWLAnnotationValueVisitor;
import org.semanticweb.owlapi.model.OWLAnnotationValueVisitorEx;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

public class VariableIRI extends IRI {
    private final IRIVariableAttribute attribute;

    /** @return the attribute */
    public IRIVariableAttribute getAttribute() {
        return attribute;
    }

    public VariableIRI(Variable<?> variable) {
        super(String.format("%s.%s", variable.getName(), AttributeName.IRI));
        if (variable == null) {
            throw new NullPointerException("The variable cannot be null");
        }
        attribute = new IRIVariableAttribute(variable);
    }

    public void accept(OWLAnnotationSubjectVisitor visitor) {
        visitor.visit(this);
    }

    public <E> E accept(OWLAnnotationSubjectVisitorEx<E> visitor) {
        return visitor.visit(this);
    }

    public Set<OWLEntity> getSignature() {
        return new HashSet<OWLEntity>(Collections.<OWLEntity> emptySet());
    }

    public Set<OWLClass> getClassesInSignature() {
        return new HashSet<OWLClass>(Collections.<OWLClass> emptySet());
    }

    public Set<OWLDataProperty> getDataPropertiesInSignature() {
        return new HashSet<OWLDataProperty>(Collections.<OWLDataProperty> emptySet());
    }

    public Set<OWLObjectProperty> getObjectPropertiesInSignature() {
        return new HashSet<OWLObjectProperty>(Collections.<OWLObjectProperty> emptySet());
    }

    public Set<OWLNamedIndividual> getIndividualsInSignature() {
        return new HashSet<OWLNamedIndividual>(
                Collections.<OWLNamedIndividual> emptySet());
    }

    public Set<OWLDatatype> getDatatypesInSignature() {
        return new HashSet<OWLDatatype>(Collections.<OWLDatatype> emptySet());
    }

    public Set<OWLClassExpression> getNestedClassExpressions() {
        return new HashSet<OWLClassExpression>(
                Collections.<OWLClassExpression> emptySet());
    }

    public void accept(OWLObjectVisitor visitor) {
        if (visitor instanceof IRIVisitor) {
            ((IRIVisitor) visitor).visitVariableIRI(this);
        } else {
            visitor.visit(this);
        }
    }

    public void accept(IRIVisitor visitor) {
        visitor.visitVariableIRI(this);
    }

    public <O> O accept(OWLObjectVisitorEx<O> visitor) {
        return visitor instanceof IRIVisitorEx<?> ? ((IRIVisitorEx<O>) visitor)
                .visitVariableIRI(this) : visitor.visit(this);
    }

    public <O> O accept(IRIVisitorEx<O> visitor) {
        return visitor.visitVariableIRI(this);
    }

    public boolean isTopEntity() {
        return false;
    }

    public boolean isBottomEntity() {
        return false;
    }

    public int compareTo(OWLObject object) {
        if (object == this) {
            return 0;
        } else if (!(object instanceof IRI)) {
            return -1;
        } else {
            return toString().compareTo(object.toString());
        }
    }

    public void accept(OWLAnnotationValueVisitor visitor) {
        visitor.visit(this);
    }

    public <O> O accept(OWLAnnotationValueVisitorEx<O> visitor) {
        return visitor.visit(this);
    }

    @Override
    public URI toURI() {
        return URI.create(toString());
    }

    @Override
    public boolean isAbsolute() {
        return false;
    }

    @Override
    public String getScheme() {
        return null;
    }

    @Override
    public String getStart() {
        return getScheme();
    }

    @Override
    public IRI resolve(String s) {
        return this;
    }

    @Override
    public boolean isReservedVocabulary() {
        return false;
    }

    @Override
    public boolean isThing() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isNothing() {
        return false;
    }

    @Override
    public boolean isPlainLiteral() {
        return false;
    }

    @Override
    public String getFragment() {
        return toString();
    }

    @Override
    public String toQuotedString() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("%s.%s", getAttribute().getVariable().getName(),
                getAttribute().getAttribute());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (attribute == null ? 0 : attribute.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        VariableIRI other = (VariableIRI) obj;
        if (attribute == null) {
            if (other.attribute != null) {
                return false;
            }
        } else if (!attribute.equals(other.attribute)) {
            return false;
        }
        return true;
    }
}
