package com.varun.socialmedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "profilePictureUrl")
    private String profilePictureUrl;
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "following",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "followingId", referencedColumnName = "id"))
    private Set<User> following;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Post> posts;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Comment> comments;

    public User(Long id, String username, String profilePictureUrl, String password, Set<User> following, Set<Post> posts, Set<Comment> comments) {
        this.userId=id;
        this.username = username;
        this.profilePictureUrl = profilePictureUrl;
        this.password = password;
        this.following = following;
        this.posts = posts;
        this.comments = comments;
    }
}
