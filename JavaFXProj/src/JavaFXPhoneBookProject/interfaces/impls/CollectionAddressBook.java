package JavaFXPhoneBookProject.interfaces.impls;

import JavaFXPhoneBookProject.Objects.Person;
import JavaFXPhoneBookProject.interfaces.AddressBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by John on 09.06.2017.
 */
public class CollectionAddressBook implements AddressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();


    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList(){
        return  personList;
    }
}
