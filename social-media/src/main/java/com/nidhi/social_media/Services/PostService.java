package com.nidhi.social_media.Services;

import com.nidhi.social_media.Model.Post;

import java.util.List;

public interface PostService {

    public Post createPost(Post post, Long userid);
    public String deletePost(Long postId,Long userId) throws Exception;
    public List<Post> findPostsById(Long userId);
    public Post findPostByPostId(Long postId );
    public List<Post> findAllPost();
    public Post savePost(Long postId, Long userId);
    public Post likePost(Long postId, Long userId);

}
