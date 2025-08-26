package co.pragma.r2dbc.user.mapper;

import co.pragma.model.role.Role;
import co.pragma.model.user.User;
import co.pragma.r2dbc.user.UserEntity;
import co.pragma.r2dbc.user.mapper.support.UserMapDomainToEntity;
import co.pragma.r2dbc.user.mapper.support.UserValueObjectMappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserValueObjectMappers.class })
public interface UserMapper {

    @UserMapDomainToEntity
    UserEntity domainToEntity(User user);

    @Mapping(target = "id", qualifiedByName = "toUserId", source = "entity.id")
    @Mapping(target = "name", qualifiedByName = "toUserName", source = "entity.name")
    @Mapping(target = "lastname", qualifiedByName = "toUserLastname")
    @Mapping(target = "dateBirth", qualifiedByName = "toUserDateBirth")
    @Mapping(target = "address", qualifiedByName = "toUserAddress")
    @Mapping(target = "phoneNumber", qualifiedByName = "toUserPhoneNumber")
    @Mapping(target = "email", qualifiedByName = "toUserEmail")
    @Mapping(target = "salary", qualifiedByName = "toUserSalary")
    @Mapping(target = "role", source = "role")
    User entityToDomain(UserEntity entity, Role role);
}
