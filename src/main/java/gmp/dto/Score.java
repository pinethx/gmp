package gmp.dto;

public class Score {
	private int no;
	private Student stdNo;
	private Subject subCode;
	private int subScore;

	public Score(Student stdNo) {
		super();
		this.stdNo = stdNo;
	}

	public Score(int no, Student stdNo, Subject subCode, int subScore) {
		super();
		this.no = no;
		this.stdNo = stdNo;
		this.subCode = subCode;
		this.subScore = subScore;
	}

	public Score(Subject subCode, int subScore) {
		super();
		this.subCode = subCode;
		this.subScore = subScore;
	}

	public Score(Student stdNo, Subject subCode) {
		super();
		this.stdNo = stdNo;
		this.subCode = subCode;
	}

	public Score(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Student getStdNo() {
		return stdNo;
	}

	public void setStdNo(Student stdNo) {
		this.stdNo = stdNo;
	}

	public Subject getSubCode() {
		return subCode;
	}

	public void setSubCode(Subject subCode) {
		this.subCode = subCode;
	}

	public int getSubScore() {
		return subScore;
	}

	public void setSubScore(int subScore) {
		this.subScore = subScore;
	}

	@Override
	public String toString() {
		return "Score [no=" + no + ", stdNo=" + stdNo.getStdNo() + ", subCode=" + subCode.getSubCode() + ", subScore=" + subScore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stdNo == null) ? 0 : stdNo.hashCode());
		result = prime * result + ((subCode == null) ? 0 : subCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (stdNo == null) {
			if (other.stdNo != null)
				return false;
		} else if (!stdNo.equals(other.stdNo))
			return false;
		if (subCode == null) {
			if (other.subCode != null)
				return false;
		} else if (!subCode.equals(other.subCode))
			return false;
		return true;
	}

}
