package tr.edu.medipol.ilerijava.proje1.ihsan_ilker_pirinc;

public class SocketGUIApp {

	public static void main(String[] args)  {
		
		try {
			new SocketGUI().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}