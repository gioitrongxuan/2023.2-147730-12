package com.jmc.htdh.view.test;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class Datatype {
    private Text text;
    private Button name;
    private CheckBox check;
    private ChoiceBox<String> choice;
    private ComboBox<String> combo;


    public Datatype(String text, Button name, CheckBox check, ChoiceBox<String> choice, ComboBox<String> combo) {
        this.text.setText(text);
        this.name = name;
        this.check = check;
        this.choice = choice;
        this.combo = combo;
    }

    public Datatype(String text) {
        this.text = new Text();
        this.name = new Button();
        this.check = new CheckBox();
        this.choice = new ChoiceBox<String>();
        this.combo = new ComboBox<String>();
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Button getName() {
        return name;
    }

    public void setName(Button name) {
        this.name = name;
    }

    public CheckBox getCheck() {
        return check;
    }

    public void setCheck(CheckBox check) {
        this.check = check;
    }

    public ChoiceBox<String> getChoice() {
        return choice;
    }

    public void setChoice(ChoiceBox<String> choice) {
        this.choice = choice;
    }

    public ComboBox<String> getCombo() {
        return combo;
    }

    public void setCombo(ComboBox<String> combo) {
        this.combo = combo;
    }
}
