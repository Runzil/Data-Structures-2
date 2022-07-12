package domeserg2;

import java.util.Vector;

//insertion from https://www.geeksforgeeks.org/threaded-binary-tree-insertion/
//search from https://www.geeksforgeeks.org/threaded-binary-search-tree-deletion/
/**
 * @author konst
 *ThreadedBinarySearchTree is the class is used to create the tbst and implement it's functions
 */
public class ThreadedBinarySearchTree {
	
	
	
	/**
	 * int numberofkeys is the number of keys
	 */
	public static int numberofkeys = 100000;	
	
	/**
	 * int data[][] is used as the NX5 matrix
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
	 * int inserts is the counter used for the inserts
	 */
	private int inserts=0;
	
	/**
	 * int searchcountertbst is the counter used for the searches
	 */
	private int searchcountertbst=0;
	
	/**
	 * Vector insertsintbst is used to store the inserts
	 */
	Vector insertsintbst=new Vector();
	
	/**
	 * Vector searchestbst is used to store the searches
	 */
	Vector searchestbst=new Vector();
	
	/**
	 * Vector multisearches is used to store the searches and comparisons in range
	 */
	Vector multisearches=new Vector();
	
	/**
	 * int rancomps is used as a counter for the comparisons in range search without finding the first element
	 */
	int rancomps=0;
	int searchcounter=0;
////////////////////////////CONSTRUCTOR///////////////////////////////
	
