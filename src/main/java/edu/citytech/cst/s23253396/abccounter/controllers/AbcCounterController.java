package edu.citytech.cst.s23253396.abccounter.controllers;

import edu.citytech.cst.s23253396.abccounter.services.AbcCounterService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.Locale;
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
    public void selectABC(ActionEvent event) {

        // Show ABC.
        if (this.tgCounter.getSelectedToggle().equals(this.rbABC)) {
            // Clear the working space.
            this.fpCounter.getChildren().clear();
            // Iterate over the list with the alphabet
            for (Character abc : counterService.countABC()) {
                var label = new Label(abc.toString());
                // Add style to the label.
                label.getStyleClass().add("displayLabel");
                // Add the label to the flow pane.
                this.fpCounter.getChildren().add(label);
            }

        }
    }

    @FXML
    public void select123(ActionEvent event) {

        if ((this.tgCounter.getSelectedToggle().equals(this.rb123))){
            // Clear the working space.
            this.fpCounter.getChildren().clear();
            // Iterate over 1-50.
            for (Integer number : counterService.count123()) {
                var label = new Label(number.toString());
                // Add style to the label.
                label.getStyleClass().add("displayLabel");
                // Add the label to the flow pane.
                this.fpCounter.getChildren().add(label);
            }

            // Clear the view.
        }
    }

    @FXML
    public void selectNothing(ActionEvent event) {
        this.fpCounter.getChildren().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fpCounter.getChildren().clear();

        this.cbIsVowel.getItems().add("Nothing");
        this.cbIsVowel.getItems().add("Vowels");
        this.cbIsVowel.getItems().add("Consonants");

        this.cbIsVowel.setOnAction(this::selectMode);
    }

    private void selectMode(ActionEvent event) {
        String selectedItem = this.cbIsVowel.getSelectionModel().getSelectedItem().toLowerCase(Locale.ROOT);

        if (selectedItem.contains("vowel".toLowerCase(Locale.ROOT))) {

            for (Node currentLabel : this.fpCounter.getChildren()) {

                var realLabel = (Label) currentLabel;
                boolean isVowel = this.counterService.isVowel(realLabel.getText());

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel");

                if (isVowel) {

                    currentLabel.getStyleClass().add("isVowel");
                }
            }

        }

        if (selectedItem.contains("consonants".toLowerCase(Locale.ROOT))) {

            for (Node currentLabel : this.fpCounter.getChildren()) {

                var realLabel = (Label) currentLabel;
                boolean isConsonant = this.counterService.isConstant(realLabel.getText());

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel");

                if (isConsonant) {
                    currentLabel.getStyleClass().add("isConsonant");
                }
            }
        }

        if (selectedItem.contains("nothing".toLowerCase(Locale.ROOT))) {
            for (Node currentLabel : this.fpCounter.getChildren()) {
                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel");
            }
        }
    }
}
