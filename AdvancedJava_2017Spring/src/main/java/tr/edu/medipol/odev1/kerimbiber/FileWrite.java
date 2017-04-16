package tr.edu.medipol.odev1.kerimbiber;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
public class FileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get("./dosya.txt");
		
		ArrayList<Ogrenci> arrayList = new ArrayList<>();
		try{
			FileOutputStream fileOut = new FileOutputStream(path.getFileName().toString());
			ObjectOutputStream outSerialize = new ObjectOutputStream(fileOut);
			outSerialize.writeObject(arrayList);
			outSerialize.flush();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}