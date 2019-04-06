package tr.edu.medipol.ilerijava.ders06.socketgui;

public class SocketGUIApp {

	public static void main(String[] args)  {
		
		try {
			new SocketGUI().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
