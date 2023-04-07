package reflection.ToStringExampleClasses;

public class ObjectFields {
    private java.util.List<Integer> testArrayList;

    public ObjectFields(java.util.List<Integer> list) {
        this.testArrayList = list;
    }

    public java.util.List<Integer> getTestArrayList() {
        return testArrayList;
    }

    public static void main(String[] args) {
        java.util.List<Integer> someArrayList = new java.util.ArrayList<Integer>();
        someArrayList.add(1);
        someArrayList.add(10);
        someArrayList.add(100);

        ObjectFields testObj = new ObjectFields(someArrayList);
        System.out.println( reflection.ToString.toString(testObj) );
    }
}
