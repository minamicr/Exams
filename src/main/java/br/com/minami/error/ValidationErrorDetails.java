package br.com.minami.error;

import br.com.minami.error.ResourceNotFoundDetails.Builder;

public class ValidationErrorDetails extends ErrorDetails {
	private String field;
	private String fieldMessage;
	
	public static final class Builder {
		private String title;
		private Integer status;
		private String detail;
		private Long timeStamp;
		private String developerMessage;
		private String field;
		private String fieldMessage;

		public Builder() {	
		}
		
		public static Builder newBuilder() {
			return new Builder();
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder status(Integer status) {
			this.status = status;
			return this;
		}
		
		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}
		
		public Builder timeStamp(Long timeStamp) {
			this.timeStamp = timeStamp;
			return this;
		}
		
		public Builder developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}
		
		public Builder field(String field) {
			this.field = field;
			return this;
		}
		
		public Builder fieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
			return this;
		}		

		public ValidationErrorDetails build() {
			ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
			validationErrorDetails.setDeveloperMessage(title);
			validationErrorDetails.setDetail(detail);
			validationErrorDetails.setStatus(status);
			validationErrorDetails.setTimestamp(timeStamp);
			validationErrorDetails.setTitle(title);
			validationErrorDetails.field = field;
			validationErrorDetails.fieldMessage = fieldMessage;
			
			return validationErrorDetails;
		}
	}
}
