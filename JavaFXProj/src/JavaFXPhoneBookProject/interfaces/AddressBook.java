package JavaFXPhoneBookProject.interfaces;

import JavaFXPhoneBookProject.Objects.Person;

/**
 * Created by John on 09.06.2017.
 */
public interface AddressBook {
    void add(Person person);

    void update(Person person);

    void delete(Person person);
}
