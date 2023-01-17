package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.ProductIDandName;
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
    @RequestMapping("/byId")
    public ResponseEntity<List<ProductIDandName>> findAllByIdAndName(){
        return new ResponseEntity(productService.findAllByIdAndName(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/sorted/{field}")
    public ResponseEntity<List<ProductWithOrderID>> findAllSorted(@PathVariable(value = "field") String field){
        return new ResponseEntity<>(productService.findAllSorted(field), HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping("/paginated/")
    public ResponseEntity<Page<ProductWithOrderID>> findAllPaginated(@RequestParam("pageNumber") Integer currentPageNumber,
                                                                     @RequestParam("size") Integer pageSize,
                                                                     @RequestParam(required = false, value = "field", defaultValue = "id")String field,
                                                                     @RequestParam(required = false, value = "order", defaultValue = "asc")String order){
        return new ResponseEntity<>(productService.findAllPaginated(currentPageNumber, pageSize, field, order), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/filtered/")
    public ResponseEntity<List<ProductWithOrderID>> findAllFiltered(@RequestParam("filterParameter") String filterParam){
        return new ResponseEntity<>(productService.findAllFiltered(filterParam), HttpStatus.OK );
    }

    @GetMapping
    @RequestMapping("/filtered/price/")
    public ResponseEntity<List<ProductWithOrderID>> findAllFilteredByPrice(@RequestParam(value = "maximum", defaultValue = "10000")Integer maximum, @RequestParam(value = "minimum", defaultValue = "0")Integer minimum){
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
