package gmp.ui.list;

import javax.swing.SwingConstants;

import gmp.dto.ClassR;
import gmp.dto.Grade;
import gmp.dto.Student;
import gmp.service.GradeService;
import gmp.ui.exception.NotSelectedException;
import java.awt.Font;

@SuppressWarnings("serial")
public class GradeTotalList extends AbstractCustomList<Grade> {
	private double korAvg;
	private double engAvg;
	private double mathAvg;
	private double socAvg;
	private double sieAvg;
	private double avgAvg;

	public double getKoravg() {
		double k = 0;
		korAvg = 0;
		for (Grade t : list) {
			double korscore = t.getKor();
			k += korscore;
		}
		korAvg = k / list.size();
		return korAvg;
	}

	public void setKoravg(double koravg) {
		this.korAvg = koravg;
	}

	public double getEngavg() {
		double e = 0;
		engAvg = 0;
		for (Grade t : list) {
			double engscore = t.getEng();
			e += engscore;
			engAvg = e / list.size();
		}
		return engAvg;
	}

	public void setEngavg(double engavg) {
		this.engAvg = engavg;
	}

	public double getMathavg() {
		double m = 0;
		mathAvg = 0;
		for (Grade t : list) {
			double mathscore = t.getMath();
			m += mathscore;
			mathAvg = m / list.size();
		}
		return mathAvg;
	}

	public void setMathavg(double mathavg) {
		this.mathAvg = mathavg;
	}

	public double getSocavg() {
		double s = 0;
		socAvg = 0;
		for (Grade t : list) {
			double socscore = t.getSociety();
			s += socscore;
			socAvg = s / list.size();
		}
		return socAvg;
	}

	public void setSocavg(double socavg) {
		this.socAvg = socavg;
	}

	public double getSieavg() {
		double si = 0;
		sieAvg = 0;
		for (Grade t : list) {
			double sciscore = t.getSience();
			si += sciscore;
			sieAvg = si / list.size();
		}
		return sieAvg;
	}

	public void setSieavg(double sieAvg) {
		this.sieAvg = sieAvg;
	}

	public double getAvgAvg() {
		double a = 0;
		avgAvg = 0;
		for (Grade t : list) {
			double avgscore = t.getAvg();
			a += avgscore;
			avgAvg = a / list.size();
		}
		return avgAvg;
	}

	public void setAvgAvg(double avgAvg) {
		this.avgAvg = avgAvg;
	}

	public GradeTotalList() {
		table.setFont(new Font("돋움", Font.PLAIN, 14));
		table.setRowHeight(30);
	}

	private GradeService service;

	@Override
	public Grade getItem() {
		int row = table.getSelectedRow();
		System.out.println(row);
		Student std = (Student) table.getValueAt(row, 0);
//		Grade std = list.get(row);
		System.out.println(std);
		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(std));
	}

	@Override
	protected void initList() {
		list = service.showGradeAll();
	}

	@Override
	protected void initList2(ClassR cls) {
		list = service.showGradeByClass(cls);
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "학번", "이름", "반", "국어", "영어", "수학", "사회", "과학", "합계", "평균" };
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		setTableCellWidth(200, 200, 150, 100, 100, 100, 100, 100, 100, 100);
	}

	public void setService(GradeService service) {
		this.service = service;
	}

	@Override
	protected Object[] toArray(Grade t) {
		return new Object[] { t.getStd().getStdNo(), t.getStd().getStdName(), t.getStd().getClassR().getClassRm(),
				t.getKor(), t.getEng(), t.getMath(), t.getSociety(), t.getSience(), t.getSum(), t.getAvg() };
	}
}
