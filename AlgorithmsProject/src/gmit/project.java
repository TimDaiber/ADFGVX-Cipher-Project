package gmit;

import java.io.BufferedReader;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class project {
	// test one
	private static ArrayList<String> lol = new ArrayList<String>();
	private static HashMap<String, String> map = new HashMap<String, String>();
	static ArrayList<ArrayList<String>> mylist = new ArrayList<ArrayList<String>>();
	static List<String> mycode = new ArrayList<String>();
	 static ArrayList<String> thisisit;
	private static String mypasprase;
	private static int counter=0;
	private static int decryptioncounter = 0;
	private static String value;
	private static int last=0;
	private static String result;
	private static int anothercounter=0;
	public static void main(String[] args) throws IOException {
		
		putstuffinmap();	
		
		System.out.println("Pleaseinput your passphrase");
		Scanner in = new Scanner(System.in);
		mypasprase = in.nextLine();
		for (int i = 0; i < mypasprase.length(); i++) {
			List<String> firstCharandMore= new ArrayList<>();
			char c = mypasprase.charAt(i);
			firstCharandMore.add(String.valueOf(c));
			  
		        mylist.add((ArrayList<String>) firstCharandMore);
		    }
		
		long startTime = System.currentTimeMillis();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
			        new FileInputStream("WarAndPeace-LeoTolstoy.txt"),
			        Charset.forName("UTF-8")));
			int c;
			while((c = reader.read()) != -1) {
			  char string = (char) c;
			  
			  encrypt(Character.toString(string).toUpperCase());
			  decryptioncounter++;
			  
			}
			
			List<List<String>> listToSort = new ArrayList<>(mylist);	
			listToSort.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
			
			decrypt();
			
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);
			 
	}

	private static void encrypt(String string) {
		
		 value= map.get(string);
		mylist.get(counter).add(value);	
		counter++;			
		if(counter>=mypasprase.length()){
			counter=0;
			last++;
		}
		
		
	}
	
	
	private static void decrypt() {

		int thiscounter=0;
		while(decryptioncounter   != thiscounter  ){
			for(int i=0;i <mypasprase.length() ;i++){
				
				String ba = mylist.get(i).get(anothercounter);				
				result= map.get(ba);
				lol.add(result);
				thiscounter++;
				if(anothercounter >=last){
					decryptioncounter =thiscounter;
				}
			}
			anothercounter++;
		}
		
		
		
	}


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
}
