package humans;

import java.util.List;

public class Talking {
    private static int phrase = 0;

    public static void talk(List<String> humanQuotes) {
        int humanIndex = phrase % humanQuotes.size();
        System.out.print("\u001B[1m" + humanQuotes.get(humanIndex) + "\u001B[0m");
        System.out.println();
        phrase++;
	}

}
