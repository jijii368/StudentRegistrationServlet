package models;

public class StudentModel {
	
	private int id;
	private String name;
	private String date;
	private String gender;
	private String phone;
	private String education;
	private String attend;
	private byte[] photo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getAttend() {
		return attend;
	}
	public void setAttend(String attend) {
		this.attend = attend;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public StudentModel() {
		super();
	}
	public StudentModel(int id, String name, String date, String gender, String phone, String education,
			String attend, byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.phone = phone;
		this.education = education;
		this.attend = attend;
		this.photo = photo;
	}
	
	public StudentModel(String name, String attend) {
		super();
		this.name = name;
		this.attend = attend;
	}
	public StudentModel(String name, String date, String gender, String phone, String education, String attend,
			byte[] photo) {
		super();
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.phone = phone;
		this.education = education;
		this.attend = attend;
		this.photo = photo;
	}
	public StudentModel(int id, String name, String attend) {
		super();
		this.id = id;
		this.name = name;
		this.attend = attend;
	}
	public StudentModel(int id, String name, String date, String phone, String education) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.phone = phone;
		this.education = education;
	}
	
	

}