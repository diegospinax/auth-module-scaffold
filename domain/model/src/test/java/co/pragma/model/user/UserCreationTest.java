package co.pragma.model.user;


import static org.junit.jupiter.api.Assertions.*;

import co.pragma.model.role.Role;
import co.pragma.model.role.valueObject.RoleDescription;
import co.pragma.model.role.valueObject.RoleId;
import co.pragma.model.role.valueObject.RoleName;
import co.pragma.model.user.valueObject.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserCreationTest {

    @Test
    public void creationValidation() {
        User user = new User(
                null,
                new UserName("Danna"),
                new UserLastname("García"),
                new UserDateBirth(LocalDate.of(2003, 12, 8)),
                new UserAddress("Calle_12_#54-12._Bogotá,_Colombia"),
                new UserPhoneNumber("3103920186"),
                new UserEmail("d@mail.com"),
                new UserSalary(1_000_000d),
                new Role(new RoleId(1L), new RoleName("ADMIN"), new RoleDescription("Admin default role."))
        );

        assertNull(user.id());
        assertEquals("DANNA", user.name().value);
        assertEquals("GARCÍA", user.lastname().value);
        assertEquals(2003, user.dateBirth().value.getYear());
        assertEquals("CALLE_12_#54-12._BOGOTÁ,_COLOMBIA", user.address().value);
        assertEquals("3103920186", user.phoneNumber().value);
        assertEquals("d@mail.com", user.email().value);
        assertEquals(1000000d, user.salary().value);
        assertEquals(1, user.role().id().value);
        assertEquals("ADMIN", user.role().name().value);
        assertEquals("Admin default role.", user.role().description().value);
    }
}
