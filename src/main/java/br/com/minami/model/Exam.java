package br.com.minami.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exam {
	private Long examId;
    private String name;
    private String tag;
    private Long materialId;
    private String unit;
    private Long mainExamId;
    private Date creationDate;
    private String creationUser;
    private Date modificationDate;
    private Date modificationUser;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Long getMainExamId() {
		return mainExamId;
	}
	public void setMainExamId(Long mainExamId) {
		this.mainExamId = mainExamId;
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
	public Date getModificationUser() {
		return modificationUser;
	}
	public void setModificationUser(Date modificationUser) {
		this.modificationUser = modificationUser;
	}
    
    
}
