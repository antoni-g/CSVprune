import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class output {
	// class to write output .csv
	static BufferedWriter toFile;
	
	public static void writeToFile(List<List<String>> inputs) {
		toFile = null;
		try {
			String outputName = "output ";
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			outputName += timeStamp;
			
			toFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputName), "utf-8"));
			// file header
			toFile.write("Designation,Case Type\n");

			// iterate over lists of lists
			for (List<String> l : inputs) {
				for (String s : l) {
					toFile.write(s);
				}
			}
			
		} catch (IOException e) {
			System.out.println("There was a problem writing to the output file. Program terminated.");
		} finally {
			try {
				toFile.close();
			} catch (IOException e) {
				System.out.println("There was a problem closing the output file. Program terminated.");
			}
		}
	}
}
