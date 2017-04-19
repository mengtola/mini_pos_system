package com.post.model;

import java.util.ArrayList;

public class SaleAdd {
	private int cusId;
	private ArrayList<SaleProduct> saleProduct;

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public ArrayList<SaleProduct> getSaleProduct() {
		return saleProduct;
	}

	public void setSaleProduct(ArrayList<SaleProduct> saleProduct) {
		this.saleProduct = saleProduct;
	}

}
