package domeserg2;

import java.util.Vector;

/**
 * @author konst
 *Mainclass is the mainclass of the project
 */
public class Mainclass {
	/**
	 *  int numberofkeys is the number of the keys required
	 */
	public static int numberofkeys = 100000;	
	
	/**
	 * main is the main function of the project
	 * @param args
	 */
	public static void main(String[] args) {
		
		Keygenerator keys=new Keygenerator();								//make a keys instanceof keygenerator
		BinarySearchTree bnt = new BinarySearchTree(numberofkeys);			//make a bnt instance of BinarySearchTree with 100k nodes
		
		keys.keys100k();						//produce 100k keys
		keys.keys100();							//produce 100 keys
		keys.keys100small();					//produce keys100small
		keys.keys1000small();					//produce keys1000small

///////////////////////////////////////BINARY TREE////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("==========BINARY TREE==========");
//for the inserts in the binary tree
		for (int c=0 ;c<numberofkeys;c++) {										//for 100kloops
			bnt.insertintoBst((int)keys.getUsedkeys().toArray()[c]);			//insert one of the 100k keys generated in Keygenerator in each loop
			bnt.updateinserts();												//call updateinserts
		}
		bnt.insertmo();															//call unsermo
		
//for the searches in the binary tree		
		for (int c=0 ;c<100;c++) {												//for 100 loops
			bnt.search((int)keys.getRandom100keys().toArray()[c]);				//search one of the 100 keys generated in Keygenerator in each loop
			bnt.updatesearches();												//call updatesearches
		}
		bnt.searchmo();															//call searchmo
		
//for the 100 range search in the binary tree
		for (int c=0 ;c<100;c++) {																										//for 100 loops
			bnt.printmultiple((int)keys.getRandom100smaller().toArray()[c],(int)keys.getRandom100smaller().toArray()[c]+100);			//in bst search one of the 100smaller keys generated in Keygenerator in each loop and in each loop search each element to element +100
			bnt.updatemulticomp();																										//call updatemulticomp
		}
		System.out.println("for 100 range");
		bnt.multicompmo();																												//call multicompmo
		
		bnt.multiclear();																												//call multiclear
//for the 1000 range search in the binary tree		
		for (int c=0 ;c<100;c++) {																										//for 100 loop
			bnt.printmultiple((int)keys.getRandom1000smaller().toArray()[c],(int)keys.getRandom1000smaller().toArray()[c]+1000);		//in bst search one of the 1000smaller keys generated in Keygenerator in each loop and in each loop search each element to element +1000
			bnt.updatemulticomp();																										//call updatemulticomp
		}
		System.out.println("for 1000 range");
		bnt.multicompmo();																												//call multicompmo
		
///////////////////////////////////////THREADED BINARY TREE/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		System.out.println("=========THREADED BINARY TREE================");
		ThreadedBinarySearchTree tbst= new ThreadedBinarySearchTree(numberofkeys);				//create a tbst instance of ThreadedBinarySearchTree 
			
//for inserts in the threaded binary tree
		for (int c=0 ;c<numberofkeys;c++) {														//for 100k loop
			tbst.insertintbst((int)keys.getUsedkeys().toArray()[c]);							//insert in tbst one of the 100k keys generated in Keygenerator in each loop
			tbst.updateinsertstbst();															//call updateinsertstbst
		}
		tbst.insertmotbst();																	//call insertmotbst
		
//for the searches in the threaded binary tree				
		for (int c=0 ;c<100;c++) {																//for 100 loops
			tbst.searchintbst((int)keys.getRandom100keys().toArray()[c]);						//search one of the 100 keys generated in Keygenerator in each loop
			tbst.updatesearchestbst();															//call updatesearchestbst
		}
		tbst.searchmotbst();																	//call searchmotbst
		
		
//for the range 100 search in tbst
		for (int c=0 ;c<100;c++) {
			tbst.searchmulti((int)keys.getRandom100smaller().toArray()[c],(int)keys.getRandom100smaller().toArray()[c]+100); 		//in tbst search one of the 100smaller keys generated in Keygenerator in each loop and in each loop search each element to element +100
			tbst.updatemultisearchestbst();						//call updatemultisearchestbst
		}
		System.out.println("for 100 range");
		tbst.multisearchmotbst();								//call multisearchmotbst
			
		tbst.refreshrange();									//call refreshrange
		
		
		
	//for the range 100 search in tbst
			for (int c=0 ;c<100;c++) {
				tbst.searchmulti((int)keys.getRandom1000smaller().toArray()[c],(int)keys.getRandom1000smaller().toArray()[c]+1000);  //in tbst search one of the 1000smaller keys generated in Keygenerator in each loop and in each loop search each element to element +1000
				tbst.updatemultisearchestbst();					//call updatemultisearchestbst
			}
			System.out.println("for 1000 range");				
			tbst.multisearchmotbst();							//call multisearchmotbst
			
			
			
			
			
			
			
			
			
			
			
///////////////////////////////////////LIST////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("===========LIST==========");
		SortedList list= new SortedList(keys.getUsedkeys());	//create an instance of SortedList named list
		
//for the searches in the list
		for(int i=0;i<100;i++) {													//for 100 loops
			list.binarySearch((int)keys.getRandom100keys().toArray()[i]);			//search one of the 100 keys generated in Keygenerator in each loop in the list
			list.refresh();															//call refresh
		}
		list.searchmo();															//call searchmo
		list.clear();																//call clear
		
	
		
		
		
		
		
//for the 100 range search in the list
		for(int i=0;i<100;i++) {						//for 100 loops
			
			list.increasecomps();
			int check=list.binarySearch((int)keys.getRandom100smaller().toArray()[i]);		//search with binary for the smallest number of the range for each of the keys in each loop		
			
			list.increasecomps();
			if(check!=-1){					//if it exists 
				list.increasecomps();
				for(int k=1;k<101;k++) {	//for 100 loops
					list.increasecomps();	//call increase comps
					if(!((int)list.getTotalkeys().toArray()[list.getSaved()+k]<(int)keys.getRandom100smaller().toArray()[i]+100)) {  //if not (the list[saved+k] is smaller than the smaller100 element +100 (or the max range) )
					break;
					}
					list.increasecomps();
				}
			}
			else {								//else if it doesn't exist
				//list.increasecomps();
				//if(check==-1){	
				list.increasecomps();
					for(int k=1;k<101;k++) {
						list.increasecomps();	//call increase comps
						if(!((int)list.getTotalkeys().toArray()[list.getSaved()+1+k]<(int)keys.getRandom100smaller().toArray()[i]+100)) {	//if not (the list[saved+1+k] is smaller than the smaller100 element +100 (or the max range) ) we use saved +1 because if the element does not exist the saved value is the previous value of the one that is requested
						break;
						//}
						}
						list.increasecomps();
					}
			}	
			list.refresh();									//call refresh
		}
		System.out.println("Mo range 100 list");
		list.searchmo();									//call searchmo
		list.clear();										//call clear
		
		
		
		
		
		
//for the 1000 range search in the list
		for(int i=0;i<100;i++) {							//for 100 loops
			list.increasecomps();
			int check=list.binarySearch((int)keys.getRandom1000smaller().toArray()[i]);		//search with binary for the smallest number of the range for each of the keys in each loop	
			
			list.increasecomps();	
			if(check!=-1){
				list.increasecomps();
				for(int k=1;k<1001;k++) {
					list.increasecomps();	//call increase comps
					if(!((int)list.getTotalkeys().toArray()[list.getSaved()+k]<(int)keys.getRandom1000smaller().toArray()[i]+1000)) {//if not (the list[saved+k] is smaller than the smaller100 element +1000 (or the max range) )
						break;
					}
					list.increasecomps();
				}
			}
			else {
				//if(check==-1){
				list.increasecomps();
					for(int k=1;k<1001;k++) {  //for 1000 loops
						list.increasecomps();	//call increase comps
						if(!((int)list.getTotalkeys().toArray()[list.getSaved()+1+k]<(int)keys.getRandom1000smaller().toArray()[i]+1000)) {//if not (the list[saved+1+k] is smaller than the smaller100 element +1000 (or the max range) ) we use saved +1 because if the element does not exist the saved value is the previous value of the one that is requested
						break;
						}
					//}
						list.increasecomps();
					}
			}
			list.refresh();								//call refresh
		}	
		System.out.println("Mo range 1000 list");
		list.searchmo();								//call searchmo
		list.clear();									//call clear
	}
}
