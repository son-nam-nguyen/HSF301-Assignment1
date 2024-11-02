package fall.hsf.slot2.repository;

import java.util.List;

import fall.hsf.slot2.dao.StudentDAO;
import fall.hsf.slot2.pojo.Student;

public class StudentRepository implements IStudentRepository{
	private StudentDAO studentDAO;

	public StudentRepository(String jpaName) {
		studentDAO = new StudentDAO(jpaName);
	}
	
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDAO.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentDAO.getStudents();
	}

	@Override
	public void delete(int studentID) {
		// TODO Auto-generated method stub
		studentDAO.delete(studentID);
	}

	@Override
	public Student findById(int studentID) {
		// TODO Auto-generated method stub
		return studentDAO.findById(studentID);
	}

	@Override
	public List<Student> findByName(String studentName) {
		// TODO Auto-generated method stub
		return studentDAO.findByName(studentName);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDAO.update(student);
	}

}
