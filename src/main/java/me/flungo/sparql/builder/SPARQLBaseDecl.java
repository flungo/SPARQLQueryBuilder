/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
 */
package me.flungo.sparql.builder;

import me.flungo.sparql.builder.terminals.IRIRef;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class SPARQLBaseDecl {

    private final IRIRef base;

    public SPARQLBaseDecl(IRIRef base) {
        this.base = base;
    }

    public SPARQLBaseDecl(String base) {
        this(new IRIRef(base));
    }

    public IRIRef getBase() {
        return base;
    }

    @Override
    public String toString() {
        return "BASE " + base;
    }
}
