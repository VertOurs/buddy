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

    @OneToMany
    private List<Role> role = new ArrayList<>();
}
