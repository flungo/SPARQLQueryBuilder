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
