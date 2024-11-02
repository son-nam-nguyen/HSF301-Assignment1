package fall.hsf.slot2.gui;


import fall.hsf.slot2.pojo.Book;
import fall.hsf.slot2.pojo.Student;
import fsll.hsf.slot2.service.IStudentService;
import fsll.hsf.slot2.service.StudentService;



public class MainGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "JPAs";
		IStudentService studentService = new StudentService(fileName);
		Student student = new Student("Lam", "Nguyen", 9);
		Book book = new Book("Java Persistence with Spring", "Catalin Tudose", "9781617299186");
		student.getBooks().add(book); 
		studentService.save(student);			

	}

}
