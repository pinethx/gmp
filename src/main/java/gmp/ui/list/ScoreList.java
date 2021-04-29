package gmp.ui.list;

import java.awt.Font;

import javax.swing.SwingConstants;

import gmp.dto.ClassR;
import gmp.dto.Score;
import gmp.service.ScoreService;
import gmp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class ScoreList extends AbstractCustomList<Score> {
	
	public ScoreList() {
		table.setFont(new Font("돋움", Font.PLAIN, 14));
		table.setRowHeight(30);
		}

	private ScoreService service;

	@Override
	public Score getItem() {
		int row = table.getSelectedRow();
		Score scr = list.get(row);
		System.out.println(scr);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(scr));
	}

	@Override
	protected void initList() {
		list = service.showScoreAll();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"번호", "이름", "과목명", "점수"};
	}
	
	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3);
		setTableCellWidth(50, 200, 200, 200);
	}
	
	public void setService(ScoreService service) {
		this.service = service;
	}

	@Override
	protected Object[] toArray(Score t) {
		return new Object[] {t.getNo(), t.getStdNo().getStdName(), t.getSubCode().getSubName(), t.getSubScore()};
	}

	@Override
	protected void initList2(ClassR cls) {
	}
}
