package tr.edu.medipol.odev1.kerimbiber;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileRead {
	public static void main(String[] args) throws Exception
	{
		Path path = Paths.get("./dosya.txt");
		FileInputStream inputStream = new FileInputStream(path.getFileName().toString());
		ObjectInputStream oInputStream = new ObjectInputStream(inputStream);
		ArrayList<Ogrenci> arrayList = new ArrayList<>();
		arrayList = (ArrayList<Ogrenci>) oInputStream.readObject();
		for(Ogrenci ogr : arrayList)
		{
			System.out.printf("Ogrenci Adi : %s, Ogrenci Bolum : %s \n", ogr.AdSoyad, ogr.Bolum);
		}
	}
}
