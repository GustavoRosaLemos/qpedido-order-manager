package br.com.qpedido.order.manager.order;

import br.com.qpedido.order.manager.model.OrderModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public interface OrderRepresentation {

    @Data
    @NoArgsConstructor
    class OrderPostRequestBody {
        @NotNull(message = "O campo owner é o obrigatório.")
        private UUID owner;
        @NotNull(message = "O campo tableNumber é o obrigatório.")
        private int tableNumber;
        @NotNull
        private OrderItems[] items;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class GetOrdersResponse {
        private List<OrderModel> orders;
    }

    @Data
    @NoArgsConstructor
    class OrderPatchRequestBody {
        @NotNull(message = "O campo orderStatus é o obrigatório.")
        private OrderStatus orderStatus;
    }

    @Data@NoArgsConstructor
    class OrderItems {
        private UUID itemId;
        private int quantity;
    }

    @Data
    @NoArgsConstructor
     class Order {
        private UUID orderId;
        private OrderStatus orderStatus;
        private String orderNumber;
        private OrderItem[] orderItems;
        private UUID orderOwner;
        private int tableNumber;
    }

    @Data
    @NoArgsConstructor
    class OrderItem {
        private String itemName;
        private String itemDescription;
        private float itemPrice;
    }

    @Data
    @NoArgsConstructor
    class OrderItemCategory {
         private String categoryName;
         private String categoryDescription;
    }
}
