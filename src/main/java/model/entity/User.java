package model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name ="_user")
@Builder
@NamedQueries({
        @NamedQuery(name = "findAllUser",query = "SELECT c FROM User c"),
        @NamedQuery(name = "findByName",query = "SELECT c FROM User c WHERE c.name =:name")})
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false,nullable = false,name = "user_name")
    private String name;

    @Column(updatable = false,nullable = false,name = "user_surname")
    private String surname;

    @Column(nullable = false,updatable = false,name = "user_birthday")
    private LocalDate birthday;

    @Column(unique = true,nullable = false,updatable = false,name = "user_fin")
    private String fin;

    @Column(unique = true,nullable = false,updatable = false,name = "password" )
    private String password;

    @Column(unique = true,nullable = false,updatable = false,name = "user_email")
    private String email;

    @Column(unique = true,nullable = false,updatable = false,name = "user_phoneNumber")
    private String phoneNumber;

    @Column(name = "account_balance")
    @Builder.Default
    private BigDecimal accountBalance = BigDecimal.valueOf(7000);

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Cart cart;

    public User(Long id, String name, String surname, LocalDate birthday, String fin, String password, String email, String phoneNumber, BigDecimal accountBalance, Cart cart) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.fin = fin;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountBalance = accountBalance;
        this.cart = cart;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
