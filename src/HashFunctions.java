import java.util.Arrays;

public class HashFunctions {

	String[] theArray;
	int arraySize;
	int itemsInArray = 0;

	public static void main(String[] args) {

		HashFunctions theFunc = new HashFunctions(30);

//		String[] elementsToAdd = { "4", "5", "28", "9", "14" };
//
//		theFunc.hashFunction1(elementsToAdd, theFunc.theArray);
		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };

		theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);

		// Locate the value 660 in the Hash Table

		theFunc.findKey("660");

		theFunc.displayTheHash();
	}

	//Basic HashFucntion that puts items at location 
	//of item within the Hash Table
	
	public void hashFunction1(String[] stringsForArray, String[] theArray) {
		for (int n = 0; n < stringsForArray.length; n++) {
			String newElementVal = stringsForArray[n];

			theArray[Integer.parseInt(newElementVal)] = newElementVal;
		}
	}

	//Advanced HashFunction that also accounts for collision detection
	//using % 29 to locate position of the item in the HashTable
	
	public void hashFunction2(String[] stringsForArray, String[] theArray) {
		
		for(int n = 0; n < stringsForArray.length; n++){
			String newElementVal = stringsForArray[n];
			
			
			// Create an index to store the value in by taking
			//the modulus
			int arrayIndex = Integer.parseInt(newElementVal) % 29;
			
			System.out.println("Modulus Index= " + arrayIndex + " for value " + 
			newElementVal);
			
			// Cycle through the array until we find an empty space
			while(theArray[arrayIndex] != "-1"){
				++arrayIndex;
				
				System.out.println("Collision Try " + arrayIndex + " Instead");

				// If we get to the end of the array go back to index 0
				
				arrayIndex %= arraySize;
			}
			
			theArray[arrayIndex] = newElementVal;
		}
		
		
	}
	
	//Returns the value stored in the HashTable
	public String findKey(String key){
		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(key) % 29;
		
		while(theArray[arrayIndexHash] != "-1"){
			if(theArray[arrayIndexHash] == key){
				// Found the key so return it
				System.out.println(key + " was Found in Index " + arrayIndexHash);
				
				return theArray[arrayIndexHash];
			}
			// Look in the next index
			++arrayIndexHash;
			
			// If we get to the end of the array go back to index 0			
			arrayIndexHash %= arraySize;
		}
		
		// Couldn't locate the key
		return null;
	}

	HashFunctions(int size) {
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray, "-1");
	}

	
	//method to print the HashTable
	public void displayTheHash() {

		int increment = 0;

		for (int m = 0; m < 3; m++) {

			increment += 10;

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				System.out.format("| %3s " + " ", n);

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				if (theArray[n].equals("-1"))
					System.out.print("|      ");

				else
					System.out.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

		}

	}
}