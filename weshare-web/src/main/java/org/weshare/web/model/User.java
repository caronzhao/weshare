package org.weshare.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Caron Zhao
 *
 * Feb 24, 2014 4:00:03 PM
 */
@Entity
@Table(name = "users")
public class User {
	// user id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	// nick name
    @Column(name = "nick_name", length = 40)
	public String nickName;
    
    @Column(name = "password", length = 40)
    public String password;
	
    @Column(name = "phone_number", length = 30)
    private String phoneNumber;
	
    @Column(name = "email_address", length = 100)
    private String emailAddress;
	
	// the picture url
    @Column(name = "image_url", length = 100)
    private String imageUrl;
	
	// the big picture url
    @Column(name = "avatar_large_url", length = 100)
    private String avatarLargeUrl;
    
    // n days (push msg before returning date)
    @Column(name = "reminder_return_days")
    private int reminderReturnDays;
	
//    private List<Book> library;
//	
//    private List<User> friends;
//    
//    private List<Group> groups;
    
    //TODO history of recent locations
    
    //@community: save current to 'my location'
    //@tag: //system - use for recommendation classification
    
    //Kudos: 
    //Credit: 
	
	// create time
    @Column(name = "created_at")
	public Date createdAt;

	//0: offline; 1: online
    @Column(name = "online_status")
	public boolean onlineStatus;
}