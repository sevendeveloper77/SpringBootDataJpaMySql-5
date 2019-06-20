package com.app.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("select p from com.app.model.Product p")
	public List<Product> getMyData();
	
	@Query("select p.prodCost from com.app.model.Product p")
	public List<Double> getCostOnly();
	
	@Query("select p.prodCost,p.prodCode from com.app.model.Product p")
	public List<Object[]> getInfo();
	
	//passing parameters(inputs at runtime)
	@Query("select p from com.app.model.Product p where p.prodId=?1 or p.prodCost<?2")
	public List<Product> getNewData(Integer pid, Double cost);
	
	@Query("select p from com.app.model.Product p where p.prodId=:a or p.prodCost<:b")
	public List<Product> getMyDataName(Integer a, Double b);
	
	@Query("select p from com.app.model.Product p where p.prodId in:a order by p.prodId desc")
	public List<Product> getMyDataAggrigate(List<Integer> a);
	
	//non-select operations
	
	@Modifying
	@Transactional
	@Query("update Product p set p.prodCost=:cost where p.prodId=:id")
	public int updateCost(Double cost, Integer id);
	
	
	@Modifying
	@Transactional
	@Query("delete from Product p where p.prodId=:id")
	public int removeData(Integer id);
	
	//special cases
	
	@Query("select p from Product p where p.prodId=:id")
	public Product getData(Integer id);
	
	@Query("select p from Product p where p.prodId=:id")
	public Optional<Product> getInfo(Integer id);
}
