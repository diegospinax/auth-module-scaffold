package co.pragma.r2dbc.role;

import co.pragma.model.role.Role;
import co.pragma.model.role.gateways.RoleRepository;
import co.pragma.model.role.valueObject.RoleId;
import co.pragma.model.role.valueObject.RoleName;
import co.pragma.r2dbc.role.mapper.RoleMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class RoleRepositoryAdapter implements RoleRepository {

    private final RoleR2DBCRepository repository;
    private final RoleMapper roleMapper;

    public RoleRepositoryAdapter(RoleR2DBCRepository repository, RoleMapper roleMapper) {
        this.repository = repository;
        this.roleMapper = roleMapper;
    }

    @Override
    @Transactional
    public Mono<Role> createRole(Role role) {
        RoleEntity roleEntity = roleMapper.domainToEntity(role);
        return repository.save(roleEntity)
                .map(roleMapper::entityToDomain);
    }

    @Override
    public Flux<Role> findAll() {
        return repository.findAll()
                .map(roleMapper::entityToDomain);
    }

    @Override
    public Mono<Role> findById(RoleId roleId) {
        return repository.findById(roleId.value)
                .map(roleMapper::entityToDomain);
    }

    @Override
    public Mono<Role> findByName(RoleName name) {
        return repository.findByName(name.value)
                .map(roleMapper::entityToDomain);
    }

    @Override
    @Transactional
    public Mono<Role> updateRole(Role role) {
        RoleEntity roleEntity = roleMapper.domainToEntity(role);
        return repository.save(roleEntity)
                .map(roleMapper::entityToDomain);
    }

    @Override
    public Mono<Void> deleteRole(RoleId roleId) {
        return repository.deleteById(roleId.value);
    }
}
