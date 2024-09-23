package org.katrin.testingglovo.repository.Order;

import org.katrin.testingglovo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>, OrderRepositoryCustom {
    List<OrderEntity> findByClientId(int clientId);
}
