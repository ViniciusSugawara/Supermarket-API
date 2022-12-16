package br.com.supermarketapi.services;

import java.util.List;

//Has default CRUD operations.
public interface CrudService<T, ID> {
    public List<T> findAll();
    public T findById(ID id);
    public T save(T object);
    public T update(T object);
    public void delete(T object);
    public void deleteById(ID id);
}
