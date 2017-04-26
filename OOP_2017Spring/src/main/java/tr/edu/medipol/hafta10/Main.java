package tr.edu.medipol.hafta10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int dizi[]={5,9,1,15,2,7,2,9,6,0,11,18,14,-2};
		System.out.println("Dizinin orijinal hali.. ");
		for(int i: dizi){
			System.out.print(i+" ");
		}
		System.out.println();
		int islem=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Kucukten buyuge siralama(1)\n Buyukten Kucuge siralama (2)");
		islem=sc.nextInt();
		int d[]=siralama(dizi,islem);
		for(int i: d){
			System.out.print(i+" ");
		}

	}
	public static int [] siralama(int[] d,int islem){
		
		int [] sonuc = new int [d.length];
		for (int i = 0; i < sonuc.length; i++) {
			sonuc[i] = d[i];
		}
		// sonuc = Arrays.copyOf(d, d.length);
		
			int temp=0;
			for(int i=0;i<d.length;i++){
				for(int j=i+1;j<d.length;j++){
					if(islem==1){
						if(d[i]>d[j]){
							temp=d[i];
							d[i]=d[j];
							d[j]=temp;
						}
					}
                    if(islem==2){
	                  if(d[i]<d[j]){
	              		temp=d[i];
	            		d[i]=d[j];
	            		d[j]=temp;
	            	  }
                    }
				}
			}
	
		return d;
	}

}
