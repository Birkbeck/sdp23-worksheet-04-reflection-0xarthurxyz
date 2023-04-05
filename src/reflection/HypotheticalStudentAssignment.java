package reflection;

public class HypotheticalStudentAssignment {
	// Fields
	private String privateField1;
	private String privateField2;
	private String privateField3;
	private String privateField4;
	private String privateField5; // Fail because there are more than four fields
	public String publicField5; // Fail because there is a non-private field
	// Fail because there is a field of type `ArrayList`
	private java.util.ArrayList<Integer> arrayListField; 

	// Helper methods
	// Fail because there are fewer than two private helper methods
	private void onlyPrivateHelperMethod() {
		System.out.println("Hello, world!");
	}

	// Fail because method returns an `int`
	public int publicMethodThatReturnsInteger() {
		return 0;
	}

	// Fail because method has a `throws` clause
	public void publicMethodThatThrowsException() throws Exception {
		throw new Exception("Hello exception!");
	}

	// Constructor
	// Fail because there is no zero-argument constructor
	public HypotheticalStudentAssignment(String firstArg, String secondArg) {
		this.privateField1 = firstArg;
		this.privateField2 = secondArg;
		this.privateField3 = "!";
		this.privateField4 = "More";
		this.privateField5 = "than four fields";
	}

	public static void main(String[] args) {
		System.out.println("Hello, world!");
	}
}
