package cs143.looking4carryplsjoin.scholarshipsearchengine;

public abstract class Scholarship {
	//private fields
	private double GPA;
	private String race;
	private String gender;
	private double income;
	private String major;
	private boolean isFirstGenImmigrant;
	private boolean isWashingtonResident;
	//default constructor
	Scholarship() {
		this(0.0, "White", "Male", 0.0, "Business", false, false);
	}
	//parameterized constructor
	Scholarship(double GPA, String race, String gender, double income, String major, boolean isFirstGenImmigrant, boolean isWashingtonResident) {
		this.GPA = GPA;
		this.race = race;
		this.gender = gender;
		this.income = income;
		this.major = major;
		this.isFirstGenImmigrant = isFirstGenImmigrant;
		this.isWashingtonResident = isWashingtonResident;
	}
	//setter methods
		
	//getter methods
}
