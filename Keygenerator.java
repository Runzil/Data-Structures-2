package domeserg2;
import java.util.Vector;


/**
 * @author konst
 *Keygenerator is a class that generates keys
 */
public class Keygenerator {
	
	/**
	 * int numberofkeys is the number of keys
	 */
	public static int numberofkeys = 100000;
	
	/**
	 * Vector Usedkeys is the vector we store the random 100k keys
	 */
	Vector Usedkeys=new Vector();
	
	/**
	 * Vector random100keys is the vector we store the random 100 keys
	 */
	Vector random100keys=new Vector();
	
	/**
	 * Vector random100smaller is the vector we store the random 100 keys for the 100 range search
	 */
	Vector random100smaller=new Vector();
	
	/**
	 * Vector random1000smaller is the vector we store the random 100 keys for the 1000 range search
	 */
	Vector random1000smaller=new Vector();			
	
////////////////////constructor////////////	
	/**
	 * Keygenerator is the constructor
	 */
	public Keygenerator() {
	}
///////////////////////////////////////////
	
//////////////////key generation //////////////////////////////////

/**
 * keys100k is the function that creates the 100k random keys
 */
public void keys100k(){					//1000000 random key generation
	int max = 1000000; 					
	int min = 1; 						
	int range = max - min + 1; 			
	

	
for (int i = 0; i < numberofkeys; i++) { 						//do the following for 100k times
int rand = (int)(Math.random() * range) + min; 					//create a random number from 1 to 1000000 using math.random and casting it to int
   
while(Usedkeys.contains(rand)) {								//while rand exists in Usedkeys aka if the key is duplicated create a new rand
rand = (int)(Math.random() * range) + min; 
}
Usedkeys.add(rand);												//add the random number to the usedkeys vector with the add() function
}

}


/**
 * keys100 is the function that creates the 100 random keys
 */
public void keys100() {													
int max2 = 1000000; 
int min2 = 1; 
int range2 = max2 - min2 + 1; 

	
for (int j = 0; j < 100; j++) {													//do the following for 100 times						
int rand2 = (int)(Math.random() * range2) + min2; 								//create a random number from 1 to 1000000 using math.random and casting it to int		

while(random100keys.contains(rand2) || !Usedkeys.contains(rand2)) {				//while rand exists in random100keys  aka if the key is duplicated ot if it not contained in Usedkeys create a new rand		
rand2 = (int)(Math.random() * range2) + min2; 									
}
random100keys.add(rand2);														//add the rand2 to the random100keys vector		
}
}



/**
 * keys100small is the function that creates the 100 random keys used for a 100 range search
 */
public void keys100small() {
	int max3 = 1000000-100; 
	int min3 = 1; 
	int range3 = max3 - min3 + 1; 

	
	for (int j = 0; j < 100; j++) {															//do the following for 100 times				
	int rand3 = (int)(Math.random() * range3) + min3; 										//create a random number from 1 to 1000000 using math.random and casting it to int		

	while(random100smaller.contains(rand3)) {												//while rand3 exists in random100smaller aka if the key is duplicated create a new rand														
	rand3 = (int)(Math.random() * range3) + min3; 
	}
	random100smaller.add(rand3);															//add the rand3 to the random100smaller vector		
	}
	}




/**
 * keys1000small is the function that creates the 100 random keys used for a 1000 range search
 */
public void keys1000small() {
	int max4 = 1000000-1000; 
	int min4 = 1; 
	int range4 = max4 - min4 + 1; 


	for (int j = 0; j < 100; j++) {															//do the following for 100 times					
	int rand4 = (int)(Math.random() * range4) + min4; 										//create a random number from 1 to 1000000 using math.random and casting it to int

	while(random1000smaller.contains(rand4)) {												//while rand4 exists in random1000smaller aka if the key is duplicated create a new rand					
	rand4 = (int)(Math.random() * range4) + min4; 											
	}
	random1000smaller.add(rand4);															//add the rand4 to the random1000smaller vector		
	}
	}

///////////////////////////////////////////////////////////////////

////getters///////////////////////////////

/**
 * getUsedkeys are getters
 * @return Usedkeys
 */
public Vector getUsedkeys() {																	//getters will return the keys
	return Usedkeys;
}

/**
 * getRandom100keys is a getter
 * @return random100keys
 */
public Vector getRandom100keys() {
	return random100keys;
}

/**
 * getRandom1000smaller is a getter
 * @return random100smaller
 */
public Vector getRandom100smaller() {
	return random100smaller;
}

/**
 * getRandom1000smaller is a getter
 * @return random1000smaller
 */
public Vector getRandom1000smaller() {
	return random1000smaller;
}



}

	
	
	

