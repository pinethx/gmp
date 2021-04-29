package gmp.service;

import java.util.List;

import gmp.dao.impl.ClassRDaoImpl;
import gmp.dto.ClassR;

public class ClassRService {
	private ClassRDaoImpl dao = ClassRDaoImpl.getInstance();
	
	public ClassRService() {
		dao = ClassRDaoImpl.getInstance();
	}
	
	public List<ClassR> showClassRAll() {
		return dao.selectClassRByAll();
	}
	
	public void showClassRNo (ClassR classr) {
		dao.selectClassRByNo(classr);
	}
	
	public void createClassR (ClassR classr) {
		dao.insertClassR(classr);
	}
	
	public void delClassR (int classNo) {
		dao.deleteClassR(classNo);
	}
	
	public void upClassR (ClassR newclassR) {
		dao.updateClassR(newclassR);
	}
}
