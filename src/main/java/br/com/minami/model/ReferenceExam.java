package br.com.minami.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReferenceExam {
	private Long referenceExamId;
    private Long referenceGroupId;
    private Long referenceOrder;
    private Long examId;
    private Long laboratoryId;
    private Date validityFrom;
    private Long validityUntil;
    private Double inferiorValueResult;
    private Double upperValueResult;
    private String textResult;
    private Integer ageYears;
    private Integer ageMonths;
    private Integer ageDays;
    private Integer genderId;
    private Boolean menopause;
    private String displayDescription;
    private Long examStatusId;
    private Date creationDate;
    private String creationUser;
    private Date modificationDate;
    private String modificationUser;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getReferenceExamId() {
		return referenceExamId;
	}
	public void setReferenceExamId(Long referenceExamId) {
		this.referenceExamId = referenceExamId;
	}
	public Long getReferenceGroupId() {
		return referenceGroupId;
	}
	public void setReferenceGroupId(Long referenceGroupId) {
		this.referenceGroupId = referenceGroupId;
	}
	public Long getReferenceOrder() {
		return referenceOrder;
	}
	public void setReferenceOrder(Long referenceOrder) {
		this.referenceOrder = referenceOrder;
	}
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	public Long getLaboratoryId() {
		return laboratoryId;
	}
	public void setLaboratoryId(Long laboratoryId) {
		this.laboratoryId = laboratoryId;
	}
	public Date getValidityFrom() {
		return validityFrom;
	}
	public void setValidityFrom(Date validityFrom) {
		this.validityFrom = validityFrom;
	}
	public Long getValidityUntil() {
		return validityUntil;
	}
	public void setValidityUntil(Long validityUntil) {
		this.validityUntil = validityUntil;
	}
	public Double getInferiorValueResult() {
		return inferiorValueResult;
	}
	public void setInferiorValueResult(Double inferiorValueResult) {
		this.inferiorValueResult = inferiorValueResult;
	}
	public Double getUpperValueResult() {
		return upperValueResult;
	}
	public void setUpperValueResult(Double upperValueResult) {
		this.upperValueResult = upperValueResult;
	}
	public String getTextResult() {
		return textResult;
	}
	public void setTextResult(String textResult) {
		this.textResult = textResult;
	}
	public Integer getAgeYears() {
		return ageYears;
	}
	public void setAgeYears(Integer ageYears) {
		this.ageYears = ageYears;
	}
	public Integer getAgeMonths() {
		return ageMonths;
	}
	public void setAgeMonths(Integer ageMonths) {
		this.ageMonths = ageMonths;
	}
	public Integer getAgeDays() {
		return ageDays;
	}
	public void setAgeDays(Integer ageDays) {
		this.ageDays = ageDays;
	}
	public Integer getGenderId() {
		return genderId;
	}
	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}
	public Boolean getMenopause() {
		return menopause;
	}
	public void setMenopause(Boolean menopause) {
		this.menopause = menopause;
	}
	public String getDisplayDescription() {
		return displayDescription;
	}
	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}
	public Long getExamStatusId() {
		return examStatusId;
	}
	public void setExamStatusId(Long examStatusId) {
		this.examStatusId = examStatusId;
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
    
    
    
}
