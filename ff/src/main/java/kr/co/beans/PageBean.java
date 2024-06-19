package kr.co.beans;

public class PageBean {
	// 최소 페이지 번호
	   private int min;
	   // 최대 페이지 번호
	   private int max;
	   // 이전 버튼의 페이지 번호
	   private int prevPage;
	   // 다음 버튼의 페이지 번호
	   private int nextPage;
	   // 전체 페이지 개수
	   private int pageCnt;
	   // 현재 페이지 번호
	   private int currentPage;
	   
	   //contentCnt:전체 글 개수, currentPage:현재 글 번호, contentPageCnt:페이지당 글의 개수, paginationCnt:페이지 버튼 개수
	   public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		  //현재 페이지 번호
		   this.currentPage= currentPage;
		   
		   //전체 페이지 개수
		   pageCnt= contentCnt / contentPageCnt;
		   
		   //553/10=53 ... 3 53+1=54
		   if(contentCnt % contentPageCnt>0) {
			   pageCnt++;
		   }
		   
		   min=((currentPage-1)/contentPageCnt)*contentPageCnt+1;
		   max=min+paginationCnt -1;
		   
		   if(max > pageCnt) {
			   max=pageCnt;
		   }
		   
		   prevPage= min-1;
		   nextPage= max+1;
		   
		   //마지막 페이지를 넘어가지 않도록
		   if(nextPage>pageCnt) {
			   nextPage=pageCnt;
		   }
	   }
	   
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	   
}
