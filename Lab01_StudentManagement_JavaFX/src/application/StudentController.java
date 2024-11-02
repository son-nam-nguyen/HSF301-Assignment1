package application;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import fall.hsf.slot2.pojo.Student;
import fsll.hsf.slot2.service.IStudentService;
import fsll.hsf.slot2.service.StudentService;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController implements Initializable{
	private IStudentService iStudentService;
	@FXML
	private TextField txtStudentID;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	
	@FXML
	private TextField txtMarks;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnUpdate;
	@FXML
	private Button btnDelete;
	
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
		switch (this.role) {
		case "ADMIN":
			this.btnAdd.setDisable(false);
			this.btnUpdate.setDisable(false);
			this.btnDelete.setDisable(false);
			break;
		case "STUDENT":
			this.btnAdd.setDisable(true);
			this.btnUpdate.setDisable(true);
			this.btnDelete.setDisable(true);
			break;
		}
	}
	
	public StudentController()
	{
		studentService = new StudentService("JPAs");
		tableModel = FXCollections.observableArrayList(studentService.getStudents());
		
	}
	private IStudentService studentService;
	@FXML
	private TableView<Student> tblStudents;
	@FXML
	private TableColumn<Student, Integer> studentId;
	@FXML
	private TableColumn<Student, String> firstName;
	@FXML
	private TableColumn<Student, String> lastName;
	@FXML
	private TableColumn<Student, Integer> marks;
	
	private ObservableList<Student>tableModel;
	
	
	@FXML public void cancelOnaction() throws IOException {
		Platform.exit();
	}
	
	@FXML public void addOnaction()throws IOException{
		Student st = new Student(txtFirstName.getText(),txtLastName.getText(),Integer.parseInt(txtMarks.getText()));
		studentService.save(st);
		 tableModel.clear(); 
		 tableModel.addAll(studentService.getStudents()); 
		 tblStudents.setItems(tableModel);  
	}
	
	@FXML public void updateOnaction() throws IOException{
		Student st = studentService.findById(Integer.parseInt(txtStudentID.getText()));
		st.setFirstName(txtFirstName.getText());
		st.setLastName(txtLastName.getText());
		st.setMarks(Integer.parseInt(txtMarks.getText()));
		studentService.update(st);
		 tableModel.clear(); 
		 tableModel.addAll(studentService.getStudents()); 
		 tblStudents.setItems(tableModel);  
		
		
	}
	@FXML public void deleteOnaction()throws IOException{
		studentService.delete(Integer.parseInt(txtStudentID.getText()));
		 tableModel.clear(); 
		 tableModel.addAll(studentService.getStudents()); 
		 tblStudents.setItems(tableModel);  
	}
	
	@FXML
	public void searchOnaction() throws IOException {
	    String searchText = txtFirstName.getText();
	    if (!searchText.isEmpty()) {
	        List<Student> foundStudents = studentService.findByName(searchText);
	        ObservableList<Student> filteredList = FXCollections.observableArrayList(foundStudents);
	        tblStudents.setItems(filteredList);
	    } else {
	        tblStudents.setItems(tableModel);
	    }
	}

	protected void showAlert(String string, String string2) {
		
	}
	protected void showStudent(Student student) {
		this.txtStudentID.setText(String.valueOf(student.getId()));
		this.txtFirstName.setText(student.getFirstName());
		this.txtLastName.setText(student.getLastName());
		this.txtMarks.setText(String.valueOf(student.getMarks()));
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		studentId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
		marks.setCellValueFactory(new PropertyValueFactory<>("Marks"));
		tblStudents.setItems(tableModel);
		
		tblStudents.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observableValue, Object oldValue, Object index) {
				if (tblStudents.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel selectionModel = tblStudents.getSelectionModel();
					ObservableList selectedCells = selectionModel.getSelectedCells();
					TablePosition tablePosition = (TablePosition) selectedCells.get(0);
					Object studentID = tablePosition.getTableColumn().getCellData(index);
					try {
						Student student = iStudentService.findById(Integer.valueOf(studentID.toString())); 
						showStudent(student);
					} catch (Exception ex) { 
						showAlert("Infomation Board!", "Please choose the First Cell !");
					}
				}
				
			}
	});
	}
}
