package co.pragma.model.user.valueObject;

import co.pragma.model.user.exception.UserValidationException;

public class UserId extends UserField<Long>{

    public UserId(Long value) {
        super(value);
    }

    @Override
    public void validate() {
        if (value == null){
            throw new UserValidationException("User id is required.");
        }
    }
}
