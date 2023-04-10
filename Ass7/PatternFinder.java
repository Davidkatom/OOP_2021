import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author David Shnaiderov - 209198308
 * Finds Hypernyms with patternes.
 * User ID - shnaidd1
 */
public class PatternFinder {
    private static final String NP = "<np>[^>]*</np>";

    /**
     * Constructor.
     *
     * @param paragraph - Line to read
     * @param database  - database to store in
     */
    public void findPattern(String paragraph, HypernymDatabase database) {
        String[] patternStrings = new String[3];
        patternStrings[0] = "(<np>[^><]+</np>) *,? ?((such as)|((including)|(especially))) ?"
                + "( ? *,? ?(<np>[^><]+</np>) ?)*( ? *,?( ?(and|or))? ?(<np>[^><]+</np>))?";

        patternStrings[1] = "( such )(<np>[^><]+<\\/np>) *,? ?(as) ?( ?,? ?(<np>[^><]+<\\/np>)"
                + " ?)*( ? *,?( ?(and|or))? ?(<np>[^><]+<\\/np>))?";

        patternStrings[2] = "(<np>[^><]+<\\/np>) *,? ?(which is (((an example)|(a kind)|a class)? of )?"
                + ")(<np>[^><]+<\\/np>)";


        for (String patternString : patternStrings) {
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(paragraph);

            while (matcher.find()) {
                String found = paragraph.substring(matcher.start(), matcher.end());
                if (patternString.equals(patternStrings[2])) {
                    hypernymSecond(found, database);
                } else {
                    hypernymFirst(found, database);
                }
            }
        }
    }

    /**
     * Hypernym is the second word.
     *
     * @param found    Phrase
     * @param database database
     */
    private void hypernymSecond(String found, HypernymDatabase database) {
        Pattern pattern = Pattern.compile(NP);
        Matcher matcher = pattern.matcher(found);
        String firstNP = "";
        String secondNP = "";
        if (matcher.find()) {
            firstNP = found.substring(matcher.start(), matcher.end());
        }

        if (matcher.find()) {
            secondNP = found.substring(matcher.start(), matcher.end());
        }
        Hypernym hypernym = database.addHypernym(secondNP.replaceAll("(</np>)|(<np>)", ""));
        hypernym.addHyponym(firstNP.replaceAll("(</np>)|(<np>)", ""));


    }

    /**
     * Hypernym is the first word.
     *
     * @param found    Phrase
     * @param database database
     */
    private void hypernymFirst(String found, HypernymDatabase database) {
        Pattern pattern = Pattern.compile(NP);
        Matcher matcher = pattern.matcher(found);
        Hypernym hypernym = null;
        boolean first = true;
        while (matcher.find()) {
            String word = found.substring(matcher.start(), matcher.end());

            if (first) {
                hypernym = database.addHypernym(word.replaceAll("(</np>)|(<np>)", ""));
                first = false;
            } else {
                hypernym.addHyponym(word.replaceAll("(</np>)|(<np>)", ""));
            }
        }
        assert hypernym != null;
        if (hypernym.getHyponyms().size() == 0) {
            database.remove(hypernym.getLemma());
        }
    }

}

