package calculator.test;

import calculator.business.Translator;
import calculator.business.TranslatorImpl;
import calculator.entities.Language;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TranslatorImplTest {
    Translator translator;
    Language from;
    Language to;

    @BeforeMethod
    public void setUp() throws Exception {
        translator = new TranslatorImpl();
        from = new Language("en", "English");
        to = new Language("es", "Spanish");
    }

    @Test(invocationCount = 100, threadPoolSize = 10)
    public void testTranslate() throws Exception {
        String response = translator.translate(from, to, "Hello World");
        Assert.assertEquals(response, "Hola Mundo");
    }

}