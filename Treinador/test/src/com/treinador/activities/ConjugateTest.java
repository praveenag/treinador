package com.treinador;

import android.test.ActivityInstrumentationTestCase2;
import com.treinador.activities.Conjugate;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.treinador.activities.ConjugateTest \
 * com.treinador.tests/android.test.InstrumentationTestRunner
 */
public class ConjugateTest extends ActivityInstrumentationTestCase2<Conjugate> {

    public ConjugateTest() {
        super("com.treinador", Conjugate.class);
    }

}
