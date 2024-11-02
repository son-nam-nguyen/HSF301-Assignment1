package fall.hsf.slot2.repository;

import java.util.List;

import fall.hsf.slot2.pojo.Student;

public interface IStudentRepository {
	public void save(Student student);
	
	public List<Student> getStudents();
	
	public void delete(int studentID);
	
	public Student findById(int studentID);
	
	public List<Student> findByName(String studentName);
	
	public void update(Student student);
}
