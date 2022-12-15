package br.com.supermarketapi.models;

//Represents the Admin class, with ADMIN role
public class Admin extends User {
    public Admin() {
        setUserRoles(UserRoles.ADMIN);
    }
}
