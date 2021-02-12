package com.varun.socialmedia.controller;

import com.varun.socialmedia.domain.Post;
import com.varun.socialmedia.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users/{userId}/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Object> getAllPosts() {
        return new ResponseEntity<Object>(service.getAllPosts(), HttpStatus.OK);
    }

    @RequestMapping(value="/{postId}", method=RequestMethod.GET)
    public ResponseEntity<Object> getPost(@PathVariable Long postId) {
        return new ResponseEntity<Object>(service.getPost(postId), HttpStatus.OK);
    }

    @RequestMapping(value="/{postId}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updatePost(@RequestBody Post post, @PathVariable Long postId) {
        try {
            return new ResponseEntity<Object>(service.updatePost(post, postId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Object> createPost(@RequestBody Post post, @PathVariable Long userId) {
        try {
            return new ResponseEntity<Object>(service.createPost(post, userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
