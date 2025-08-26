package co.pragma.usecase.user.cases;

import reactor.core.publisher.Mono;

public interface DeleteUserUseCase {
    Mono<Void> deleteUser(Long userId);
}
