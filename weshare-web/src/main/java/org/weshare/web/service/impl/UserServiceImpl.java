package org.weshare.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weshare.web.model.User;
import org.weshare.web.service.UserService;

/**
 * @author Caron Zhao
 *
 * Mar 16, 2014 11:36:28 PM
 */
@Service
public class UserServiceImpl implements UserService {

	@Transactional
	@Override
	public User register(User user) {
		return null;
	}
}