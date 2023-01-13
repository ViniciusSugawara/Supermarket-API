package br.com.supermarketapi.controllers;

import br.com.supermarketapi.dtos.input.CategoryDTO;
import br.com.supermarketapi.dtos.output.CategoryWithProductID;
import br.com.supermarketapi.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("categories")
public class CategoryController extends AbsController<CategoryDTO, CategoryWithProductID> {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<List<CategoryWithProductID>> findAll() {
        return new ResponseEntity(categoryService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryWithProductID> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO object) {
        return new ResponseEntity<>(categoryService.save(object), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDTO> update(@RequestBody   CategoryDTO object) {
        return new ResponseEntity<>(categoryService.update(object), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(@RequestBody CategoryDTO object) {
        categoryService.delete(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        return null;
    }
}
