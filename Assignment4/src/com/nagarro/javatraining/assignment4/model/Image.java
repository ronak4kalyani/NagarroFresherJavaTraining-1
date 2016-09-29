package com.nagarro.javatraining.assignment4.model;

import java.io.File;

import javax.persistence.*;

@Entity
public class Image {
	@Id @GeneratedValue
	int id ;
	@Transient
	File file ;
	@Column(name="Image_Name")
	String imgName ;
	long imgSize ;
	@Lob
	private byte[] imageData;
	
	@ManyToOne
	User user ;
	
	public int getId() {
		return id;
	}
	public File getFile() {
		return file;
	}
	
	public String getImgName() {
		return imgName;
	}
	public long getImgSize() {
		return imgSize;
	}
	public void setImg(File file) {
		this.file = file;
		this.imgSize =  file.length();
		this.imgName = file.getName();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public void setImgSize(long imgSize) {
		this.imgSize = imgSize;
	}
	
	
}
