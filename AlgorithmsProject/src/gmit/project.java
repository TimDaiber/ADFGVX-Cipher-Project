package gmit;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class project {
	// Creating Hashmap
	private static HashMap<String, String> stringmap = new HashMap<String, String>();

	// Creating String Array lists
	private static ArrayList<ArrayList<String>> mylist = new ArrayList<ArrayList<String>>();
	private static ArrayList<String> lol = new ArrayList<String>();
	
	// Declaring int variables
	private static int encryptioncounter=0,decryptioncounter=0,lastindexcounter=0,
			mylistindexcounter=0,resortcounter=0;
	// Declaring String variables
	private static String password,value;
	private static String result,text;
	
	
	// ----------------------------------------------- Main start --------------------------------------------------------
	public static void main(String[] args) throws IOException {
		// Method to populate HashMap
		putstuffinstrinmap();
		
		System.out.println("Pleaseinput your passphrase");
		// Gets user Input
		Scanner in = new Scanner(System.in);
		password = in.nextLine();
		
		System.out.println("Please input the file name you want to encrypt.(WarAndPeace-LeoTolstoy.txt)");
		// Gets user Input
		Scanner tin = new Scanner(System.in);
		 text = in.nextLine();
		 
		//Starts Timer
		 long startTime = System.nanoTime();
		 
		// Starts for loop
		// Creates Array list in number of the amount of characters of the password
		// Adds created arraylists to Arraylist<List> mylist.
		for (int i = 0; i < password.length(); i++) {
			List<String> firstCharandMore= new ArrayList<>();
			char c = password.charAt(i);
			firstCharandMore.add(String.valueOf(c));
			String resortcountertostring= String.valueOf(resortcounter);
		        mylist.add((ArrayList<String>) firstCharandMore);
		        // Adds index for resort to arraylists
		        mylist.get(i).add(resortcountertostring);
		        //mylist.add((ArrayList<String>) resortcountertostring);
		        resortcounter++;
		    }
		
		//Starts Timer
		
		
		// Reads in File in UTF-8 format
		// gets back a character
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
			        new FileInputStream(text),
			        Charset.forName("UTF-8")));
			int c;
			while((c = reader.read()) != -1) {
			  char string = (char) c;
			 
			  // Converts Character to upper case String
			  // Passes the string into encryption method
			  encrypt(Character.toString(string).toUpperCase());
			  // Adds one to counter
			  decryptioncounter++;
			  
			}
			//long endTime2   = System.nanoTime();
			//long totalTime2 = endTime2 - startTime;
			//double seconds2 = (double)totalTime2 / 1000000000.0;
			//System.out.println(seconds2+" Encryption");
			// Creates new Arraylist listToSort (Copy of mylist)
			// Sorts Array lists in alphabetic order by first character from each list
			sortarraylists();
			
			writetofileencrypted();
			// Resorts arraylists using the index
			resortarraylist();
			
			// Calls decryption method
			decrypt();
			// Calls write to file method
			writetofilefin();
			// Ends Timer
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			// Prints Time
			double seconds = (double)totalTime / 1000000000.0;
			System.out.println(seconds+" Total time");		 
	}
	// ------------------------------------ End Main -----------------------------------------
	
	// Writes encrypted message to file.
	private static void writetofileencrypted() throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		PrintWriter writer2 = new PrintWriter("encrypted.txt", "UTF-8");
		StringBuilder builder2 = new StringBuilder();
		for (ArrayList<String> value : mylist) {
		    builder2.append(value);
		}
		String s = builder2.toString();
		//String s = lol.toString();
		writer2.println(s);
		writer2.close();
	}

	// -------------------------------------resorting-----------------------------------------
	private static void resortarraylist() {
		// Resorts lists using index 1 (The numbers assigned to that index))
		mylist.sort((l1, l2) -> l1.get(1).compareTo(l2.get(1)));
	}
	// ------------------------------------End resorting --------------------------------------
	
	
	
	// ------------------------------------ Sorting ------------------------------------------
	private static void sortarraylists() {
		// Sorting lists in alphabetical order by index 0
		mylist.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
	}
	// ------------------------------------End sorting ---------------------------------------

	// ------------------------------------write to file --------------------------------------
	private static void writetofilefin() throws FileNotFoundException, UnsupportedEncodingException {
		// Prints to array list lol to file
		PrintWriter writer = new PrintWriter("finished.txt", "UTF-8");
		StringBuilder builder = new StringBuilder();
		for (String value : lol) {
		    builder.append(value);
		}
		String s = builder.toString();
		//String s = lol.toString();
		writer.println(s);
		writer.close();
		
	}
	
	
	// -------------------------------- Encryption Start -------------------------------------
	private static void encrypt(String string) {
		 
		// Gets coherent value from map
		value= stringmap.get(string);
		// adds value to mylist at index encryptioncounter
		mylist.get(encryptioncounter).add(value);
		// Adds one to counter
		encryptioncounter++;
		// Resets encryptioncounter 
		if(encryptioncounter>=password.length()){
			encryptioncounter=0;
			// Adds one to lastindexcounter
			lastindexcounter++;
		}		
	}
	// --------------------------------- Encryption End ---------------------------------------
	
	// --------------------------------- Decryption Start -------------------------------------
	private static void decrypt() {
		
		int thiscounter=0;
		// runs until decryptioncounter is = to thiscounter or 
		// mylistindexcounter is = to lastindexcounter
		while(decryptioncounter   != thiscounter  ){
			for(int i=0;i <password.length() ;i++){
				// gets value from Arraylist
				String ba = mylist.get(i).get(mylistindexcounter);
				// gets coherent value from map
				result= stringmap.get(ba);
				// adds value to arraylist lol
				lol.add(result);
				thiscounter++;
				if(mylistindexcounter >=lastindexcounter){
					decryptioncounter =thiscounter;
				}
			}
			mylistindexcounter++;
		}		
	}
	// ---------------------------------- Decryption End ---------------------------------------
	
	// --------------------------------- Map population start ---------------------------------
	
	public static void putstuffinstrinmap(){
		stringmap.put("AA", "P");//AA - P
		stringmap.put("AD", "H");//AD - H
		stringmap.put("AF", "0");//
		stringmap.put("AG", "Q");//
		stringmap.put("AV", "G");//
		stringmap.put("AX", "6");//
		stringmap.put("DA", "4");//
		stringmap.put("DD", "M");//
		stringmap.put("DF", "E");//
		stringmap.put("DG", "A");//
		stringmap.put("DV", "1");//
		stringmap.put("DX", "Y");//
		stringmap.put("FA", "L");//
		stringmap.put("FD", "2");//
		stringmap.put("FF", "N");//
		stringmap.put("FG", "O");//
		stringmap.put("FV", "F");//
		stringmap.put("FX", "D");//
		stringmap.put("GA", "X");//
		stringmap.put("GD", "K");//
		stringmap.put("GF", "R");//
		stringmap.put("GG", "3");//
		stringmap.put("GV", "C");//
		stringmap.put("GX", "V");//
		stringmap.put("VA", "S");//
		stringmap.put("VD", "5");//
		stringmap.put("VF", "Z");//
		stringmap.put("VG", "W");//
		stringmap.put("VV", "7");//
		stringmap.put("VX", "B");//
		stringmap.put("XA", "J");//
		stringmap.put("XD", "9");//
		stringmap.put("XF", "U");//
		stringmap.put("XG", "T");//
		stringmap.put("XV", "I");//
		stringmap.put("XX", "8");//		
		stringmap.put("P", "AA");//
		stringmap.put("H", "AD");//
		stringmap.put("0", "AF");//
		stringmap.put("Q", "AG");//
		stringmap.put("G", "AV");//
		stringmap.put("6", "AX");//
		stringmap.put("4", "DA");//
		stringmap.put("M", "DD");//
		stringmap.put("E", "DF");//
		stringmap.put("A", "DG");//
		stringmap.put("1", "DV");//
		stringmap.put("Y", "DX");//
		stringmap.put("L", "FA");//
		stringmap.put("2", "FD");//
		stringmap.put("N", "FF");//
		stringmap.put("O", "FG");//
		stringmap.put("F", "FV");//
		stringmap.put("D", "FX");//
		stringmap.put("X", "GA");//
		stringmap.put("K", "GD");//
		stringmap.put("R", "GF");//
		stringmap.put("3", "GG");//
		stringmap.put("C", "GV");//
		stringmap.put("V", "GX");//
		stringmap.put("S", "VA");//
		stringmap.put("5", "VD");//
		stringmap.put("Z", "VF");//
		stringmap.put("W", "VG");//
		stringmap.put("7", "VV");//
		stringmap.put("B", "VX");//
		stringmap.put("J", "XA");//
		stringmap.put("9", "XD");//
		stringmap.put("U", "XF");//
		stringmap.put("T", "XG");//
		stringmap.put("I", "XV");//
		stringmap.put("8", "XX");//	
		stringmap.put("AH", ".");//
		stringmap.put("DH", "!");//
		stringmap.put("FH", "?");//
		stringmap.put("GH", " ");//
		stringmap.put("VH", "'");//
		stringmap.put("XH", ",");//
		stringmap.put(".", "AH");//
		stringmap.put("!", "DH");//
		stringmap.put("?", "FH");//
		stringmap.put(" ", "GH");//
		stringmap.put("'", "VH");//
		stringmap.put(",", "XH");//		
		stringmap.put("AP", "]");//
		stringmap.put("DP", "[");//
		stringmap.put("FP", "~");//
		stringmap.put("GP", "&");//
		stringmap.put("VP", ":");//
		stringmap.put("XP", ";");//
		stringmap.put("AP", "-");//"
		stringmap.put("DP", "");//
		stringmap.put("FP", "*");//
		stringmap.put("GP", "^");//
		stringmap.put("VP", "\"");//
		stringmap.put(null, " ");//
	}
	// --------------------------------- Map population End -----------------------------------
	
}