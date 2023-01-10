package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.BaseDTO;
import br.com.supermarketapi.services.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

public abstract class AbsController<T extends BaseDTO> {
    @GetMapping
    abstract public ResponseEntity<List<T>> findAll();
    @GetMapping("{id}")
    abstract public ResponseEntity<T> findById(@PathVariable("id")Long id);
    @PostMapping
    abstract public ResponseEntity<T> save(@RequestBody T object);
    @PutMapping
    abstract public ResponseEntity<T> update(@RequestBody T object);
    @DeleteMapping
    abstract public ResponseEntity delete(@RequestBody T object);
    @DeleteMapping("{id}")
    abstract public ResponseEntity deleteById(@PathVariable("id")Long id);
}
