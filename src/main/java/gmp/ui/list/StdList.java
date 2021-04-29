package gmp.ui.list;

import javax.swing.SwingConstants;

import gmp.dto.Student;
import gmp.service.StudentService;
import gmp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class StdList extends AbstractCustomList<Student> {
	
	public StdList() {}
	
	private StudentService service;

	@Override
	public Student getItem() {
		int row = table.getSelectedRow();
		Student std = list.get(row);
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(std));
	}

	@Override
	protected void initList() {
		list = service.showStudentAll();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"학번", "이름", "분반"};
	}
	
	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		setTableCellWidth(200, 400, 100);
	}
	
	public void setService(StudentService service) {
		this.service = service;
	}

	@Override
	protected Object[] toArray(Student t) {
		return new Object[] {t.getStdNo(), t.getStdName(), t.getClassR().getClassRm() };
	}
}
