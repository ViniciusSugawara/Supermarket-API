package br.com.supermarketapi.services;

import br.com.supermarketapi.dtos.input.CategoryDTO;
import br.com.supermarketapi.dtos.output.CategoryWithProductID;
import br.com.supermarketapi.models.Category;
import br.com.supermarketapi.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Qualifier("Category")
public class CategoryService implements CrudService<CategoryDTO, CategoryWithProductID, Long>{
    private CategoryRepository categoryRepository;
    private ModelMapper mapper = new ModelMapper();

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryWithProductID> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryWithProductID> allCategoriesWithId = new ArrayList<>();

        for(Category category : allCategories){
            CategoryWithProductID categoryWithProductID = mapper.map(category, CategoryWithProductID.class);
            category.getProducts()
                    .stream()
                    .forEach((product)-> categoryWithProductID
                                         .getProducts_id()
                                         .add(product.getId())
                    );
            allCategoriesWithId.add(categoryWithProductID);
        }
        return allCategoriesWithId;
    }

    @Override
    public CategoryWithProductID findById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        CategoryWithProductID categoryWithProductID = mapper.map(category, CategoryWithProductID.class);

        category.getProducts()
                .stream()
                .forEach((product)-> categoryWithProductID
                                     .getProducts_id()
                                     .add(product.getId())
                );
        return categoryWithProductID;
    }

    @Override
    public CategoryDTO save(CategoryDTO object) {
        return mapper.map(
                categoryRepository.save(
                        mapper.map(object, Category.class)
                ),
                CategoryDTO.class);
    }

    @Override
    public CategoryDTO update(CategoryDTO object) {
        categoryRepository.save(mapper.map(object, Category.class));
        return object;
    }

    @Override
    public void delete(CategoryDTO object) {
        categoryRepository.delete(mapper.map(object, Category.class));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
