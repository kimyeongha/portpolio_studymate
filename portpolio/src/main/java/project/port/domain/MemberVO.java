package project.port.domain;

public class MemberVO {

  String password;
  String email;
  String name;
 // int studyCnt;
  //int leaderCnt;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "MemberVO [password=" + password + ", email=" + email + ", name=" + name + "]";
}


/*
public int getStudyCnt() {
	return studyCnt;
}
public void setStudyCnt(int studyCnt) {
	this.studyCnt = studyCnt;
}
public int getLeaderCnt() {
	return leaderCnt;
}
public void setLeaderCnt(int leaderCnt) {
	this.leaderCnt = leaderCnt;
}
*/





}