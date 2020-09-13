package ACME.Model;

public class PayDay {

	public String inHour;
	public String outHour;
	public int cost;

	public PayDay(String inHour, String outHour, int cost) {
		super();
		this.inHour = inHour;
		this.outHour = outHour;
		this.cost = cost;
	}

	public PayDay() {
		super();
	}

	public String getInHour() {
		return inHour;
	}

	public void setInHour(String inHour) {
		this.inHour = inHour;
	}

	public String getOutHour() {
		return outHour;
	}

	public void setOutHour(String outHour) {
		this.outHour = outHour;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	};

}
