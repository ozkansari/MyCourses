package tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack;

public class ProcessClass {

	public String processGoinUp(String value) {

		String values = "0123456789";
		String process = "+-*/";

		char[] valuesArray = value.toCharArray();
		char[] valuesControl = values.toCharArray();
		char[] processArray = process.toCharArray();

		int base = 0;
		int processType = 0;

		for (int i = 0; i < valuesArray.length; i++) {
			for (int j = 0; j < processArray.length; j++) {
				if (processArray[j] == valuesArray[i]) {
					base = i;
					processType = j;
				}
			}
		}

		char endP = ' ';
		String num1 = "";
		String num2 = "";

		for (int i = 0; i < valuesArray.length; i++) {
			for (int j = 0; j < valuesControl.length; j++) {
				if (valuesArray[i] == endP) {
					continue;
				} else if (valuesArray[i] == valuesControl[j] && i < base) {
					num1 = num1 + String.valueOf(valuesArray[i]);
				} else if (valuesArray[i] == valuesControl[j] && i > base) {
					num2 = num2 + String.valueOf(valuesArray[i]);
				}
			}

		}

		double endValue = 0;
		switch (processType) {
		case 0:
			endValue = Double.parseDouble(num1) + Double.parseDouble(num2);
			break;
		case 1:
			endValue = Double.parseDouble(num1) - Double.parseDouble(num2);
			break;
		case 2:
			endValue = Double.parseDouble(num1) * Double.parseDouble(num2);
			break;
		case 3:
			endValue = Double.parseDouble(num1) / Double.parseDouble(num2);
			break;

		default:
			break;
		}
		return value = String.valueOf(endValue);
	}
}
