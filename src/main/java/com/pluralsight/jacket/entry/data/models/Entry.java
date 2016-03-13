package com.pluralsight.jacket.entry.data.models;

import javax.persistence.Entity;
import javax.persistence.Table;

<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> hf1
=======
>>>>>>> bd3dcb6c94605feb645a9757c67759dc3d17ecd4
@Entity
@Table(name = "entries")
public class Entry extends BaseModel {

	private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
