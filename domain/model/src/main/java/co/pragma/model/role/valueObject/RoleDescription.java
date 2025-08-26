package co.pragma.model.role.valueObject;

import co.pragma.model.role.exception.RoleValidationException;

public class RoleDescription extends RoleField<String>{

    public RoleDescription(String value) {
        super(value);
    }

    @Override
    public void validate() {
        String regex = "^[a-zA-Z0-9]+([ _-]|, )[a-zA-Z0-9]+(([ _-]|, )[a-zA-Z0-9]+)*\\.?$";

        if(value == null)
            throw new RoleValidationException("Role description is required.");
        if(!value.matches(regex)) {
            throw new RoleValidationException("Role description must only contain letters, numbers, comma and period.");
        }
    }
}
