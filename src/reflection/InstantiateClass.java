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

            // Find the parameter types of every constructor and keep the ones that take
            // strings as their only argument
            // You can use `java.lang.reflect.Constructor.getParameterTypes()` to get 
            // the parameter types
            for (Constructor<?> constructor : constructorList) {
                // this removes the constructor from the list if the parameter list is not
                // Strings only
                for (Class<?> type : constructor.getParameterTypes()) {
                    if (type != String.class) {
                        constructorList.remove(constructor);
                    }
                }
                // this does not remove the constructor from the list, only remove it from
                // the parameter list
                // java.util.List<Class<?>> paramerterList = java.util.Arrays.asList(
                //         constructor.getParameterTypes());
                // paramerterList.removeIf(type -> type != String.class); 
            }

            // Use Stream API instead to filter the list
            // constructorList.stream()
            //         .filter(constructor -> java.util.Arrays
            //                 .asList(constructor.getParameterTypes())
            //                 .contains(String.class))
            //         .collect(java.util.stream.Collectors.toList());

            // Create typed argument objects

            // Call the proper constructors that take a string as their only argument
            // You can call a dynamic instructor using: `java.lang.reflect.Constructor.newInstance()`
            

        } catch (Exception e) {
            System.err.println("Class could not be found");
            System.exit(-1);
        }


        

    }
}
