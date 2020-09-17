package com.qa.ims.persistence.domain;

public class Order {

	private Long oid;
	private Long cid;
	private Long iid;
	private Long quantity;
	private String name;
	private float price;
	private float total;
	
	


	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cid=" + cid + ", iid=" + iid + ", quantity=" + quantity + ", name=" + name
				+ ", price=" + price + ", total=" + total + "]";
	}
	public Order() {
		
	}
	public Order(Long cid) {
		this.setCid(cid);
	}
	public Order(Long oid, Long iid) {
		this.setOid(oid);
		this.setIid(iid);
	}
	public Order(Long oid2, Long iid2, Long quantity2) {
		this.setOid(oid2);
		this.setIid(iid2);
		this.setQuantity(quantity2);
	}
	public Order(Long oid, Long cid, Long iid, Long quantity, String name, float price, float total) {
		this.setOid(oid);
		this.setCid(cid);
		this.setIid(iid);
		this.setQuantity(quantity);
		this.setName(name);
		this.setPrice(price);
		this.setTotal(total);
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
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((iid == null) ? 0 : iid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + Float.floatToIntBits(total);
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
		if (iid == null) {
			if (other.iid != null)
				return false;
		} else if (!iid.equals(other.iid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}
	
	


}
