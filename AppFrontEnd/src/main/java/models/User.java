package models;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String rol;
    private int phone;

    public User(String id, String name, String email, String address, int phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }
    
    public User(String id, String name, String email, String password, String address, String rol, int phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.rol = rol;
        this.phone = phone;
    }
    
    public User(){

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
         return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getRol() {return rol;}

    public int getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRol(String rol) {this.rol = rol;}

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    
}

