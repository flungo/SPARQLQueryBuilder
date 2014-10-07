/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
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
