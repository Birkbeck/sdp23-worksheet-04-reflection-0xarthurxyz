package reflection.ToStringExampleClasses;

public class ProtectedStringFields {
    protected String protectedStringField1;
    protected String protectedStringField2;

    public ProtectedStringFields(String a, String b) {
        this.protectedStringField1 = a;
        this.protectedStringField2 = b;
    }

    public void setStringFields(String a, String b) {
        this.protectedStringField1 = a;
        this.protectedStringField2 = b;
    }

    public String getStringField1() {
        return this.protectedStringField1;
    }

    public String getStringField2() {
        return this.protectedStringField2;
    }

    public static void main(String[] args) {
        ProtectedStringFields protectedStringFields = new ProtectedStringFields("Hello", "World");
        System.out.println( reflection.ToString.toString(protectedStringFields) );
    }
}
