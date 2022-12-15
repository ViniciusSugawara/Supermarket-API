package br.com.supermarketapi.models;

//Represents the Client class, with CLIENT role.
public class Client extends User {
    public Client(){
        setUserRoles(UserRoles.CLIENT);
    }
}
