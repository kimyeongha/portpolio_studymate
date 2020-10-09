package project.port.domain;

public class ReplyVO {
    int studyno;
    String name;
    String email;
    String studyname;
    String level;
    String subject;
    String leader;
    String local;
    String quota;
    String content;
    String leaderemail;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getLeaderemail() {
		return leaderemail;
	}
	public void setLeaderemail(String leaderemail) {
		this.leaderemail = leaderemail;
	}
	@Override
	public String toString() {
		return "ReplyVO [studyno=" + studyno + ", name=" + name + ", email=" + email + ", studyname=" + studyname
				+ ", level=" + level + ", subject=" + subject + ", leader=" + leader + ", local=" + local + ", quota="
				+ quota + ", content=" + content + ", leaderemail=" + leaderemail + "]";
	}
	
	
    
	
    
    
    
}
