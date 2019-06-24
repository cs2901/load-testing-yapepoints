package calculator.business;

import calculator.entities.Language;
import com.google.cloud.translate.*;


import java.util.LinkedList;
import java.util.List;

public class TranslatorImpl implements Translator {

    private static final String API_KEY = "AIzaSyAqGKOFzgCbvtZZvGnf4zzi5TSOP-EUZTY";
    private Translate translate;

    public TranslatorImpl() {
        translate = TranslateOptions.newBuilder().setApiKey(API_KEY).build().getService();
    }

    @Override
    public String translate(Language from, Language to, String text) {

        String idFrom = from.getId();
        String idTo = to.getId();

        List<String> texts = new LinkedList<>();
        texts.add(text);

        List<Translation> translations = translate.translate(texts,
                Translate.TranslateOption.sourceLanguage(idFrom),
                Translate.TranslateOption.targetLanguage(idTo));

        Translation translation = translations.get(0);

        return translation.getTranslatedText();
    }
}
