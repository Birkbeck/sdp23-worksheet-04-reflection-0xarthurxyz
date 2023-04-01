package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DescribeClass {
    public static void main(String[] args) {
        /* 
         * Validates the class name supplied via the command line.
         * The program takes exactly one argument.
         */
        String classNameSuppliedInCLI;
        if ( args.length == 1 ) {
            classNameSuppliedInCLI = args[0]; // e.g. "java.lang.String"
            System.out.println("Usage: " + classNameSuppliedInCLI + "\n" );
        } else {
            System.out.println("Argument count: " + args.length + ", max 1 argument." + "\n" );
            return;
        }

        /* 
         * Emits the interface of the class in Java syntax including
         * - modifiers of the methods, fields, and constructors,
         * - constructors,
         * - methods,
         * - fields,
         */
        try {
            // Loads class
            Class<?> suppliedClass = java.lang.Class.forName(classNameSuppliedInCLI);

            // Prints class fields
            java.lang.reflect.Field[] fields = suppliedClass.getFields();
            System.out.println(  "Fields: " + java.util.Arrays.toString(fields) + "\n"  );
            
            // Prints class constructors including modifiers
            java.lang.reflect.Constructor<?>[] constructors = suppliedClass.getConstructors();
            System.out.println( "Constructors: " + java.util.Arrays.toString(constructors) + "\n" );

            // Prints class methods including modifiers
            java.lang.reflect.Method[] methods = suppliedClass.getMethods();
            System.out.println(  "Methods: " + java.util.Arrays.toString(methods) + "\n" );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
