/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
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
