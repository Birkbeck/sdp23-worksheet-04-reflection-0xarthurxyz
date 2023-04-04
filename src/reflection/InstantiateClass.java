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

            // Enumarate the constructors of the class
            Constructor<?>[] constructors = suppliedClass.getConstructors();
            
            // Identify the constructor(s) with the appropriate parameter count

            // Convert array into ArrayList to delete constructors with wrong parameter count
            // using `java.util.Arrays.asList()`
            java.util.List<Constructor<?>> constructorList = new java.util.LinkedList<Constructor<?>>(
                    java.util.Arrays.asList(constructors));
            
            // You can use `java.lang.reflect.Constructor.getParameterCount()` to get the 
            // number of parameters
            // for (Constructor<?> constructor : constructorList) {
            //     if (constructor.getParameterCount() != argumentCount) {
            //         constructorList.remove(constructor);
            //     }
            // }

            // Use for loop to remove constructors with wrong parameter count
            for (int i = 0; i < constructorList.size(); i++) {
                if (constructorList.get(i).getParameterCount() != argumentCount) {
                    constructorList.remove(i);
                }
            }
            // Invariant: list contains only constructors with the correct parameter count
            

            // Find the parameter types of every constructor and keep the ones that take
            // strings as their only argument
            // You can use `java.lang.reflect.Constructor.getParameterTypes()` to get 
            // the parameter types

            // System.out.println("Argument count is: " + argumentCount); // Debugging

            // Use for loop to remove constructors that take non-string parameters
            for (int i = 0; i < constructorList.size(); i++) {
                // System.out.println("Constructor " + constructorList.get(i).toString() 
                //         + " has " + constructorList.get(i).getParameterTypes().length 
                //         + " parameters"); // Debugging
                for (int j = 0; j < constructorList.get(i).getParameterTypes().length; j++) {
                    if (constructorList.get(i).getParameterTypes()[j] != String.class) {
                        constructorList.remove(i);
                        // System.out.println("Removed: " 
                        //         + constructorList.get(i).toString()); // Debugging
                    }
                    break;
                }
            }
            

            // for (Constructor<?> constructor : constructorList) {
            //     // this removes the constructor from the list if the parameter list is not
            //     // Strings only
            //     for (Class<?> type : constructor.getParameterTypes()) {
            //         if (type != String.class) {
            //             constructorList.remove(constructor);
            //         }
            //     }
            // }

            

            // Use Stream API instead to filter the list
            // constructorList.stream()
            //         .filter(constructor -> java.util.Arrays
            //                 .asList(constructor.getParameterTypes())
            //                 .contains(String.class))
            //         .collect(java.util.stream.Collectors.toList());

            // Create typed argument objects
            // You can use `java.lang.reflect.Constructor.newInstance()` to create an object
            Object[] typedArguments = new Object[argumentCount];
            // Not sure this is the best way to do this
            for (int i = 0; i < argumentCount; i++) {
                typedArguments[i] = args[i + 1];
            }

            // Call the proper constructors that take a string as their only argument
            // You can call a dynamic instructor using: `java.lang.reflect.Constructor.newInstance()`
            
            // There might be multiple constructors that take a string as their only argument
            // so we need to iterate through the list. Incorrect constructors will throw an error
            // so we need to catch it and continue to the next constructor
            for (Constructor<?> constructor : constructorList) {
                try {
                    Object object = constructor.newInstance(typedArguments);
                    System.out.println(object.toString());
                } catch (Exception e) {
                    continue;
                }
            }

        } catch (Exception e) {
            System.err.println(e);
            // System.err.println("Class could not be found");
            System.exit(-1);
        }


        

    }
}
