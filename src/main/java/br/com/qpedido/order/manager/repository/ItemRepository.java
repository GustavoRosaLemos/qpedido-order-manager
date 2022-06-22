package br.com.qpedido.order.manager.repository;

import br.com.qpedido.order.manager.model.ItemModel;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemModel, UUID> {

    @Query(nativeQuery = true, value = "SELECT * FROM qpedido.item WHERE id_category = :idCategory")
    List<ItemModel> getCategoryItems(@Param("idCategory") UUID idCategory);
}
