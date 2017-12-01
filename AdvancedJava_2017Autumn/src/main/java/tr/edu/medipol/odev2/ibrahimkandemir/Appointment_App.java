package tr.edu.medipol.odev2.ibrahimkandemir;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// 110

// Menu bonus (+10)
// Hata kontrolu (-5)
// Guzel kod (+5)

public class Appointment_App {

	static Scanner screenReader = new Scanner(System.in);
	static List<String> appointmentList = new ArrayList<String>();
	static SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH.mm");
	static int processNumber;
	static int registerCount = 0;
	static String appointmentName;
	static String rendezvous;
	static String appointmentDateTime;

	public static void main(String[] args) {
		while (true) {

			long startProgram = System.currentTimeMillis();
			AppointmentAppMenu();

			switch (processNumber) {
			case 1:
				AppointmentRegister();
				break;
			case 2:
				try {
					AppointmentListView();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				long finishProgram = System.currentTimeMillis();
				long dif = finishProgram - startProgram;
				System.out.println("Worked up to " + dif / 1000 + " second application.");
				System.exit(1);
				break;
			default:
				System.out.println("You made the incorrect entry, try again");
			}

		}
	}

	public static void AppointmentAppMenu() {
		System.out.println("");
		System.out.println("Appointment System - Welcome");
		System.out.println("");

		System.out.println("To create a new appointment:.......1");
		System.out.println("To view the appointments:..........2");
		System.out.println("To exit the application:...........3\n");

		System.out.print("Enter the transaction number: ");
		processNumber = screenReader.nextInt();

	}

	public static void AppointmentRegister() {
			if (registerCount < 5) {
			screenReader.nextLine();
			System.out.print("Appointment Name: ");
			appointmentName = screenReader.nextLine();

			System.out.print("Rendezvous: ");
			rendezvous = screenReader.nextLine();

			System.out.print("Your appointment time (DD.MM.YYYY AT HH.MM) enter in the format: ");
			appointmentDateTime = screenReader.nextLine();

			appointmentList.add(appointmentName);
			appointmentList.add(rendezvous);
			appointmentList.add(appointmentDateTime);

			registerCount++;
		}else {
			System.out.println("You can only add five records to the appointment system.");
	
			}
	}

	public static void AppointmentListView() throws ParseException {
		int index = 0;
		while(true) {
			if(index >= appointmentList.size()) {
				return;
			}else {			
				System.out.println("***********************************");
				System.out.println("Appointment name: " + appointmentList.get(index));
				index ++;
				System.out.println("Rendezvous: " + appointmentList.get(index));
				index ++;
				Date dateNow = formatDate.parse(appointmentList.get(index));
				System.out.println("Appointment time: " + formatDate.format(dateNow));
				index ++;
				System.out.println("***********************************");
			}
		}
	}
}
