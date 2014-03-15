package org.bks.model;

/**
 * @author Caron Zhao
 *
 * Feb 24, 2014 4:00:03 PM
 */
public class User {
	// user id
	public long id;
	
	public String phone;
	
	public String email;
	
	// nick name
	public String screen_name;
	
	// display name
	public String name;
	
	public String description;
	
	// the user homepage in this application
	public String url;
	
	// the picture url
	public String profile_image_url;
	
	// the big picture url
	public String avatar_large;
	
	//m: male; f:female; n:unknown
	public String gender;
	
	public int followers_count;

	public int friends_count;

	public int favourites_count;
	
	// create time
	public long created_at;

	//0: offline; 1: online
	public boolean online_status;
}