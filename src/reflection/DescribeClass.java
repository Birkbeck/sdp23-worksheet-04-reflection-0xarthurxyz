package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DescribeClass {
    public static void main(String[] args) {
        // Attribute(s)
        String suppliedClassName;

        // Validates inputs from command line
        if ( args.length == 1 ) {
            suppliedClassName = args[0]; // e.g. "java.lang.String"
            System.out.println("Usage: " + suppliedClassName + "\n" );
        } else {
            System.out.println("Argument count: " + args.length + ", max 1 argument." + "\n" );
            return;
        }

        // - [ ] TODO: implement the functionality for Question 1
        /* Notes:
         * - [ ] emit the interface of the class in Java syntax
         * interface or class, 
         * - [x] modifiers, 
         * constructors, 
         * methods, 
         * fields; 
         * no method bodies
         */
        try {
            // Gets class using class loader
            Class<?> suppliedClass = Class.forName(suppliedClassName);

            Constructor<?>[] constructors = suppliedClass.getConstructors();
            System.out.println( "Constructors: " + Arrays.toString(constructors) + "\n" );


            // Gets methods defined in class
            Method[] methods = suppliedClass.getMethods();
            System.out.println(  "Methods: " + Arrays.toString(methods) + "\n" );

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
