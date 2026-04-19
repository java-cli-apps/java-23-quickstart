package language.en;

import language.api.Greeter;

public class Hello implements Greeter {

    @Override
    public String greet() {
        return "Hello " + Character.toString(0x1F1EC) + Character.toString(0x1F1E7);
    }
}
