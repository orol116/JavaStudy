package edu.kh.comm.board.model.vo;

public class Pagination {
	   // ���������̼�(����¡ ó��)�� �ʿ��� ��� ������ �����ϰ� �ִ� ��ü
	   
	   private int currentPage;      // ���� ������ ��ȣ
	   private int listCount;         // ��ü �Խñ� ��
	   
	   private int limit = 10;         // �� �������� ������ �Խñ��� ��
	   private int pageSize = 10;      // ��� �ϴ� ������ ��ȣ�� ���� ����
	      
	   private int maxPage;         // ���� ū ������ ��ȣ == ������ ������ ��ȣ
	   private int startPage;         // ��� �ϴܿ� ����� �������� ���� ��ȣ
	   private int   endPage;         // ��� �ϴܿ� ����� �������� �� ��ȣ
	   
	   private int prevPage;         // ��� �ϴܿ� ����� ��ȣ�� ���� ��� �� ��ȣ
	   private int nextPage;         // ��� �ϴܿ� ����� ��ȣ�� ���� ��� ���� ��ȣ
	      
	   
	   // ������
	   public Pagination(int currentPage, int listCount) {
	      this.currentPage = currentPage;
	      this.listCount = listCount;
	      
	      calculatePagination(); // ��� �޼��� ȣ��
	   }


	   public int getCurrentPage() {
	      return currentPage;
	   }


	   public void setCurrentPage(int currentPage) {
	      this.currentPage = currentPage;
	      
	      calculatePagination();
	   }


	   public int getListCount() {
	      return listCount;
	   }


	   public void setListCount(int listCount) {
	      this.listCount = listCount;
	      
	      calculatePagination();
	   }


	   public int getLimit() {
	      return limit;
	   }


	   public void setLimit(int limit) {
	      this.limit = limit;
	      
	      calculatePagination();
	   }


	   public int getPageSize() {
	      return pageSize;
	   }


	   public void setPageSize(int pageSize) {
	      this.pageSize = pageSize;
	      
	      calculatePagination();
	   }


	   public int getMaxPage() {
	      return maxPage;
	   }


	   public void setMaxPage(int maxPage) {
	      this.maxPage = maxPage;
	   }


	   public int getStartPage() {
	      return startPage;
	   }


	   public void setStartPage(int startPage) {
	      this.startPage = startPage;
	   }


	   public int getEndPage() {
	      return endPage;
	   }


	   public void setEndPage(int endPage) {
	      this.endPage = endPage;
	   }


	   public int getPrevPage() {
	      return prevPage;
	   }


	   public void setPrevPage(int prevPage) {
	      this.prevPage = prevPage;
	   }


	   public int getNextPage() {
	      return nextPage;
	   }


	   public void setNextPage(int nextPage) {
	      this.nextPage = nextPage;
	   }


	   @Override
	   public String toString() {
	      return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
	            + ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
	            + endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	   }
	   
	   
	   
	   // ����¡ ó���� �ʿ��� ���� ����ϴ� �޼���
	   private void calculatePagination() {
	      
	      // * maxPage ��� : �ִ� ������ �� == ������ ������ ��ȣ
	      
	      // ��ü �Խñ� �� : 500��  //  �������� �Խñ� ��: 10��
	      // -> ������ ������ ��ȣ��?  500 / 10 =  50
	      
	      // ��ü �Խñ� �� : 501��  //  �������� �Խñ� ��: 10��
	      // -> ������ ������ ��ȣ��?  501 / 10 =  51  (50.1�� �ø� ó��)
	      
	      maxPage = (int)Math.ceil(  (double)listCount / limit  );
	      
	      
	      
	      // * startPage : ��� �ϴܿ� ����� �������� ���� ��ȣ
	      
	      // ��� �ϴ� ������ ��ȣ�� ���� ������ 10���� ��
	      
	      // ���� ��������  1~10 �� ��� :  1
	      // ���� �������� 11~20 �� ��� : 11
	      // ���� �������� 21~30 �� ��� : 21
	      
	      startPage = (currentPage - 1) / pageSize * pageSize + 1;
	      
	      
	      
	      // * endPage : ��� �ϴܿ� ����� �������� �� ��ȣ
	      
	      // ��� �ϴ� ������ ��ȣ�� ���� ������ 10���� ��
	      
	      // ���� ��������  1~10 �� ��� : 10
	      // ���� �������� 11~20 �� ��� : 20
	      // ���� �������� 21~30 �� ��� : 30

	      endPage = startPage + pageSize - 1;
	      
	      // ���࿡ endPage�� maxPage�� �ʰ��ϴ� ���
	      if(endPage > maxPage) {
	         endPage = maxPage;
	      }
	      
	      
	      // * prevPage(<) : ��� �ϴܿ� ����� ��ȣ�� ���� ��� �� ��ȣ
	      // * nextPage(>) : ��� �ϴܿ� ����� ��ȣ�� ���� ��� ���� ��ȣ
	      
	      
	      // ���� ��������  1~10 �� ���
	      // < :  1 ������
	      // > : 11 ������
	      
	      // ���� �������� 11~20 �� ���
	      // < : 10 ������
	      // > : 21 ������
	      
	      // ���� �������� 41~50 �� ���  (maxPage�� 50)
	      // < : 40 ������
	      // > : 50 ������
	      
	      if(currentPage <= pageSize) { 
	         prevPage = 1;
	      }else {
	         prevPage = startPage - 1;
	      }
	      
	      
	      if(endPage == maxPage) {
	         nextPage = maxPage;
	      }else {
	         nextPage = endPage + 1;
	      }
	      
	      
	   }

}
