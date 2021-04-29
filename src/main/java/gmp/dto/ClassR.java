package gmp.dto;

public class ClassR {
	private int classNo;
	private String classRm;

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public ClassR(int classNo) {
		super();
		this.classNo = classNo;
	}

	public ClassR(String classRm) {
		super();
		this.classRm = classRm;
	}

	public ClassR(int no, String classR) {
		super();
		classNo = no;
		classRm = classR;
	}

	public ClassR() {
		super();
	}

	public String getClassRm() {
		return classRm;
	}

	public void setClassRm(String classR) {
		classRm = classR;
	}

	@Override
	public String toString() {
		return classRm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNo;
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
		ClassR other = (ClassR) obj;
		if (classNo != other.classNo)
			return false;
		return true;
	}

}
