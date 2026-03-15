package seedu.address.testutil;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.person.Health;
import seedu.address.model.person.Location;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Trait;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person (cat) objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Bowie";
    public static final String DEFAULT_TRAIT = "Orange";
    public static final String DEFAULT_LOCATION = "Utown";
    public static final String DEFAULT_HEALTH = "Vaccinated";

    private Name name;
    private List<Trait> traits;
    private Location location;
    private Health health;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        traits = SampleDataUtil.getTraitList(DEFAULT_TRAIT);
        location = new Location(DEFAULT_LOCATION);
        health = new Health(DEFAULT_HEALTH);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        traits = new ArrayList<>(personToCopy.getTraits());
        location = personToCopy.getLocation();
        health = personToCopy.getHealth();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code traits} into a {@code List<Trait>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTraits(String... traits) {
        this.traits = SampleDataUtil.getTraitList(traits);
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Person} that we are building.
     */
    public PersonBuilder withLocation(String location) {
        this.location = new Location(location);
        return this;
    }

    /**
     * Sets the {@code Health} of the {@code Person} that we are building.
     */
    public PersonBuilder withHealth(String health) {
        this.health = new Health(health);
        return this;
    }

    public Person build() {
        return new Person(name, traits, location, health);
    }

}
