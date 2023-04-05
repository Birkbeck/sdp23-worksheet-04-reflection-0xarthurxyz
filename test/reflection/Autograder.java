package reflection;

import org.junit.jupiter.api.Test;

public class Autograder {

    static final String CLASS_NAME = "HypotheticalStudentAssignment.java";

    // Make the tests fail if the class under test has any of the following:
    //    + more than four fields,
    //    + any non-private fields,
    //    + any fields of type `ArrayList`,
    //    + fewer than two private *helper* methods, 
    //    + any method that has a `throws` clause, 
    //    + any method that returns an `int`,
    //    + missing a zero-argument constructor.

    @Test
    public void givenClassName_whenClassHasMoreThanFourFields_thenFail() {
        // TODO: add testing code
    }

    @Test
    public void givenClassName_whenClassHasNonPrivateFields_thenFail() {
        // TODO: add testing code
    }

    @Test
    public void givenClassName_whenClassHasFieldOfTypeArrayList_thenFail() {
        // TODO: add testing code
    }

    @Test
    public void givenClassName_whenClassHasFewerThanTwoPrivateHelperMethods_thenFail() {
        // TODO: add testing code
    }
    
    @Test
    public void givenClassName_whenClassHasAnyMethodThatReturnsAnInteger_thenFail() {
        // TODO: add testing code
    }
    
    @Test
    public void givenClassName_whenClassHasAnyMethodWithThrowsClause_thenFail() {
        // TODO: add testing code
    }

    @Test
    public void givenClassName_whenClassIsMissingZeroArgumentConstructor_thenFail() {
        // TODO: add testing code
    }
}
