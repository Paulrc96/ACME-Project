package ACME.Controller;

import java.util.ArrayList;

import ACME.Model.PayDay;

public class ControllerPayDay {

	// Method to fill an ArrayList of PayDay Object with the discriminating data to
	// use
	public ArrayList<PayDay> fillPayDayList() {
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
		return payRules;
	}

}
