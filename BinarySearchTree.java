package domeserg2;
import java.util.Vector;
//insertion: https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/164137/java-easy-to-understand-solution
//search   : https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
//multisearch :https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/

/**
 * @author konst
 *BinarySearchTree is the class is used to create the bst and implement it's functions
 */
public class BinarySearchTree {		
	
	/**
	 * int numberofkeys is the number of keys
	 */
	public static int numberofkeys = 100000;
	
	/**
	 * int data[][] is used as the NX3 matrix
	 */
	private int data[][];
	
	/**
	 * int AVAIL is used for the position of the next available "node"
	 */
	private int AVAIL;	
	
	/**
	 * int rootindex is the root of the tree
	 */
	private int rootindex=-1;
	
	/**
	 * int searchcounter is the counter used for the searches
	 */
	int searchcounter=0;
	
	/**
	 * int insertcounter is the counter used for the inserts
	 */
	int insertcounter=0;
	
	/**
	 * int multicomp is the counter used for the range searches
	 */
	int multicomp=0;
	
	/**
	 * Vector searches is used to store the searches
	 */
	Vector searches=new Vector();
	
	/**
	 * Vector inserts is used to store the inserts
	 */
	Vector inserts=new Vector();
	
	/**
	 * Vector multicomps is used to store the searches and comparisons in range
	 */
	Vector multicomps=new Vector();


////////////////////////////CONSTRUCTOR///////////////////////////////
	
	/**
	 * BinarySearchTree is the constructor of the bst
	 * @param size is the size of tree
	 */
	public BinarySearchTree(int size) {											
		data = new int[size][3];							//initialize a sizex3 matrix
		AVAIL=0;
		for(int i=0;i<size;i++) {							//for size loops
			if(i==size-1) {									//if i is in the last position of the matrix 
			data[i][0]=-1;
			data[i][1]=-1;
			data[i][2]=-1;
			}
			else {											//for every loop except the last
			data[i][0]=-1;
			data[i][1]=-1;
			data[i][2]=i+1;									//the avail is uses the right branch's position if it does not exist and points to the next "node" except for the last one 
			}
		}
		
	}
/////////////////////////////////////////////////////////////////////////
	
///////PRINTS///////////////////////////////////////
	
	/**
	 * InorderPrint and ultraprint are debug functions
	 */
	void InorderPrint(int nodeindex) {
		
        if (nodeindex == -1) {						
            return;
        }
        
        InorderPrint(data[nodeindex][1]);
        
        System.out.println(data[nodeindex][0]+ " " +data[nodeindex][1]+ " " + data[nodeindex][2]);
        
        InorderPrint(data[nodeindex][2]);

    }
	
	void ultraprint() {
		for(int j=0;j<10;j++) {
			System.out.println(" pos" + j +" "+data[j][0]+ " " +data[j][1]+ " " + data[j][2]);
		}
	}
////////////////////////////////////////////////////
	

///////////////////INSERT ELEMENT IN THE TREE///////////////////////////////////////
    /**
     * insertintoBst calls the insert fucntion of the tbst we create this so that we can use the rootindex as a private variable
     * @param val is the value we want to insert
     */
    public void insertintoBst(int val) {
    	rootindex=insertintoBstinner(this.rootindex,val);		//call the insertintoBstinner from the insertintoBst 
    }
    
    
    
    /**
     * insertintoBstinner is the insert function of the bst
     * @param rootindex
     * @param val is the value we want to insert 
     * @return rootindex or saved
     * 
     */
    private int insertintoBstinner(int rootindex,int val) {
    	insertcounter++;
    	if(rootindex==-1) {										//if root does not exist
    		int saved= AVAIL;									//save the avail
    		AVAIL=data[saved][2];								//avail becomes the position of the next "node"
    		data[saved][0]=val;
    		data[saved][1]=-1;
    		data[saved][2]=-1;
    		insertcounter=insertcounter+5;
    		return saved;
    	}	
    	
    	insertcounter++;
    	if(data[rootindex][0]>val) {																				//if the val is bigger than the key of the "node"
    		insertcounter++;
    		data[rootindex][1]=insertintoBstinner(data[rootindex][1],val);											//the left branch becomes the return value of insertintoBstinner
    	}else {
    		insertcounter++;
    		data[rootindex][2]=insertintoBstinner(data[rootindex][2],val);											//the right branch becomes the return value of insertintoBstinner
    	}
    	return rootindex;																							//return the rootindex
    }
    
    
    
    /**
     * updateinserts adds the inserts in the vector and resets the counter
     */
    public void updateinserts() {
    	inserts.add(insertcounter);												//put the insertcount in the inserts vector
    	insertcounter=0;														//reset the value of insertcounter
    }
    
    
    /**
     * insertmo calculates the median of the inserts
     */
    public void insertmo() {
	      int insertMo=0;
	      for(int z=0;z<numberofkeys;z++) {										//for 100k loops				
	    	  insertMo=insertMo+(int)inserts.toArray()[z];						//add the comps of each search in each loop so that in the end we have the sum of all 	
	      }
	      insertMo=insertMo/numberofkeys;										//divide the sum by the number of elements to find the median									
	      System.out.println("binary tree mesos oros inserts="+insertMo);
    }
    
////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
///////////////////SEARCH ELEMENT IN THE TREE///////////////////////////////////////
    
