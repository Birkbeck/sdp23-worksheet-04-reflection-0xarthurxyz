package reflection;

import java.util.Arrays;

public class DescribeClass {
    public static void main(String[] args) {
        if ( args.length == 0 ) {
            System.out.println("Argument count: " + args.length + ", too few args supplied.");
        } else {
            System.out.println("Usage: " + Arrays.toString(args)); // TODO: describe how to use the utility
        }

        // TODO: implement the functionality for Question 1
        try {
            Class<?> suppliedClass = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
