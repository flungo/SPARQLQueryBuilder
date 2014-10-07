/*
 * Copyright (C) 2014 Fabrizio Lungo <fab@lungo.co.uk> - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Created by Fabrizio Lungo <fab@lungo.co.uk>, October 2014
 */
package me.flungo.sparql.builder.terminals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.jena.iri.IRIException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Fabrizio Lungo <fab@lungo.co.uk>
 */
public class IRIRefTest {

    // Map of test cases that should be valid <Input, Expected Result>
    private static final Map<String, String> validTestCases = new HashMap<String, String>();
    // Set of invalid test cases
    private static final Set<String> invalidTestCases = new HashSet<String>();

    static {
        // Add valid test cases
        validTestCases.put("<http://xmlns.com/foaf/0.1/>", "<http://xmlns.com/foaf/0.1/>");
        //validTestCases.put("<http://www.w3.org/People/Berners-Lee/card#>", "<http://www.w3.org/People/Berners-Lee/card#>");
        validTestCases.put("http://purl.org/net/schemas/space/", "<http://purl.org/net/schemas/space/>");
        validTestCases.put("http://example.com/resource", "<http://example.com/resource>");
        validTestCases.put("localData.ttl", "<localData.ttl>");
        validTestCases.put("<localData.ttl>", "<localData.ttl>");
        validTestCases.put("<abc#def>", "<abc#def>");

        // Add invalid test cases
        invalidTestCases.add("!£$%^&*()");
        invalidTestCases.add("!localData.ttl");
        invalidTestCases.add("<<localData.ttl>>");
        invalidTestCases.add("<<http://purl.org/net/schemas/space/>>");
        invalidTestCases.add("<http://xmlns.com/foaf/0.1/");
        invalidTestCases.add("http://xmlns.com/foaf/0.1/>");
        invalidTestCases.add("http://<xmlns.com>/foaf/0.1/");
        invalidTestCases.add("http://xmlns.com>/foaf/0.1/");
        invalidTestCases.add("http://<xmlns.com/foaf/0.1/");
        invalidTestCases.add("abc##def");
    }

    public IRIRefTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRef method, of class IRIRef.
     */
    @org.junit.Test
    public void testGetRefValidInputs() {
        System.out.println("getRef - valid inputs");
        for (String iri : validTestCases.keySet()) {
            System.out.println("Testing: " + iri);
            IRIRef instance = new IRIRef(iri);
            String expResult = validTestCases.get(iri);
            String result = instance.getRef();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of validate method, of class IRIRef.
     */
    @org.junit.Test
    public void testValidateValidInputs() {
        System.out.println("validate - valid inputs");
        for (String iri : validTestCases.keySet()) {
            System.out.println("Testing: " + iri);
            try {
                IRIRef.validate(iri);
            } catch (IRIException e) {
                e.printStackTrace();
                fail(iri + " should be valid");
            }
        }
    }

    /**
     * Test of validate method, of class IRIRef.
     */
    @org.junit.Test
    public void testValidateInvalidInputs() {
        System.out.println("validate - invalid inputs");
        for (String iri : invalidTestCases) {
            System.out.println("Testing: " + iri);
            try {
                IRIRef.validate(iri);
                fail(iri + " should be invalid");
            } catch (IRIException e) {
                // Do nothing, this is what we expected.
            }
        }
    }

}
