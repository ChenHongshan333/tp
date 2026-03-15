package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_HEALTH;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TRAIT;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Adds a cat profile to the cat notebook.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a cat profile to the cat notebook. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_TRAIT + "TRAIT "
            + PREFIX_LOCATION + "LOCATION "
            + "[" + PREFIX_HEALTH + "HEALTH_STATUS]\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "Bowie "
            + PREFIX_TRAIT + "Orange "
            + PREFIX_LOCATION + "Utown "
            + PREFIX_HEALTH + "Vaccinated";

    public static final String MESSAGE_SUCCESS = "New cat profile successfully added: %1$s.";
    public static final String MESSAGE_DUPLICATE_PERSON = "The cat name already exists!";

    public static final String MESSAGE_MISSING_ATTRIBUTES = "Missing attribute. Make sure to include key attributes";
    public static final String MESSAGE_INVALID_PARAMETERS = "Invalid command parameters!";
    public static final String MESSAGE_DUPLICATION_DETECTED = "Duplication detected!";

    private final Person toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddCommand(Person person) {
        requireNonNull(person);
        toAdd = person;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addPerson(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddCommand)) {
            return false;
        }

        AddCommand otherAddCommand = (AddCommand) other;
        return toAdd.equals(otherAddCommand.toAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}
