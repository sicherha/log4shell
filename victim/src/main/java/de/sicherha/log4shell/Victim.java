package de.sicherha.log4shell;

import java.util.*;
import org.apache.logging.log4j.*;

public final class Victim {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Victim.class.getSimpleName());

        try (Scanner in = new Scanner(System.in)) {
            for (;;) {
                System.out.print("> ");
                if (!in.hasNext()) {
                    break;
                }
                logger.info("User input: {}", in.nextLine());
            }
        }
    }
}
