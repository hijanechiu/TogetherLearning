package tl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Point;

public interface PointRepository extends JpaRepository<Point, Integer> {

	public List<Point> findBySid(Integer sid);




}
