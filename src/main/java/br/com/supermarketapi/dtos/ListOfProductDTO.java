package br.com.supermarketapi.dtos;

import br.com.supermarketapi.models.Product;

import java.util.List;

public class ListOfProductDTO {
    private Long id;
    private List<Product> shoplist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getShoplist() {
        return shoplist;
    }

    public void setShoplist(List<Product> shoplist) {
        this.shoplist = shoplist;
    }
}
