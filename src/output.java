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
			outputName += ".csv";
						
			toFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputName), "utf-8"));
			// file header

			// iterate over lists of lists
			for (List<String> l : inputs) {
				for (String s : l) {
					System.out.println(s);
					toFile.write(s);
					toFile.newLine();
				}
			}
			
		} catch (IOException e) {
			System.out.println("There was a problem writing to the output file. Program terminated.");
		} finally {
			try {
				toFile.flush();
				toFile.close();
			} catch (IOException e) {
				System.out.println("There was a problem closing the output file. Program terminated.");
			}
		}
	}
}
