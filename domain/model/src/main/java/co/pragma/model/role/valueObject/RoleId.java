package co.pragma.model.role.valueObject;

import co.pragma.model.role.exception.RoleValidationException;

public class RoleId extends RoleField<Long>{
    public RoleId(Long value) {
        super(value);
    }

    @Override
    public void validate() {
        if(value == null) {
            throw new RoleValidationException("Role Id is required");
        }
    }
}
