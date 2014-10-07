/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
 */
package me.flungo.sparql.builder;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class SPARQLBuilder {

    private SPARQLPrologue prologue = null;
    private SPARQLQuery query = null;

    public void setPrologue(SPARQLPrologue prologue) {
        this.prologue = prologue;
    }

    public void setQuery(SPARQLQuery query) {
        this.query = query;
    }

    public SPARQLPrologue getPrologue() {
        return prologue;
    }

    public SPARQLQuery getQuery() {
        return query;
    }

    public Query buildQuery() {
        // Validate that a query can be produced
        if (query == null) {
            throw new IllegalStateException("No query to build");
        }
        // Create the query
        return QueryFactory.create(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (prologue != null) {
            sb.append(prologue).append('\n').append('\n');
        }
        if (prologue != null) {
            sb.append(prologue).append('\n');
        }
        return sb.toString();
    }

}
