package com.e_commerce_platform.domain.commodity;

import com.e_commerce_platform.domain.category.entity.CategoryEntity;
import com.e_commerce_platform.domain.commodity.CommodityEntity.Condition;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CommodityEntity.class)
public abstract class CommodityEntity_ {

	public static volatile SingularAttribute<CommodityEntity, Condition> condition;
	public static volatile SingularAttribute<CommodityEntity, BigDecimal> price;
	public static volatile SingularAttribute<CommodityEntity, Integer> id;
	public static volatile SingularAttribute<CommodityEntity, CategoryEntity> category;

	public static final String CONDITION = "condition";
	public static final String PRICE = "price";
	public static final String ID = "id";
	public static final String CATEGORY = "category";

}

