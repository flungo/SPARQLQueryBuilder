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
public class SPARQLDescribeQuery extends SPARQLQuery {

    protected final Set<SPARQLDescribable> describables = new LinkedHashSet<SPARQLDescribable>();
    protected SPARQLSolutionModifier solutionModifier = null;

    public boolean addVariable(SPARQLDescribable e) {
        return describables.add(e);
    }

    public boolean removeVariable(SPARQLDescribable o) {
        return describables.remove(o);
    }

    public boolean addAllVariables(Collection<? extends SPARQLDescribable> c) {
        return describables.addAll(c);
    }

    public boolean retainAllVariables(Collection<?> c) {
        return describables.retainAll(c);
    }

    public boolean removeAllVariables(Collection<?> c) {
        return describables.removeAll(c);
    }

    public void clearVariables() {
        describables.clear();
    }

    public void setSolutionModifier(SPARQLSolutionModifier solutionModifier) {
        this.solutionModifier = solutionModifier;
    }

    public Set<SPARQLDescribable> getDescribables() {
        return new LinkedHashSet<SPARQLDescribable>(describables);
    }

    public SPARQLSolutionModifier getSolutionModifier() {
        return solutionModifier;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DESCRIBE");
        if (describables.isEmpty()) {
            sb.append(" *");
        } else {
            for (SPARQLDescribable var : describables) {
                sb.append(' ').append(var);
            }
        }
        for (SPARQLDatasetClause clause : datasetClauses) {
            sb.append('\n').append(clause);
        }
        if (whereClause != null) {
            sb.append('\n').append(whereClause);
        }
        if (solutionModifier != null) {
            sb.append('\n').append(solutionModifier);
        }
        return sb.toString();
    }

}
