package gmp.service;

import java.util.List;

import gmp.dao.impl.GradeDaoImpl;
import gmp.dto.ClassR;
import gmp.dto.Grade;

public class GradeService {
	private GradeDaoImpl grddao = GradeDaoImpl.getInstance();

	public GradeService() {
		grddao = GradeDaoImpl.getInstance();
	}

	public List<Grade> showGradeAll() {
		return grddao.selectGradeByAllfromView();
	}
	
	public List<Grade> showGradeByClass(ClassR clr){
		return grddao.selectGradeByClassfromView(clr);
	}
}
