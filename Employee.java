package Package;

public class Employee {
	String name, eno, sal, job, dept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee(String name, String eno, String sal, String job, String dept) {
		super();
		this.name = name;
		this.eno = eno;
		this.sal = sal;
		this.job = job;
		this.dept = dept;
	}

}