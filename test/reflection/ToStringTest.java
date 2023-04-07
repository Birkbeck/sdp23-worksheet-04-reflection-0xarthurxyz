package reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import reflection.ToStringExampleClasses.PublicStringFields;

public class ToStringTest {

    @Test
    public void givenClassWithPublicStringFields_whenToString_thenReturnStringVersion() {
        Assertions.assertEquals("String publicStringField1: Hello, String publicStringField2: World", 
                                ToString.toString(new PublicStringFields("Hello", "World")));
    }

    @Test
    public void testToString1() {
    }
}
