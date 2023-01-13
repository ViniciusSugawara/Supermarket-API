package br.com.supermarketapi.services;

import java.util.List;

//Has default CRUD operations.
public interface CrudService<T_input, T_output, ID> {
    public List<T_output> findAll();
    public T_output findById(ID id);
    public T_input save(T_input object);
    public T_input update(T_input object);
    public void delete(T_input object);
    public void deleteById(ID id);
}
