package cs143.looking4carryplsjoin.scholarshipsearchengine;
import java.util.ArrayList;
import java.util.List;
public class CompareScholarships {
	//private fields
	ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>();
    ArrayList<Scholarship> eligibleSchol = new ArrayList<Scholarship>();
	
	private void fillScholarships() {
		scholarships.add(new MicrosoftScholarship());
		scholarships.add(new AfricanAmericanScholarship());
		scholarships.add(new AsianAmericanScholarship());
		scholarships.add(new BusinessScholarship());
		scholarships.add(new EverettScholarship());
		scholarships.add(new LynnwoodScholarship());
		scholarships.add(new MukilteoScholarship());
		scholarships.add(new NursingScholarship());
		scholarships.add(new WashingtonScholarship());
		scholarships.add(new WomenInStemScholarship());
	}
	
    //Add scholarship to returned list if all return false:
    //Race, Gender, Major are not "Any" and do not match user inputs
    //if user gpa less than scholarship minimum gpa
    //if user income greater than maximum income for scholarship
    //if user is not WA resident and scholarship requires WA residence
    //if user is first gen and scholarship requires not first gen
    public ArrayList<Scholarship> returnEligible(User user) {
		fillScholarships();
        boolean eligibleForScholarship = true;
        for (Scholarship ss : scholarships) {
            if (user.getGPA() <= ss.getGPA()) {
                eligibleForScholarship = false;
            }
            else if (user.getIncome() >= ss.getIncome()) {
                eligibleForScholarship = false;
            }
            else if ((!ss.getRace().toLowerCase().equals("any")) && (!ss.getRace().toLowerCase().equals(user.getRace()))) {
                eligibleForScholarship = false;
            }
            else if ((!ss.getGender().toLowerCase().equals("any")) && (!ss.getGender().toLowerCase().equals(user.getGender()))) {
                eligibleForScholarship = false;
            }
            else if ((!ss.getMajor().toLowerCase().equals("any")) && (!ss.getMajor().toLowerCase().equals(user.getMajor()))) {
                eligibleForScholarship = false;
            }
            else if ((user.getIsWashingtonResident() == false) && (ss.getIsWashingtonResident() == true)) {
                eligibleForScholarship = false;
            }
            else if ((user.getIsFirstGen() == true) && (ss.getIsFirstGen() == false)) {
                eligibleForScholarship = false;
            }
            if (eligibleForScholarship = true) {
                eligibleSchol.add(ss);
            }
        }
        return eligibleSchol;
    }

	// Display all scholarships in CompareScholarships
	public void displayAllScholarships()
	{
		fillScholarships();
		for (Scholarship ss: scholarships)
		{
			ss.printDescription();
			System.out.println();		
		}
	}

    // Display all eligible scholarships after compared
	public void displayEligibleScholarships()
	{
		for (Scholarship ss: eligibleSchol)
		{
			ss.printDescription();
			System.out.println();		
		}
	}
}
