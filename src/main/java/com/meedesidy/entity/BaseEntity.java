package com.meedesidy.entity;

public class BaseEntity {
	public Integer id;

	public String name;// 名称

	public String createdAt;// 创建时间

	public String remark;// 备注

	public int pindex;// 当前页

	public int psize;// 每页显示记录数

	public int ptotal;// 总计记录数

	public BaseEntity(Integer id, String name, String createdAt, String remark, int pindex, int psize, int ptotal) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.remark = remark;
		this.pindex = pindex;
		this.psize = psize;
		this.ptotal = ptotal;
	}

	public BaseEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcreatedAt() {
		return createdAt;
	}

	public void setcreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getPindex() {
		return pindex;
	}

	public void setPindex(int pindex) {
		this.pindex = pindex;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}

	public int getPtotal() {
		return ptotal;
	}

	public void setPtotal(int ptotal) {
		this.ptotal = ptotal;
	}
	
}
