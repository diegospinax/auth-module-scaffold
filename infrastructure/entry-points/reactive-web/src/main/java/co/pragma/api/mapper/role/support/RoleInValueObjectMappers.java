package co.pragma.api.mapper.role.support;

import co.pragma.model.role.valueObject.RoleDescription;
import co.pragma.model.role.valueObject.RoleId;
import co.pragma.model.role.valueObject.RoleName;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RoleInValueObjectMappers {

    @Named("toRoleId")
    default RoleId toRoleId(Long id) {
        return new RoleId(id);
    }

    @Named("toRoleName")
    default RoleName toRoleName(String name){
        return new RoleName(name);
    }

    @Named("toRoleDescription")
    default RoleDescription toRoleDescription(String description) {
        return new RoleDescription(description);
    }
}
