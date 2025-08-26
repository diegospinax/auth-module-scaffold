package co.pragma.model.user.valueObject;

import co.pragma.model.user.exception.UserValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAddressTest {

    @Test
    public void nullTest () {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserAddress(null);
        });
        Assertions.assertEquals("Address is required.", exception.getMessage());
    }

    @Test
    public void validAddress() {
        UserAddress userAddress = new UserAddress("Calle_16_#75-10._Manizales,_Colombia");
        Assertions.assertEquals("CALLE_16_#75-10._MANIZALES,_COLOMBIA", userAddress.value);
    }

    @Test
    public void invalidAddress () {
        Exception exception = Assertions.assertThrows(UserValidationException.class, () -> {
            new UserAddress("Calle_27_#30-02._Bogotá121,_Colombia");
        });
        Assertions.assertEquals("Invalid address provided.", exception.getMessage());
    }


}
