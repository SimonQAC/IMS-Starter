package com.qa.ims.persistence.domain;

public class Order {

	private Long oid;
	private Long cid;

	public Order(Long cid) {
		this.setCid(cid);
	}
	public Order(Long oid, Long cid) {
		this.setOid(oid);
		this.setCid(cid);
	}
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cid=" + cid + "]";
	}
		
	


}
