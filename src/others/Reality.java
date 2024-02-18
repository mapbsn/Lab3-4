package others;

public class Reality {
	public final String name;
	
	public Reality(String name) {	
		this.name = name;		
	}
	
	public void shimmer() {
		System.out.printf("%s shimmered.%n", this.name);	
	}
}