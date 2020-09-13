package ACME.Views;

import java.util.ArrayList;

import ACME.Controller.ControllerPayDay;
import ACME.Controller.ControllerSchedule;
import ACME.Controller.TexxtReader;
import ACME.Model.Schedule;

public class main {
	
	public static void main(String[] args) {

		ControllerPayDay cpd = new ControllerPayDay();
		ControllerSchedule cs = new ControllerSchedule();
		TexxtReader tx = new TexxtReader();
		
		try {
			// ---------------Phase 1: Read and divide the name from the Schedule--------------------**
			// -Part 1: Read the file and split into many arrays-------------------------------------
			String a = tx.readTxt(System.getProperty("user.dir") + "/src/input.txt");
			String arrFrst1[] = a.split(";");
			// -Part 2: create a for to make many query of employees--------------------------------
			for (int i = 0; i < arrFrst1.length; i++) {
				// -Part 3: Divide the name from the schedule introduced---------------------------- 
				String name = tx.separedObjects(arrFrst1[i])[0];
				String arrfc[] = tx.separedObjects(arrFrst1[i])[1].split(",");
				// ---------------Phase 2: Calculate the total to Pay --------------------------------**
				// -Part 1: Create an ArrayList of the object Schedule------
				ArrayList<Schedule> schedule = cs.fillScheduleList(name, arrfc);
				// -Part 2: Make an Array of hours with the discriminate in the hours what he
				// worked
				int hours[] = cs.calculateHourWork(schedule, cpd.fillPayDayList());
				// -Part 3: Print the result according the days what he worked
				System.out.println("The amount to Pay " + name + " is: " + cs.getPay(schedule, hours));
			}
			// --------------------------END-----------------------------------------------------
		} catch (Exception e) {
			System.out.println("error date:" + e);
		}

	}

}
