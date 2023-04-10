import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author David Shnaiderov - 209198308
 * Hypernym class
 * User ID - shnaidd1
 */
public class Hypernym {
    private final String lemma;
    private final List<Hyponym> hyponyms;

    /**
     * Constructor.
     *
     * @param lemma Hypernym lemma
     */
    public Hypernym(String lemma) {
        this.lemma = lemma;
        hyponyms = new LinkedList<>();
    }

    /**
     * Returns Hyponym list.
     *
     * @return List of Hyponyms
     */
    public List<Hyponym> getHyponyms() {
        return hyponyms;
    }

    /**
     * Add a hyponym to the list.
     *
     * @param l Hyponym lemma
     */
    public void addHyponym(String l) {
        for (Hyponym hyponym : hyponyms) {
            if (hyponym.getLemma().equals(l)) {
                hyponym.addOccurrence();
                return;
            }
        }
        hyponyms.add(new Hyponym(l));
    }

    /**
     * Gets the lemma.
     *
     * @return String Lemma
     */
    public String getLemma() {
        return lemma;
    }

    /**
     * Number of hyponyms.
     *
     * @return int Count
     */
    public int getHyponymCount() {
        return getHyponyms().size();
    }


    /**
     * Creates a string version of the Hypernym.
     *
     * @return String representation
     */
    public String write() {
        StringBuilder output = new StringBuilder();
        //Comparator<Hyponym> comparator = Comparator.comparing(Hyponym :: getOccurrences);
        Comparator<Hyponym> comparator = new Comparator<>() {
            @Override
            public int compare(Hyponym o1, Hyponym o2) {
                return Integer.compare(o1.getOccurrences(), o2.getOccurrences());
            }
        };

        hyponyms.sort(comparator.reversed());


        for (Hyponym hyponym : hyponyms) {
            output.append(" ").append(hyponym.getLemma()).append(" ").append("(").
                    append(hyponym.getOccurrences()).append(")");
            if (!hyponym.equals(hyponyms.get(hyponyms.size() - 1))) {
                output.append(",");
            }
        }
        return output.toString();
    }
}
