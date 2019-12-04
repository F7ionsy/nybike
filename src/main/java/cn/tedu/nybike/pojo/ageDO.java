package cn.tedu.nybike.pojo;

public class ageDO {
	private int count;

	public ageDO(int count) {
		super();
		this.count = count;
	}

	public ageDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ageDO [count=" + count + "]";
	}

}
