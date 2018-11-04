
/**
 * @author Asus
 *
 */
public class Main {

	/**
	 * This is main function of this class.
	 * @param args is the arguments that will got from the user.
	 */
	public static void main(String[] args) {
		String fileName=args[0];
		int k=Integer.parseInt(args[1]);
		LineController lineController=new LineController(fileName,k);
	}
	
	
}
