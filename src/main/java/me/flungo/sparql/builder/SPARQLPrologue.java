/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
 */
package me.flungo.sparql.builder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class SPARQLPrologue {

    private SPARQLBaseDecl baseDeclaration = null;
    private final Set<SPARQLPrefixDecl> prefixDeclarations = new HashSet<SPARQLPrefixDecl>();

    public SPARQLPrologue setBase(SPARQLBaseDecl base) {
        this.baseDeclaration = base;
        return this;
    }

    public SPARQLPrologue addPrefix(SPARQLPrefixDecl prefix) {
        prefixDeclarations.add(prefix);
        return this;
    }

    public SPARQLPrologue removePrefix(SPARQLPrefixDecl o) {
        prefixDeclarations.remove(o);
        return this;
    }

    public SPARQLPrologue addAllPrefix(Collection<? extends SPARQLPrefixDecl> c) {
        prefixDeclarations.addAll(c);
        return this;
    }

    public SPARQLPrologue retainAllPrefix(Collection<?> c) {
        prefixDeclarations.retainAll(c);
        return this;
    }

    public SPARQLPrologue removeAllPrefix(Collection<?> c) {
        prefixDeclarations.removeAll(c);
        return this;
    }

    public Set<SPARQLPrefixDecl> getPrefixDeclarations() {
        return new HashSet<SPARQLPrefixDecl>(prefixDeclarations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (baseDeclaration != null) {
            sb.append(baseDeclaration).append('\n');
        }
        for (SPARQLPrefixDecl prefix : prefixDeclarations) {
            sb.append(prefix).append('\n');
        }
        return sb.toString();
    }

}
