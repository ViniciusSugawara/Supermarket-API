package br.com.supermarketapi.controllers;

import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.supermarketapi.dtos.ProductDTO;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController extends AbsController<ProductDTO> {
    private ProductService productService;
    public ProductController(ProductService productService) {
         this.productService = productService;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findAll() {
        return new ResponseEntity(productService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name")String name){
        return new ResponseEntity(productService.findByName(name), HttpStatus.OK);
    }
    @GetMapping("/description/{description}")
    public ResponseEntity<Product> findByDescription(@PathVariable("description")String description){
        return new ResponseEntity(productService.findByDescription(description), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO object){
        return new ResponseEntity(productService.save(object), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO object){
        return new ResponseEntity(productService.update(object),HttpStatus.CREATED);
    }
    @PutMapping("/deactivate/{status}")
    public ResponseEntity<Product> deactivate(@RequestBody ProductDTO object, @PathVariable("status")String status){
        return new ResponseEntity(productService.deactivate(object, status), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(ProductDTO object) {
        this.productService.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteById(Long id) {
        this.productService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
