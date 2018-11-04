import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Asus
 *
 */
public class LineController {
	

	/**
	 * This constructor is used to assign the values of object
	 * and to call functions to required functions.
	 * @param filename
	 * @param k
	 */
	public LineController(String filename, int k) {
		
		File file=new File();
		ArrayList<String> lines=new ArrayList<String>();
		
		char exit='y';
		while(exit=='y'){
			//get key, read line and get line number
			String key=getKey();
			lines=file.readFile(filename);
			int lineNumber=file.getLineNumber(filename);
			
			//create Line objects
			Line parsedlines[]=new Line[lineNumber];
			createLines(parsedlines,lines,lineNumber);
			
			//sort the Line objects and search the given key
			sort(parsedlines, lineNumber);
			Line[] resultOfsearch =search(lineNumber, parsedlines, key);
			
			//sort the found keys and print output
			QuickSort quickSort=new QuickSort();
			int length=resultOfsearch.length;
			quickSort.sortInt(resultOfsearch,0,length-1);
			printOutput(resultOfsearch, length-1, k);
			
			//ask new input
			System.out.println("\nenter \"y\" if you want to continue, enter \"n\" if you want to exit");
			Scanner input = new Scanner(System.in);
			exit=input.next().charAt(0);
		}
	}

	/**
	 * This function is used to get search key
	 * And, it checks whether the search key is empty or null
	 * @return
	 */
	public static String getKey(){
		System.out.print("search key:");
		Scanner input = new Scanner(System.in);
		String key=input.nextLine();
		try{
			if(key==null||key.isEmpty())
				throw new NullPointerException();
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return key;
	}
	/**
	 * This function is used to check the weight of the Line objects.
	 * if it is less the 0, it thrown the exception.
	 * @param l
	 */
	public static void checkWeight(long l){
		try{
			if(l<0)
				throw new IllegalArgumentException();
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	/**
	 * This function is used to create Quicksort object and
	 * to call sortString of the object to sort the query string names.
	 * @param parsedlines
	 * @param lineNumber
	 */
	public static void sort(Line[] parsedlines, int lineNumber){
		
		QuickSort quickSort=new QuickSort();
		quickSort.sortString(parsedlines,0,lineNumber-1);
	}
	/**
	 * This function is used to search the given search key from the 
	 * Line objects and call the checkWeight function to check the values of weights.
	 * @param lineNumber
	 * @param parsedlines
	 * @param key
	 * @return
	 */
	public static Line[] search(int lineNumber, Line[] parsedlines,String key){
		ArrayList<Line> foundLine=new ArrayList<Line>();
		BinarySearch binarySearch=new BinarySearch();
		//The first result of query is found
		int a=binarySearch.binarySearch(parsedlines, key,lineNumber);
		if(a==-1){
			System.out.println("There is not searched key..!");
			System.exit(0);
		}
		checkWeight(parsedlines[a].getWeight());
		foundLine.add(parsedlines[a]);
		//The other matching words is check for biggest values
		int x=a-1;
		while(x>=0){
			if(parsedlines[x].getName().startsWith(key)){
				checkWeight(parsedlines[x].getWeight());
				foundLine.add(parsedlines[x]);
			}
			x--;
		}
		//The other matching words is check for less values
		x=a+1;
		while(x<lineNumber){
			if(parsedlines[x].getName().startsWith(key)){
				checkWeight(parsedlines[x].getWeight());
				foundLine.add(parsedlines[x]);
			}
			x++;
		}
		Line[] resultOfsearch = foundLine.toArray(new Line[0]);
		return resultOfsearch;
	}
	/**
	 * This function is used to print output of the found keys and their weights
	 * according to k value on the screen.
	 * @param resultOfsearch
	 * @param position
	 * @param k
	 */
	public static void printOutput(Line[] resultOfsearch, int position, int k){
		//if the found keys is less than k, only print the number of found keys.
		if(resultOfsearch.length<k){
			k=resultOfsearch.length;
		}
		for(int i=0;i<k;i++){
	    	System.out.println(resultOfsearch[position].getWeight()+" "+resultOfsearch[position].getName());
	    	position--;
	    }
	}
	/**
	 * This function is used to create lines according to N number.
	 * @param parsedlines
	 * @param cpy_lines
	 * @param lineNumber
	 */
	
	public static void createLines(Line[] parsedlines, ArrayList<String> cpy_lines,int lineNumber) {
		
		String[] lines = cpy_lines.toArray(new String[0]);
	    for(int i = 0; i <lineNumber; i++){
	    	parsedlines[i]=new Line(lines[i]);
        }
    }
}
