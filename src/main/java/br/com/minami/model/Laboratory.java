package br.com.minami.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laboratory {
	private Long laboratoryId;
	private String name;
	private String nickname;
	private Date creationDate;
	private String creationUser;
	private Date modificationDate;
	private String modificationUser;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return laboratoryId;
	}
	public void setId(Long id) {
		this.laboratoryId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreationUser() {
		return creationUser;
	}
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getModificationUser() {
		return modificationUser;
	}
	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}
	@Override
	public String toString() {
		return "Laboratory [laboratoryId=" + laboratoryId + ", name=" + name + ", nickname=" + nickname
				+ ", creationDate=" + creationDate + ", creationUser=" + creationUser + ", modificationDate="
				+ modificationDate + ", modificationUser=" + modificationUser + "]";
	}
	
	
}
