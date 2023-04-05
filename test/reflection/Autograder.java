package reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Autograder {
    // Make the tests fail if the class under test has any of the following:
    //    + more than four fields,
    //    + any non-private fields,
    //    + any fields of type `ArrayList`,
    //    + fewer than two private *helper* methods, 
    //    + any method that has a `throws` clause, 
    //    + any method that returns an `int`,
    //    + missing a zero-argument constructor.

    static final String CLASS_NAME = "HypotheticalStudentAssignment";
    static final String PACKAGE_NAME = "reflection";
    static final String SUPPLIED_CLASS_NAME = PACKAGE_NAME + "." + CLASS_NAME;
    static Class<?> SUPPLIED_CLASS = null; 
    // remember this cannot be `final` because it is set in `setUp()` and
    // `final` attributes cannot be overridden/modified.

    @BeforeEach
    public void setUp() {
        try {
            // Gets class using class loader
            SUPPLIED_CLASS = java.lang.Class.forName(SUPPLIED_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            // Catches exception if class is not found
            System.err.println(e);
            System.exit(-1);
        }
    }

    @Test
    public void givenClassName_whenClassHasMoreThanFourFields_thenFail() {
        Assertions.assertTrue(SUPPLIED_CLASS.getFields().length <= 4);
    }

    @Test
    public void givenClassName_whenClassHasNonPrivateFields_thenFail() {
        // `getFields()` returns an array with all accessible fields for the class.
        // `getDeclaredFields()` returns an array with all declared fields for the class,
        //  including all private fields.
        Assertions.assertTrue(SUPPLIED_CLASS.getFields().length > 0);
    }

    @Test
    public void givenClassName_whenClassHasFieldOfTypeArrayList_thenFail() {
        for (java.lang.reflect.Field field : SUPPLIED_CLASS.getDeclaredFields()) {
            Assertions.assertFalse( field.getType().equals( java.util.ArrayList.class ) );
        }
    }

    @Test
    public void givenClassName_whenClassHasFewerThanTwoPrivateHelperMethods_thenFail() {
        // `getMethods()` returns an array with all accessible methods for the class.
        // `getDeclaredMethods()` returns an array with all declared methods for the class,
        //  including all private methods.
        Assertions.assertTrue((SUPPLIED_CLASS.getDeclaredMethods().length 
                - SUPPLIED_CLASS.getMethods().length) >= 2);
    }
    
    @Test
    public void givenClassName_whenClassHasAnyMethodThatReturnsAnInteger_thenFail() {
        for (java.lang.reflect.Method method : SUPPLIED_CLASS.getDeclaredMethods()) {
            Assertions.assertFalse( method.getReturnType().equals( java.lang.Integer.class ) );
        }
    }
    
    @Test
    public void givenClassName_whenClassHasAnyMethodWithThrowsClause_thenFail() {
        for (java.lang.reflect.Method method : SUPPLIED_CLASS.getDeclaredMethods()) {
            Assertions.assertTrue( method.getExceptionTypes().length == 0 );
        }
    }

    @Test
    public void givenClassName_whenClassIsMissingZeroArgumentConstructor_thenFail() {
        for (java.lang.reflect.Constructor<?> constructor : SUPPLIED_CLASS.getConstructors()) {
            if ( constructor.getParameterCount() == 0 ) {
                Assertions.assertTrue( true );
            } else {
                Assertions.assertTrue( false );
            }
        }
    }
}
