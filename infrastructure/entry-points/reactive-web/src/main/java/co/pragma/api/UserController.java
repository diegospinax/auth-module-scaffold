package co.pragma.api;

import co.pragma.api.dto.user.ResponseUserDto;
import co.pragma.api.dto.user.SaveUserDto;
import co.pragma.api.mapper.user.UserInMapper;
import co.pragma.model.role.Role;
import co.pragma.model.role.valueObject.RoleId;
import co.pragma.model.user.User;
import co.pragma.model.user.valueObject.UserEmail;
import co.pragma.usecase.role.cases.FindRoleUseCase;
import co.pragma.usecase.user.cases.CreateUserUseCase;
import co.pragma.usecase.user.cases.DeleteUserUseCase;
import co.pragma.usecase.user.cases.FindUserUseCase;
import co.pragma.usecase.user.cases.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserInMapper mapper;
    private final CreateUserUseCase createUseCase;
    private final FindUserUseCase findUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final FindRoleUseCase findRoleUseCase;

    @PostMapping("/create")
    public ResponseEntity<Mono<ResponseUserDto>> createUser(@RequestBody SaveUserDto saveUserDto) {
        return new ResponseEntity<>(
                findRoleUseCase.findById(new RoleId(saveUserDto.roleId()))
                        .flatMap(role -> {
                            User user = mapper.createDtoToDomain(saveUserDto, role);

                            return createUseCase.createUser(user)
                                    .map(mapper::toResponseDto);
                        }),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ResponseUserDto>> findById(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(
                findUserUseCase.findById(userId)
                        .map(mapper::toResponseDto),
                HttpStatus.OK
        );
    }

    @GetMapping("/email")
    public ResponseEntity<Mono<ResponseUserDto>> findByEmail(@RequestParam("value") String email) {
        return new ResponseEntity<>(
                findUserUseCase.findByEmail(new UserEmail(email))
                        .map(mapper::toResponseDto),
                HttpStatus.OK
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Flux<ResponseUserDto>> findAll() {
        return new ResponseEntity<>(
                findUserUseCase.findAll()
                        .map(mapper::toResponseDto),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<ResponseUserDto>> updateUser(@PathVariable("id") Long userId, @RequestBody SaveUserDto saveUserDto) {
        User newUserData = mapper.updateDataToDomain(saveUserDto, new Role(new RoleId(saveUserDto.roleId()), null, null));
        return new ResponseEntity<>(
                updateUserUseCase.updateUser(userId, newUserData)
                        .map(mapper::toResponseDto),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteUser(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(
                deleteUserUseCase.deleteUser(userId),
                HttpStatus.NO_CONTENT
        );
    }
}
