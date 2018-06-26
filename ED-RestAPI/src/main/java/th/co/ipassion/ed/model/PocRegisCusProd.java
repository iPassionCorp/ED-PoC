package th.co.ipassion.ed.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the POC_REGIS_CUS_PROD database table.
 * 
 */
@Entity
@Table(name="POC_REGIS_CUS_PROD")
@NamedQuery(name="PocRegisCusProd.findAll", query="SELECT p FROM PocRegisCusProd p")
public class PocRegisCusProd implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	PocRegisCusProdPK id;
	
	public PocRegisCusProd() {
		
	}
	
	public PocRegisCusProd(PocRegisCusProdPK id) {
		super();
		this.id = id;
	}

	public PocRegisCusProdPK getId() {
		return id;
	}

	public void setId(PocRegisCusProdPK id) {
		this.id = id;
	}
	
	//for json
	public long getCusId() {
		return this.id.getCusId();
	}
	public String getGpId() {
		return this.id.getGpId();
	}
	public long getProductId() {
		return this.id.getProductId();
	}
	
}