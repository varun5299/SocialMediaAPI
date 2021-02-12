package com.varun.socialmedia.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long postId;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    public Post(Long id, String content, Date date, User user, Set<Comment> comments) {
        this.postId=id;
        this.content = content;
        this.date = date;
        this.user = user;
        this.comments = comments;
    }
}
