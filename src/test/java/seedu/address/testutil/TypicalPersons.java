package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_HEALTH_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_HEALTH_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRAIT_FLUFFY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRAIT_ORANGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} (cat) objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person BOWIE = new PersonBuilder().withName("Bowie")
            .withTraits("Orange").withLocation("Utown").withHealth("Vaccinated").build();
    public static final Person MOCHI = new PersonBuilder().withName("Mochi")
            .withTraits("White", "Fluffy").withLocation("Science").withHealth("Unknown").build();
    public static final Person LUNA = new PersonBuilder().withName("Luna")
            .withTraits("Black").withLocation("PGP").withHealth("Vaccinated").build();
    public static final Person KIKI = new PersonBuilder().withName("Kiki")
            .withTraits("Tabby", "short tail").withLocation("SDE").withHealth("Healthy").build();
    public static final Person PIPI = new PersonBuilder().withName("Pipi")
            .withTraits("Calico").withLocation("Biz").withHealth("Unknown").build();
    public static final Person NEMO = new PersonBuilder().withName("Nemo")
            .withTraits("Orange", "striped").withLocation("CLB").withHealth("Vaccinated").build();
    public static final Person SIMBA = new PersonBuilder().withName("Simba")
            .withTraits("Brown").withLocation("FASS").withHealth("Unknown").build();

    // Manually added
    public static final Person FELIX = new PersonBuilder().withName("Felix")
            .withTraits("Grey").withLocation("UTown").withHealth("Unknown").build();
    public static final Person OSCAR = new PersonBuilder().withName("Oscar")
            .withTraits("Black", "White").withLocation("Medicine").withHealth("Unknown").build();

    // Manually added - Cat's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY)
            .withTraits(VALID_TRAIT_ORANGE).withLocation(VALID_LOCATION_AMY).withHealth(VALID_HEALTH_AMY).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB)
            .withTraits(VALID_TRAIT_FLUFFY, VALID_TRAIT_ORANGE).withLocation(VALID_LOCATION_BOB)
            .withHealth(VALID_HEALTH_BOB).build();

    public static final String KEYWORD_MATCHING_MOCHI = "Mochi"; // A keyword that matches MOCHI

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical cats.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(BOWIE, MOCHI, LUNA, KIKI, PIPI, NEMO, SIMBA));
    }
}
