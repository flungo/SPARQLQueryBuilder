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
package me.flungo.sparql.builder.query;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public abstract class SPARQLQuery {

    protected final Set<SPARQLDatasetClause> datasetClauses = new LinkedHashSet<SPARQLDatasetClause>();
    protected SPARQLWhereClause whereClause = null;

    public abstract boolean isValid();

    public boolean addDatasetClause(SPARQLDatasetClause e) {
        return datasetClauses.add(e);
    }

    public boolean removeDatasetClause(SPARQLDatasetClause o) {
        return datasetClauses.remove(o);
    }

    public boolean addAllDatasetClauses(Collection<? extends SPARQLDatasetClause> c) {
        return datasetClauses.addAll(c);
    }

    public boolean retainAllDatasetClauses(Collection<?> c) {
        return datasetClauses.retainAll(c);
    }

    public boolean removeAllDatasetClauses(Collection<?> c) {
        return datasetClauses.removeAll(c);
    }

    public void clearDatasetClauses() {
        datasetClauses.clear();
    }

    public void setWhereClause(SPARQLWhereClause whereClause) {
        this.whereClause = whereClause;
    }

    public Set<SPARQLDatasetClause> getDatasetClauses() {
        return new LinkedHashSet<SPARQLDatasetClause>(datasetClauses);
    }

    public SPARQLWhereClause getWhereClause() {
        return whereClause;
    }

}
