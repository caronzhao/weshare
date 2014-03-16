package org.weshare.web.model;

import java.util.List;

/**
 * @author Caron Zhao
 * 
 *         Feb 24, 2014 4:00:09 PM
 */
public class Book {
	private long id;
	private String title;
	private String coverPath;
	private String thumbnailCoverPath;
	private User owner; // ˭��
	private List<User> lenders; // ˭���
	private List<User> wanters; // ˭���
	private List<User> likers; // ˭ϲ��
	// visibility
	private long returnDate; // �黹����, -1��ʾû��ָ��
//	private BookStatus status;
	private String introduction; // ���
	// private String comment; // should not be here?
	private List<String> stores; // �Ƽ���� link
	
	public Book(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<User> getLenders() {
		return lenders;
	}

	public void setLenders(List<User> lenders) {
		this.lenders = lenders;
	}

	public List<User> getWanters() {
		return wanters;
	}

	public void setWanters(List<User> wanters) {
		this.wanters = wanters;
	}

	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}

	public long getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(long returnDate) {
		this.returnDate = returnDate;
	}

//	public BookStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(BookStatus status) {
//		this.status = status;
//	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<String> getStores() {
		return stores;
	}

	public void setStores(List<String> stores) {
		this.stores = stores;
	}

	public long getId() {
		return id;
	}
}