package cs143.looking4carryplsjoin.scholarshipsearchengine;

public class LynnwoodScholarship extends Scholarship {
	LynnwoodScholarship(){
		super("LynnwoodScholarship", 2.6, "Any", "Any", 95000, "Any", true, true, 2500);

	}
	@Override
	public void printDescription() {
		System.out.println("LynnwoodScholarship");
		System.out.println("Minimum GPA: 2.6");
		System.out.println("Major: Any");
		System.out.println("Award Amount: $2500 ");
	}
}
