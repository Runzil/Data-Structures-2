package domeserg2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;


/**
 * @author konst
 *SortedListis is the class tha is used to create the list and implement it's functions
 */
public class SortedList {
	
	/**
	 * Vector totalkeys is the vector that contains the 100k keys
	 */
	Vector totalkeys=new Vector();
	
	/**
	 * Vector search100keys is the vector that contains 100 keys
	 */
	Vector search100keys=new Vector();
	
	/**
	 * Vector search100keys is the vector that contains 100 keys for search in range 100
	 */
	Vector search100keys100smaller=new Vector();
	
	/**
	 * Vector search100keys is the vector that contains 100 keys for search in range 1000
	 */
	Vector search100keys1000smaller=new Vector();
	
	/**
	 * int comps is the counter of the comparisons
	 */
	int comps=0;
	
	/**
	 * int saved is used as "pointer" to a specific node of the list
	 */
	int saved=0;
	
	/**
	 * Vector totalcomps is the vector that contains the comparisons
	 */
	Vector totalcomps=new Vector();
	
	
//////////constructors/////////////
	/**
	 * SortedList is the constructor of the list
	 * @param totalkeys is the vector with the keys of the list
	 */
	public SortedList(Vector totalkeys) { 
		this.totalkeys=totalkeys;
		Collections.sort(totalkeys);						//from https://beginnersbook.com/2014/06/how-to-sort-vector-using-collections-sort-in-java-example/  it sorts the elements of the vector
	}
///////////////////////////////////
	
    /**
     * binarySearch is the search function of the list
     * @param x is the element we want to search
     * @return middle if found -1 if not
     */
    public int binarySearch(int x) 									//binary search method
    {
    	 comps++;
    	 comps++;
        int l = 0, r = totalkeys.toArray().length - 1;				//r becomes 100k-1		
        comps++;
        while (l <= r) {											//while the left part is smaller than the right part of the array
        	comps=comps+2;
        	int m = l + (r - l) / 2;
            saved=m;
            comps++;
            if ((int)totalkeys.toArray()[m] > x) {					//if the requested value is smaller than the current value of the arrayt
            	comps++;
            	 r = m - 1;
            }
            
           
            else if((int)totalkeys.toArray()[m] < x) {
            	comps++;
            	comps++;
            	l = m + 1;
            }
            
            else {
            	comps++;
                return m;
            }
            comps++;
        }
        return -1;  												//if element we want is not existent then return -1
    }

    
	/**
	 * refresh adds the comparisons in the totalcomps vector and resets the counter
	 */
	public void refresh() {
		totalcomps.add(comps);										//add the comps to the totalcomps vector and set comps=0;
		comps=0;
	}
	
	/**
	 * searchmo calculates the median value of the searches
	 */
	public void searchmo() {													
		int listsearchmo=0;
	      for(int z=0;z<100;z++) {												//for 100 loops
	    	  listsearchmo=listsearchmo+(int)totalcomps.toArray()[z];			//add the comps of each search in each loop so that in the end we have the sum of all 			
	      }
	      listsearchmo=listsearchmo/100;										//divide the sum by the number of elements to find the median						
	      System.out.println("mesos oros searches se lista="+listsearchmo);		
	}
	
	/**
	 * clear clears the totalcomps vector
	 */
	public void clear() {
		totalcomps.clear();														//empty the totalcomps vector
	}
	
/**
 * increasecomps increases the comparisons counter
 */
public void increasecomps() {
	comps++;																	//increase the comps by 1
}
	
//////////////////////////////////////


//////////////////////GETTERS///////////////////////////////////////
	/**
	 * getSaved is a getter
	 * @return saved
	 */
	public int getSaved() {
		return saved;
	}
	
	/**
	 * getComps is a getter
	 * @return comps
	 */
	public int getComps() {
		return comps;
	}
	
	/**
	 * getTotalkeys is a getter
	 * @return totalkeys
	 */
	public Vector getTotalkeys() {
		return totalkeys;
	}


}
