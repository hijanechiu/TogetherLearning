package tl.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Dict;

public interface dictRepository extends JpaRepository<Dict, String> {

	Page<Dict> findBycustomField1(Pageable pageable,String customField1);
	

	

}
