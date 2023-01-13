package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.input.OrderDetailsDTO;
import br.com.supermarketapi.dtos.output.OrderDetailsWithIDs;
import br.com.supermarketapi.services.OrderDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController extends AbsController<OrderDetailsDTO, OrderDetailsWithIDs> {
    private OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @Override
    public ResponseEntity<List<OrderDetailsWithIDs>> findAll() {
        return new ResponseEntity<>(orderDetailsService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDetailsWithIDs> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderDetailsService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDetailsDTO> save(@RequestBody OrderDetailsDTO object) {
        return new ResponseEntity<>(orderDetailsService.save(object), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<OrderDetailsDTO> update(@RequestBody OrderDetailsDTO object) {
        return new ResponseEntity<>(orderDetailsService.update(object), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(@RequestBody OrderDetailsDTO object) {
        orderDetailsService.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        orderDetailsService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
