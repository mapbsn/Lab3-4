package humans;

import java.util.List;

public class Thinking {
	private static int thoughts = 0;
	
	public static void think(List<String> humanThoughts) {
		int humanIndex = thoughts % humanThoughts.size();
		System.out.print("\u001B[1m" + humanThoughts.get(humanIndex) + "\u001B[0m");
		System.out.println();
		thoughts++;
		
	}

}
