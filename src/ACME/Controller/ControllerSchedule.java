package ACME.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ACME.Model.PayDay;
import ACME.Model.Schedule;

public class ControllerSchedule {

	// Method to fill a Schedule of the employee
	public ArrayList<Schedule> fillScheduleList(String name, String data[]) {
		ArrayList<Schedule> listSchedule = new ArrayList<Schedule>();

		for (int i = 0; i < data.length; i++) {
			Schedule schedule = new Schedule();
			schedule.setName(name);
			schedule.setDay(data[i].substring(0, 2));
			schedule.setHourIn(data[i].substring(2, 7));
			schedule.setHourOut(data[i].substring(8, 13));
			schedule.setTotalHours(hoursWork(data)[i]);
			listSchedule.add(schedule);
		}

		return listSchedule;
	}

	// Method to get an array of hours of work calculated
	private int[] hoursWork(String schedule[]) {
		int hours[] = new int[schedule.length];
		Long c = new Long(10);
		for (int i = 0; i < schedule.length; i++) {
			String date1 = schedule[i].substring(2, 7);
			String date2 = schedule[i].substring(8, 13);

			c = transformDate(date2).getTime() - transformDate(date1).getTime();

			Long total = ((c / (1000 * 60 * 60)) % 24);
			hours[i] = total.intValue();
		}

		return hours;
	}

	// Method to calculate the Hours of the employee with the discriminated data of
	// PAYDAY object
	public int[] calculateHourWork(ArrayList<Schedule> schedule, ArrayList<PayDay> payRules) {
		int result[] = new int[schedule.size()];
		for (int i = 0; i < schedule.size(); i++) {
			Long initTime = transformDate(schedule.get(i).getHourIn()).getTime();
			Long endTime = transformDate(schedule.get(i).getHourOut()).getTime();
			int workHours = schedule.get(i).getTotalHours();
			for (int j = 0; j < payRules.size(); j++) {
				if (initTime >= transformDate(payRules.get(j).getInHour()).getTime()
						&& endTime <= transformDate(payRules.get(j).getOutHour()).getTime()) {
					result[i] = payRules.get(j).getCost();
				}else if(schedule.get(i).getTotalHours() >= 9) {
					System.out.println("Schedule out of range for: "+ schedule.get(i).getName());
					break;
				}
			}
		}
		return result;
	}

	// Method to get all the Pay to Calculate according the day
	public int getPay(ArrayList<Schedule> schedule, int hoursCalculated[]) {
		int total = 0;

		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getDay().contains("SA") || schedule.get(i).getDay().contains("SU")) {
				total += (hoursCalculated[i] + 5) * schedule.get(i).getTotalHours();
			} else {
				total += hoursCalculated[i] * schedule.get(i).getTotalHours();
			}
		}

		return total;
	}

	// Method to transform a string Hour to a Date Hour
	private Date transformDate(String hour) {
		Date convertido1 = new Date();
		try {
			DateFormat hora = new SimpleDateFormat("HH:mm");
			convertido1 = hora.parse(hour);
		} catch (Exception e) {
			System.out.println("error date:" + e);
		}
		return convertido1;
	}

}
