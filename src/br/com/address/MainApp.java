package br.com.address;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane principal;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Eletra");

        initPrincipal();

        showTreeView();
    }
    
    /**
     * Inicializa o Principal (layout base).
     */
    public void initPrincipal() {
        try {
            // Carrega o Principal do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Principal.fxml"));
            principal = (BorderPane) loader.load();
            
            // Mostra a scene (cena) contendo o Principal.
            Scene scene = new Scene(principal);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra o Tree View dentro do Principal.
     */
    public void showTreeView() {
        try {
            // Carrega o Tree View.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TreeView.fxml"));
            AnchorPane treeView = (AnchorPane) loader.load();
            
            // Define o Tree View dentro do Principal.
            principal.setCenter(treeView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retorna o palco principal.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}