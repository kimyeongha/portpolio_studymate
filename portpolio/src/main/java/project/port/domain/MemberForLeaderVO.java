package project.port.domain;

public class MemberForLeaderVO {
int studyno;
String name;
String email;
String studyname;
String subject;
String leaderemail;
@Override
public String toString() {
	return "MemberForLeaderVO [studyno=" + studyno + ", name=" + name + ", email=" + email + ", studyname=" + studyname
			+ ", subject=" + subject + ", leaderemail=" + leaderemail + "]";
}
public int getStudyno() {
	return studyno;
}
public void setStudyno(int studyno) {
	this.studyno = studyno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getStudyname() {
	return studyname;
}
public void setStudyname(String studyname) {
	this.studyname = studyname;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getLeaderemail() {
	return leaderemail;
}
public void setLeaderemail(String leaderemail) {
	this.leaderemail = leaderemail;
}





}

