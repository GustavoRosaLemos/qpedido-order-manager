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
            return Util.responseEntity("Busca realizada com sucesso!", orderService.getOrdersByOwnerService(ownerId), PATH+"/{categoryId}");
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH+"/{categoryId}");
        }
    }

    @GetMapping("/items")
    @ApiOperation(value = "Método para buscar todos os itens disponíveis.")
    private ResponseEntity<?> getItems() {
        try {
            return Util.responseEntity("Busca realizada com sucesso!", orderService.getItemsService(), PATH);
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH);
        }
    }

    @GetMapping("/items/{categoryId}")
    @ApiOperation(value = "Método para buscar todos os itens de uma categoria.")
    private ResponseEntity<?> getCategoryItems(@PathVariable UUID categoryId) {
        try {
            return ResponseEntity.ok().body("teste");
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH+"/{categoryId}");
        }
    }

    @GetMapping("/categories")
    @ApiOperation(value = "Método para buscar todos os itens de uma categoria.")
    private ResponseEntity<?> getCategories() {
        try {
            return Util.responseEntity("Busca realizada com sucesso!", orderService.getCategoriesService(), PATH);
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH);
        }
    }

    @PostMapping
    @ApiOperation(value = "Método para criar um novo pedido.")
    public ResponseEntity<?> postOrder(@RequestBody @Valid OrderRepresentation.OrderPostRequestBody order) {
        try {
            return ResponseEntity.ok().body(order);
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH);
        }
    }

    @PatchMapping("/{orderId}")
    @ApiOperation(value = "Método para modificar o status de um pedido.")
    public ResponseEntity<?> patchOrderStatus(@PathVariable("orderId") UUID orderId, @RequestBody @Valid OrderRepresentation.OrderPatchRequestBody body) {
        try {
            return ResponseEntity.ok().body(body);
        } catch (Exception e) {
            LOGGER.error("Houve um erro inesperado. Mensagem: {}", e.getMessage());
            return Util.responseErrorEntity(e, HttpStatus.EXPECTATION_FAILED, PATH);
        }
    }
}
