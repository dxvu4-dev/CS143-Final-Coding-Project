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
		boolean repeat;		// while-loop repeating variable 
		do
		{
			System.out.println("	...::: Scholarship Menu :::...");
	
			System.out.println("1. Fill out user profile\n"
							+  "2. View user profile\n"
							+  "3. View all scholarships in system\n"
							+  "4. View eligible scholarships\n"
							+  "5. Accept scholarships\n"
							+  "6. View accepted scholarships\n"
							+  "7. Exit program\n");
			System.out.print("Enter the number next to the choice you'd like to make: ");			
			int choice = sc.nextInt();
			System.out.println();
	
			switch (choice) {
			case 1:		// Fill out user profile
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
				
				// Find eligible scholarships that matches user profile
				elegibleScholarships = compare.returnEligible(user);
	
				break;		// exit case 1
				
			case 2:		// View user profile
				user.printDescription();			// print user profile
				System.out.println();
				
				break;		// exit case 2
				
			case 3:		// Display scholarships in system
				compare.displayAllScholarships();
				
				break;		// exit case 3
				
			case 4:		// View eligible scholarships to user and print out total eligible amount of scholarship money			
				// Add up all of eligible scholarships money
				double elegibleMoneyAmount = 0.00;
				System.out.println("	...::: Eligible Scholarships :::...");
				for (int i = 0; i < elegibleScholarships.size(); i++)
				{
					elegibleScholarships.get(i).printDescription();
					System.out.println();
					elegibleMoneyAmount += elegibleScholarships.get(i).getScholarshipAmount();
				}
				System.out.println("You're eligible for $" + elegibleMoneyAmount + " total!");
				
				break;		// exit case 4
				
			case 5:		// User select scholarships from elegibleScholarships to move to acceptedScholarships
				for (int i = 0; i < acceptedScholarships.size(); i++)
				{
					elegibleScholarships.get(i).printDescription();	// Display current eligible scholarship
					// Prompt user to add to acceptedScholarships or not
					System.out.println("Would you like to accept this scholarship? Enter 1 for YES or 2 for NO");
					choice = sc.nextInt();
					if (choice == 1) // Add current scholarship to acceptedScholarships
					{
						acceptedScholarships.add(elegibleScholarships.get(i));
						scholarshipAmount += acceptedScholarships.get(i).getScholarshipAmount();
						System.out.println("You have just accepted " + acceptedScholarships.get(i).getName());
					}
					else continue;	// Reject current scholarship for any other value
				}
				
				break;		// exit case 5
				
			case 6:		// Display acceptedScholarships along with total scholarship money
				// Loops through and prints all scholarships in acceptedScholarships
				for (Scholarship ss: acceptedScholarships)
				{
					ss.printDescription();
					System.out.println();		
				}
				System.out.println("You've earned $" + scholarshipAmount + " total from scholarships!");
				
				break;		// exit case 6
				
			case 7:		// Exit program
				repeat = false;
				
				return;		// exit case 7 and do-while loop
				
			default:		// loop again
			}
			repeat = true;	// loop variable -- repeat this menu until user chooses case 5
			//TODO include exception handling for scanner in user profile
						
		} while(repeat == true);		// End of do-while menu loop
	}	// End of main
	
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
