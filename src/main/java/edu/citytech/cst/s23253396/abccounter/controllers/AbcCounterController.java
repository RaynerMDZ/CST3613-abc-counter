package edu.citytech.cst.s23253396.abccounter.controllers;

import edu.citytech.cst.s23253396.abccounter.enums.AbcSelectBoxChoice;
import edu.citytech.cst.s23253396.abccounter.enums.NumberSelectBoxChoice;
import edu.citytech.cst.s23253396.abccounter.services.AbcCounterService;
import edu.citytech.cst.s23253396.abccounter.services.AbcCounterServiceJsonImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AbcCounterController implements Initializable {

    private final AbcCounterService counterService = new AbcCounterServiceJsonImpl();

    private int counter = 0;

    @FXML
    private Label title;

    @FXML
    private Label count;

    @FXML
    private FlowPane fpCounter;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ToggleGroup tgCounter;

    @FXML
    private RadioButton rbABC;

    @FXML
    private RadioButton rb123;

    @FXML
    private RadioButton rb321;

    @FXML
    private RadioButton rbNone;

    @FXML
    private RadioButton rbCBA;

    @FXML
    private RadioButton rbAaBbCb;

    @FXML
    private RadioButton rb369;

    @FXML
    private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scrollPane.setFitToWidth(true);
        this.scrollPane.setFitToHeight(true);
        this.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.fpCounter.getChildren().clear();
        this.count.setText("Count is: 0");
    }

    // Letters ---------------------------------------------------------
    @FXML
    public void selectABC(ActionEvent event) {
        this.count.setText("Count is: 0");
        this.choiceBox.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.choiceBoxABC();

        // Iterate over the list with the alphabet
        for (Character abc : this.counterService.countABC()) {
            var label = new Label(abc.toString());
            // Add style to the label.
            label.getStyleClass().add("displayLabel");
            // Add the label to the flow pane.
            this.fpCounter.getChildren().add(label);
        }
    }

    @FXML
    public void selectCBA(ActionEvent event) {
        this.count.setText("Count is: 0");
        this.choiceBox.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.choiceBoxABC();

        // Iterate over the list with the alphabet
        for (Character abc : this.counterService.countCBA()) {
            var label = new Label(abc.toString());
            // Add style to the label.
            label.getStyleClass().add("displayLabel");
            // Add the label to the flow pane.
            this.fpCounter.getChildren().add(label);
        }
    }

    @FXML
    public void selectAaBbCc(ActionEvent event) {
        this.count.setText("Count is: 0");
        this.choiceBox.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.choiceBoxABC();

        // Iterate over the list with the alphabet

        this.counterService.countAaBbCc().forEach((string) -> {
            var label = new Label(string);
            // Add style to the label.
            label.getStyleClass().add("displayLabel-bigger");
            // Add the label to the flow pane.
            this.fpCounter.getChildren().add(label);

        });
    }

    private void choiceBoxABC() {
        for (AbcSelectBoxChoice choice : AbcSelectBoxChoice.values()) {
            this.choiceBox.getItems().add(choice.toString());
        }
        this.choiceBox.setOnAction(this::selectModeABC);
    }

    private void selectModeABC(ActionEvent event) {

        String selectedItem = this.choiceBox.getSelectionModel().getSelectedItem();

        if (selectedItem == null) return;

        if (selectedItem.equalsIgnoreCase(AbcSelectBoxChoice.VOWEL.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isVowel;
                currentLabel.getStyleClass().clear();

                if (this.tgCounter.getSelectedToggle().equals(this.rbAaBbCb)) {
                    isVowel = this.counterService.isVowelAaBbCc(((Label) currentLabel).getText());

                    currentLabel.getStyleClass().add("displayLabel-bigger");

                    if (isVowel) {
                        currentLabel.getStyleClass().add("isVowelBigger");
                        this.counter++;
                    }

                } else {
                    isVowel = this.counterService.isVowel(((Label) currentLabel).getText());
                    currentLabel.getStyleClass().add("displayLabel");
                    if (isVowel) {
                        currentLabel.getStyleClass().add("isVowel");
                        this.counter++;
                    }
                }
            });

            this.count.setText("Count is: " + counter);
            this.counter = 0;
        }

        if (selectedItem.equalsIgnoreCase(AbcSelectBoxChoice.CONSONANT.toString())) {

            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isConsonant;
                currentLabel.getStyleClass().clear();

                if (this.tgCounter.getSelectedToggle().equals(this.rbAaBbCb)) {
                    isConsonant = this.counterService.isConsonantAaBbCc(((Label) currentLabel).getText());

                    currentLabel.getStyleClass().add("displayLabel-bigger");

                    if (isConsonant) {
                        currentLabel.getStyleClass().add("isConsonantBigger");
                        this.counter++;
                    }

                } else {
                    isConsonant = this.counterService.isConsonant(((Label) currentLabel).getText());
                    currentLabel.getStyleClass().add("displayLabel");

                    if (isConsonant) {
                        currentLabel.getStyleClass().add("isConsonant");
                        this.counter++;
                    }
                }
            });

            this.count.setText("Count is: " + counter);
            this.counter = 0;
        }

        if (selectedItem.equalsIgnoreCase(AbcSelectBoxChoice.NOTHING.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                currentLabel.getStyleClass().clear();

                if (this.tgCounter.getSelectedToggle().equals(this.rbAaBbCb)) {
                    currentLabel.getStyleClass().add("displayLabel-bigger");
                } else {
                    currentLabel.getStyleClass().add("displayLabel");
                }
            });

            this.counter = 0;
            this.count.setText("Count is: " + counter);
        }
    }

    // Numbers ---------------------------------------------------------
    @FXML
    public void select123(ActionEvent event) {

        this.choiceBox.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.count.setText("Count is: 0");
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
        this.choiceBox.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.count.setText("Count is: 0");
        this.choiceBox123();

        for (Integer number : counterService.count321()) {
            var label = new Label(number.toString());
            // Add style to the label.
            label.getStyleClass().add("displayLabel-123");
            // Add the label to the flow pane.
            this.fpCounter.getChildren().add(label);
        }
    }

    @FXML
    public void select369(ActionEvent event) {
        this.choiceBox.getItems().clear();
        this.fpCounter.getChildren().clear();
        this.count.setText("Count is: 0");
        this.choiceBox123();

        for (Integer number : counterService.count369()) {
            var label = new Label(number.toString());
            // Add style to the label.
            label.getStyleClass().add("displayLabel-123");
            // Add the label to the flow pane.
            this.fpCounter.getChildren().add(label);
        }
    }

    private void choiceBox123() {
        for (NumberSelectBoxChoice choice : NumberSelectBoxChoice.values()) {
            this.choiceBox.getItems().add(choice.toString());
        }
        this.choiceBox.setOnAction(this::selectMode123);
    }

    private void selectMode123(ActionEvent event) {
        String selectedItem = this.choiceBox.getSelectionModel().getSelectedItem();

        if (selectedItem == null) return;

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.EVEN.toString())) {

            this.fpCounter.getChildren().forEach(currentLabel -> {

                boolean isEven = this.counterService.isEven(Integer.parseInt(((Label) currentLabel).getText()));

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");
                if (isEven) {
                    currentLabel.getStyleClass().add("isEven");
                    this.counter++;
                }
            });

            this.count.setText("Count is: " + counter);
            this.counter = 0;
        }

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.ODD.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isOdd = this.counterService.isOdd(Integer.parseInt(((Label) currentLabel).getText()));

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");

                if (isOdd) {
                    currentLabel.getStyleClass().add("isOdd");
                    this.counter++;
                }
            });

            this.count.setText("Count is: " + counter);
            this.counter = 0;
        }

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.EVERY_6.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean isDivisibleBy6 = this.counterService.isDivisibleBy6(Integer.parseInt(((Label) currentLabel).getText()));

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");

                if (isDivisibleBy6) {
                    currentLabel.getStyleClass().add("isDivisibleBy6");
                    this.counter++;
                }
            });

            this.count.setText("Count is: " + counter);
            this.counter = 0;
        }

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.CONTAINS_7.toString())) {

            this.fpCounter.getChildren().forEach(currentLabel -> {
                boolean contains7 = this.counterService.contains7(Integer.parseInt(((Label) currentLabel).getText()));

                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");

                if (contains7) {
                    currentLabel.getStyleClass().add("contains7");
                    counter++;
                }
            });

            this.count.setText("Count is: " + counter);
            this.counter = 0;
        }

        if (selectedItem.equalsIgnoreCase(NumberSelectBoxChoice.NOTHING.toString())) {
            this.fpCounter.getChildren().forEach(currentLabel -> {
                currentLabel.getStyleClass().clear();
                currentLabel.getStyleClass().add("displayLabel-123");
            });

            this.counter = 0;
            this.count.setText("Count is: " + counter);
        }
    }

    // Nothing ---------------------------------------------------------
    @FXML
    public void selectNothing(ActionEvent event) {
        this.count.setText("Count is: 0");
        this.choiceBox.getItems().clear();
        this.fpCounter.getChildren().clear();
    }

}
