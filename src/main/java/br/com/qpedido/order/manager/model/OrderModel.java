package br.com.qpedido.order.manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "order", schema = "qpedido")
@Getter @Setter
public class OrderModel {
    @Id @GeneratedValue
    @Column(name = "id_order")
    private UUID idOrder;

    @Column(nullable = false, name = "id_table")
    private UUID idTable;

    @Column
    private String status;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false, name = "owner_id")
    private UUID ownerId;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
