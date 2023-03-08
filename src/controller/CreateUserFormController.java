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

    public void btnOnActionAddNewUser(ActionEvent actionEvent) {
        txtUserName.setDisable(false);
        txtEnterEmail.setDisable(false);
        pwdNewPassword.setDisable(false);
        pwdConfirmPassword.setDisable(false);


        txtUserName.requestFocus();

        Connection connection = DBconnection.getInstance().getConnection();
        System.out.println(connection);
        autoGenerate();



    }
    public void autoGenerate(){

        Connection connection = DBconnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from user order by id desc limit 1");

            boolean isExist = resultSet.next();

            if(isExist){

                String oldId = resultSet.getString(1);
                System.out.println("oldId");

                int length = oldId.length();
                System.out.println("oldId :"+oldId);
                System.out.println("length :"+length);
                String substringId = oldId.substring(1, length);
                int intId = Integer.parseInt(substringId);
                System.out.println("old int id : "+intId);
                intId++;
                System.out.println("new int id : "+intId);

                if(intId<10){
                    lblUserId.setText("u00"+intId);
                }else if(intId<100){
                    lblUserId.setText("u0"+intId);

                }else {
                    lblUserId.setText("u"+intId);
                }


            }
            else {
                lblUserId.setText("u001");

            }


        } catch (SQLException throwables) {
            //  System.out.println("sssssssssss");
            throwables.printStackTrace();
        }
    }
    public void btnOnActionRegister(ActionEvent actionEvent) {
        String newpassword=pwdNewPassword.getText();
        String confirmpassword = pwdConfirmPassword.getText();

        if(newpassword.equals(confirmpassword)){
            pwdNewPassword.setStyle("-fx-border-color:transparent");
            pwdConfirmPassword.setStyle("-fx-border-color:transparent");
            lblPasswordNotMatchConfirmPassword.setVisible(false);
            lblPasswordNotMatchNewPassword.setVisible(false);

            addData();


        }else{
            lblPasswordNotMatchNewPassword.setVisible(true);
            lblPasswordNotMatchConfirmPassword.setVisible(true);
            pwdNewPassword.setStyle("-fx-border-color:red");
            pwdConfirmPassword.setStyle("-fx-border-color:red");
            pwdNewPassword.clear();
            pwdConfirmPassword.clear();
            pwdNewPassword.requestFocus();
        }
    }



}
