package th.co.ipassion.ed.bean;

import java.util.List;

import th.co.ipassion.ed.model.PocRegisCusProdPK;

public class SaveData {
	
	private long cusId;
	List<PocRegisCusProdPK> products;
	
	public SaveData() {
		
	}
	public SaveData(long cusId, List<PocRegisCusProdPK> products) {
		super();
		this.cusId = cusId;
		this.products = products;
	}
	public long getCusId() {
		return cusId;
	}
	public void setCusId(long cusId) {
		this.cusId = cusId;
	}
	public List<PocRegisCusProdPK> getProducts() {
		return products;
	}
	public void setProducts(List<PocRegisCusProdPK> products) {
		this.products = products;
	}

	
	
}

