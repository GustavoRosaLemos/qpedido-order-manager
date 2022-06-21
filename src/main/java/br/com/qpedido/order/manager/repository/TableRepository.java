package br.com.qpedido.order.manager.repository;

import br.com.qpedido.order.manager.model.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TableRepository extends JpaRepository<TableModel, UUID> {
}
