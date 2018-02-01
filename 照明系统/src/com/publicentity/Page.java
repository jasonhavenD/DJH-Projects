package com.publicentity;

public class Page {
	private  Integer pageIndex;
	private Integer pageSize;
	private Integer totalCount;
	
	public Page() {
		super();
		this.pageIndex = 1;
	}
	public Page(Integer pageIndex, Integer pageSize){
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public Page(Integer pageIndex, Integer pageSize, Integer totalCount) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	
    //总页数 
    public Integer getPageCount(){ 
    	int size = totalCount/pageSize;//总条数/每页显示的条数=总页数 
        int mod = totalCount % pageSize;//最后一页的条数 
        if(mod != 0) 
            size++; 
        return totalCount == 0 ? 1 : size; 
    } 
    
    //当前页 
    public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer currentPage){ 
        int validPage = currentPage <= 0 ? 1 : currentPage; 
        validPage = validPage > getPageCount() ? getPageCount() : validPage; 
        this.pageIndex = validPage; 
    }
    
    //获取查询起始位置
    public int getFromIndex(){ 
        //System.out.println("from index:"+(currentPage-1) * pageSize); 
        return (this.pageIndex-1) * this.pageSize; 
    } 
    //不包含 
    public int getToIndex(){ 
        //System.out.println("to index:"+Math.min(recordCount, currentPage * pageSize)); 
        return  Math.min(this.totalCount, this.pageIndex * this.pageSize); 
    } 
    
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
