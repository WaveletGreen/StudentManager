package entity;

/**
 * Studentsystem entity. @author MyEclipse Persistence Tools
 */

public class Studentsystem implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String name;
	private String sex;
	private Integer age;
	private String grade;
	private String major;
	private String address;

	// Constructors

	/** default constructor */
	public Studentsystem() {
	}

	/** full constructor */
	public Studentsystem(String name, String sex, Integer age, String grade, String major, String address) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
		this.major = major;
		this.address = address;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}