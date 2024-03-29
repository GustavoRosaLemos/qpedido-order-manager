package br.com.qpedido.order.manager.order;

import br.com.qpedido.order.manager.repository.TableRepository;
import br.com.qpedido.order.manager.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/order")
@Api("API rest para gestão de pedidos.")
public class OrderController {

    @Autowired
    TableRepository tableRepository;

    @Autowired
    OrderService orderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private static final String PATH = "/qpedido/order-manager/api/v1/order";

    @GetMapping
    @ApiOperation(value = "Método para buscar todos os pedidos.")
    public ResponseEntity<?> getOrders() {
        try {
            return Util.responseEntity("Busca realizada com sucesso!", orderService.getOrdersService(), HttpStatus.OK, PATH);
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH);
        }
    }

    @GetMapping("/{ownerId}")
    @ApiOperation(value = "Método para buscar todos os pedidos de um cliente.")
    public ResponseEntity<?> getOrdersByOwner(@PathVariable UUID ownerId) {
        try {
            return Util.responseEntity("Busca realizada com sucesso!", orderService.getOrdersByOwnerService(ownerId), PATH+"/{ownerId}");
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH+"/{ownerId}");
        }
    }

    @GetMapping("/items")
    @ApiOperation(value = "Método para buscar todos os itens disponíveis.")
    private ResponseEntity<?> getItems() {
        try {
            return Util.responseEntity("Busca realizada com sucesso!", orderService.getItemsService(), PATH+"/items");
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH+"/items");
        }
    }

    @GetMapping("/items/{idCategory}")
    @ApiOperation(value = "Método para buscar todos os itens de uma categoria.")
    private ResponseEntity<?> getCategoryItems(@PathVariable UUID idCategory) {
        try {
            System.out.println("teste");
            System.out.println(idCategory);
            return Util.responseEntity("Busca realizada com sucesso!", orderService.getCategoryItemsService(idCategory), PATH+"/items/{idCategory}");
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH+"/items/{idCategory}");
        }
    }

    @GetMapping("/categories")
    @ApiOperation(value = "Método para buscar todos os itens de uma categoria.")
    private ResponseEntity<?> getCategories() {
        try {
            return Util.responseEntity("Busca realizada com sucesso!", orderService.getCategoriesService(), PATH+"/categories");
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH+"/categories");
        }
    }

    @PostMapping
    @ApiOperation(value = "Método para criar um novo pedido.")
    public ResponseEntity<?> postOrder(@RequestBody @Valid OrderRepresentation.OrderPostRequestBody order) {
        try {
            return Util.responseEntity("Novo pedido criado com sucesso!", orderService.createOrderService(order), PATH);
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH);
        }
    }

    @PatchMapping("/{orderId}")
    @ApiOperation(value = "Método para modificar o status de um pedido.")
    public ResponseEntity<?> patchOrderStatus(@PathVariable("orderId") UUID orderId, @RequestBody @Valid OrderRepresentation.OrderPatchRequestBody body) {
        try {
            return Util.responseEntity("Status do pedido modificado com sucesso!", orderService.updateOrderStatusService(orderId, body.getOrderStatus()), PATH);
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH+"/{orderId}");
        }
    }
}
