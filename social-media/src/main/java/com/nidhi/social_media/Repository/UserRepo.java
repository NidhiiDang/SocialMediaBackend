package com.nidhi.social_media.Repository;

import com.nidhi.social_media.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {

    public Users findByUsername(String Username);

    @Query("select u from Users u where u.firstName LIKE %:query% OR u.lastName LIKE %:query%")
    public List<Users> searchUser(@Param("query") String query);
}
