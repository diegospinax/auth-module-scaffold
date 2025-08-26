package co.pragma.api.mapper.user;

import co.pragma.api.dto.user.ResponseUserDto;
import co.pragma.api.dto.user.SaveUserDto;
import co.pragma.api.mapper.user.support.UserInMapToResponse;
import co.pragma.api.mapper.user.support.UserInValueObjectMappers;
import co.pragma.model.role.Role;
import co.pragma.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserInValueObjectMappers.class })
public interface UserInMapper {

    @UserInMapToResponse
    ResponseUserDto toResponseDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", qualifiedByName = "toUserName", source = "saveDto.name")
    @Mapping(target = "lastname", qualifiedByName = "toUserLastname")
    @Mapping(target = "dateBirth", qualifiedByName = "toUserDateBirth")
    @Mapping(target = "address", qualifiedByName = "toUserAddress")
    @Mapping(target = "phoneNumber", qualifiedByName = "toUserPhoneNumber")
    @Mapping(target = "email", qualifiedByName = "toUserEmail")
    @Mapping(target = "salary", qualifiedByName = "toUserSalary")
    @Mapping(target = "role", source = "role")
    User createDtoToDomain(SaveUserDto saveDto, Role role);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", qualifiedByName = "toUserName", source = "saveDto.name")
    @Mapping(target = "lastname", qualifiedByName = "toUserLastname")
    @Mapping(target = "dateBirth", qualifiedByName = "toUserDateBirth")
    @Mapping(target = "address", qualifiedByName = "toUserAddress")
    @Mapping(target = "phoneNumber", qualifiedByName = "toUserPhoneNumber")
    @Mapping(target = "email", qualifiedByName = "toUserEmail")
    @Mapping(target = "salary", qualifiedByName = "toUserSalary")
    @Mapping(target = "role", source = "role")
    User updateDataToDomain(SaveUserDto saveDto, Role role);
}
