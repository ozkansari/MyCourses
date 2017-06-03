package tr.edu.medipol.ogrenciler.selahattinbozat.odev5;


public class LinkedListogrenciList {

	public class LinkedListSinifi {


		private LinkedListogrenciList listem=new LinkedListogrenciList();


		public LinkedListogrenciList getListem() {


				return listem;


			}


		public void setListem(LinkedListogrenciList listem) {


				this.listem = listem;


			}


		public void elemanEkle(String e1){


				getListem().add(0, e1);


			}


		public void elemanCikart(String isim){

			if(getListem().contains(isim)){


		System.out.println("Cikartma basarili mi: "


				+getListem().Remove(isim));


				}


			else{


		System.out.println("Aranan deger listede yok.");


				}


			}
		public void elemanGoster(){

		    /* HATALI
			for (String i : getListem()) {


					System.out.println(i);


				} */
			}


		public void main(String[] args) {


		LinkedListSinifi nesnem=new LinkedListSinifi();


			nesnem.elemanEkle("Ethem");


			nesnem.elemanEkle("Mehmet");

			nesnem.elemanGoster();


			nesnem.elemanCikart("Mehmet");


			nesnem.elemanCikart("yanlis");


			nesnem.elemanGoster();


		System.out.println("Diger linket liste metodlari");


			nesnem.getListem().get(0);


			nesnem.getListem().getFirst();


			nesnem.getListem().add(2, "Istanbul");


			nesnem.getListem().add(0, "Ankara");


			nesnem.getListem().addLast("Dersler");


			}


		}

	public String Remove(String isim) {
		// TODO Auto-generated method stub
		return null;
	}

	public void get(int i) {
		// TODO Auto-generated method stub
		
	}

	public void getFirst() {
		// TODO Auto-generated method stub
		
	}

	public void addLast(String string) {
		// TODO Auto-generated method stub
		
	}

	public void add(int i, String e1) {
		// TODO Auto-generated method stub
		
	}

	public boolean contains(String isim) {
		// TODO Auto-generated method stub
		return false;
	}
}
