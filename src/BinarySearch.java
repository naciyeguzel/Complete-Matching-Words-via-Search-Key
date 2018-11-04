
public class BinarySearch {
	

	/**
	 * This function is used to search the given key from Line array objects
	 * @param lines is object to search
	 * @param key is search value
	 * @param end is last element index of the Line objects
	 * @return is the value of index
	 */
	public int binarySearch(Line[] lines, String key, int end) {
		
		for(int start=0;start < end;) {
			int sum=start + end;
			int mid = sum/2;
			int check=key.compareTo(lines[mid].getName());
			//if the name contains the search key in the beginning of it , we find it
			if(lines[mid].getName().startsWith(key)){
				return mid;
				}
			else if (check < 0) {
			    end = mid;
			    }
			else if (check > 0) {
			    start = mid + 1;
			    } 
	    }
		//if there is not the search key, return -1
		return -1;
	}
	
	
}
