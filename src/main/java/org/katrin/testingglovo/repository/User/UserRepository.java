package org.katrin.testingglovo.repository.User;

import org.katrin.testingglovo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, UserRepositoryCustom {
}
