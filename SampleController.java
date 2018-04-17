package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class SampleController {

    @FXML
    private TabPane cmdTabPane;

    @FXML
    private Tab newVanTab;

    @FXML
    private Button addVanButton;

    @FXML
    private TextField addVanTextField;

    @FXML
    private TextArea addVanTextArea;

    @FXML
    private Tab updateInvTab;

    @FXML
    private Button updateVanButton;

    @FXML
    private TextField updateInvTextField;

    @FXML
    private TextArea addVanTextArea1;

    @FXML
    private TextField updateInvTextField2;

    @FXML
    private Tab enterPartTab;

    @FXML
    private Tab displayPartTab;

    @FXML
    private CheckBox allWareHousesCheckBox;

    @FXML
    private Tab sellPartTab;

    @FXML
    private TextField sellPartTextField1;

    @FXML
    private TextField sellTextField2;

    @FXML
    private Tab sortTab;

    @FXML
    private TextArea sortTextArea;

    @FXML
    private CheckBox sortAllWareHousesCheckbox;

    @FXML
    private ToggleButton nameSortToggleButton;

    @FXML
    private ToggleButton numSortToggleButton;

    @FXML
    private Tab moveTab;

    @FXML
    private Tab showWHTab;

    @FXML
    private Menu quitcmdMenu;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTextField;

    @FXML
    void addVan(ActionEvent event) {

    }

    @FXML
    void addVanInv(ActionEvent event) {

    }

    @FXML
    void allWareHousesYes(ActionEvent event) {

    }

    @FXML
    void quit(ActionEvent event) {

    }
}
