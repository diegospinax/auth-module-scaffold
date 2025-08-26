package co.pragma.usecase.user.cases;

import co.pragma.model.user.User;
import reactor.core.publisher.Mono;

public interface UpdateUserUseCase {
    Mono<User> updateUser(Long userId, User userNewData);
}
