//package com.qa.ims.persistence.domain;
//
//public class OrderUpdate {
//
//	private Long oid;
//	private Long iid;
//	private Long quantity;
//
//	public OrderUpdate(Long oid, Long iid, Long quantity) {
//		this.setOid(oid);
//		this.setIid(iid);
//		this.setQuantity(quantity);
//	}
//	
//	public OrderUpdate(Long oid, Long iid) {
//		this.setOid(oid);
//		this.setIid(iid);
//	}
//	
//	
//	@Override
//	public String toString() {
//		return "OrderUpdate [oid=" + oid + ", iid=" + iid + ", quantity=" + quantity + "]";
//	}
//
//
//	public Long getOid() {
//		return oid;
//	}
//
//	public void setOid(Long oid) {
//		this.oid = oid;
//	}
//
//
//	public Long getIid() {
//		return iid;
//	}
//
//	public void setIid(Long iid) {
//		this.iid = iid;
//	}
//
//	public Long getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Long quantity) {
//		this.quantity = quantity;
//	}
//
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((iid == null) ? 0 : iid.hashCode());
//		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
//		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		OrderUpdate other = (OrderUpdate) obj;
//		if (iid == null) {
//			if (other.iid != null)
//				return false;
//		} else if (!iid.equals(other.iid))
//			return false;
//		if (oid == null) {
//			if (other.oid != null)
//				return false;
//		} else if (!oid.equals(other.oid))
//			return false;
//		if (quantity == null) {
//			if (other.quantity != null)
//				return false;
//		} else if (!quantity.equals(other.quantity))
//			return false;
//		return true;
//	}
//
//
//	
//	
//}