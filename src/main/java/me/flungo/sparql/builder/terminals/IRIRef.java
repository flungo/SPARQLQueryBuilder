/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
 */
package me.flungo.sparql.builder.terminals;

import org.apache.jena.iri.IRIException;
import org.apache.jena.iri.IRIFactory;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class IRIRef {

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
