
public class QuickSort {

	public QuickSort() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This function is used to sort the given Lines objects for string values.
	 * @param lines is array of the line objects
	 * @param start is of lines object.
	 * @param end is of lines object.
	 */
	public void sortString(Line[] lines, int start, int end) {
		if(start>=end)
			return;
	    String pivot = lines[start].getName();
	    int j=partitionString(lines, start, end, pivot);
	    int new_end=j - 1;
	    sortString(lines, start, new_end);
	    int new_start=j + 1;
	    sortString(lines, new_start, end); 
	    }	
	
	/**
	 * This function is used to partition the given Line objects for string values.
	 * When partition is completed, if j is bigger than i, they are swapped.
	 * @param lines is array of the line objects
	 * @param start is of lines object.
	 * @param end is of lines object.
	 * @param pivot is of lines object(first element of the partition part)
	 * @return
	 */
	public int partitionString(Line[] lines, int start, int end, String pivot){
		int i = start,j;
        for(j=end;j>i;){
        	//pivot go forward, if it is not bigger than the next value 
        	while (lines[i].getName().compareTo(pivot) <= 0){
        		if(i <= end && j > i)
        			i++;
        		else
        			break;
             }
        	//pivot going back, if it is bigger than the next value 
        	while (lines[j].getName().compareTo(pivot) > 0){
        		if(j >= start && j >= i)
        			j--;
            	 else 
            		 break;
             }
        	if (j > i)
        		swap(lines, i, j);
         }
        swap(lines, start, j);
		return j;
		
	 }
	/**
	 * This function is used to sort the given Lines objects for integer values.
	 * @param lines is array of the line objects
	 * @param start is of lines object.
	 * @param end is of lines object.
	 */
	public void sortInt(Line[] lines, int start, int end) {
		if(start>=end)
			return;
		//first element of the partition part
	    long pivot = lines[start].getWeight();
	    int j=partitionInt(lines, start, end, pivot);
	    int new_end=j - 1;
	    sortInt(lines, start, new_end);
	    int new_start=j + 1;
	    sortInt(lines, new_start, end); 
	    }	
	
	/**
	 * This function is used to partition the given Line objects for integer values.
	 * When partition is completed, if j is bigger than i, they are swapped.
	 * @param lines is array of the line objects
	 * @param start is of lines object.
	 * @param end is of lines object.
	 * @param pivot is of lines object(first element of the partition part)
	 * @return
	 */
	public int partitionInt(Line[] lines, int start, int end, long pivot){
		int i = start,j;
        for(j=end;j>i;){
        	//pivot go forward, if it is not bigger than the next value 
        	while (lines[i].getWeight()<=pivot){
        		if(i <= end && j > i)
        			i++;
        		else
        			break;
             }
        	//pivot going back, if it is bigger than the next value 
        	while (lines[j].getWeight()> pivot){
        		if(j >= start && j >= i)
        			j--;
            	 else 
            		 break;
             }
        	if (j > i)
        		swap(lines, i, j);
         }
        swap(lines, start, j);
		return j;
		
	 }
	/**
	 * This function is used to swap the given two Line objects
	 * @param lines is array of the line objects
	 * @param x is index of an element
	 * @param y is index of an element
	 */
	public void swap(Line lines[], int x, int y) {
		Line temp = lines[x];
		lines[x]=lines[y];
		lines[y]=temp;
	    }
}
