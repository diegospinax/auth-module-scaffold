package co.pragma.usecase.user.cases;

import co.pragma.model.user.User;
import reactor.core.publisher.Mono;

public interface CreateUserUseCase {
    Mono<User> createUser(User user);
}
