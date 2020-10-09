package project.port.domain;

public class StudyAttachVO {
    
	private String uuid;
	private String uploadPath;
	private String fileName;
	private int studyno;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getStudyno() {
		return studyno;
	}
	public void setStudyno(int studyno) {
		this.studyno = studyno;
	}
	@Override
	public String toString() {
		return "StudyAttachVO [uuid=" + uuid + ", uploadPath=" + uploadPath + ", fileName=" + fileName + ", studyno="
				+ studyno + "]";
	}
	
	
	
	
	
}
