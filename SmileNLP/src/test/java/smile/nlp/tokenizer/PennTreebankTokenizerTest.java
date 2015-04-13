/*******************************************************************************
 * Copyright (c) 2010 Haifeng Li
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package smile.nlp.tokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Haifeng
 */
public class PennTreebankTokenizerTest {

    public PennTreebankTokenizerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of split method, of class TreebankWordTokenizer.
     */
    @Test
    public void testSplit() {
        System.out.println("tokenize");
        String text = "Good muffins cost $3.88\nin New York.  Please buy "
                + "me\ntwo of them.\n\nYou cannot eat them. I gonna eat them. "
                + "Thanks.";

        String[] expResult = {"Good", "muffins", "cost", "$", "3.88", "in",
            "New", "York.", "Please", "buy", "me", "two", "of", "them", ".",
            "You", "can", "not", "eat", "them.", "I", "gon", "na", "eat",
            "them.", "Thanks", "."};

        PennTreebankTokenizer instance = PennTreebankTokenizer.getInstance();
        String[] result = instance.split(text);

        assertEquals(expResult.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of split method, of class TreebankWordTokenizer.
     */
    @Test
    public void testSplitContraction() {
        System.out.println("tokenize contraction");
        String text = "Here are some examples of contractions: 'tis, "
                + "'twas, ain't, aren't, can't, could've, couldn't, didn't, doesn't, "
                + "don't, hasn't, he'd, he'll, he's, how'd, how'll, how's, i'd, i'll, i'm, "
                + "i've, isn't, it's, might've, mightn't, must've, mustn't, shan't, "
                + "she'd, she'll, she's, should've, shouldn't, that'll, that's, "
                + "there's, they'd, they'll, they're, they've, wasn't, we'd, we'll, "
                + "we're, weren't, what'd, what's, when'd, when'll, when's, "
                + "where'd, where'll, where's, who'd, who'll, who's, why'd, why'll, "
                + "why's, won't, would've, wouldn't, you'd, you'll, you're, you've";

        String[] expResult = {"Here", "are", "some", "examples", "of",
            "contractions", ":", "'t", "is", ",", "'t", "was", ",", "ai",
            "n't", ",", "are", "n't", ",", "ca", "n't", ",", "could", "'ve",
            ",", "could", "n't", ",", "did", "n't", ",", "does", "n't", ",", "do",
            "n't", ",", "has", "n't", ",", "he", "'d", ",", "he", "'ll", ",",
            "he", "'s", ",", "how", "'d", ",", "how", "'ll", ",", "how", "'s",
            ",", "i", "'d", ",", "i", "'ll", ",", "i", "'m", ",", "i", "'ve", ",",
            "is", "n't", ",", "it", "'s", ",", "might", "'ve", ",", "might",
            "n't", ",", "must", "'ve", ",", "must", "n't", ",", "sha",
            "n't", ",", "she", "'d", ",", "she", "'ll", ",", "she", "'s", ",",
            "should", "'ve", ",", "should", "n't", ",", "that", "'ll", ",",
            "that", "'s", ",", "there", "'s", ",", "they", "'d", ",", "they", "'ll",
            ",", "they", "'re", ",", "they", "'ve", ",", "was", "n't", ",", "we",
            "'d", ",", "we", "'ll", ",", "we", "'re", ",", "were", "n't", ",",
            "what", "'d", ",", "what", "'s", ",", "when",
            "'d", ",", "when", "'ll", ",", "when", "'s", ",", "where", "'d", ",",
            "where", "'ll", ",", "where", "'s", ",", "who", "'d", ",", "who",
            "'ll", ",", "who", "'s", ",", "why", "'d", ",", "why", "'ll", ",",
            "why", "'s", ",", "wo", "n't", ",", "would", "'ve", ",", "would",
            "n't", ",", "you", "'d", ",", "you", "'ll", ",", "you", "'re", ",",
            "you", "'ve"};

        PennTreebankTokenizer instance = PennTreebankTokenizer.getInstance();
        String[] result = instance.split(text);

        assertEquals(expResult.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of split method, of class TreebankWordTokenizer.
     */
    @Test
    public void testSplitAbbreviation() {
        System.out.println("tokenize abbreviation");
        String text = "Here are some examples of abbreviations: A.B., abbr., "
                + "acad., A.D., alt., A.M., B.C., etc.";

        String[] expResult = {"Here", "are", "some", "examples", "of",
            "abbreviations", ":", "A.B.", ",", "abbr.", ",", "acad.",
            ",", "A.D.", ",", "alt.", ",", "A.M.", ",", "B.C.", ",", "etc.", "."};

        PennTreebankTokenizer instance = PennTreebankTokenizer.getInstance();
        String[] result = instance.split(text);

        assertEquals(expResult.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of split method, of class TreebankWordTokenizer.
     */
    @Test
    public void testSplitTis() {
        System.out.println("tokenize tis");
        String text = "'tis, 'tisn't, and 'twas were common in early modern English texts.";
        String[] expResult = {"'t", "is", ",", "'t", "is", "n't", ",", "and",
            "'t", "was", "were", "common", "in", "early", "modern", "English",
            "texts", "."};

        PennTreebankTokenizer instance = PennTreebankTokenizer.getInstance();
        String[] result = instance.split(text);

        assertEquals(expResult.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of split method, of class TreebankWordTokenizer.
     */
    @Test
    public void testSplitHyphen() {
        System.out.println("tokenize hyphen");
        String text = "On a noncash basis for the quarter, the bank reported a "
                + "loss of $7.3 billion because of a $10.4 billion write-down "
                + "in the value of its credit card unit, attributed to federal "
                + "regulations that limit debit fees and other charges.";

        String[] expResult = {"On", "a", "noncash", "basis", "for", "the",
            "quarter", ",", "the", "bank", "reported", "a", "loss", "of", "$",
            "7.3", "billion", "because", "of", "a", "$", "10.4", "billion",
            "write-down", "in", "the", "value", "of", "its", "credit", "card",
            "unit", ",", "attributed", "to", "federal", "regulations", "that",
            "limit", "debit", "fees", "and", "other", "charges", "."};

        PennTreebankTokenizer instance = PennTreebankTokenizer.getInstance();
        String[] result = instance.split(text);

        assertEquals(expResult.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of split method, of class TreebankWordTokenizer.
     */
    @Test
    public void testSplitSingleQuote() {
        System.out.println("tokenize single quote");
        String text = "String literals can be enclosed in matching single "
                + "quotes ('). But it's also appearing in contractions such as can't.";

        String[] expResult = {"String", "literals", "can", "be", "enclosed", "in",
            "matching", "single", "quotes", "(", "'", ")", ".", "But", "it", "'s", "also",
            "appearing", "in", "contractions", "such", "as", "ca", "n't", "."};

        PennTreebankTokenizer instance = PennTreebankTokenizer.getInstance();
        String[] result = instance.split(text);

        assertEquals(expResult.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i], result[i]);
        }
    }

    /**
     * Test of split method, of class TreebankWordTokenizer.
     */
    @Test
    public void testSplitRomanNumeral() {
        System.out.println("tokenize roman numeral");
        String text = "S.. or S: means \"twice\" (as in \"twice a third\").";
        String[] expResult = {"S..", "or", "S", ":", "means", "\"", "twice",
            "\"", "(", "as", "in", "\"", "twice", "a", "third", "\"", ")", "."};

        PennTreebankTokenizer instance = PennTreebankTokenizer.getInstance();
        String[] result = instance.split(text);

        assertEquals(expResult.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expResult[i], result[i]);
        }
    }
}
