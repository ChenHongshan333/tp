package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRAIT_FLUFFY;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BOWIE;
import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class PersonTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Person person = new PersonBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> person.getTraits().remove(0));
    }

    @Test
    public void isSamePerson() {
        // same object -> returns true
        assertTrue(BOWIE.isSamePerson(BOWIE));

        // null -> returns false
        assertFalse(BOWIE.isSamePerson(null));

        // same name, all other attributes different -> returns true
        Person editedBowie = new PersonBuilder(BOWIE).withLocation(VALID_LOCATION_BOB)
                .withTraits(VALID_TRAIT_FLUFFY).withHealth("Unknown").build();
        assertTrue(BOWIE.isSamePerson(editedBowie));

        // different name, all other attributes same -> returns false
        editedBowie = new PersonBuilder(BOWIE).withName(VALID_NAME_BOB).build();
        assertFalse(BOWIE.isSamePerson(editedBowie));

        // name differs in case -> returns true (case-insensitive check)
        Person editedBob = new PersonBuilder(BOB).withName(VALID_NAME_BOB.toLowerCase()).build();
        assertTrue(BOB.isSamePerson(editedBob));

        // name has trailing spaces -> returns false (different trimmed string)
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedBob = new PersonBuilder(BOB).withName(nameWithTrailingSpaces).build();
        assertFalse(BOB.isSamePerson(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Person bowieCopy = new PersonBuilder(BOWIE).build();
        assertTrue(BOWIE.equals(bowieCopy));

        // same object -> returns true
        assertTrue(BOWIE.equals(BOWIE));

        // null -> returns false
        assertFalse(BOWIE.equals(null));

        // different type -> returns false
        assertFalse(BOWIE.equals(5));

        // different person -> returns false
        assertFalse(BOWIE.equals(BOB));

        // different name -> returns false
        Person editedBowie = new PersonBuilder(BOWIE).withName(VALID_NAME_BOB).build();
        assertFalse(BOWIE.equals(editedBowie));

        // different location -> returns false
        editedBowie = new PersonBuilder(BOWIE).withLocation(VALID_LOCATION_BOB).build();
        assertFalse(BOWIE.equals(editedBowie));

        // different traits -> returns false
        editedBowie = new PersonBuilder(BOWIE).withTraits(VALID_TRAIT_FLUFFY).build();
        assertFalse(BOWIE.equals(editedBowie));
    }

    @Test
    public void toStringMethod() {
        String expected = Person.class.getCanonicalName() + "{name=" + BOWIE.getName()
                + ", traits=" + BOWIE.getTraits()
                + ", location=" + BOWIE.getLocation()
                + ", health=" + BOWIE.getHealth() + "}";
        assertEquals(expected, BOWIE.toString());
    }
}
