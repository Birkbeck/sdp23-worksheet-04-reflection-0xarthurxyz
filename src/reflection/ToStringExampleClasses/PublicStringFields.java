package reflection.ToStringExampleClasses;

public class PublicStringFields {
    public String publicStringField1;
    public String publicStringField2;

    public PublicStringFields(String a, String b) {
        this.publicStringField1 = a;
        this.publicStringField2 = b;
    }

    public void setStringFields(String a, String b) {
        this.publicStringField1 = a;
        this.publicStringField2 = b;
    }

    public String getStringField1() {
        return this.publicStringField1;
    }

    public String getStringField2() {
        return this.publicStringField2;
    }

    public static void main(String[] args) {
        PublicStringFields publicStringFields = new PublicStringFields("Hello", "World");
        System.out.println( reflection.ToString.toString(publicStringFields) );
    }
}
