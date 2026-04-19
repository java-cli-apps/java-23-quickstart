package language.fr;

import language.api.Greeter;

public class Bonjour implements Greeter {

    @Override
    public String greet() {
        return "Bonjour " + Character.toString(0x1F1EB) + Character.toString(0x1F1F7);
    }
}
