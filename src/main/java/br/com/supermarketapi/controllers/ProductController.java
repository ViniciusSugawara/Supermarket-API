package br.com.supermarketapi.controllers;

import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.supermarketapi.dtos.ProductDTO;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity(productService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id")Long id){
        return new ResponseEntity(productService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/product/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name")String name){
        return new ResponseEntity(productService.findByName(name), HttpStatus.OK);
    }
    @GetMapping("/product/description/{description}")
    public ResponseEntity<Product> findByDescription(@PathVariable("description")String description){
        return new ResponseEntity(productService.findByDescription(description), HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody ProductDTO object){
        return new ResponseEntity(productService.save(object), HttpStatus.CREATED);
    }
    @PutMapping("/product")
    public ResponseEntity<Product> update(@RequestBody ProductDTO object){
        return new ResponseEntity(productService.update(object),HttpStatus.CREATED);
    }
    @PutMapping("/product/deactivate/{status}")
    public ResponseEntity<Product> deactivate(@RequestBody ProductDTO object, @PathVariable("status")String status){
        return new ResponseEntity(productService.deactivate(object, status), HttpStatus.OK);
    }
}
