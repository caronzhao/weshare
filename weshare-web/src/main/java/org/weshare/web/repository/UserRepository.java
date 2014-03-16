package org.weshare.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.weshare.web.model.User;

/**
 * @author Caron Zhao
 *
 * Mar 16, 2014 9:59:43 PM
 */
public interface UserRepository extends JpaRepository<User, Long> {

}