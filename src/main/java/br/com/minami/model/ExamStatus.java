package br.com.minami.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExamStatus {
	private Long examPatientId;
    private Long patientId;
    private Long examId;
    private String textResult;
    private Double valueResult;
    private Long referenceGroupId;
    private Long statusExamId;
    private Date creationDate;
    private String creationUser;
    private Date modificationDate;
    private String modificationUser;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getExamPatientId() {
		return examPatientId;
	}
	public void setExamPatientId(Long examPatientId) {
		this.examPatientId = examPatientId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	public String getTextResult() {
		return textResult;
	}
	public void setTextResult(String textResult) {
		this.textResult = textResult;
	}
	public Double getValueResult() {
		return valueResult;
	}
	public void setValueResult(Double valueResult) {
		this.valueResult = valueResult;
	}
	public Long getReferenceGroupId() {
		return referenceGroupId;
	}
	public void setReferenceGroupId(Long referenceGroupId) {
		this.referenceGroupId = referenceGroupId;
	}
	public Long getStatusExamId() {
		return statusExamId;
	}
	public void setStatusExamId(Long statusExamId) {
		this.statusExamId = statusExamId;
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
