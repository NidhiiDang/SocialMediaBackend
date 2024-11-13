package com.nidhi.social_media.Services;

import com.nidhi.social_media.Model.Post;
import com.nidhi.social_media.Model.Users;
import com.nidhi.social_media.Repository.PostRepo;
import com.nidhi.social_media.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Post createPost(Post post, Long userId) {
        Users user = userService.findUserById(userId);
        Post newPost = new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        newPost.setVideo(post.getVideo());
        newPost.setCreatedAt(LocalDateTime.now());
        newPost.setUser(user);
        return postRepo.save(newPost);
    }

    @Override
    public String deletePost(Long postId, Long userId) throws Exception {
       Post post = postRepo.findById(postId).orElse(null);
       Users user = userService.findUserById(userId);
       if(post.getUser().getId() != user.getId()){
           throw new Exception("in appropriate behaviour");
       }
       postRepo.delete(post);
       return "Post deleted successfully";
    }

    @Override
    public List<Post> findPostsById(Long userId) {
       return postRepo.findPosts(userId);
    }

    @Override
    public Post findPostByPostId(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }

    @Override
    public List<Post> findAllPost() {
        return postRepo.findAll();
    }

    @Override
    public Post savePost(Long postId, Long userId) {
        Post post = postRepo.findById(postId).orElse(null);
        Users user = userService.findUserById(userId);

        if(user.getSavedPost().contains(post)){
            user.getSavedPost().remove(post);
        }
        else{
            user.getSavedPost().add(post);
        }
        userRepo.save(user);
        return postRepo.save(post);
    }

    @Override
    public Post likePost(Long postId, Long userId) {
        Post post = postRepo.findById(postId).orElse(null);
        Users user = userService.findUserById(userId);

        if(post.getLikes().contains(user)) {
            post.getLikes().remove(user);
        }
        else {
            post.getLikes().add(user);
        }

        return postRepo.save(post);
    }
}
