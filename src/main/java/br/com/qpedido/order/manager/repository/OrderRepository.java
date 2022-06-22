package br.com.qpedido.order.manager.repository;

import br.com.qpedido.order.manager.model.OrderModel;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderModel, UUID> {

    @Query(nativeQuery = true, value = "SELECT * FROM qpedido.order WHERE owner_id = :ownerId")
    List<OrderModel> findByOwnerId(@Param("ownerId") UUID ownerId);

    @Query(nativeQuery = true, value = "SELECT * FROM qpedido.order WHERE id_order = :idOrder")
    OrderModel findByOrderId(@Param("idOrder") UUID idOrder);
}
