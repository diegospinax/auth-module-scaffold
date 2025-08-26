package co.pragma.model.user.valueObject;

import co.pragma.model.user.exception.UserValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserEmailTest {

    @Test
    public void nullTest() {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserEmail(null);
        });
        Assertions.assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    public void invalidEmail() {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserEmail("aeiou@.com");
        });
        Assertions.assertEquals("Invalid email provided.", exception.getMessage());
    }

    @Test
    public void validEmail() {
        UserEmail userEmail = new UserEmail("d@mail.com");
        Assertions.assertEquals("d@mail.com", userEmail.value);
    }
}
