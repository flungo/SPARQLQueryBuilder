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
