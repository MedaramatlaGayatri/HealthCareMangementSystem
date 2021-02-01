package Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AppointmentBooking extends Admin{
	private int id;
	Scanner sc = new Scanner(System.in);
	public AppointmentBooking(int id){
		this.id = id;
	}
	public void appointmentScheduling() throws ParseException {
		System.out.println("Enter id");
		if(this.id == sc.nextInt()){
		sc.nextLine();
		System.out.print("Enter Date in 2010-01-04 01:32:27 UTC format");
		String inputDate = sc.nextLine();
		Date from = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(inputDate);
		
	    System.out.print("Enter Date in 2010-01-04 01:32:27 UTC format");
		inputDate = sc.nextLine();
		Date to = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(inputDate);
		HashMap<String,String> dateTime = new HashMap<String,String>();
		String slot = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(from);
		slot = slot +" "+ new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(to);
	    HashMap<String, String> slots = this.getSlotForAppoitment();
	    		slots.put(slot, "vacancy");
	    setSlotForAppoitment(id,slots);
	}else {
		System.out.println("You can't fix other doctor's schedule");
	}
	}
	
	
}
