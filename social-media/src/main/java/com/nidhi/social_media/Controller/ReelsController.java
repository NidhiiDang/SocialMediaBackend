package com.nidhi.social_media.Controller;

import com.nidhi.social_media.Jwt.JwtService;
import com.nidhi.social_media.Model.Reels;
import com.nidhi.social_media.Model.Users;
import com.nidhi.social_media.Services.ReelsService;
import com.nidhi.social_media.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelsController {

    @Autowired
    private ReelsService reelsService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/api/reels")
    public Reels createReels(@Valid @RequestBody Reels reel, @RequestHeader("Authorization") String jwt){
        System.out.println(jwt);
        Users reqUser = userService.findUserByUsername(jwtService.extractUserName(jwt));
        return reelsService.createReel(reel,reqUser);
    }

    @GetMapping("/api/getReels")
    public List<Reels> getAllReels(){
        return reelsService.findAllReels();
    }

    @GetMapping("/api/getReels/{userId}")
    public List<Reels> getAllUserReels(@PathVariable Long userId) throws Exception {
        return reelsService.findUsersReels(userId);
    }
}
