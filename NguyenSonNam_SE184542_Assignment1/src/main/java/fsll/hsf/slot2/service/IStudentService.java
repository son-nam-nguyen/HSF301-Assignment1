package fsll.hsf.slot2.service;

import java.util.List;

import fall.hsf.slot2.pojo.Student;

public interface IStudentService {
	public void save(Student student);
	
	public List<Student> getStudents();
	
	public void delete(int studentID);
	
	public Student findById(int studentID);
	
	public List<Student> findByName(String studentName);
	
	public void update(Student student);
}
