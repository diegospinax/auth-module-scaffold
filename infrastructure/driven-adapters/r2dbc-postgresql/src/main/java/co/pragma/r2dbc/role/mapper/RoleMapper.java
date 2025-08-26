package co.pragma.r2dbc.role.mapper;

import co.pragma.model.role.Role;
import co.pragma.r2dbc.role.RoleEntity;
import co.pragma.r2dbc.role.mapper.support.RoleMapFromDomain;
import co.pragma.r2dbc.role.mapper.support.RoleValueObjectMappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoleValueObjectMappers.class})
public interface RoleMapper {

    @RoleMapFromDomain
    RoleEntity domainToEntity(Role role);

    @Mapping(target = "id", qualifiedByName = "toRoleId")
    @Mapping(target = "name", qualifiedByName = "toRoleName")
    @Mapping(target = "description", qualifiedByName = "toRoleDescription")
    Role entityToDomain(RoleEntity roleEntity);
}
