package edu.pw.test.parser;

import edu.pw.main.parser.StandardFunction;

public class StandardFunctionTest {

    @org.junit.Test
    public void isStandard() {
        org.junit.Assert.assertTrue(StandardFunction.isStandard("print"));
        org.junit.Assert.assertTrue(StandardFunction.isStandard("toText"));
        org.junit.Assert.assertTrue(StandardFunction.isStandard("loadImage"));
        org.junit.Assert.assertTrue(StandardFunction.isStandard("loadText"));
        org.junit.Assert.assertTrue(StandardFunction.isStandard("countWords"));
        org.junit.Assert.assertTrue(StandardFunction.isStandard("countParagraphs"));
        org.junit.Assert.assertTrue(StandardFunction.isStandard("compare"));
        org.junit.Assert.assertTrue(StandardFunction.isStandard("ocr"));
        org.junit.Assert.assertFalse(StandardFunction.isStandard("nonStandardFunction"));
    }
}