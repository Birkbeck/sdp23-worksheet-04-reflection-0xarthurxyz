package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DescribeClass {
    public static void main(String[] args) {
        /* 
         * Validates the class name supplied via the command line.
         * The program takes exactly one argument.
         */
        String classNameSuppliedViaCLI; // stores the class name supplied in the command line
        // Checks if the arguments supplied  count is 1
        if ( args.length == 1 ) {
            classNameSuppliedViaCLI = args[0]; // e.g. "java.lang.String"
            System.out.println("Class name: " + "\n" 
                    + classNameSuppliedViaCLI + "\n" );
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
            Class<?> suppliedClass = java.lang.Class.forName(classNameSuppliedViaCLI);

            // Gets the fields, constructors, and methods of the class
            java.lang.reflect.Field[] fields = suppliedClass.getFields(); 
            java.lang.reflect.Constructor<?>[] constructors = suppliedClass.getConstructors();
            java.lang.reflect.Method[] methods = suppliedClass.getMethods();

            // Prints class information to the console
            printArray("Fields", fields);
            printArray("Constructors", constructors);
            printArray("Methods", methods);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void printArray(String description, Object[] array) {
        System.out.println(description + ":"); // Prints the string passed as argument

        Stream.of(array)
                .map( s -> s.toString() )
                .forEach(System.out::println); // Prints every element in the array
        
        System.out.println("\n"); // Adds new line for readability
    }
}
