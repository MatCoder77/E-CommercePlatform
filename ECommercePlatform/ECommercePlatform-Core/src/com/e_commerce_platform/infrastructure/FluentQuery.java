package com.e_commerce_platform.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.SingularAttribute;

public class FluentQuery {
	
	public interface SelectStep<T> {
		public WhereStep<T> select(Selection<? extends T> selection);
		public WhereStep<T> selectAll();
	}
	
	public interface WhereStep<T> extends BuildStep<T> {
		public GroupByStep<T> where(Predicate ...conditions);
	}
	
	public interface GroupByStep<T> extends BuildStep<T> {
		public HavingStep<T> groupBy(Expression<?>...expressions);
	}
	
	public interface HavingStep<T> extends BuildStep<T> {
		public OrderByStep<T> having();
	}
	
	public interface OrderByStep<T> extends BuildStep<T> {
		public LimitStep<T> orderBy();
	}
	
	public interface LimitStep<T> extends BuildStep<T> {
		public BuildStep<T> limit();
	}
	
	public interface BuildStep<T> {
		public TypedQuery<T> build();
	}
	
	public static <T> FluentQueryBuilder<T> from(Class<T> rootEntityClass) {
		return new FluentQueryBuilder<>(rootEntityClass);
	}
	
	public static class FluentQueryBuilder<T> implements 
	SelectStep<T>, WhereStep<T>, GroupByStep<T>, HavingStep<T>, OrderByStep<T>, LimitStep<T>, BuildStep<T> {

		public FluentQueryBuilder(Class<T> rootEntityClass) {
			this.rootEntityClass = rootEntityClass;
			criteriaQuery = entityManager.getCriteriaBuilder().createQuery(rootEntityClass);
			root = criteriaQuery.from(rootEntityClass);
		}
		@PersistenceContext(unitName = "E-CommercePlatform")
		private EntityManager entityManager;
		
		private CriteriaQuery<T> criteriaQuery;
		private Root<T> root;
		private Class<T> rootEntityClass;
		private Selection<? extends T> selection;
		private Predicate[] predicates;
		private List<Exception> groupByExpressions;
		private Predicate havingCondition;
		
		
		@SuppressWarnings("unchecked")
		@Override
		public TypedQuery<T> build() {
			criteriaQuery.select(selection);
			criteriaQuery.where(predicates);
			return entityManager.createQuery(criteriaQuery);
		}

		@Override
		public BuildStep<T> limit() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LimitStep<T> orderBy() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public OrderByStep<T> having() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public HavingStep<T> groupBy(Expression<?>...expressions) {
			
			return null;
		}

		@Override
		public GroupByStep<T> where(Predicate ...conditions) {
			predicates = conditions;
			return this;
		}

		@Override
		public WhereStep<T> select(Selection<? extends T> selection) {
			this.selection = selection;
			return this;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public WhereStep<T> selectAll() {
			selection = (Selection<? extends T>) root;
			return this;
		}
		
		public <X> Predicate getInSetPredicate(SingularAttribute<T, X> attr, List<X> values) {
			Expression<X> expr = root.get(attr);
			return expr.in(values);
		}
	}
}
