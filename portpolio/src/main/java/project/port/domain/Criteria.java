package project.port.domain;

public class Criteria {

	private int pageNum; 
	private int amount;  //한페이지당 게시글 수
	private String subject;
	
	
	public Criteria() {
		this(1,9);
	};
	
	
	public Criteria(int pageNum, int amount) {
	  this.pageNum = pageNum;
	  this.amount= amount;
	}


	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", subject=" + subject + "]";
	}

  
	
	
}
