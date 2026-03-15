package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_HEALTH;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TRAIT;

import java.util.List;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Person;
import seedu.address.model.person.Trait;

/**
 * A utility class for Person (cat).
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddCommand(Person person) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(person);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getPersonDetails(Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + person.getName().fullName + " ");
        person.getTraits().forEach(
            s -> sb.append(PREFIX_TRAIT + s.traitName + " ")
        );
        sb.append(PREFIX_LOCATION + person.getLocation().value + " ");
        sb.append(PREFIX_HEALTH + person.getHealth().value + " ");
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        if (descriptor.getTraits().isPresent()) {
            List<Trait> traits = descriptor.getTraits().get();
            if (traits.isEmpty()) {
                sb.append(PREFIX_TRAIT);
            } else {
                traits.forEach(s -> sb.append(PREFIX_TRAIT).append(s.traitName).append(" "));
            }
        }
        descriptor.getLocation().ifPresent(location -> sb.append(PREFIX_LOCATION).append(location.value).append(" "));
        descriptor.getHealth().ifPresent(health -> sb.append(PREFIX_HEALTH).append(health.value).append(" "));
        return sb.toString();
    }
}
