package cn.edu.model;

public class Pager {
	private int totalRows = 100; // 总行数
	private int pageSize = 10; // 每页显示的行数
	private int pageNo = 0; // 当前页号,从0开始
	private int totalPages = 10; // 总页数
	private int startRow = 1; // 当前页在数据库中的起始行

	public Pager() {
	}

	public Pager(int totalRows, int pageSize, int pageNo, int totalPages,
			int startRow) {
		super();
		this.totalRows = totalRows;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalPages = totalPages;
		this.startRow = startRow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	@Override
	public String toString() {
		return "Pager [totalRows=" + totalRows + ", pageSize=" + pageSize
				+ ", pageNo=" + pageNo + ", totalPages=" + totalPages
				+ ", startRow=" + startRow + "]";
	}

}