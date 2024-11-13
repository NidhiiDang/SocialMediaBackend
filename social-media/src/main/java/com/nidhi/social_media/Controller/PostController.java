package com.nidhi.social_media.Controller;

import com.nidhi.social_media.CustomResponses.ApiResponse;
import com.nidhi.social_media.Model.Post;
import com.nidhi.social_media.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<ApiResponse<Post>> createPost(@RequestBody Post post, @PathVariable Long userId){
       try {
           Post createdPost = postService.createPost(post, userId);
           ApiResponse<Post> response = new ApiResponse<>("success",createdPost);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
       }
       catch(Exception e){
           ApiResponse<Post> response = new ApiResponse<>("error", null);
           return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
       }
    }

    @DeleteMapping("/delete/{postId}/{userId}")
    public ResponseEntity<ApiResponse<String>> deletePost(@PathVariable Long postId, @PathVariable Long userId){
        try{
            String message = postService.deletePost(postId,userId);
            ApiResponse<String> response = new ApiResponse<>("success",message);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            ApiResponse<String> response = new ApiResponse<>("error", null);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<Post>> getPostById(@PathVariable Long postId){
        try{
            Post post = postService.findPostByPostId(postId);
            ApiResponse<Post> response = new ApiResponse<>("Success",post);
            return new ResponseEntity<>(response,HttpStatus.FOUND);
        }catch(Exception e){
            ApiResponse<Post> response = new ApiResponse<>("error",null);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<ApiResponse<List<Post>>> getAllPostsOfUser(@PathVariable Long userId){
        try{
            List<Post> posts = postService.findPostsById(userId);
            ApiResponse<List<Post>> response = new ApiResponse<>("Success",posts);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

        }catch(Exception e){
            ApiResponse<List<Post>> response = new ApiResponse<>("error : User not Found",null);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/posts")
    public ResponseEntity<ApiResponse<List<Post>>> getAllPostsAsFeed(){
        try{
            List<Post> posts = postService.findAllPost();
            ApiResponse<List<Post>> response = new ApiResponse<>("Success",posts);
            return new ResponseEntity<>(response,HttpStatus.OK);

        }catch(Exception e){
            ApiResponse<List<Post>> response = new ApiResponse<>("error refreshing feed",null);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/post/save/{postId}/user/{userId}")
    public ResponseEntity<ApiResponse<Post>> savePostById(@PathVariable Long postId,@PathVariable Long userId){
        try{
            Post post = postService.savePost(postId,userId);
            ApiResponse<Post> response = new ApiResponse<>("Success",post);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            ApiResponse<Post> response = new ApiResponse<>("error",null);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/like/{postId}/user/{userId}")
    public ResponseEntity<ApiResponse<Post>> likePostById(@PathVariable Long postId,@PathVariable Long userId){
        try{
            Post post = postService.likePost(postId,userId);
            ApiResponse<Post> response = new ApiResponse<>("Success",post);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            ApiResponse<Post> response = new ApiResponse<>("error",null);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }
}
