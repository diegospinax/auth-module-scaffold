package co.pragma.model.user.valueObject;

import static org.junit.jupiter.api.Assertions.*;

import co.pragma.model.user.exception.UserValidationException;
import org.junit.jupiter.api.Test;

public class UserIdTest {

    @Test
    public void validCreationTest() {
        UserId userId = new UserId(1L);
        assertEquals(1, userId.value);
    }

    @Test
    public void nullCreationTest() {
        Exception exception = assertThrows(UserValidationException.class, () -> {
            new UserId(null);
        });
        assertEquals("User id is required.", exception.getMessage());
    }
}
