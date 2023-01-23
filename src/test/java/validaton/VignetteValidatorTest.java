package validaton;

import hu.fenyvesvolgyimate.tollsystem.exception.InvalidRegistrationNumberException;
import hu.fenyvesvolgyimate.tollsystem.validaton.VignetteValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VignetteValidatorTest {
    VignetteValidator validator = new VignetteValidator();
    @Test
    public void testInvalidRegistrationNumberJsonString(){
        String invalidJsonString = """
                { "registrationNumber" : "ABC-123"
                """;
        assertThrowsExactly(InvalidRegistrationNumberException.class,() ->
                validator.validateRegistrationNumberJsonString(invalidJsonString));

        String validJsonWithoutRegistrationNumber = """
                {"asd" : "asd"}
                """;
        assertThrowsExactly(InvalidRegistrationNumberException.class,() ->
                validator.validateRegistrationNumberJsonString(invalidJsonString));
    }

}