package ACME.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TexxtReader {
	// Read the .txt file
	public String readTxt(String direccion) {
		String text = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String temp = "";
			String bfRead;
			while ((bfRead = bf.readLine()) != null) {
				temp = temp +bfRead;
			}
			
			text = temp;
			
		} catch (Exception e) {
			System.out.println("Error in:" + e);
		}
		return text;
	}

	// Separe the name of the schedule
	public String[] separedObjects(String data) {
		String nameSepared[] = new String[2];
		String[] aux = data.split("=");
		nameSepared[0] = aux[0];
		nameSepared[1] = aux[1];
		return nameSepared;
	}
}
