package tl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Paypaldata;

public interface PaypalRepository extends JpaRepository<Paypaldata, Integer> {

}
