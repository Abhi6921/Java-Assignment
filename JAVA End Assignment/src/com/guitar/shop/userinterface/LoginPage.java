package com.guitar.shop.userinterface;

import com.guitar.shop.datalayer.Database;
import com.guitar.shop.model.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import com.guitar.shop.model.SalesRepresentative;

public class LoginPage {
    Stage stage;
    public LoginPage() {

        createPageGrid();
        Database db = new Database();
        ObservableList<SalesRepresentative> data = FXCollections.observableArrayList(db.getSalespersons());
        


        GridPane gridPane = new GridPane();
        // Login label
        Label loginLabel = new Label();
        loginLabel.setText("Login");

        // username label
        Label usernamelabel = new Label();
        usernamelabel.setText("Username:");

        // password label
        Label passwordlabel = new Label();
        passwordlabel.setText("Password:");

        // create textfield for username and password
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");

        String username = usernameInput.getText();

        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");

        String password = passwordInput.getText();

        Button loginButton = new Button();
        loginButton.setText("Login");

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                for(int i=0; i< data.size();i++)
                {
                    if (data.get(i).getUsername().contains(username) && data.get(i).getPassword().contains(password))
                    {
                        System.out.println("You are logged in!");
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid Login!");
                    }
                    break;
                }
            }
        });



        GridPane.setConstraints(usernamelabel,10,10);
        GridPane.setConstraints(usernameInput,11,10);
        GridPane.setConstraints(passwordlabel,10,11);
        GridPane.setConstraints(passwordInput,11,11);
        GridPane.setConstraints(loginButton,11,12);

        createLoginPage(usernamelabel,passwordlabel,usernameInput,passwordInput,loginButton,gridPane);
    }

    private void createLoginPage(Label usernamelabel, Label passwordlabel, TextField usernameInput, TextField passwordInput,Button loginButton, GridPane gridPane) {
        stage = new Stage();
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setTitle("Login Page");
        stage.setX(100);

        gridPane.getChildren().addAll(usernamelabel,passwordlabel,usernameInput,passwordInput,loginButton);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
    }

    private void createPageGrid(){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(8);
    }


}
