package application;

import java.io.IOException;

import fall.hsf.slot2.pojo.Account;
import fsll.hsf.slot2.service.AccountService;
import fsll.hsf.slot2.service.IAccountService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountController {
private IAccountService iAccountService;
	
	public AccountController(){
		iAccountService = new AccountService("JPAs");
	}
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private PasswordField txtPassword;
	
	@FXML
    private Label errorLabel;
	
	@FXML
    public void loginOnaction() throws IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        Account account = iAccountService.findByUserName(username);
        errorLabel.setText("");

        if (account != null && account.getPassword().equals(password)) {
            errorLabel.setText("");
            Stage win = (Stage) txtUsername.getScene().getWindow();
            win.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../application/StudentController.fxml"));
            Parent root = loader.load();
            StudentController studentController = loader.getController();
            studentController.setRole(account.getRole());
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            errorLabel.setText("Invalid username or password.");
        }
	}
	@FXML public void cancelOnaction() throws IOException {
		Platform.exit();
	}

}
