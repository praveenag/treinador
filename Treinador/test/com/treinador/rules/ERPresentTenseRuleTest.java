package com.treinador.rules;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ERPresentTenseRuleTest {
    ERPresentTenseRule erPresentTenseRule = new ERPresentTenseRule();

    @Test
    public void euShouldAppendOToTheInfinitive() {
        assertEquals("como", erPresentTenseRule.eu("comer"));
    }

    @Test
    public void tuShouldAppendESToTheInfinitive() {
        assertEquals("comes", erPresentTenseRule.tu("comer"));
    }

    @Test
    public void eleElaVoceShouldAppendEToTheInfinitive() {
        assertEquals("come", erPresentTenseRule.ele("comer"));
        assertEquals("come", erPresentTenseRule.ela("comer"));
        assertEquals("come", erPresentTenseRule.voce("comer"));
    }

    @Test
    public void nosShouldAppendEmosToTheInfinitive() {
        assertEquals("comemos", erPresentTenseRule.nos("comer"));
    }

    @Test
    public void vosShouldAppendEmosToTheInfinitive() {
        assertEquals("comeis", erPresentTenseRule.vos("comer"));
    }

    @Test
    public void elesElasVocesShouldAppendEToTheInfinitive() {
        assertEquals("comem", erPresentTenseRule.eles("comer"));
        assertEquals("comem", erPresentTenseRule.elas("comer"));
        assertEquals("comem", erPresentTenseRule.voces("comer"));
    }
}
