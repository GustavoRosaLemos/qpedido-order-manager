package br.com.qpedido.order.manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "order_item", schema = "qpedido")
@Getter @Setter
public class OrderItemModel {
    @Id @GeneratedValue
    @Column(name = "id_order_item")
    private UUID idOrderItem;

    @Column(nullable = false, name = "id_order")
    private UUID idOrder;

    @Column(nullable = false, name = "id_item")
    private UUID idItem;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
