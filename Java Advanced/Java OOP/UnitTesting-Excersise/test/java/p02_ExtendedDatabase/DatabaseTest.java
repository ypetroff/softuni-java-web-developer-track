package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person PERSON = new Person(100, "Pesho");
    private static final Person PERSON_NOT_ADDED_TO_ARRAY = new Person(102, "Dani");

    private static final Person[] PEOPLE = {
            PERSON,
            new Person(101, "Dimo"),
};

    private Database database;

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorAddsPerson() {
        Assert.assertEquals(PEOPLE.length, database.getElements().length);
        Assert.assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowsONSELessThanOnePerson() throws OperationNotSupportedException {
        new Database();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowsONSEMoreThan16Person() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddMethodPersonEqualsNullThrowsONSE() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddPerson() throws OperationNotSupportedException {
        database.add(PERSON_NOT_ADDED_TO_ARRAY);
    }

    @Test
    public void testRemovePerson() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(PEOPLE[PEOPLE.length - 2], database.getElements()[database.getElements().length - 1]);
    }
    
    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveNoMoreElementsThrowONSE() throws OperationNotSupportedException {
        for (int i = 0; i <= database.getElements().length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameNoSuchUserThrowONSE() throws OperationNotSupportedException {
        database.findByUsername(PERSON_NOT_ADDED_TO_ARRAY.getUsername());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsername_NULL_Person_Throw_ONSE() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameTheSameNameForTwoUsersThrowONSE() throws OperationNotSupportedException {
        new Database(PERSON, PERSON).findByUsername(PERSON.getUsername());
    }

    @Test
    public void testFindByUsernameReturnsCorrectPerson() throws OperationNotSupportedException {
        Assert.assertEquals(PEOPLE[0], database.findByUsername("Pesho"));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdUserNotPresentInList() throws OperationNotSupportedException {
        database.findById(PERSON_NOT_ADDED_TO_ARRAY.getId());
    }

    @Test
    public void testUserNameIsNull() throws OperationNotSupportedException {
        database.add(PERSON_NOT_ADDED_TO_ARRAY);

    }

}