package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.BaseDTO;
import br.com.supermarketapi.services.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

public abstract class AbsController<T_input extends BaseDTO, T_output extends BaseDTO> {
    @GetMapping
    abstract public ResponseEntity<List<T_output>> findAll();
    @GetMapping("{id}")
    abstract public ResponseEntity<T_output> findById(Long id);
    @PostMapping
    abstract public ResponseEntity<T_input> save(T_input object);
    @PutMapping
    abstract public ResponseEntity<T_input> update(T_input object);
    @DeleteMapping
    abstract public ResponseEntity delete(T_input object);
    @DeleteMapping("{id}")
    abstract public ResponseEntity deleteById(Long id);
}
