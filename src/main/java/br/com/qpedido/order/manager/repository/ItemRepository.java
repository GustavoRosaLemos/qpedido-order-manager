package br.com.qpedido.order.manager.repository;

import br.com.qpedido.order.manager.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemModel, UUID> {
}
