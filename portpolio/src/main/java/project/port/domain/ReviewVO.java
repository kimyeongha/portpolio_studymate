package project.port.domain;

import java.util.Date;

public class ReviewVO {
String leader; 
String writer;
String level; 
String content;
String score;
String subject;
int bno;
Date writedate;
String studyname;//
int studyno;


public String getLeader() {
	return leader;
}
public void setLeader(String leader) {
	this.leader = leader;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
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
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public Date getWritedate() {
	return writedate;
}
public void setWritedate(Date writedate) {
	this.writedate = writedate;
	
}

public String getStudyname() {
	return studyname;
}
public void setStudyname(String studyname) {
	this.studyname = studyname;
}
public int getStudyno() {
	return studyno;
}
public void setStudyno(int studyno) {
	this.studyno = studyno;
}
@Override
public String toString() {
	return "ReviewVO [leader=" + leader + ", writer=" + writer + ", level=" + level + ", content=" + content
			+ ", score=" + score + ", subject=" + subject + ", bno=" + bno + ", writedate=" + writedate + ", studyname="
			+ studyname + ", studyno=" + studyno + "]";
}






}
