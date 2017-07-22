package util;

public class Page {

	private int pageIndex;
	private int totalPages;
	private int prePageIndex;
	private int nextPageIndex;
	private int maxResult;
	private int start;

	public Page() {
	}

	public Page(int pageIndex, int totalPages, int prePageIndex, int nextPageIndex) {
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public int getPageIndex() {
		return this.pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalPages() {
		return this.totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPrePageIndex() {
		return this.prePageIndex;
	}

	public void setPrePageIndex(int prePageIndex) {
		this.prePageIndex = prePageIndex - 1;
		if (this.prePageIndex <= 0) {
			this.prePageIndex = pageIndex;
		}
	}

	public int getNextPageIndex() {
		return this.nextPageIndex;

	}

	public void setNextPageIndex(int nextPageIndex) {
		this.nextPageIndex = nextPageIndex + 1;
		if (this.nextPageIndex > totalPages) {
			this.nextPageIndex = totalPages;
		}
	}

	/**
	 * 根据传入的当前页自动设置上一页和下一页的索引，totalPage需要手动传入
	 * 
	 * @param pageIndex
	 *            当前页数
	 * @param totalPages
	 *            最大页数
	 */

	public void autoSetter(int pageIndex, int totalPages) {
		this.totalPages = totalPages;
		this.prePageIndex = pageIndex - 1;

		if (this.prePageIndex <= 0) {
			this.prePageIndex = 1;
		}
		this.nextPageIndex = pageIndex + 1;
		if (this.nextPageIndex > totalPages) {
			this.nextPageIndex = totalPages;
		}
	}
}
