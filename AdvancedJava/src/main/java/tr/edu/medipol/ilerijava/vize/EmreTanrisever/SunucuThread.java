package tr.edu.medipol.ilerijava.vize.EmreTanrisever;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class SunucuThread extends Thread {

	private Socket istemciadresi;

	public SunucuThread(Socket istemciadresi) {
		this.istemciadresi = istemciadresi;
	}

	@Override
	public void run() {
		try {
			DataInputStream gelen = new DataInputStream(this.istemciadresi.getInputStream());
			DataOutputStream cikan = new DataOutputStream(this.istemciadresi.getOutputStream());

			while (true) {
				// wait for input
				String input = gelen.readUTF();

				if (input.equals("bye"))
					break;

				System.out.println("Equation received:-" + input);
				int sonuc;

				StringTokenizer st = new StringTokenizer(input);

				int s1 = Integer.parseInt(st.nextToken());
				String islem = st.nextToken();
				int s2 = Integer.parseInt(st.nextToken());

				// perform the required operation.
				if (islem.equals("+")) {
					sonuc = s1 + s2;
				}

				else if (islem.equals("-")) {
					sonuc = s1 - s2;
				} else if (islem.equals("*")) {
					sonuc = s1 * s2;
				} else {
					sonuc = s1 / s2;
				}

				cikan.writeUTF(Integer.toString(sonuc));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
