package controller;

import db.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
public class CreateUserFormController {
    public Label lblUserId;
    public TextField txtUserName;
    public TextField txtEnterEmail;
    public PasswordField pwdNewPassword;
    public PasswordField pwdConfirmPassword;
    public Label lblPasswordNotMatchConfirmPassword;
    public Label lblPasswordNotMatchNewPassword;
    public AnchorPane root;

    public void initialize(){
        txtUserName.setDisable(true);
        txtEnterEmail.setDisable(true);
        pwdNewPassword.setDisable(true);
        pwdConfirmPassword.setDisable(true);
        lblPasswordNotMatchNewPassword.setVisible(false);
        lblPasswordNotMatchConfirmPassword.setVisible(false);
    }


}
