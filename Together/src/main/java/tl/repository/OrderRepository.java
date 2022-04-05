package tl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.TLOrder;

public interface OrderRepository extends JpaRepository<TLOrder, Integer> {


	public List<TLOrder> findBySid(Integer sid);

	



}
