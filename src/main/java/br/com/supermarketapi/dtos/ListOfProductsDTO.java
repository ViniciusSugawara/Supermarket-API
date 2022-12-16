package br.com.supermarketapi.dtos;

import br.com.supermarketapi.models.Product;

import java.util.List;

public class ListOfProductsDTO {
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
