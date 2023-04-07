package reflection.ToStringExampleClasses;

public class NoFields {
    // Class with no fields

    public NoFields() {}

    public void helloWorldPrinter() {
        System.out.println("Hello world");;
    }

    public static void main(String[] args) {
        NoFields testObj = new NoFields();
        System.out.println( reflection.ToString.toString(testObj) );
    }
}
