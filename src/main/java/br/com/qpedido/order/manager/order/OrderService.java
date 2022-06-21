package br.com.qpedido.order.manager.order;

import br.com.qpedido.order.manager.repository.CategoryRepository;
import br.com.qpedido.order.manager.repository.ItemRepository;
import br.com.qpedido.order.manager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
