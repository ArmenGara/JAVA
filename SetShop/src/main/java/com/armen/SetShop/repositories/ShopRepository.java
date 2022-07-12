package com.armen.SetShop.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.armen.SetShop.models.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
	List<Shop> findAll();

}
