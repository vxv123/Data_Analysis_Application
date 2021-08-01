import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Helper {

	public static void main(String[] args) throws IOException {
		helper("user");
		helper("checkin");
		helper("review");
		helper("business");
		System.out.println("Done!");

	}
	
	public static void helper(String str) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/yelp_" + str +".json"));
		int index = 0;
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/yelp_" + str +"_transform" + index + ".json"));
		String line = reader.readLine();
		writer.append("[");
		writer.append("\n");
		int count = 1;
		while(line != null) {
			writer.append(line);
			line = reader.readLine();
			
			if(line == null) {
				writer.append("\n");
			}
			++count;
			if(count == 49999) {
				writer.append("\n");
			}
			else {
				writer.append(",");
				writer.append("\n");
			}
			
			if(count == 50000) {
				writer.append("\n");
				writer.append("]");
				writer.close();
				++index;
				writer = new BufferedWriter(new FileWriter("src/yelp_" + str + "_transform" + index + ".json"));
			}
		}
		writer.append("\n");
		writer.append("]");
		writer.close();
	}

}
