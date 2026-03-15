package seedu.address.model.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Health;
import seedu.address.model.person.Location;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Trait;

/**
 * Contains utility methods for populating {@code AddressBook} with sample cat data.
 */
public class SampleDataUtil {
    /**
     * Returns an array of sample {@code Person} objects.
     */
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Bowie"), getTraitList("Orange"), new Location("Utown"),
                new Health("Vaccinated")),
            new Person(new Name("Mochi"), getTraitList("White", "Fluffy"), new Location("Science"),
                new Health("Unknown")),
            new Person(new Name("Luna"), getTraitList("Black"), new Location("PGP"),
                new Health("Vaccinated")),
            new Person(new Name("Kiki"), getTraitList("Tabby", "short tail"), new Location("SDE"),
                new Health("Healthy")),
            new Person(new Name("Pipi"), getTraitList("Calico"), new Location("Biz"),
                new Health("Unknown")),
            new Person(new Name("Simba"), getTraitList("Brown"), new Location("FASS"),
                new Health("Unknown"))
        };
    }

    /**
     * Returns a sample {@code ReadOnlyAddressBook} pre-populated with sample cat data.
     */
    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a trait list containing the list of strings given.
     */
    public static List<Trait> getTraitList(String... strings) {
        return Arrays.stream(strings)
                .map(Trait::new)
                .collect(Collectors.toList());
    }

}
