package ACME.Test;

import java.util.ArrayList;
import ACME.Controller.ControllerSchedule;
import ACME.Model.PayDay;
import ACME.Model.Schedule;
import junit.framework.TestCase;

public class TestControllerSchedule extends TestCase{
	private ControllerSchedule controllerSchedule;
	
	public void escenario() {
		controllerSchedule = new ControllerSchedule();
	}
	
	public void testFillScheduleList() {
		escenario();
		
		String name = "PEDRO";
		String[] data = {"MO10:00-12:00", "MO10:00-12:00"};
		
		ArrayList<Schedule> listScheduletest = controllerSchedule.fillScheduleList(name, data);
		
		assertEquals(2, listScheduletest.size());
	}
	
	public void testCalculateHourWork() {

		escenario();
		// Create an Array List of Schedule
		ArrayList<Schedule> listScheduletest = new ArrayList<Schedule>();
		Schedule schedule = new Schedule();
		schedule.setName("MANUEL");
		schedule.setDay("MO");
		schedule.setHourIn("10:00");
		schedule.setHourOut("12:00");
		schedule.setTotalHours(2);
		listScheduletest.add(schedule);
		
		Schedule schedule1 = new Schedule();
		schedule1.setName("MANUEL");
		schedule1.setDay("TU");
		schedule1.setHourIn("10:00");
		schedule1.setHourOut("12:00");
		schedule1.setTotalHours(2);
		listScheduletest.add(schedule1);
		
		// Create an Array List of PayDay
		
		ArrayList<PayDay> payRules = new ArrayList<PayDay>();
		PayDay py = new PayDay();
		py.setInHour("00:00");
		py.setOutHour("09:00");
		py.setCost(25);
		payRules.add(py);
		PayDay py1 = new PayDay();
		py1.setInHour("09:01");
		py1.setOutHour("18:00");
		py1.setCost(15);
		payRules.add(py1);
		PayDay py2 = new PayDay();
		py2.setInHour("18:01");
		py2.setOutHour("23:59");
		py2.setCost(20);
		payRules.add(py2);
		
		int[] hours = {15, 15};
		int[] hoursTest = controllerSchedule.calculateHourWork(listScheduletest, payRules);
		
		assertEquals(hours[0], hoursTest[0]);
	}
	
	public void testGetPay() {
		
		escenario();
		// Create an Array List of Schedule
		ArrayList<Schedule> listScheduletest = new ArrayList<Schedule>();
		Schedule schedule = new Schedule();
		schedule.setName("MANUEL");
		schedule.setDay("MO");
		schedule.setHourIn("10:00");
		schedule.setHourOut("12:00");
		schedule.setTotalHours(2);
		listScheduletest.add(schedule);
		
		Schedule schedule1 = new Schedule();
		schedule1.setName("MANUEL");
		schedule1.setDay("TU");
		schedule1.setHourIn("10:00");
		schedule1.setHourOut("12:00");
		schedule1.setTotalHours(2);
		listScheduletest.add(schedule1);
		
		int[] hours = {15, 15};
		
		int payTest = controllerSchedule.getPay(listScheduletest, hours);
		
		assertEquals(60, payTest);
		
	}
	
	
	
	
	

}
