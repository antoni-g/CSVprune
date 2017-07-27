import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class input {
	//parse csv to prune duplicate entries
	ArrayList<String> uniqueEntries;
	String file;
	
	BufferedReader parse = null;
	
	//object to initiate file pruning with
	public input (String filename) {
		uniqueEntries = new ArrayList<String>();
		file = filename;
		parseInput();
	}
	
	// helper to parse whole file
	void parseInput() {
		try {
			File csv = new File(file);
			parse = new BufferedReader(new FileReader(csv));
		} catch (IOException e) {
			System.out.print("There was a problem opening :" + file + ". Program terminated");
			System.exit(0);
		}
		
		try {
			String current;
			while ((current = parse.readLine()) != null) {
				parseLine(current);
			}
		} catch (IOException e) {
			System.out.print("There was a problem parsing tweets. Program terminated.");
			System.exit(0);
		}
	}
	
	//helper to parse individual csv lines
	void parseLine(String in) {
		String[] split = in.split(",");
		String line = split[3] + "," + split[8];
		if (uniqueEntries.contains(line)) {
			uniqueEntries.add(line);
		}
	}
	
	public List<String> getInput() {
		return uniqueEntries;
	}
}
