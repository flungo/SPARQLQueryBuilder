/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
 */
package me.flungo.sparql.builder.terminals;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class PrefixedName {

    public final static String CHARS_BASE = "[A-Z]|[a-z]|[\\u00C0-\\u00D6]|[\\u00D8-\\u00F6]|[\\u00F8-\\u02FF]|[\\u0370-\\u037D]|[\\u037F-\\u1FFF]|[\\u200C-\\u200D]|[\\u2070-\\u218F]|[\\u2C00-\\u2FEF]|[\\u3001-\\uD7FF]|[\\uF900-\\uFDCF]|[\\uFDF0-\\uFFFD]|[\\u10000-\\uEFFFF]";
    public final static String CHARS_U = CHARS_BASE + "|_";
    public final static String CHARS = CHARS_U + "|-|[0-9]|\\u00B7|[\\u0300-\\u036F]|[\\u203F-\\u2040]";

}
