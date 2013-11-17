package org.coode.parsers.oppl.test;

import org.coode.parsers.SymbolTable;
import org.coode.parsers.common.SilentListener;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

@SuppressWarnings("javadoc")
public class SymbolTables {
    public static OPPLSymbolTable getOPPLSymbolTable(OWLOntology o) {
        OPPLSymbolTable symtab = new org.coode.parsers.oppl.factory.SimpleSymbolTableFactory(
                o.getOWLOntologyManager()).createSymbolTable();
        symtab.setErrorListener(new SilentListener());
        return symtab;
    }

    public static OPPLSymbolTable getOPPLSymbolTable(OWLOntologyManager o) {
        OPPLSymbolTable symtab = new org.coode.parsers.oppl.factory.SimpleSymbolTableFactory(
                o).createSymbolTable();
        symtab.setErrorListener(new SilentListener());
        return symtab;
    }

    public static SymbolTable getSymbolTable(OWLOntology o) {
        SymbolTable symtab = new org.coode.parsers.factory.SimpleSymbolTableFactory(
                o.getOWLOntologyManager()).createSymbolTable();
        symtab.setErrorListener(new SilentListener());
        return symtab;
    }
}
