package gmp.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gmp.dao.GradeDao;
import gmp.dto.Grade;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GradeDaoImplTest {
	private static GradeDao dao = GradeDaoImpl.getInstance();
	
	@Test
	public void test01SelectGradeByAllfromView() {
		System.out.printf("%s()%n", "test01SelectGradeByAllfromView");
		List<Grade> gradeList = dao.selectGradeByAllfromView();
		Assert.assertNotNull(gradeList);

		for (Grade t : gradeList) {
			System.out.println(t);
		}
	}

	@Test
	public void test02SelectGradeByClassfromView() {
		fail("Not yet implemented");
	}

	@Test
	public void test03SelectScoreByStudentfromView() {
		fail("Not yet implemented");
	}

}
