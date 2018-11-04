import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Asus
 *
 */
public class File {

	/**
	 * This method is used to read file.
	 * @param file This is the parameter which is name of file.
	 * @return This returns all lines in the file.
	 */
	public static ArrayList readFile(String file) {

		ArrayList<String> results=new ArrayList<String>();
		int i=0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    //The first line passed since it is the number of lines.
		    while ((line = br.readLine()) != null) {
		    	if(i==0){
		    		i++;
		    		continue;
		    	}
		    	results.add(line.trim());
		    }
		    return results;
		}catch (IOException e){
		    e.printStackTrace();
		    return null;
	        }
	}
	/**
	 * This method is used to get line numbers.
	 * @param file This is the parameter which is name of file.
	 * @return This returns all lines in the file.
	 */
	public static int getLineNumber(String file){
		int i=0,lineNumber = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		  //The first line is read only since it is the number of lines.
		    while ((line = br.readLine()) != null) {
		    	if(i==0){
		    		lineNumber=Integer.parseInt(line.trim());
		    		break;
		    	}
		    	i++;
		    }
		    return lineNumber;
		}catch (IOException e){
		    e.printStackTrace();
		    return 0;
	        }
	}

}
