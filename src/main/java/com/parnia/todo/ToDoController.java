package com.parnia.todo;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
public class ToDoController {
    @FXML
    private TextField taskInputField;

    @FXML
    private ListView<String> taskListView;

    @FXML
    protected void onAddTaskClick() {
        String task = taskInputField.getText();
        if (!task.isEmpty()) {
            taskListView.getItems().add(task);
            taskInputField.clear();
        }
    }
}
