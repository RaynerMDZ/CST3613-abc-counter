package edu.citytech.cst.s23253396.abccounter.controllers;

import edu.citytech.cst.s23253396.abccounter.enums.AbcSelectBoxChoice;
import edu.citytech.cst.s23253396.abccounter.enums.NumberSelectBoxChoice;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fpCounter.getChildren().clear();
    }

    @FXML
    public void selectABC(ActionEvent event) {

        this.cbIsVowel.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.choiceBoxABC();

        // Iterate over the list with the alphabet
        for (Character abc : counterService.countABC()) {
            var label = new Label(abc.toString());
            // Add style to the label.
            label.getStyleClass().add("displayLabel");
            // Add the label to the flow pane.
            this.fpCounter.getChildren().add(label);
        }
    }

    private void choiceBoxABC() {
        this.cbIsVowel.getItems().add(AbcSelectBoxChoice.VOWEL.toString());
        this.cbIsVowel.getItems().add(AbcSelectBoxChoice.CONSONANT.toString());
        this.cbIsVowel.getItems().add(AbcSelectBoxChoice.NOTHING.toString());
        this.cbIsVowel.setOnAction(this::selectModeABC);
    }

    private void selectModeABC(ActionEvent event) {

        String selectedItem = this.cbIsVowel.getSelectionModel().getSelectedItem();

        if (selectedItem == null) return;

        if (selectedItem.equalsIgnoreCase(AbcSelectBoxChoice.VOWEL.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isVowel = this.counterService.isVowel(((Label) currentLabel).getText());
                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel");
                if (isVowel) currentLabel.getStyleClass().add("isVowel");
            });
        }

        if (selectedItem.equalsIgnoreCase(AbcSelectBoxChoice.CONSONANT.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isConsonant = this.counterService.isConstant(((Label) currentLabel).getText());
                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel");
                if (isConsonant) currentLabel.getStyleClass().add("isConsonant");
            });
        }

        if (selectedItem.equalsIgnoreCase(AbcSelectBoxChoice.NOTHING.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel");
            });
        }
    }

    @FXML
    public void select123(ActionEvent event) {

        this.cbIsVowel.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.choiceBox123();

        // Iterate over 1-50.
        for (Integer number : counterService.count123()) {
            var label = new Label(number.toString());
            // Add style to the label.
            label.getStyleClass().add("displayLabel-123");
            // Add the label to the flow pane.
            this.fpCounter.getChildren().add(label);
        }
    }

    @FXML
    public void select321(ActionEvent event) {
        this.cbIsVowel.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.choiceBox123();

        for (Integer number : counterService.count321()) {
            var label = new Label(number.toString());
            // Add style to the label.
            label.getStyleClass().add("displayLabel-123");
            // Add the label to the flow pane.
            this.fpCounter.getChildren().add(label);
        }
    }

    private void choiceBox123() {
        this.cbIsVowel.getItems().add(NumberSelectBoxChoice.EVEN.toString());
        this.cbIsVowel.getItems().add(NumberSelectBoxChoice.ODD.toString());
        this.cbIsVowel.getItems().add(NumberSelectBoxChoice.EVERY6.toString());
        this.cbIsVowel.getItems().add(NumberSelectBoxChoice.NOTHING.toString());

        this.cbIsVowel.setOnAction(this::selectMode123);
    }

    private void selectMode123(ActionEvent event) {
        String selectedItem = this.cbIsVowel.getSelectionModel().getSelectedItem();

        if (selectedItem == null) return;

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.EVEN.toString())) {

            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isEven = this.counterService.isEven(Integer.parseInt(((Label) currentLabel).getText()));

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");
                if (isEven) {
                    currentLabel.getStyleClass().add("isEven");
                }
            });
        }

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.ODD.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isOdd = this.counterService.isOdd(Integer.parseInt(((Label) currentLabel).getText()));

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");

                if (isOdd) {
                    currentLabel.getStyleClass().add("isOdd");
                }
            });
        }

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.EVERY6.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isDivisibleBy6 = this.counterService.isDivisibleBy6(Integer.parseInt(((Label) currentLabel).getText()));

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");

                if (isDivisibleBy6) {
                    currentLabel.getStyleClass().add("isDivisibleBy6");
                }
            });
        }

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.NOTHING.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");
            });
        }
    }

    @FXML
    public void selectNothing(ActionEvent event) {
        this.cbIsVowel.getItems().clear();
        this.fpCounter.getChildren().clear();
    }
}
