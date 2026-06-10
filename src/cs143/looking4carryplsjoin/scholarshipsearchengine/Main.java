package cs143.looking4carryplsjoin.scholarshipsearchengine;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

	
public static void main(String[] args) {
	ArrayList<Scholarship> elegibleScholarships = new ArrayList<Scholarship>();
	ArrayList<Scholarship> acceptedScholarships = new ArrayList<Scholarship>();
	CompareScholarships compare = new CompareScholarships();
	Scanner sc = new Scanner(System.in);
	User user;
	String name;
	double GPA;
	String race;
	String gender;
	double income;
	String major;
	boolean isFirstGen;
	boolean isWashingtonResident;
	double scholarshipAmount = 0; //at beginning user has no scholarships + this is for ACCEPTED scholarshisp only
	
	//use static methods to initialize fields to initialize user constructor
	//For TT
	user = new User();			// create new user object
	boolean repeat = true;		// while-loop repeating variable 
	do
	{
		System.out.println("		...::: Scholarship Menu :::...");
		System.out.println("1. Display all eligible scholarships\n"
						+  "2. Fill out user profile\n"
						+  "3. Display all scholarships in system\n"
						+  "4. View user profile\n"
						+  "5. Continue\n");
		System.out.print("Enter the number of choice you'd like to make: ");			
		int choice = sc.nextInt();
		System.out.println();

		switch (choice) {
		case 1:		// call comparescholarshisp and return elegiblescholarships and display + calculate elegiblemoneyamount
			elegibleScholarships = compare.returnEligible(user);
			
			// Add up of all eligible scholarships money
			double elegibleMoneyAmount = 0.00;
			for (int i = 0; i < elegibleScholarships.size(); i++)
			{
				elegibleMoneyAmount += elegibleScholarships.get(i).getScholarshipAmount();
			}
			System.out.println(elegibleMoneyAmount);
			return;
		case 2:		// prompt user to fill out user profile
			// Display menu prompting user for input
			System.out.println("Fill out the forms below");
			name = promptName(sc);
			user.setName(name);
			GPA = promptGPA(sc);
			user.setGPA(GPA);
			race = promptRace(sc);
			user.setRace(race);
			gender = promptGender(sc);
			user.setGender(gender);
			income = promptIncome(sc);
			user.setIncome(income);
			major = promptMajor(sc);
			user.setMajor(major);
			isFirstGen = promptIsFirstGen(sc);
			user.setIsFirstGen(isFirstGen);
			isWashingtonResident = promptIsWashingtonResident(sc);
			user.setIsWashingtonResident(isWashingtonResident);
			return;		// exit case 2
		case 3:		// display all scholarships in system
			compare.displayAllScholarships();
			return;
		case 4:		// printDescription() from user class
			user.printDescription();			// print user profile
			return;		// exit case 4sc
		case 5:		// exit
			repeat = false;
			return;		// exit case 5 and do-while loop
		default:		// loop again
			
		}
		//TODO include exception handling for scanner in user profile
					
	} while(repeat == true);		// End of do-while menu loop
}	// End of main-class
	
	public static String promptName(Scanner sc) {
		String name;
		System.out.print("Enter Name: ");
		name = sc.next();
		return name;
	}
	
	public static Double promptGPA(Scanner sc) {
		double GPA;
		System.out.print("Enter GPA: ");
		GPA = sc.nextDouble();
		
		if (GPA < 0.0) {
			System.out.println("Entered GPA was negative and was set to zero.");
			GPA = 0.0;
		}
		if (GPA > 4.0) {
			System.out.println("Entered GPA was greater than 4.0 and was set to 4.0.");
			GPA = 4.0;
		}
		return GPA;
	}
	
	public static String promptRace(Scanner sc) {
		int choice = 0;
		System.out.println("1. white");
		System.out.println("2. black");
		System.out.println("3. asian");
		System.out.println("Press unlisted numbers to set race as 'other'");
		System.out.print("Choose race: ");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			return "white";
		case 2:
			return "black";
		case 3:
			return "asian";
		default:
			return "other";
		}
		}
	
				public static String promptGender(Scanner sc) {
			System.out.println("Select Gender");
			System.out.println("1. Male");
			System.out.println("2. Female");
			
			System.out.print("Choice: ");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				return "Male";
			case 2:
				return "Female";
			default:
				return "Male";
				
			}
		}
		public static Double promptIncome(Scanner sc) {
			System.out.print("Enter Household Income: ");
			return sc.nextDouble();
		}
		public static String promptMajor(Scanner sc) {
			System.out.print("Enter Major: ");
			sc.nextLine();
			return sc.nextLine();
		}
		public static boolean promptIsFirstGen(Scanner sc) {
			System.out.print("Are you a First Generation College Student? true or false: ");
			return sc.nextBoolean();
		}
		public static boolean promptIsWashingtonResident(Scanner sc) {
			System.out.print("Are you a Washington Resident? true or false: ");
			return sc.nextBoolean();
		}
	


	}
