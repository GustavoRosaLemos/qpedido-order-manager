package br.com.qpedido.order.manager.order;

import br.com.qpedido.order.manager.exceptions.DatabaseException;
import br.com.qpedido.order.manager.model.ItemModel;
import br.com.qpedido.order.manager.model.OrderModel;
import br.com.qpedido.order.manager.repository.CategoryRepository;
import br.com.qpedido.order.manager.repository.ItemRepository;
import br.com.qpedido.order.manager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;


    public OrderRepresentation.GetOrdersResponse getOrdersService() {
        OrderRepresentation.GetOrdersResponse response = new OrderRepresentation.GetOrdersResponse();
        response.setOrders(orderRepository.findAll());
        return response;
    }

    public OrderRepresentation.GetOrdersResponse getOrdersByOwnerService(UUID ownerId) {
        OrderRepresentation.GetOrdersResponse response = new OrderRepresentation.GetOrdersResponse();
        response.setOrders(orderRepository.findByOwnerId(ownerId));
        return response;
    }

    public OrderRepresentation.GetItemsResponse getItemsService() {
        OrderRepresentation.GetItemsResponse response = new OrderRepresentation.GetItemsResponse();
        response.setItems(itemRepository.findAll());
        return response;
    }

    public OrderRepresentation.GetCategoriesResponse getCategoriesService() {
        OrderRepresentation.GetCategoriesResponse response = new OrderRepresentation.GetCategoriesResponse();
        response.setCategories(categoryRepository.findAll());
        return response;
    }

    public OrderModel createOrderService(OrderRepresentation.OrderPostRequestBody order) {
        OrderModel orderModel = new OrderModel();
        orderModel.setIdTable(order.getIdTable());
        orderModel.setStatus(OrderStatus.CREATED.toString());
        orderModel.setNumber(order.getTableNumber());
        orderModel.setOwnerId(order.getOwnerId());
        orderModel.setUpdatedAt(LocalDateTime.now());
        orderModel.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(orderModel);
    }

    public List<ItemModel> getCategoryItemsService(UUID idCategory) {
        return itemRepository.getCategoryItems(idCategory);
    }

    public OrderModel updateOrderStatusService(UUID orderId, OrderStatus status) throws DatabaseException {
        OrderModel order = orderRepository.findByOrderId(orderId);

        if (order == null) {
            throw new DatabaseException("O pedido não existe.");
        }

        order.setStatus(status.toString());
        orderRepository.save(order);
        return order;
    }
}
