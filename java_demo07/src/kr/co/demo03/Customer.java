package kr.co.demo03;

import java.util.Objects;

public class Customer extends Person {
	
	
	private double discount = 0.03;

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Customer [getName()=" + getName() + ", getAge()=" + getAge() + ", getGender()=" + getGender()
				+ ", discount=" + discount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(discount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Double.doubleToLongBits(discount) == Double.doubleToLongBits(other.discount);
	}
}
