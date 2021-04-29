package gmp.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gmp.dao.SubjectDao;
import gmp.dto.Subject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectDaoImplTest {
	private static SubjectDao dao = SubjectDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectSubjectByAll() {
		System.out.printf("%s()%n", "test04SelectTitleByAll");
		List<Subject> subjectList = dao.selectSubjectByAll();
		Assert.assertNotNull(subjectList);

		for (Subject t : subjectList) {
			System.out.println(t);
		}
	}

	@Test
	public void test05SelectStudentByNo() {
		System.out.printf("%s()%n", "testSelectTitleByNo");
		Subject subject = new Subject(05);
		Subject searchsubject = dao.selectSubjectByNo(subject);
		Assert.assertNotNull(searchsubject);
		System.out.println(searchsubject);
	}

	@Test
	public void test01InsertSubject() {
		System.out.printf("%s()%n", "testInsertTitle");
		Subject newSubject = new Subject(06, "화학");
		int res = dao.insertSubject(newSubject);
		Assert.assertEquals(1, res);
//		System.out.println(dao.selectClassRByNo(newClassR));

		dao.selectSubjectByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test02UpdateSubject() {
		System.out.printf("%s()%n", "testUpdateTitle");
		Subject newSubject = new Subject(6, "물리");
		int res = dao.updateSubject(newSubject);
		Assert.assertEquals(1, res);
//		System.out.println(dao.selectClassRByNo(newClassR));

		dao.selectSubjectByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test03DeleteSubject() {
		System.out.printf("%s()%n", "testDeleteTitle");
		int res = dao.deleteSubject(6);
		Assert.assertEquals(1, res);
		
		dao.selectSubjectByAll().stream().forEach(System.out::println);
	}

}
