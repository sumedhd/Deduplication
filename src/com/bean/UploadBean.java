package com.bean;

import java.io.InputStream;

public class UploadBean {
	
	private String cloudname;
	private String filename;
	private String path;
	InputStream file;
	private String key;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public InputStream getFile() {
		return file;
	}
	public void setFile(InputStream file) {
		this.file = file;
	}
	public String getCloudname() {
		return cloudname;
	}
	public void setCloudname(String cloudname) {
		this.cloudname = cloudname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
