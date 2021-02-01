package Services;

import java.util.ArrayList;

public class Prescription {
	private int prescriptionId;
	private ArrayList<ArrayList<String>> medicines;;
	public Prescription(int prescriptionId,ArrayList<ArrayList<String>> medicines) {
		super();
		this.prescriptionId = prescriptionId;
		this.medicines = new ArrayList<ArrayList<String>>(medicines);
	}
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public ArrayList<ArrayList<String>> getMedicines() {
		return medicines;
	}
	public void setMedicines(ArrayList<ArrayList<String>> medicines) {
		this.medicines = medicines;
	}
}
