package br.com.qpedido.order.manager.repository;

import br.com.qpedido.order.manager.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {
}
