package br.com.qpedido.order.manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "item", schema = "qpedido")
@Getter @Setter
public class ItemModel {
    @Id @GeneratedValue
    @Column(name = "id_item")
    private UUID idItem;

    @Column(nullable = false, name = "id_category")
    private UUID idCategory;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Float price;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
