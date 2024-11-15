package com.nidhi.social_media.Services;

import com.nidhi.social_media.Dto.UserDto;
import com.nidhi.social_media.Jwt.JwtService;
import com.nidhi.social_media.Model.Users;
import com.nidhi.social_media.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private UserService userService;

    @Autowired
    private JwtService jwtService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private AuthenticationManager authManager;

    @Override
    public Users registerUser(UserDto user) {
        Users u = new Users(user.getFirstName(), user.getLastName(), user.getUsername(), encoder.encode(user.getPassword()));
//        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(u);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }


    @Override
    public Users findUserById(Long id) {
       return userRepo.findById(id).get();
    }

    @Override
    public Users findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Users updateUser(Long id, Users newUser) {
        Users oldUser = userRepo.findById(id).orElse(null);

        if (oldUser != null) {
            oldUser.setFirstName(((newUser.getFirstName() != null)) ? newUser.getFirstName() : oldUser.getFirstName());
            oldUser.setLastName(((newUser.getLastName() != null)) ? newUser.getLastName() : oldUser.getLastName());
            oldUser.setUsername(((newUser.getUsername() != null)) ? newUser.getUsername() : oldUser.getUsername());
        }

            return userRepo.save(oldUser);

    }

    @Override
    public Users followUser(Long userId, Long followUserId) {

        Users user = findUserById(userId);
        Users userToFollow = findUserById(followUserId);

        user.getFollowings().add(userToFollow.getId());
        userToFollow.getFollowers().add(user.getId());

        userRepo.save(user);
        userRepo.save(userToFollow);

        return userToFollow;
    }

    @Override
    public Users unFollowUser(Long userId, Long unFollowUserId) {

        Users user = findUserById(userId);
        Users userToUnfollow = findUserById(unFollowUserId);

        user.getFollowings().remove(userToUnfollow.getId());
        userToUnfollow.getFollowers().remove(user.getId());

        userRepo.save(user);
        userRepo.save(userToUnfollow);

        return user;

    }

//    @Override
//    public Users findUserByJwt(String jwt) {
//        String username = jwtService.extractUserName(jwt);
//        if (username == null) {
//            return null;
//        }
//        return userService.findUserByEmail(username);
//
//    }

    @Override
    public List<Users> searchUser(String query) {
        return userRepo.searchUser(query);
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }
}
