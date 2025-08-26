package co.pragma.r2dbc.user.mapper.support;

import co.pragma.model.user.valueObject.*;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface UserValueObjectMappers {

    @Named("toUserId")
    default UserId toUserId(Long id){
        return new UserId(id);
    }

    @Named("toUserName")
    default UserName toUserName(String name) {
        return new UserName(name);
    }

    @Named("toUserLastname")
    default UserLastname toUserLastname(String lastname){
        return new UserLastname(lastname);
    }

    @Named("toUserDateBirth")
    default UserDateBirth toUserDateBirth(LocalDate dateBirth) {
        return new UserDateBirth(dateBirth);
    }

    @Named("toUserAddress")
    default UserAddress toUserAddress(String address) {
        return new UserAddress(address);
    }

    @Named("toUserPhoneNumber")
    default UserPhoneNumber toUserPhoneNumber(String phoneNumber) {
        return new UserPhoneNumber(phoneNumber);
    }

    @Named("toUserEmail")
    default UserEmail toUserEmail(String email){
        return new UserEmail(email);
    }

    @Named("toUserSalary")
    default UserSalary toUserSalary(Double salary) {
        return new UserSalary(salary);
    }


}
