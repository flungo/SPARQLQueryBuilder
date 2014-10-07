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
package me.flungo.sparql.builder.terminals;

import me.flungo.sparql.builder.query.SPARQLDescribable;
import org.apache.jena.iri.IRIException;
import org.apache.jena.iri.IRIFactory;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class IRIRef implements SPARQLDescribable {

    static IRIFactory iriFactory = IRIFactory.semanticWebImplementation();

    private final String ref;

    public IRIRef(String ref) throws IRIException {
        ref = ref.replaceFirst("^<(.*)>$", "\\1");
        validate(ref);
        this.ref = ref;
    }

    public String getRef() {
        return '<' + ref + '>';
    }

    public static void validate(String ref) throws IRIException {
        iriFactory.construct(ref);
    }
}
