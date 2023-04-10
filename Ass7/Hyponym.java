/**
 * @author David Shnaiderov - 209198308
 * Hyponym class
 * User ID - shnaidd1
 */
public class Hyponym {
    private final String lemma;
    private int occurrences = 1;

    /**
     * Constructor.
     *
     * @param lemma lemma
     */
    public Hyponym(String lemma) {
        this.lemma = lemma;
    }

    /**
     * Adds one occurrence.
     */
    public void addOccurrence() {
        occurrences++;
    }

    /**
     * Gets occurrences count.
     *
     * @return Int occurrences
     */
    public int getOccurrences() {
        return occurrences;
    }

    /**
     * Gets Lemma.
     * @return String Lemma
     */
    public String getLemma() {
        return lemma;
    }
}
