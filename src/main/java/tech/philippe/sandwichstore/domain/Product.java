package tech.philippe.sandwichstore.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import tech.philippe.sandwichstore.domain.type.UnitType;

@MappedSuperclass
public abstract class Product extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String description;
	private UnitType unit;
	private BigDecimal unitPrice;
	private BigDecimal stockQuantity;
	private BigDecimal servingPerNormalSize;

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Enumerated(EnumType.STRING)
	public UnitType getUnit() {
		return unit;
	}

	public void setUnit(UnitType unit) {
		this.unit = unit;
	}

	@Column(precision=10, scale=3)
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(BigDecimal stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public BigDecimal getServingPerNormalSize() {
		return servingPerNormalSize;
	}

	public void setServingPerNormalSize(BigDecimal servingPerNormalSize) {
		this.servingPerNormalSize = servingPerNormalSize;
	}
}
