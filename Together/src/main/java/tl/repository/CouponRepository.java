package tl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

		public List<Coupon> findBySid(Integer sid);



}
