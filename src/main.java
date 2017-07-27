import java.util.ArrayList;
import java.util.List;

public class main {
	
	static List<List<String>> ins;

	// each argument represents an input file
	public static void main(String[] args) {
		ins = new ArrayList<List<String>>();
		
		for (String s : args) {
			input i = new input(s);
			ins.add(i.getInput());
		}
		
		output.writeToFile(ins);
	}
}
