package gmp.dto;

public class Student {
	private int stdNo;
	private String stdName;
	private ClassR classR;

	public Student(int stdNo, String stdName, ClassR classR) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.classR = classR;
	}

	public Student(int stdNo) {
		super();
		this.stdNo = stdNo;
	}

	public Student(String stdName) {
		super();
		this.stdName = stdName;
	}

	public Student(ClassR classR) {
		super();
		this.classR = classR;
	}

	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", stdName=" + stdName + ", classR=" + classR + "]";
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public ClassR getClassR() {
		return classR;
	}

	public void setClassR(ClassR classR) {
		this.classR = classR;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stdNo;
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
		Student other = (Student) obj;
		if (stdNo != other.stdNo)
			return false;
		return true;
	}
	
}
