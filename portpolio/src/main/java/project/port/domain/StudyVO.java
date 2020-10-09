package project.port.domain;

public class StudyVO {
 
 private  String studyname;
 private String quota;
 private int studyno;
 private String subject;
 private int cost;
 private String local;
 private String level;
 private String content;
 private String leader;
 private String email; //리더 email
 private String uuid;
	private String uploadPath;
	private String fileName;

 
 
// private StudyAttachVO Attachvo;
 
public String getStudyname() {
	return studyname;
}
public void setStudyname(String studyname) {
	this.studyname = studyname;
}
public String getQuota() {
	return quota;
}
public void setQuota(String quota) {
	this.quota = quota;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public String getLocal() {
	return local;
}
public void setLocal(String local) {
	this.local = local;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getLeader() {
	return leader;
}
public void setLeader(String leader) {
	this.leader = leader;
}
public int getStudyno() {
	return studyno;
}
public void setStudyno(int studyno) {
	this.studyno = studyno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
//public StudyAttachVO getAttachvo() {
//	return Attachvo;
//}
//public void setAttachvo(StudyAttachVO attachvo) {
	//Attachvo = attachvo;
//}


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
@Override
public String toString() {
	return "StudyVO [studyname=" + studyname + ", quota=" + quota + ", studyno=" + studyno + ", subject=" + subject
			+ ", cost=" + cost + ", local=" + local + ", level=" + level + ", content=" + content + ", leader=" + leader
			+ ", email=" + email + ", uuid=" + uuid + ", uploadPath=" + uploadPath + ", fileName=" + fileName
			+ ", Attachvo=" + "ddd" + "]";
}







}
