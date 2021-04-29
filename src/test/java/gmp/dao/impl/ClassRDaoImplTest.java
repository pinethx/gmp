package gmp.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gmp.dao.ClassRDao;
import gmp.dto.ClassR;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassRDaoImplTest {
	private static ClassRDao dao = ClassRDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test04SelectClassRByAll() {
		System.out.printf("%s()%n", "test04SelectTitleByAll");
		List<ClassR> classList = dao.selectClassRByAll();
		Assert.assertNotNull(classList);

		for (ClassR t : classList) {
			System.out.println(t);
		}
	}

	@Test
	public void test05SelectClassRByNo() {
		System.out.printf("%s()%n", "testSelectTitleByNo");
		ClassR classR = new ClassR(2);
		ClassR searchclassR = dao.selectClassRByNo(classR);
		Assert.assertNotNull(searchclassR);
		System.out.println(searchclassR);
	}

	@Test
	public void test01InsertClassR() {
		System.out.printf("%s()%n", "testInsertTitle");
		ClassR newClassR = new ClassR(3, "A03");
		int res = dao.insertClassR(newClassR);
		Assert.assertEquals(1, res);
//		System.out.println(dao.selectClassRByNo(newClassR));

		dao.selectClassRByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test02UpdateClassR() {
		System.out.printf("%s()%n", "testUpdateTitle");
		ClassR newClassR = new ClassR(3, "A04");
		int res = dao.updateClassR(newClassR);
		Assert.assertEquals(1, res);
//		System.out.println(dao.selectClassRByNo(newClassR));

		dao.selectClassRByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test03DeleteClassR() {
		System.out.printf("%s()%n", "testDeleteTitle");
		int res = dao.deleteClassR(3);
		Assert.assertEquals(1, res);
		
		dao.selectClassRByAll().stream().forEach(System.out::println);
	}

}
