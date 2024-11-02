package fsll.hsf.slot2.service;

import java.util.List;

import fall.hsf.slot2.pojo.Student;
import fall.hsf.slot2.repository.IStudentRepository;
import fall.hsf.slot2.repository.StudentRepository;

public class StudentService implements IStudentService {

	private IStudentRepository studentRepository;

	public StudentService(String jpaName) {

		studentRepository = new StudentRepository(jpaName);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.getStudents();
	}

	@Override
	public void delete(int studentID) {
		// TODO Auto-generated method stub
		studentRepository.delete(studentID);
	}

	@Override
	public Student findById(int studentID) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentID);
	}

	@Override
	public List<Student> findByName(String studentName) {
		// TODO Auto-generated method stub
		return studentRepository.findByName(studentName);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentRepository.update(student);
	}
}
