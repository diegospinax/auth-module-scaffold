package co.pragma.model.role;

import co.pragma.model.role.exception.RoleValidationException;
import co.pragma.model.role.valueObject.RoleDescription;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoleDescriptionTest {

    @Test
    public void nullTest() {
        Exception exception = Assertions.assertThrows(RoleValidationException.class, () -> {
            new RoleDescription(null);
        });
        Assertions.assertEquals("Role description is required.", exception.getMessage());
    }

    @Test
    public void invalidRoleDescriptionProvidedTest() {
        Exception exception = Assertions.assertThrows(RoleValidationException.class, () -> {
           new RoleDescription("");
        });
        Assertions.assertEquals("Role description must only contain letters, numbers, comma and period.", exception.getMessage());
    }

    @Test
    public void validRoleDescriptionTest() {
        RoleDescription description = new RoleDescription("Employee User Role, area 12.");
        Assertions.assertEquals("Employee User Role, area 12.", description.value);
    }
}
