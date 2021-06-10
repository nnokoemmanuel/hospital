package com.internship.hospital.service.usermanagement;

import java.util.ArrayList;

import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;

public interface UserTrackingService {

	public void save(UserTracking userTracking);
	public ArrayList<UserTracking> findByUser(User user);
	public void deleteUserTracking(UserTracking userTracking);

}
