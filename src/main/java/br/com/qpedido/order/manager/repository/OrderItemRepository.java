package br.com.qpedido.order.manager.repository;

import br.com.qpedido.order.manager.model.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItemModel, UUID> {
}