    /**
     * search calls the search fucntion of the tbst we create this so that we can use the rootindex as a private variable
     * @param val is the value we want to search
     */
    public void search(int val) {									
    	searchinner(rootindex,val);									//call the searchinner from the search
    }
    
    /**
     * searchinner is the function that searches in the bst
     * @param currentnode is the rootindex
     * @param val is the value we want to search
     * @return currentnode
     */
    private int searchinner(int currentnode,int val) {						
    	searchcounter++;
    	if (currentnode==-1) {										//if the node we want to search does not exist
    		return currentnode;
    	}
    	
    	searchcounter++;
    	if (data[currentnode][0]==val) {							//if the node we want to search is equal to the current node
    		return currentnode;
    	}
    	
    	searchcounter++;
    	if (data[currentnode][0] < val) {							//if the key of the node that we want is bigger than the value of the current node
    		//searchcounter++;
           return searchinner(data[currentnode][2], val);			//call searchinner but with left branch
        }else {
        	return searchinner(data[currentnode][1], val);				//reaches here ifthe key of the node that we want is smaller than the value of the current node and calls searchinner but with right branch
        }													
    }
    /**
     * updatesearches adds the searches in the vector and resets the counter
     */
    public void updatesearches() {
    	searches.add(searchcounter);								//adds searchcounter to the searches vector
    	searchcounter=0;											//resets the searchcounter value to 0
    }
    
    /**
     * searchmo calculates the median of the searches
     */
    public void searchmo() {
	      int searchmMo=0;
	      for(int z=0;z<100;z++) {													//for 100 loops
	    	  searchmMo=searchmMo+(int)searches.toArray()[z];						//add the comps of each search in each loop so that in the end we have the sum of all 
	      }
	      searchmMo=searchmMo/100;													//divide the sum by the number of elements to find the median		
	      System.out.println("mesos oros searches="+searchmMo);
  }
    
////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
///////////////////SEARCH ELEMENTS IN THE TREE///////////////////////////////////////    
    /**
     * printmultiple calls the range search fucntion of the bst we create this so that we can use the rootindex as a private variable
     * @param k1 is the lower limit of the range we want to search in 
     * @param k2 is the upper limit of the range we want to search in 
     */
    public void printmultiple(int k1, int k2) {
    	printmultipleinner( rootindex,  k1,  k2);
    }
    
        /**
         * printmultipleinner is the range search function of the bst
         * @param currentnode is the rootindex
         * @param k1 is the lower limit of the range we want to search in 
         * @param k2 is the upper limit of the range we want to search in 
         * 
         */
        private void printmultipleinner(int currentnode, int k1, int k2){
       multicomp++;
        if (currentnode == -1) {                                //if the currentnode does not exist
            return;
        }
         multicomp++;
        if (k1 < data[currentnode][0]) {                        //if k1< key of the currentnode
            printmultipleinner(data[currentnode][1], k1, k2);    // call printmultipleinner with the right branch of the currentnode
        }
        
        multicomp++;
        if(k1<=data[currentnode][0]) {                            //if k1 is smaller or equal than the key of the current node
            multicomp++;
            if(k2>=data[currentnode][0]) {                        //if k2 is bigger or equal than the key of the current node
                //System.out.println(data[currentnode][0]);
            }
            
        }
        
         multicomp++;
         if (k2 > data[currentnode][0]) {                                //if k2> key of the currentnode
             printmultipleinner(data[currentnode][2], k1, k2);            // call printmultipleinner with the left branch of the currentnode
         }
        
    }

    
    
    
    
    /**
     * updatemulticomp adds the range searches in the vector and resets the counter
     */
    public void updatemulticomp() {
    	multicomps.add(multicomp);					//adds multicomp to the multicomps vector
    	multicomp=0;								//resets the multicomp value to 0
    }
    
    /**
     *multicompmo calculates the median of the searches
     */
    public void multicompmo() {
	      int multicompMo=0;
	      for(int z=0;z<100;z++) {													//for 100 loop
	    	  multicompMo=multicompMo+(int)multicomps.toArray()[z];					//add the comps of each search in each loop so that in the end we have the sum of all 
	      }
	      multicompMo=multicompMo/100;																	
	      System.out.println("mesos oros multisearches="+multicompMo);				//divide the sum by the number of elements to find the median	
    }
    
    /**
     * multiclear clears the range comparisons vector
     */
    public void multiclear() {
    	multicomps.clear();															//empites the multicomps vector
    }
    
////////////////////////////////////////////////////////////////////////////////////////
  
    
    
    

///////////////GETTERS////////////////////////////////////////////
	/**
	 * getRootindex is a getter
	 * @return rootindex
	 * 
	 */
	public int getRootindex() {
		return rootindex;
	}
    
}
