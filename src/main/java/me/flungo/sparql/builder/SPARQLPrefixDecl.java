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

import java.util.regex.Pattern;
import me.flungo.sparql.builder.terminals.IRIRef;
import me.flungo.sparql.builder.terminals.PrefixedName;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class SPARQLPrefixDecl {

    public final static String patternString = "^(" + PrefixedName.CHARS_BASE + ")((" + PrefixedName.CHARS + "|\\.)*(" + PrefixedName.CHARS + "))??:??$";
    public final static Pattern pattern = Pattern.compile(patternString);

    private final String prefix;
    private final IRIRef iri;

    public SPARQLPrefixDecl(String prefix, IRIRef iri) {
        // Check string is a valid prefix name
        if (!validate(prefix)) {
            throw new IllegalArgumentException("Invalid prefix string");
        }
        // Remove ':' if it has been included, we will add this later.
        prefix = prefix.replaceFirst(":$", "");
        this.prefix = prefix;
        this.iri = iri;
    }

    public SPARQLPrefixDecl(String prefix, String iri) {
        this(prefix, new IRIRef(iri));
    }

    public String getPrefix() {
        return prefix + ':';
    }

    public IRIRef getIRI() {
        return iri;
    }

    @Override
    public String toString() {
        return "PREFIX " + getPrefix() + getIRI();
    }

    public static boolean validate(String prefix) {
        return pattern.matcher(prefix).find();
    }
}
