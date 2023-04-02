package reflection;

import java.lang.reflect.Constructor;

public class InstantiateClass {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: Cannot instantiate class without supplying a class name");
            System.exit(-1);
        }
        
        // TODO: implement the functionality for Question 2
        String classNameSuppliedViaCLI = args[0];
        int argumentCount = args.length - 1; // -1 for the class name

        try {
            // Loads class
            Class<?> suppliedClass = java.lang.Class.forName(classNameSuppliedViaCLI);

            // Enumarete the constructors of the class
            Constructor<?>[] constructors = suppliedClass.getConstructors();
            
            // Identify the constructor(s) with the appropriate parameter count

            // Convert array into ArrayList to delete constructors with wrong parameter count
            // using `java.util.Arrays.asList()`
            java.util.List<Constructor<?>> constructorList = java.util.Arrays.asList(constructors);

            // You can use `java.lang.reflect.Constructor.getParameterCount()` to get the 
            // number of parameters
            for (Constructor<?> constructor : constructorList) {
                if (constructor.getParameterCount() != argumentCount) {
                    constructorList.remove(constructor);
                }
            }
            // Invariant: list contains only constructors with the correct parameter count

            // Find the parameter types
            // You can use `java.lang.reflect.Constructor.getParameterTypes()` to get 
            // the parameter types

            // Create typed argument objects

            // Call the proper constructors that take a string as their only argument
            // You can call a dynamic instructor using: `java.lang.reflect.Constructor.newInstance()`
            

        } catch (Exception e) {
            System.err.println("Class could not be found");
            System.exit(-1);
        }


        

    }
}
