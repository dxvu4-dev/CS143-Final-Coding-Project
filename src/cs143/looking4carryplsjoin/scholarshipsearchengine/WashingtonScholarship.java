package cs143.looking4carryplsjoin.scholarshipsearchengine;

public class WashingtonScholarship extends Scholarship {
         WashingtonScholarship(){
		super("WashingtonScholarship", 3.5, "Any", "Any", 100000, "Any", false, true, 3000);
	}

	@Override
	public void printDescription() {
		System.out.println("Washington Scholarship");
		System.out.println("Minimum GPA: 2.5");
		System.out.println("Major: Any");
		System.out.println("Award Amount: $3000");
		
	}
}
