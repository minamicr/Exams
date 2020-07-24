package br.com.minami.error;

public class ResourceNotFoundDetails extends ErrorDetails {

	//VERIFICAR COMO EXIBIR DATA FORMATADA
	//VERIFICAR ULTIMA AULA DE EXCEPTION
	

	public static final class Builder {
		private String title;
		private Integer status;
		private String detail;
		private Long timeStamp;
		private String date;
		private String developerMessage;
		
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
		
		public Builder date(String date) {
			this.date = date;
			return this;
		}
		
		public Builder developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ResourceNotFoundDetails build() {
			ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
			resourceNotFoundDetails.setDeveloperMessage(developerMessage);
			resourceNotFoundDetails.setDetail(detail);
			resourceNotFoundDetails.setStatus(status);
			resourceNotFoundDetails.setTimestamp(timeStamp);
			resourceNotFoundDetails.setTitle(title);
			
			return resourceNotFoundDetails;
		}
	}
}
