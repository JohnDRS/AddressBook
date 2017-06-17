package JavaFXAddressBookProject.interfaces.impls;

import JavaFXAddressBookProject.Objects.Person;
import JavaFXAddressBookProject.interfaces.AddressBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
