package batu.dev.sem.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

public class MultipartData {

	private Map<String, String> formData;
	private List<FileItem> fileData;

	public Map<String, String> getFormData() {
		return formData;
	}

	public void setFormData(Map<String, String> formData) {
		this.formData = formData;
	}

	public List<FileItem> getFileData() {
		return fileData;
	}

	public void setFileData(List<FileItem> fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "MultipartData [formData=" + formData + ", fileData=" + fileData + "]";
	}

}
