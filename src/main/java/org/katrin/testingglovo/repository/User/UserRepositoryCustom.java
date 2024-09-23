package org.katrin.testingglovo.repository.User;

import org.katrin.testingglovo.entity.OrderEntity;
import org.katrin.testingglovo.entity.UserEntity;

public interface UserRepositoryCustom {
    UserEntity updateWithoutOrders(UserEntity userEntity);

    UserEntity addOrder(int userId, OrderEntity orderEntity);
}
