package tl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Subscription;

public interface SubcriptionRepository extends JpaRepository<Subscription, Integer> {

	public Subscription findByEmail(String email);

}
