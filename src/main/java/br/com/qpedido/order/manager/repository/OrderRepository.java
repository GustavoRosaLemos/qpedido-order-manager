package br.com.qpedido.order.manager.repository;

import br.com.qpedido.order.manager.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderModel, UUID> {
}
