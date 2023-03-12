package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DescribeClass {
    public static void main(String[] args) {
        // Validates inputs from command line
        String suppliedClassName;
        if ( args.length == 1 ) {
            suppliedClassName = args[0]; // e.g. "java.lang.String"
            System.out.println("Usage: " + suppliedClassName + "\n" );
        } else {
            System.out.println("Argument count: " + args.length + ", max 1 argument." + "\n" );
            return;
        }

        /* Notes:
         * 
         * Emit the interface of the class in Java syntax:
         * - [x] modifiers (with getConstructors())
         * - [x] constructors, 
         * - [x] methods, 
         * - [ ] fields; 
         * - [x] no method bodies
         */
        try {
            // Gets class using class loader
            Class<?> suppliedClass = java.lang.Class.forName(suppliedClassName);

            // Prints class fields
            
            // Prints class constructors including modifiers
            Constructor<?>[] constructors = suppliedClass.getConstructors();
            System.out.println( "Constructors: " + java.util.Arrays.toString(constructors) + "\n" );

            // Prints class methods including modifiers
            Method[] methods = suppliedClass.getMethods();
            System.out.println(  "Methods: " + java.util.Arrays.toString(methods) + "\n" );

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
