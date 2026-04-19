package language.api;

import language.en.Hello;
import language.fr.Bonjour;

public interface Greeter {

    enum Language {
        French, English
    }

    String greet();

    static Greeter byLanguage(Language language) {
        return switch (language) {
            case French -> new Bonjour();
            case English -> new Hello();
        };
    }
}
