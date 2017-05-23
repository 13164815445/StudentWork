package unp.student.work.manager.utils;
import java.util.List;
public class PageBean {
	public int curPage; // 当前页码
	public int maxPage; // 总的页数
	public int maxRowCount; // 总的记录�?
	public int rowsPerPage=10; // 每页记录�?
	public List data ;    //每页�?��显示的数�?
	/**
	* @Description: 根据记录数计算页�?
	* @param      
	* @return void   
	* @throws
	 */
	public void countMaxPage() { 
		if (this.maxRowCount % this.rowsPerPage == 0) {
			this.maxPage = this.maxRowCount / this.rowsPerPage;
		} else {
			this.maxPage = this.maxRowCount / this.rowsPerPage + 1;
		}
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxRowCount() {
		return maxRowCount;
	}
	public void setMaxRowCount(int maxRowCount) {
		this.maxRowCount = maxRowCount;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
}


//test