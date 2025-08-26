package co.pragma.usecase.user.cases;

import co.pragma.model.user.User;
import co.pragma.model.user.valueObject.UserEmail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindUserUseCase {
    Flux<User> findAll();
    Mono<User> findById(Long userId);
    Mono<User> findByEmail(UserEmail email);
}
