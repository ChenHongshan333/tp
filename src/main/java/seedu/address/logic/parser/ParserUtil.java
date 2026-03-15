package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Health;
import seedu.address.model.person.Location;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Trait;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     * Validates: not blank, no symbols, max 30 characters.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new ParseException(Name.MESSAGE_BLANK);
        }
        if (trimmedName.length() > Name.MAX_LENGTH) {
            throw new ParseException(Name.MESSAGE_TOO_LONG);
        }
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_HAS_SYMBOLS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String trait} into a {@code Trait}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code trait} is blank.
     */
    public static Trait parseTrait(String trait) throws ParseException {
        requireNonNull(trait);
        String trimmedTrait = trait.trim();
        if (!Trait.isValidTrait(trimmedTrait)) {
            throw new ParseException(Trait.MESSAGE_CONSTRAINTS);
        }
        return new Trait(trimmedTrait);
    }

    /**
     * Parses {@code Collection<String> traits} into a {@code List<Trait>}.
     * Validates: at most 3 traits, no duplicates.
     *
     * @throws ParseException if the collection has more than 3 traits or contains duplicates.
     */
    public static List<Trait> parseTraits(Collection<String> traits) throws ParseException {
        requireNonNull(traits);
        if (traits.size() > 3) {
            throw new ParseException(Trait.MESSAGE_TOO_MANY);
        }
        List<Trait> traitList = new ArrayList<>();
        for (String traitName : traits) {
            Trait trait = parseTrait(traitName);
            if (traitList.contains(trait)) {
                throw new ParseException(Trait.MESSAGE_DUPLICATE);
            }
            traitList.add(trait);
        }
        return traitList;
    }

    /**
     * Parses a {@code String location} into a {@code Location}.
     * Leading and trailing whitespaces will be trimmed.
     * Validates: not blank, max 50 characters.
     *
     * @throws ParseException if the given {@code location} is invalid.
     */
    public static Location parseLocation(String location) throws ParseException {
        requireNonNull(location);
        String trimmedLocation = location.trim();
        if (trimmedLocation.isEmpty()) {
            throw new ParseException(Location.MESSAGE_BLANK);
        }
        if (trimmedLocation.length() > Location.MAX_LENGTH) {
            throw new ParseException(Location.MESSAGE_TOO_LONG);
        }
        return new Location(trimmedLocation);
    }

    /**
     * Parses a {@code String health} into a {@code Health}.
     * Leading and trailing whitespaces will be trimmed.
     * If empty, returns the default health status.
     */
    public static Health parseHealth(String health) {
        requireNonNull(health);
        String trimmedHealth = health.trim();
        if (trimmedHealth.isEmpty()) {
            return new Health(Health.DEFAULT_VALUE);
        }
        return new Health(trimmedHealth);
    }

    // ========================= Legacy methods kept for backward compatibility =========================

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
