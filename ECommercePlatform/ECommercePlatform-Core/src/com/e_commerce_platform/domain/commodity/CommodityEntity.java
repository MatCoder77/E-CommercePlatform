package com.e_commerce_platform.domain.commodity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.e_commerce_platform.domain.category.entity.CategoryEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CommodityEntity {
	
	public enum Condition {
		NEW,
		USED,
		BROKEN;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal price;
	private Condition condition;
	
	@ManyToOne
	private CategoryEntity category;
	
	public int getId() {
		return id;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public CategoryEntity getCategory() {
		return category;
	}
}
