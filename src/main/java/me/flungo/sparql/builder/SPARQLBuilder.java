/*
 * Copyright 2014 Fabrizio Lungo <fab@lungo.co.uk>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.flungo.sparql.builder;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import me.flungo.sparql.builder.query.SPARQLQuery;

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
        if (!query.isValid()) {
            throw new IllegalStateException("Query is not valid");
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
