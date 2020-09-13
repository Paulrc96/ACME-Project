package ACME.Test;

import java.util.ArrayList;

import ACME.Controller.ControllerPayDay;
import ACME.Model.PayDay;
import junit.framework.TestCase;

public class TestControllerPayDay extends TestCase{
	
	private ControllerPayDay controllerPayDay;
	
	public void escenario() {
		controllerPayDay = new ControllerPayDay();
	}
	
	public void testFillPayDayList() {
		
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
	
		assertEquals(3, payRules.size());
	}
	
}
