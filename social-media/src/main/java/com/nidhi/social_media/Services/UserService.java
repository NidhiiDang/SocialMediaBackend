package com.nidhi.social_media.Services;

import com.nidhi.social_media.Model.Users;

import java.util.List;


public interface UserService {

    public Users registerUser(Users user);
    public List<Users> getAllUsers();
    public Users findUserById(Long id);
    public Users findUserByEmail(String email);
    public Users updateUser(Long id, Users user);
    public Users followUser(Long userId, Long followUserId);
    public Users unFollowUser(Long userId, Long unFollowUserId);
    public List<Users> searchUser(String query);
    public String verify(Users user);
}
