package br.com.qpedido.order.manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "table", schema = "qpedido")
@Getter @Setter
public class TableModel {
    @Id @GeneratedValue
    @Column(name = "id_table")
    private UUID idTable;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "table_number")
    private String tableNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
