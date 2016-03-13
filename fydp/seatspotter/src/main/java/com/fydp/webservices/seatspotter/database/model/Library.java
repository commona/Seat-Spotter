package com.fydp.webservices.seatspotter.database.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Library {
	
	@XmlElement
	private int libraryId;
	
	@XmlElement
	private String libraryName;
	
	public Library(){}
	
	public Library(int libraryId, String libraryName) {
		this.libraryId = libraryId;
		this.libraryName = libraryName;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
}