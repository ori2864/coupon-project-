package Beans;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
//@NoArgsConstructor
public class Company {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private ArrayList<Coupon> coupons;

public Company(){

}
public Company(int id,String name,String email,String password){
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
}
    public Company(int id,String name, String email, String password, ArrayList<Coupon> coupons) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.coupons = coupons;
    }
    public Company(String name, String email, String password, ArrayList<Coupon> coupons) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.coupons = coupons;
    }
    public Company(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", coupons=" + coupons +
                '}';
    }
}