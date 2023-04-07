package reflection.ToStringExampleClasses;

public class PrivateStringFields {
    private String privateStringField1;
    private String privateStringField2;

    public PrivateStringFields(String a, String b) {
        this.privateStringField1 = a;
        this.privateStringField2 = b;
    }

    public void setStringFields(String a, String b) {
        this.privateStringField1 = a;
        this.privateStringField2 = b;
    }

    public String getStringField1() {
        return this.privateStringField1;
    }

    public String getStringField2() {
        return this.privateStringField2;
    }

    public static void main(String[] args) {
        PrivateStringFields privateStringFields = new PrivateStringFields("Hello", "World");
        System.out.println( reflection.ToString.toString(privateStringFields) );
    }
}
