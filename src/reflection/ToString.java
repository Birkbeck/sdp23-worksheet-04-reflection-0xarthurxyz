package reflection;

public class ToString {
    public static String toString(Object obj) {
        // Initialise empty string representation
        String stringRepresentation = "";

        // Loads class that `obj` is an instance of
        Class<?> suppliedClass = obj.getClass();

        // Adds class name that `obj` is an instance of to string representation
        stringRepresentation += "Instance of: "
                + suppliedClass.getName()
                + "\n";

        // Gets declared fields in `obj` class
        java.lang.reflect.Field[] fields = suppliedClass.getDeclaredFields();

        if (fields.length == 0 || fields == null) {
            // If `obj` has no fields
            stringRepresentation += "No fields";
        } else {
            // If `obj` has fields
            // Adds number of fields to string representation
            stringRepresentation += "Number of fields: "
                    + fields.length
                    + "\n";

            stringRepresentation += "Fields and values: \n";
            
            // Adds each field name and value to string representation
            for (java.lang.reflect.Field field : fields) {
                try {
                    // Makes all fields accessible (including private fields)
                    field.setAccessible(true);

                    // Adds field name to string representation
                    stringRepresentation += field.toString() + ": ";

                    // Adds field value to string representation
                    stringRepresentation += field.get(obj);
                } catch (NullPointerException e) {
                    // If the specified object is null and the field is an instance field.
                    // Adds field value as null to string representation
                    stringRepresentation += "null" + " ";
                } catch (IllegalAccessException e) {
                    // If this Field object is enforcing Java language access control and the
                    // underlying field is inaccessible.
                    // Adds field value as inaccessible to string representation
                    // Should never happen as we set all fields to be accessible
                    stringRepresentation += "inaccessible" + " ";
                } catch (IllegalArgumentException e) {
                    // If the specified object is not an instance of the class or interface
                    // declaring the underlying field (or a subclass or implementor thereof).
                    stringRepresentation += "not instance of class" + " ";
                } catch (ExceptionInInitializerError e) {
                    // If the initialization provoked by this method fails.
                    stringRepresentation += "initialization failed" + " ";
                } catch (Exception e) {
                    // If any other exception
                    stringRepresentation += "unknown exception" + " ";
                }
                // Adds new line to for each field
                stringRepresentation += "\n";
            }
            // Remove trailing space
            stringRepresentation = stringRepresentation
                    .substring(0, stringRepresentation.length() - 1);
        }

        // Return beautified string version of `obj`
        return stringRepresentation;
    }
}
