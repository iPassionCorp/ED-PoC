package th.co.ipassion.ed.bean;

import java.util.List;

import th.co.ipassion.ed.model.PocCustomer;
import th.co.ipassion.ed.model.PocRegisCusProdPK;

public class SaveDataAll {
	
	
	PocCustomer customer;
	
	List<PocRegisCusProdPK> products;

	public PocCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(PocCustomer customer) {
		this.customer = customer;
	}

	public List<PocRegisCusProdPK> getProducts() {
		return products;
	}

	public void setProducts(List<PocRegisCusProdPK> products) {
		this.products = products;
	}
	
	
}

