package JavaFXAddressBookProject.Controllers;

import JavaFXAddressBookProject.Objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EditDialogController {


    @FXML
    public Label lblUName;
    public Label lblNPhone;
    public TextField fldUName;
    public TextField fldNPhone;
    public Button btnOk;
    public Button btnCancel;
    public Label lblEmail;
    public TextField fldEmail;


    private Person person;

    public void actionClose(ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void actionSet (ActionEvent actionEvent) {
        person.setPhoneNumber(fldNPhone.getText());
        person.setFio(fldUName.getText());
        person.seteMail(fldEmail.getText());
        actionClose(actionEvent);
    }

    public void setPerson(Person person){
        if(person == null){
            return;
        }
        this.person = person;
        fldUName.setText(person.getFio());
        fldNPhone.setText(person.getPhoneNumber());
        fldEmail.setText(person.geteMail());
    }

    public Person getPerson(){
        return person;
    }
}
