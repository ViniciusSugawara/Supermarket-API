package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.output.ProductWithOrderID;
import br.com.supermarketapi.models.Product;
import br.com.supermarketapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import br.com.supermarketapi.dtos.input.ProductDTO;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends AbsController<ProductDTO, ProductWithOrderID> {
    private ProductService productService;
    public ProductController(ProductService productService) {
         this.productService = productService;
    }

    @Override
    public ResponseEntity<List<ProductWithOrderID>> findAll() {
        return new ResponseEntity(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/sorted/{field}")
    public ResponseEntity<List<ProductWithOrderID>> findAllSorted(@PathVariable(value = "field") String field){
        return new ResponseEntity<>(productService.findAllSorted(field), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping("/paginated/{pageNumber}/{size}")
    public ResponseEntity<Page<ProductWithOrderID>> findAllPaginated(@PathVariable("pageNumber") Integer currentPageNumber, @PathVariable("size") Integer pageSize){
        return new ResponseEntity<>(productService.findAllPaginated(currentPageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/filter/{filterParameter}")
    public ResponseEntity<List<ProductWithOrderID>> findAllFiltered(@PathVariable("filterParameter") String filterParam){
        return new ResponseEntity<>(productService.findAllFiltered(filterParam), HttpStatus.OK );
    }

    @GetMapping
    @RequestMapping("/filter/price/{maximum}/{minimum}")
    public ResponseEntity<List<ProductWithOrderID>> findAllFilteredByPrice(@PathVariable("maximum")Integer maximum, @PathVariable("minimum")Integer minimum){
        return new ResponseEntity<>(productService.findAllFilteredByPrice(maximum, minimum), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ProductWithOrderID> findById(@PathVariable("id") Long id) {
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
