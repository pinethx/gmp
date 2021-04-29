package gmp.ui.list;

import javax.swing.SwingConstants;

import gmp.dto.ClassR;
import gmp.service.ClassRService;
import gmp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class ClassRList extends AbstractCustomList<ClassR> {
	
	public ClassRList() {}
	
	private ClassRService service;

	@Override
	public ClassR getItem() {
		int row = table.getSelectedRow();
		int classNo = (int) table.getValueAt(row, 0);
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new ClassR(classNo)));
	}

	@Override
	protected void initList() {
		list = service.showClassRAll();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"분반코드", "분반명"};
	}
	
	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellWidth(200, 200);
	}
	
	public void setService(ClassRService service) {
		this.service = service;
	}

	@Override
	protected Object[] toArray(ClassR t) {
		return new Object[] {t.getClassNo(), t.getClassRm() };
	}
}
