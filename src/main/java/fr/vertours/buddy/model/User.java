package fr.vertours.buddy.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false, length = 50)
    //@Size()
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;


    @OneToOne(mappedBy = "user")
    private ApplicationAccount account;

    @ManyToMany
    @JoinTable(name = "user_friend", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "friend_id")})
    private List<User> myFriendList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CreditCard> creditCardList = new ArrayList<>();

    @OneToMany
    private List<Role> role = new ArrayList<>();
}
