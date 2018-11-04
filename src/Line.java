import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Asus
 *
 */
public class Line {

	private long weight;
	private String name;
	/**
	 * This constructor is used to assign the values of object
	 */
	public Line(String line) {
		String parts[]=tabDivide(line);
		weight=Long.parseLong(parts[0]);
		name=parts[1];
	}
	public long getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}
	/**
	 * This function is used to divide line according to tab
	 * @param line
	 * @return
	 */
	public static String[] tabDivide(String line){
		return line.split("\t");
	}
}
