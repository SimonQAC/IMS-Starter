package com.qa.ims.persistence.domain;

public class Item {

	private Long iid;
	private String name;
	private Double price;
	
	public Item(String name, Double price) {
		this.setName(name);
		this.setPrice(price);
	}
	
	public Item(Long iid, String name, Double price) {
		this.setIid(iid);
		this.setName(name);
		this.setPrice(price);
	}
	
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", name=" + name + ", price=" + price + "]";
	}

	public Long getIid() {
		return iid;
	}

	public void setIid(Long iid) {
		this.iid = iid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}
	
	public String getPriceStr() {
		String priceStr = Double.toString(price);
		return priceStr;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iid == null) ? 0 : iid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Item other = (Item) obj;
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
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}



}
