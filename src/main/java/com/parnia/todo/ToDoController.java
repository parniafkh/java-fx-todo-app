package com.parnia.todo;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
public class ToDoController {
    @FXML
    private TextField taskInputField;

    @FXML
    private ListView<TodoTask> taskListView;
    @FXML
    public void initialize() {
        taskListView.setCellFactory(param -> new TaskCell());
    }

    @FXML
    protected void onAddTaskClick() {
        String title = taskInputField.getText();
        if (title != null && !title.isEmpty()) {
            // Erstelle ein neues Objekt statt nur einen String
            TodoTask newTask = new TodoTask(title);
            taskListView.getItems().add(newTask);
            taskInputField.clear();
        }
    }


}
