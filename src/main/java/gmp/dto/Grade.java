package gmp.dto;

public class Grade {
	private Student std;
	private ClassR classr;
	private int kor;
	private int eng;
	private int math;
	private int society;
	private int sience;
	private int sum;
	private double avg;

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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSociety() {
		return society;
	}

	public void setSociety(int society) {
		this.society = society;
	}

	public int getSience() {
		return sience;
	}

	public void setSience(int sience) {
		this.sience = sience;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public Grade(Student std) {
		super();
		this.std = std;
	}

	public Grade(Student std, ClassR classr, int kor, int eng, int math, int society, int sience, int sum,
			double avg) {
		super();
		this.std = std;
		this.classr = classr;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.society = society;
		this.sience = sience;
		this.sum = sum;
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Grade [std=" + std + ", classr=" + classr + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", society=" + society + ", sience=" + sience + ", sum=" + sum + ", avg=" + avg + "]";
	}

}
