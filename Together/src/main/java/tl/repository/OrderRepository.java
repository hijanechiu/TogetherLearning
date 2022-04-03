package tl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.TLOrder;

public interface OrderRepository extends JpaRepository<TLOrder, Integer> {

}
