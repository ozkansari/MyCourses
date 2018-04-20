/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.medipol.vizeproje.baris_koksal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;

public class YayinEviListele extends JFrame{
        
        public YayinEviListele() throws FileNotFoundException{
        File file = new File("Yayin Evi Adi.txt");
        
        Scanner oku = new Scanner(file);
        
        while(oku.hasNextLine()){
            String satir = oku.nextLine();
            System.out.println(oku.nextLine()+"\n");
            
        }
        oku.close();
        }
    }