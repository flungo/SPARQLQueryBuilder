/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
 */
package me.flungo.sparql.builder.query;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class SPARQLConstructQuery extends SPARQLQuery {

    protected SPARQLConstructTemplate constructTemplate = null;
    protected SPARQLSolutionModifier solutionModifier = null;

    public void setConstructTemplate(SPARQLConstructTemplate constructTemplate) {
        this.constructTemplate = constructTemplate;
    }

    public void setSolutionModifier(SPARQLSolutionModifier solutionModifier) {
        this.solutionModifier = solutionModifier;
    }

    public SPARQLConstructTemplate getConstructTemplate() {
        return constructTemplate;
    }

    public SPARQLSolutionModifier getSolutionModifier() {
        return solutionModifier;
    }

    @Override
    public boolean isValid() {
        return whereClause != null && constructTemplate != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CONSTRUCT ");
        sb.append(constructTemplate);
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
