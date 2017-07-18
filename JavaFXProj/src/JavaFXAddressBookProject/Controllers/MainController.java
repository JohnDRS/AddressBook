package JavaFXAddressBookProject.Controllers;


import JavaFXAddressBookProject.Objects.Person;
import JavaFXAddressBookProject.interfaces.impls.CollectionAddressBook;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;

public class MainController {



    private CollectionAddressBook addressBook = new CollectionAddressBook();
    private EditDialogController editDialogController;
    private WarningWindowController warningWindowController;

    @FXML
    public Label lblCount;
    public TextField fldSearch;
    public Button btnSearch;
    public Button btnEdit;
    public Button btnDelete;
    public Button btnAdd;
    public TableColumn<Person, String> clmnFIO;
    public TableColumn<Person, String> clmnPhone;
    public TableColumn<Person, String> clmnMail;
    public TableView<Person> tblPhoneBook;
    public FXMLLoader fxmlLoader = new FXMLLoader();
    public FXMLLoader fxmlWWLoader = new FXMLLoader();
    public Parent fxmlEdit;
    private Parent fxmlWarningWindow;

    public Stage editDialogStage;
    private Stage warningDialogStage;
    private Stage mainStage;


    @FXML
    private void initialize(){
        clmnFIO.setCellValueFactory(new PropertyValueFactory<>("fio"));
        clmnPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        clmnMail.setCellValueFactory(new PropertyValueFactory<>("eMail"));

        addressBook.getPersonList().addListener((ListChangeListener<Person>) c -> countUpdate());

        tblPhoneBook.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){
                editDialogController.setPerson((Person) tblPhoneBook.getSelectionModel().getSelectedItem());
                showDialog("Изменение данных");
            }
        });

        tblPhoneBook.setItems(addressBook.getPersonList());

        try{
            fxmlLoader.setLocation(getClass().getResource("../fxml/AddWindow.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            fxmlWWLoader.setLocation(getClass().getResource("../fxml/WarningWindow.fxml"));
            fxmlWarningWindow = fxmlWWLoader.load();
            warningWindowController = fxmlWWLoader.getController();
        }catch(IOException ex){
            ex.printStackTrace();
        }



        countUpdate();
    }

    public void setMainStage(Stage mainStage){
        this.mainStage = mainStage;
    }
    public void countUpdate(){
        lblCount.setText("Количество записей: " + addressBook.getPersonList().size());
    }

    public void actionButtonClicked(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }

        Button clickedButton = (Button) source;

        Person selectedPerson = tblPhoneBook.getSelectionModel().getSelectedItem();

        switch (clickedButton.getId()){
            case "btnAdd":
                editDialogController.setPerson(new Person());
                showDialog("Добавление контакта");
                addressBook.add(editDialogController.getPerson());
                break;

            case "btnEdit":
                if(selectedPerson == null){
                    showWarningWindow("Выберите контакт");
                    break;
                }
                editDialogController.setPerson(selectedPerson);
                showDialog("Изменение данных");
                break;

            case "btnDelete":
                if(selectedPerson == null){
                    showWarningWindow("Выберите контакт");
                    break;
                }
                addressBook.delete(selectedPerson);
                break;
        }
    }
        private void showDialog(String title){

        if(editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setMinWidth(300);
            editDialogStage.setMinHeight(150);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }
        editDialogStage.setTitle(title);
        editDialogStage.showAndWait();
    }

    private void showWarningWindow(String text){
        if(warningDialogStage == null) {
            warningDialogStage = new Stage();
            warningDialogStage.setResizable(false);
            warningDialogStage.setScene(new Scene(fxmlWarningWindow));
            warningDialogStage.initModality(Modality.WINDOW_MODAL);
            warningDialogStage.initOwner(mainStage);
            warningDialogStage.setTitle("Ошибка");
        }
        warningWindowController.setLblWarningWindow(text);
        warningDialogStage.show();
    }

}
