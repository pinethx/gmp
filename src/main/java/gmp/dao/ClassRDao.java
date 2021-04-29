package gmp.dao;

import java.util.List;

import gmp.dto.ClassR;

public interface ClassRDao {

	List<ClassR> selectClassRByAll();
	ClassR selectClassRByNo(ClassR classR);
	
	int insertClassR(ClassR classR);
	int updateClassR(ClassR newclassR);
	int deleteClassR(int classNo);
}
