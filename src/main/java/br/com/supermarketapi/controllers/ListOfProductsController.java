package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.ListOfProductDTO;
import br.com.supermarketapi.services.ListOfProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListOfProductsController {
    private ListOfProductsService listOfProductsService;

    public ListOfProductsController(ListOfProductsService listOfProductsService) {
        this.listOfProductsService = listOfProductsService;
    }

    @GetMapping("/listofproducts")
    public ResponseEntity<List<ListOfProductDTO>> findAll(){
        return new ResponseEntity(listOfProductsService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/listofproducts/{id}")
    public ResponseEntity<ListOfProductDTO> findById(@PathVariable("id")Long id){
        return new ResponseEntity(listOfProductsService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/listofproducts")
    public ResponseEntity<ListOfProductDTO> save(@RequestBody ListOfProductDTO object){
        return new ResponseEntity(listOfProductsService.save(object), HttpStatus.CREATED);
    }
    @PutMapping("/listofproducts")
    public ResponseEntity<ListOfProductDTO> update(@RequestBody ListOfProductDTO object){
        return new ResponseEntity(listOfProductsService.update(object),HttpStatus.CREATED);
    }

    @DeleteMapping("/listofproducts")
    public ResponseEntity delete(@RequestBody ListOfProductDTO object){
        listOfProductsService.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/listofproducts/{id}")
    public ResponseEntity deleteById(@PathVariable("id")Long id){
        this.listOfProductsService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
