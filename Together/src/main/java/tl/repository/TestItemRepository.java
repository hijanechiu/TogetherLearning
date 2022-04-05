package tl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tl.VO.TestItemVO;

public interface TestItemRepository extends JpaRepository<TestItemVO, Long> {

	
	@Query(value="select * from StudentTest as t inner join ItemBank as i on t.item_id=i.item_id where t.student_id=?1" , nativeQuery=true)
	public List<TestItemVO> findDetailBySid(Integer sid);
}

//@Query("select NEW tl.VO.TestItemVO(t.tid,t.grade,t.testTime,i.itemTitle) from studenttest t join t.itembank i")
//
//@Query(value="select t.test_id as tid,t.grade as grade,t.test_time as testTime,i.item_title as itemTitle from studenttest as t inner join itembank as i on t.item_id=i.item_id where t.student_id=?1" , nativeQuery=true)

//@Query("select NEW tl.VO.TestItemVO(t.tid,t.grade,t.testTime,i.itemTitle) from Test t join ItemBank i")