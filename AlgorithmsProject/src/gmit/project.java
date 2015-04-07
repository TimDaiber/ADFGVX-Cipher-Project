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
	private static int encryptioncounter=0,decryptioncounter=0,lastindexcounter=0,mylistindexcounter=0;
	// Declaring String variables
	private static String password,value;
	private static String result;
	
	
	// ----------------------------------------------- Main start --------------------------------------------------------
	public static void main(String[] args) throws IOException {
		// Method to populate HashMap
		putstuffinstrinmap();
		
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
			writetofile();
			// Ends Timer
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			// Prints Time
			System.out.println(totalTime);		 
	}
	// ------------------------------------ End Main -----------------------------------------
	
	private static void writetofile() throws FileNotFoundException, UnsupportedEncodingException {
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
		 
		// Gets
		value= stringmap.get(string);
		mylist.get(encryptioncounter).add(value);
		// Adds one to counter
		encryptioncounter++;			
		if(encryptioncounter>=password.length()){
			encryptioncounter=0;
			// Adds one to counter
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
				result= stringmap.get(ba);
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