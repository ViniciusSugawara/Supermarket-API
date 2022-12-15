package br.com.supermarketapi.models;

//Represents all base entities that will be used
public abstract class BaseEntity {
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
