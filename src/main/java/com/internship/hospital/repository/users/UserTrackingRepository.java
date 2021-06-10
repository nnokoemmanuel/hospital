package com.internship.hospital.repository.users;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;

@Repository("userTrackingRepository")
public interface UserTrackingRepository extends JpaRepository<UserTracking,Integer> {
    public List<UserTracking> findByUser(User user);
    public List<UserTracking> findAll();
    public UserTracking save(UserTracking userTracking);
} 