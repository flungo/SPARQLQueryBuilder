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
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class SPARQLSelectQuery implements SPARQLQuery {

    private boolean distinct = false;
    private boolean reduced = false;
    private final Set<SPARQLVariable> variables = new HashSet<SPARQLVariable>();
    private final Set<SPARQLDatasetClause> datasetClauses = new HashSet<SPARQLDatasetClause>();
    private SPARQLWhereClause whereClause = null;
    private SPARQLSolutionModifier solutionModifier = null;

    public void setDistinct(boolean distinct) {
        if (reduced) {
            throw new IllegalStateException("Query cannot be set to both distinct and reduced.");
        }
        this.distinct = distinct;
    }

    public void setReduced(boolean reduced) {
        this.reduced = reduced;
    }

    public boolean addVariable(SPARQLVariable e) {
        return variables.add(e);
    }

    public boolean removeVariable(SPARQLVariable o) {
        return variables.remove(o);
    }

    public boolean addAllVariables(Collection<? extends SPARQLVariable> c) {
        return variables.addAll(c);
    }

    public boolean retainAllVariables(Collection<?> c) {
        return variables.retainAll(c);
    }

    public boolean removeAllVariables(Collection<?> c) {
        return variables.removeAll(c);
    }

    public void clearVariables() {
        variables.clear();
    }

    public boolean addDatasetClause(SPARQLDatasetClause e) {
        return datasetClauses.add(e);
    }

    public boolean removeDatasetClause(Object o) {
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

    public void setSolutionModifier(SPARQLSolutionModifier solutionModifier) {
        this.solutionModifier = solutionModifier;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public boolean isReduced() {
        return reduced;
    }

    public Set<SPARQLVariable> getVariables() {
        return new HashSet<SPARQLVariable>(variables);
    }

    public Set<SPARQLDatasetClause> getDatasetClauses() {
        return new HashSet<SPARQLDatasetClause>(datasetClauses);
    }

    public SPARQLWhereClause getWhereClause() {
        return whereClause;
    }

    public SPARQLSolutionModifier getSolutionModifier() {
        return solutionModifier;
    }

    @Override
    public boolean isValid() {
        return whereClause != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SELECT");
        if (distinct) {
            sb.append(" DISTINCT");
        } else if (reduced) {
            sb.append(" REDUCED");
        }
        if (variables.isEmpty()) {
            sb.append(" *");
        } else {
            for (SPARQLVariable var : variables) {
                sb.append(' ').append(var);
            }
        }
        for (SPARQLDatasetClause clause : datasetClauses) {
            sb.append('\n').append(clause);
        }
        sb.append('\n').append(whereClause);
        if (solutionModifier != null) {
            sb.append('\n').append(solutionModifier);
        }
        return sb.toString();
    }

}
