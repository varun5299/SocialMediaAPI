package com.varun.socialmedia.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long commentId;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    public Comment(Long id, String content, Date date, User user, Post post) {
        this.commentId=id;
        this.content = content;
        this.date = date;
        this.user = user;
        this.post = post;
    }
}
