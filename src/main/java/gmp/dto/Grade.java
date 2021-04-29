package gmp.dto;

import java.util.List;

public class Grade {
	private Score no;
	private Student std;
	private ClassR classr;
	private List<Score> grade;
	private int sum;
	private double avg;

	public Score getNo() {
		return no;
	}

	public void setNo(Score no) {
		this.no = no;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public ClassR getClassr() {
		return classr;
	}

	public void setClassr(ClassR classr) {
		this.classr = classr;
	}

	public List<Score> getGrade() {
		return grade;
	}

	public void setGrade(List<Score> grade) {
		this.grade = grade;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Grade(Score no, Student std, ClassR classr, List<Score> grade, int sum, double avg) {
		super();
		this.no = no;
		this.std = std;
		this.classr = classr;
		this.grade = grade;
		this.sum = sum;
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Grade [no=" + no + ", stdno=" + std + ", classrm=" + classr + ", grade="
				+ grade + ", sum=" + sum + ", avg=" + avg + "]";
	}

}
