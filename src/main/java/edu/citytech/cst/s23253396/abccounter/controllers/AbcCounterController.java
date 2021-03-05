package edu.citytech.cst.s23253396.abccounter.controllers;

import edu.citytech.cst.s23253396.abccounter.services.AbcCounterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AbcCounterController implements Initializable {

    private final AbcCounterService counterService = new AbcCounterService();

    @FXML
    private Label title;

    @FXML
    private FlowPane fpCounter;

    @FXML
    private ToggleGroup tgCounter;

    @FXML
    private RadioButton rbABC;

    @FXML
    private RadioButton rb123;

    @FXML
    private RadioButton rbNone;

    @FXML
    private ChoiceBox<String> cbIsVowel;

    @FXML
    void mode(ActionEvent event) {

        // Show ABC.
        if (this.tgCounter.getSelectedToggle().equals(this.rbABC)) {
            // Clear the working space.
            this.fpCounter.getChildren().clear();
            for (Character abc : counterService.countABC()) {
                var label = new Label(abc.toString());
                label.getStyleClass().add("displayLabel");
                this.fpCounter.getChildren().add(label);
            }

        // Show 123.
        } else if ((this.tgCounter.getSelectedToggle().equals(this.rb123))){
            // Clear the working space.
            this.fpCounter.getChildren().clear();
            for (Integer number : counterService.count123()) {
                var label = new Label(number.toString());
                label.getStyleClass().add("displayLabel");
                this.fpCounter.getChildren().add(label);
            }

        // Clear the view.
        } else {
            this.fpCounter.getChildren().clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fpCounter.getChildren().clear();

        cbIsVowel.getItems().add("Nothing");
        cbIsVowel.getItems().add("Vowels");
        cbIsVowel.getItems().add("Consonants");

        
    }
}
