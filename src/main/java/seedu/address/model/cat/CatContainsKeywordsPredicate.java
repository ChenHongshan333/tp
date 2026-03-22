package seedu.address.model.cat;

import seedu.address.commons.util.StringUtil;

import java.util.List;
import java.util.function.Predicate;

public class CatContainsKeywordsPredicate implements Predicate<Cat> {
    private final List<String> nameKeywords;
    private final List<String> locationKeywords;
    private final List<String> traitKeywords;
    private final List<String> healthKeywords;

    public CatContainsKeywordsPredicate(List<String> nameKeywords, List<String> locationKeywords,
                                        List<String> traitKeywords, List<String> healthKeywords) {
        this.nameKeywords = nameKeywords;
        this.locationKeywords = locationKeywords;
        this.traitKeywords = traitKeywords;
        this.healthKeywords = healthKeywords;
    }

    @Override
    public boolean test(Cat cat) {
        boolean matchesName = nameKeywords.isEmpty() || nameKeywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(cat.getName().fullName, keyword));

        boolean matchesLocation = locationKeywords.isEmpty() || locationKeywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(cat.getLocation().value, keyword));

        boolean matchesTraits = traitKeywords.isEmpty() || traitKeywords.stream()
                .anyMatch(keyword -> cat.getTraits().stream()
                        .anyMatch(trait -> StringUtil.containsWordIgnoreCase(trait.traitName, keyword)));

        boolean matchesHealth = healthKeywords.isEmpty() || healthKeywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(cat.getHealth().value, keyword));

        // Returns true only if the cat matches ALL specified criteria (AND logic)
        return matchesName && matchesLocation && matchesTraits && matchesHealth;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof CatContainsKeywordsPredicate)) {
            return false;
        }

        CatContainsKeywordsPredicate otherPredicate = (CatContainsKeywordsPredicate) other;
        return nameKeywords.equals(otherPredicate.nameKeywords)
                && locationKeywords.equals(otherPredicate.locationKeywords)
                && traitKeywords.equals(otherPredicate.traitKeywords)
                && healthKeywords.equals(otherPredicate.healthKeywords);
    }

    @Override
    public int hashCode() {
        return nameKeywords.hashCode() + locationKeywords.hashCode() + traitKeywords.hashCode() + healthKeywords.hashCode();
    }
}
