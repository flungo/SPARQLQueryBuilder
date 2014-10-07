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
public class SPARQLSelectQuery extends SPARQLQuery {

    protected boolean distinct = false;
    protected boolean reduced = false;
    protected final Set<SPARQLVariable> variables = new LinkedHashSet<SPARQLVariable>();
    protected SPARQLSolutionModifier solutionModifier = null;

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
        return new LinkedHashSet<SPARQLVariable>(variables);
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
