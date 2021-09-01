package com.baggio.innohospital.time;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;


    @PostMapping
    public void post(){
        Post post = new Post("First post");
        Author author = new Author("Conan Doyle");
        author = authorRepository.save(author);
        post.setAuthor(author);
        postRepository.save(post);
        postRepository.save(new Post("second post"));
    }

    @GetMapping("/post")
    public List<Post> getPost(){
        return postRepository.findAll();
    }

    @DeleteMapping("")
    public String delete(){
        Long id = 1L;
        postRepository.delete(postRepository.findById(id).get());
        return "deleting post";
    }

}
