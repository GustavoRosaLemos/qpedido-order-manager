package br.com.qpedido.order.manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "category", schema = "qpedido")
@Getter @Setter
public class CategoryModel {
    @Id @GeneratedValue
    @Column(name = "id_category")
    private UUID idCategory;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
