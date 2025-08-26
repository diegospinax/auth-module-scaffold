package co.pragma.api.mapper.role;

import co.pragma.api.dto.role.ResponseRoleDto;
import co.pragma.api.dto.role.SaveRoleDto;
import co.pragma.api.mapper.role.support.RoleInMapFromDomain;
import co.pragma.api.mapper.role.support.RoleInValueObjectMappers;
import co.pragma.model.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoleInValueObjectMappers.class})
public interface RoleInMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", qualifiedByName = "toRoleName")
    @Mapping(target = "description", qualifiedByName = "toRoleDescription")
    Role createDtoToDomain(SaveRoleDto saveRoleDto);

    @RoleInMapFromDomain
    ResponseRoleDto domainToResponse(Role role);

}
