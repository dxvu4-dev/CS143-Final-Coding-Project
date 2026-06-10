package cs143.looking4carryplsjoin.scholarshipsearchengine;
import java.util.ArrayList;
import java.util.List;
public class CompareScholarships {
	//private fields
	ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>(); //option 1: initialize immediately
	
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
	
    //Remove scholarship from list if:
    //Race, Gender, Major are not "Any" and do not match user inputs
    //if user gpa less than scholarship minimum gpa
    //if user income greater than maximum income for scholarship
    //if user is not WA resident and scholarship requires WA residence
    //if user is first gen and scholarship requires not first gen
    public ArrayList<Scholarship> returnEligible(User user) {
		fillScholarships();
        for (Scholarship ss : scholarships) {
            if (user.getGPA() <= ss.getGPA()) {
                scholarships.remove(ss);
            }
            else if (user.getIncome() >= ss.getIncome()) {
                scholarships.remove(ss);
            }
            else if ((!ss.getRace().toLowerCase().equals("any")) && (!ss.getRace().toLowerCase().equals(user.getRace()))) {
                scholarships.remove(ss);
            }
            else if ((!ss.getGender().toLowerCase().equals("any")) && (!ss.getGender().toLowerCase().equals(user.getGender()))) {
                scholarships.remove(ss);
            }
            else if ((!ss.getMajor().toLowerCase().equals("any")) && (!ss.getMajor().toLowerCase().equals(user.getMajor()))) {
                scholarships.remove(ss);
            }
            else if ((user.getIsWashingtonResident() == false) && (ss.getIsWashingtonResident() == true)) {
                scholarships.remove(ss);
            }
            else if ((user.getIsFirstGen() == true) && (ss.getIsFirstGen() == false)) {
                scholarships.remove(ss);
            }
        }
        
        return scholarships;
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
}
