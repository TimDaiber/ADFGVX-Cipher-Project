package gmit;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class project {
	// Creating Hashmap
	private static HashMap<String, String> map = new HashMap<String, String>();
	// Creating String Array lists
	private static ArrayList<ArrayList<String>> mylist = new ArrayList<ArrayList<String>>();
	private static ArrayList<String> lol = new ArrayList<String>();
	// Declaring int variables
	private static int encryptioncounter=0,decryptioncounter=0,lastindexcounter=0,mylistindexcounter=0;
	// Declaring String variables
	private static String password,value,result;
	
	
	// ----------------------------------------------- Main start --------------------------------------------------------
	public static void main(String[] args) throws IOException {
		// Method to populate HashMap
		putstuffinmap();	
		
		System.out.println("Pleaseinput your passphrase");
		// Gets user Input
		Scanner in = new Scanner(System.in);
		password = in.nextLine();
		
		// Starts for loop
		// Creates Array list in number of the amount of characters of the password
		// Adds created arraylists to Arraylist<List> mylist.
		for (int i = 0; i < password.length(); i++) {
			List<String> firstCharandMore= new ArrayList<>();
			char c = password.charAt(i);
			firstCharandMore.add(String.valueOf(c));
			  
		        mylist.add((ArrayList<String>) firstCharandMore);
		    }
		
		//Starts Timer
		long startTime = System.currentTimeMillis();
		// Reads in File in UTF-8 format
		// gets back a character
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
			        new FileInputStream("WarAndPeace-LeoTolstoy.txt"),
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
			
			// Creates new Arraylist listToSort (Copy of mylist)
			// Sorts Array lists in alphabetic order by first character from each list
			List<List<String>> listToSort = new ArrayList<>(mylist);	
			listToSort.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
			
			// Calls decryption method
			decrypt();
			
			// Ends Timer
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			// Prints Time
			System.out.println(totalTime);		 
	}
	// ------------------------------------ End Main -----------------------------------------
	
	// -------------------------------- Encryption Start -------------------------------------
	private static void encrypt(String string) {
		
		 value= map.get(string);
		mylist.get(encryptioncounter).add(value);	
		encryptioncounter++;			
		if(encryptioncounter>=password.length()){
			encryptioncounter=0;
			lastindexcounter++;
		}		
	}
	// --------------------------------- Encryption End ---------------------------------------
	
	// --------------------------------- Decryption Start -------------------------------------
	private static void decrypt() {

		int thiscounter=0;
		while(decryptioncounter   != thiscounter  ){
			for(int i=0;i <password.length() ;i++){
				
				String ba = mylist.get(i).get(mylistindexcounter);				
				result= map.get(ba);
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
	public static void putstuffinmap(){
		map.put("AA", "P");//AA - P
		map.put("AD", "H");//AD - H
		map.put("AF", "0");//
		map.put("AG", "Q");//
		map.put("AV", "G");//
		map.put("AX", "6");//
		map.put("DA", "4");//
		map.put("DD", "M");//
		map.put("DF", "E");//
		map.put("DG", "A");//
		map.put("DV", "1");//
		map.put("DX", "Y");//
		map.put("FA", "L");//
		map.put("FD", "2");//
		map.put("FF", "N");//
		map.put("FG", "O");//
		map.put("FV", "F");//
		map.put("FX", "D");//
		map.put("GA", "X");//
		map.put("GD", "K");//
		map.put("GF", "R");//
		map.put("GG", "3");//
		map.put("GV", "C");//
		map.put("GX", "V");//
		map.put("VA", "S");//
		map.put("VD", "5");//
		map.put("VF", "Z");//
		map.put("VG", "W");//
		map.put("VV", "7");//
		map.put("VX", "B");//
		map.put("XA", "J");//
		map.put("XD", "9");//
		map.put("XF", "U");//
		map.put("XG", "T");//
		map.put("XV", "I");//
		map.put("XX", "8");//
		map.put("P", "AA");//
		map.put("H", "AD");//
		map.put("0", "AF");//
		map.put("Q", "AG");//
		map.put("G", "AV");//
		map.put("6", "AX");//
		map.put("4", "DA");//
		map.put("M", "DD");//
		map.put("E", "DF");//
		map.put("A", "DG");//
		map.put("1", "DV");//
		map.put("Y", "DX");//
		map.put("L", "FA");//
		map.put("2", "FD");//
		map.put("N", "FF");//
		map.put("O", "FG");//
		map.put("F", "FV");//
		map.put("D", "FX");//
		map.put("X", "GA");//
		map.put("K", "GD");//
		map.put("R", "GF");//
		map.put("3", "GG");//
		map.put("C", "GV");//
		map.put("V", "GX");//
		map.put("S", "VA");//
		map.put("5", "VD");//
		map.put("Z", "VF");//
		map.put("W", "VG");//
		map.put("7", "VV");//
		map.put("B", "VX");//
		map.put("J", "XA");//
		map.put("9", "XD");//
		map.put("U", "XF");//
		map.put("T", "XG");//
		map.put("I", "XV");//
		map.put("8", "XX");//	
		map.put("AH", ".");//
		map.put("DH", "!");//
		map.put("FH", "?");//
		map.put("GH", " ");//
		map.put("VH", "'");//
		map.put("XH", ",");//
		map.put(".", "AH");//
		map.put("!", "DH");//
		map.put("?", "FH");//
		map.put(" ", "GH");//
		map.put("'", "VH");//
		map.put(",", "XH");//	
	}
	// --------------------------------- Map population End -----------------------------------
}