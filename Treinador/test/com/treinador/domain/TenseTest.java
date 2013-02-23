package com.treinador.domain;

import org.junit.Test;

import static com.treinador.domain.Tense.*;
import static org.junit.Assert.assertEquals;

public class TenseTest {
    @Test
    public void getId() throws Exception {
        assertEquals("1", PAST.getId());
        assertEquals("2", PRESENT.getId());
        assertEquals("3", FUTURE.getId());
    }
}
