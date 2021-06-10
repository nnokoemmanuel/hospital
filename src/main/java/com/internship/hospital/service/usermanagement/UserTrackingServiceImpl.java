package com.internship.hospital.service.usermanagement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.repository.users.UserTrackingRepository;

@Service("userTrackingService")
public class UserTrackingServiceImpl implements UserTrackingService {

	@Autowired
    private UserTrackingRepository userTrackingRepository;

	@Override
	public void save(UserTracking userTracking) {
		// TODO Auto-generated method stub
		userTrackingRepository.save(userTracking);
		
	}

	@Override
	public ArrayList<UserTracking> findByUser(User user) {
		// TODO Auto-generated method stub
		return (ArrayList<UserTracking>) userTrackingRepository.findByUser(user);
	}
	
	
	@Override
	public void deleteUserTracking(UserTracking userTracking) {
		userTrackingRepository.delete(userTracking);
	}


}
