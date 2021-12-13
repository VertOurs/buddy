package fr.vertours.buddy.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 50)
    private String firstName;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 50)
    private String lastName;

    @Column(nullable = false)
    @Email(message = "This email have not correct syntax")
    private String mail;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 8)
    private String password;


    @OneToOne(mappedBy = "user")
    private ApplicationAccount account;

    @ManyToMany
    @JoinTable(name = "user_friend",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")})
    private List<User> myFriendList = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CreditCard> creditCardList = new ArrayList<>();

    @ManyToMany
    private List<Role> role = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ApplicationAccount getAccount() {
        return account;
    }

    public void setAccount(ApplicationAccount account) {
        this.account = account;
    }

    public List<User> getMyFriendList() {
        return myFriendList;
    }

    public void setMyFriendList(List<User> myFriendList) {
        this.myFriendList = myFriendList;
    }

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }

    public void setCreditCardList(List<CreditCard> creditCardList) {
        this.creditCardList = creditCardList;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
