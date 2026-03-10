package com.parnia.todo;

import javafx.scene.control.ListCell;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import org.kordamp.ikonli.javafx.FontIcon;

public class TaskCell extends ListCell<TodoTask> {
    private HBox hbox = new HBox(10);
    private CheckBox doneCheckBox = new CheckBox();
    private Label titleLabel = new Label();
    private Button deleteButton = new Button("🗑️");

    public TaskCell() {
        super();
        // Layout-Einstellungen
        HBox.setHgrow(titleLabel, Priority.ALWAYS);
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        hbox.getChildren().addAll(doneCheckBox, titleLabel, deleteButton);

        // LOGIK: Löschen
        deleteButton.setOnAction(event -> {
            getListView().getItems().remove(getItem());
        });
        FontIcon deleteIcon = new FontIcon("fas-trash-alt"); // "fas" steht für FontAwesome Solid
        deleteIcon.setIconSize(10);
        deleteIcon.setIconColor(javafx.scene.paint.Color.RED);

        deleteButton.setGraphic(deleteIcon);
        deleteButton.setText("");

        // LOGIK: Erledigt (UX-Effekt)
        doneCheckBox.setOnAction(event -> {
            getItem().setCompleted(doneCheckBox.isSelected());
            updateStyle(doneCheckBox.isSelected());
        });
    }

    private void updateStyle(boolean completed) {
        if (completed) {
            titleLabel.setStyle("-fx-text-fill: rgb(128,128,128); -fx-strikethrough: true;");
        } else {
            titleLabel.setStyle("-fx-text-fill: black; -fx-strikethrough: false;");
        }
    }

    @Override
    protected void updateItem(TodoTask item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
        } else {
            titleLabel.setText(item.getTitle());
            doneCheckBox.setSelected(item.isCompleted());
            updateStyle(item.isCompleted());
            setGraphic(hbox);
        }
    }
}