package com.parnia.todo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // FXML-Datei aus dem resources-Ordner
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/todo-view.fxml"));

        // Wir erstellen die Szene (Fensterinhalt)
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // Fenster-Einstellungen
        primaryStage.setTitle("Parnias To-Do App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}