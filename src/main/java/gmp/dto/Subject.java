package gmp.dto;

public class Subject {
	private int subCode;
	private String subName;
	
	public Subject(int subCode, String subName) {
		super();
		this.subCode = subCode;
		this.subName = subName;
	}

	public Subject(int subCode) {
		super();
		this.subCode = subCode;
	}

	public Subject(String subName) {
		super();
		this.subName = subName;
	}

	public Subject() {
		super();
	}

	public int getSubCode() {
		return subCode;
	}

	public void setSubCode(int subCode) {
		this.subCode = subCode;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	@Override
	public String toString() {
		return subName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subCode;
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
		Subject other = (Subject) obj;
		if (subCode != other.subCode)
			return false;
		return true;
	}
	
	
}