	/**
	 * ThreadedBinarySearchTree is the constructor of the tree
	 * @param size used for the size of tree
	 */
	public ThreadedBinarySearchTree(int size) {
		data = new int[size][5];						//initialize a sizex5 matrix
		AVAIL=0;
		for(int i=0;i<size;i++) {						//for size loops
			
			if(i==size-1) {							//if i is in the last position of the matrix 					
			data[i][0]=-1;
			data[i][1]=-1;
			data[i][2]=-1;
			data[i][3]=0;	
			data[i][4]=0;	
			}
			else {									//for every loop except the last
			data[i][0]=-1;
			data[i][1]=-1;
			data[i][2]=i+1;							//the avail is uses the right branch's position if it does not exist and points to the next "node" except for the last one 
			data[i][3]=0;	
			data[i][4]=0;	
			}
		}
	}
//////////////////////////////////////////////////////////////////////
	
	
///////////////////////////////Prints/////////////////////	
	/**
	 * ultraprint prints the first 10 lines (for debug purposes)
	 */
	public void ultraprint() {
		for(int j=0;j<10;j++) {
			System.out.println(" pos" + j +" "+data[j][0]+ " " +data[j][1]+ " " + data[j][2]+ " " +data[j][3]+ " " +data[j][4]);
		}
	}
////////////////////////////////////////////////////////////
	
	
	
///////////////////INSERT ELEMENT IN THE TREE///////////////////////////////////////
	
/**
 * insertintbst calls the insert fucntion of the tbst we create this so that we can use the rootindex as a private variable
 * @param val is the value that we need to insert
 */
public void insertintbst(int val) {
	rootindex=insertintbstinner(rootindex,val);							//call the insertintbstinner from the insertintbst 
}


/**
 * insertintbstinner is the insert function of the tbst
 * @param rootindex is the root of the tree
 * @param val is the value we want to insert
 * @return the rootindex
 */
private int insertintbstinner(int rootindex,int val) {
	int ptr=rootindex;													
	int par=-1;
	inserts=inserts+2;
	inserts++;															
	while(ptr!=-1) 														//while ptr exists
	{
		inserts++;	
		par=ptr;
		inserts++;
		if(val<data[ptr][0]) {											//if the requested value is smaller than the key of ptr
			inserts++;
			if(data[ptr][3]==0) 			//if left thread does not exist
			{			
				inserts++;	
				ptr= data[ptr][1];			//ptr becomes the left branch of ptr
			}
			else
				break;
			
		}
		else 
		{
			inserts++;
			if(data[ptr][4]==0)				//if right thread does not exist
			{
				inserts++;
				ptr=data[ptr][2];			//ptr becomes the right branch of ptr
			}
			else
				break;
		}
	}
	inserts=inserts+5;
	int tmp=AVAIL;
	AVAIL=data[AVAIL][2];					//avail becomes the position of the next "node"
	data[tmp][0]=val;						//value of tmp becomes val
	data[tmp][3]=1;							//left thread of tmp exists
	data[tmp][4]=1;							//right thread of tmp exists
	inserts++;
	if(par==-1) {							//par does not exists
		inserts=inserts+3;
		rootindex=tmp;						
		data[tmp][1]=-1;					//left branch of tmp does not exists
		data[tmp][2]=-1;					//right branch of tmp does not exists
	}
	else if(val< data[par][0]) {			//if requested value is smaller than the key of par
		inserts=inserts+4;
		inserts++;
		data[tmp][1]=data[par][1];			//left node/branch of tmp becomes the left node of par 
		data[tmp][2]=par;					//right node of tmp becomes par
		data[par][3]=0;						//left thread of par becomes non existent 0
		data[par][1]=tmp;					//left node of par becomes tmp
	}
	else {
		inserts=inserts+4;
		inserts++;
		data[tmp][1]=par;					//left node of tmp becomes par
		data[tmp][2]=data[par][2];			//right node/branch of tmp becomes the right node of par 
		data[par][4]=0;						//right thread of par becomes non existent 0
		data[par][2]=tmp;					//right node of par becomes tmp
	}
	return rootindex;
}



/**
 * updateinsertstbst updates the inserts (adds the inserts in the vector and resets the counter)
 */
public void updateinsertstbst() {			
	insertsintbst.add(inserts);				//add inserts in the insertsintbst vector
	inserts=0;
}

/**
 * insertmotbst calculates the median value of all the inserts
 */
public void insertmotbst() {
      int inserttbstMo=0;
      for(int z=0;z<numberofkeys;z++) {										//for 100k loops										
    	  inserttbstMo=inserttbstMo+(int)insertsintbst.toArray()[z];		//add the comps of each search in each loop so that in the end we have the sum of all 					
      }
      inserttbstMo=inserttbstMo/numberofkeys;								//divide the sum by the number of elements to find the median										
      System.out.println("mesos oros inserts="+inserttbstMo);
}

////////////////////////////////////////////////////////////////////////////////////



/////////////////////SEARCH ELEMENT IN THE TREE//////////////////////////////////////



/**
 * searchintbst calls the search fucntion of the tbst we create this so that we can use the rootindex as a private variable
 * @param key is the key we need to search
 */
public void searchintbst(int key) {
	searchinner(rootindex,key);					//call searchinner from searchintbst
}
					

/**
 * searchinner is the search function of the tbst
 * @param currentnode is the rootindex 
 * @param val is the value we want to search
 * @return currentnode
 */
private int searchinner(int currentnode,int val){	
													
 													
	searchcountertbst++; 
	int ptr=currentnode;
	searchcountertbst++;
    while (currentnode != -1){						//while currentnode exists
    	searchcountertbst++;						
        if (val == data[currentnode][0])			//if the requested value is equal to the key of current node
            break;
        
        searchcountertbst++;
        	
        if (val < data[currentnode][0]) {				//if the requested value is smaller to the key of current node
        	searchcountertbst ++;
            if (data[currentnode][3] == 0) {				//if the left thread of current node is non existent
            	searchcountertbst++; 
            	currentnode = data[currentnode][1];		//currentnode becomes the left node of currentnode
            }
            else
            	break;
        }
        else {										//if the requested value is bigger to the key of current node
        	searchcountertbst++;
            if (data[currentnode][4] == 0) {			//if the right thread of current node is non existent
            	currentnode = data[currentnode][2];			//currentnode becomes the right node of currentnode
            	searchcountertbst++; 
            }
           	else
            	break;
        }
        searchcountertbst++;
    }
    return currentnode;
    
 }


/**
 * updatesearchestbst updates the searches (adds the searches in the vector and resets the counter)
 */
public void updatesearchestbst() {
	searchestbst.add(searchcountertbst);			//add searchcountertbst into searchestbst vector
	searchcountertbst=0;
}


/**
 * searchmotbst calculates the median value of all the searches
 */
public void searchmotbst() {
      int searchtbstMo=0;
      for(int z=0;z<100;z++) {													//for 100 loops	
    	  searchtbstMo=searchtbstMo+(int)searchestbst.toArray()[z];			//add the comps of each search in each loop so that in the end we have the sum of all 	
      }
      searchtbstMo=searchtbstMo/100;										//divide the sum by the number of elements to find the median												
      System.out.println("mesos oros searches="+searchtbstMo);
}
///////////////////////////////////////////////////////////////////////////////////////	


////////////////////////////SEARCH MULTIPLE////////////////////////////////////////////////


/**
 * searchmulti calls the range search fucntion of the tbst we create this so that we can use the rootindex as a private variable
 * @param lower is the lower limit of the range we want to search in 
 * @param upper is the upperis limit of the range we want to search in
 */
public void searchmulti(int lower, int upper) {
	multisearchinner(rootindex,lower,upper);						//call multisearchinner from searchmulti
}


/**
 * multisearchinner is the range search function of the tbst
 * @param currentnode is the rootindex
 * @param lower is the lower limit of the range we want to search in 
 * @param upper is the upperis limit of the range we want to search in
 */
private void multisearchinner(int currentnode, int lower, int upper) {	
   int index = searchinner(currentnode,lower);
   rancomps ++; 
   
   rancomps ++;
   if (data[index][0] < lower) {							//if the key of the index is smaller than the lower value of the range
       index = data[index][2];							//index becomes the right node of index
       rancomps ++;
   }
   
   
   rancomps ++;
   while(index != -1){									//while index does not exist

	 rancomps ++;
     if(data[index][0] > upper)						//if the key of the index is bigger than the upper value of the range
         break;

       rancomps ++;
     if (data[index][4] == 1){						//if right thread exists
    	  rancomps++;
    	 index = data[index][2];						//index becomes the right node of index
      }
       
       else{
    	   rancomps=rancomps+2; 
    	   index = data[index][2];						//index becomes the right node of index
        while (data[index][3] == 0) {				//while the left thread of index does not exists
            index = data[index][1];					//index becomes the left node of index
            rancomps ++;
            rancomps ++;
         }
       }
       rancomps ++;
   }
}



/**
 * updatemultisearchestbst updates the range searches (adds the range searches in the vector and resets the counter)
 */
public void updatemultisearchestbst() {
	multisearches.add(rancomps+searchcountertbst);				//add searchcountertbst and rancomps to the multisearches vector and refresh their values to 0
	searchcountertbst=0;										
	rancomps=0;
}

/**
 * multisearchmotbst calculates the median value of all the range searches
 */
public void multisearchmotbst() {
    int multisearchtbstMo=0;	
    for(int z=0;z<100;z++) {																//for 100 loops											
  	  multisearchtbstMo=multisearchtbstMo+(int)multisearches.toArray()[z];					//add the comps of each search in each loop so that in the end we have the sum of all 	
    }
    multisearchtbstMo=multisearchtbstMo/100;												//divide the sum by the number of elements to find the median						
    System.out.println("mesos oros ranged searches searches="+multisearchtbstMo);
}


/**
 * refreshrange clears the rannge search vector
 */
public void refreshrange() {
	multisearches.clear();								//clears the multisearches vector
}


}
