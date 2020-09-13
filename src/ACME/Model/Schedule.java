package ACME.Model;

public class Schedule {
	public String name;
	public String day;
	public String hourIn;
	public String hourOut;
	public int totalHours;

	public Schedule(String name, String day, String hourIn, String hourOut, int totalHours) {
		super();
		this.name = name;
		this.day = day;
		this.hourIn = hourIn;
		this.hourOut = hourOut;
		this.totalHours = totalHours;
	}

	public Schedule() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHourIn() {
		return hourIn;
	}

	public void setHourIn(String hourIn) {
		this.hourIn = hourIn;
	}

	public String getHourOut() {
		return hourOut;
	}

	public void setHourOut(String hourOut) {
		this.hourOut = hourOut;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

}
