package JavaFXPhoneBookProject.Objects;
import javafx.beans.property.SimpleStringProperty;



public class Person{
    private SimpleStringProperty fio = new SimpleStringProperty("");
    private SimpleStringProperty phoneNumber = new SimpleStringProperty("");
    private SimpleStringProperty eMail = new SimpleStringProperty("");

    public Person(String fio, String phoneNumber, String email){
        this.fio = new SimpleStringProperty(fio);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.eMail = new SimpleStringProperty(email);
    }

    public Person() {

    }

    public String getFio() {
        return fio.get();
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String geteMail() {
        return eMail.get();
    }

    public void seteMail(String eMail) {
        this.eMail.set(eMail);
    }

    public SimpleStringProperty fioProperty(){
        return fio;
    }

    public SimpleStringProperty phoneNumberProperty(){
        return phoneNumber;
    }

    public SimpleStringProperty eMailProperty(){
        return eMail;
    }
}
