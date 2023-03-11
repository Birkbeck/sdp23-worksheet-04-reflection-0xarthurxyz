package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DescribeClass {
    public static void main(String[] args) {
        // Attribute(s)
        String suppliedClassName;

        // Validates inputs from command line
        if ( args.length == 1 ) {
            suppliedClassName = args[0]; // e.g. "java.lang.String"
            System.out.println("Usage: " + suppliedClassName);
        } else {
            System.out.println("Argument count: " + args.length + ", max 1 argument.");
            return;
        }

        // - [ ] TODO: implement the functionality for Question 1
        /* Notes:
         * - [ ] emit the interface of the class in Java syntax
         */
        try {
            // Gets class using class loader
            Class<?> suppliedClass = Class.forName(suppliedClassName);

            // Test: Confirm class loader works as expected
            Method[] methods = suppliedClass.getMethods();
            System.out.println(Arrays.toString(methods));

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
