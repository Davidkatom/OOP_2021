import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Hypernym class
 * User ID - shnaidd1
 */
public class HypernymDatabase {
    private Map<String, Hypernym> hypernyms = new HashMap<>();

    /**
     * Adds a hypernym to the database.
     *
     * @param lemma lemma
     * @return Hypernym added
     */
    public Hypernym addHypernym(String lemma) {
        if (hypernyms.containsKey(lemma.toLowerCase())) {
            return hypernyms.get(lemma.toLowerCase());
        }
        Hypernym hypernym = new Hypernym(lemma.toLowerCase());
        hypernyms.put(lemma.toLowerCase(), hypernym);
        return hypernym;
    }

    /**
     * Remove hypernym from database.
     *
     * @param lemma Hypernym lemma
     */
    public void remove(String lemma) {
        hypernyms.remove(lemma);
    }

    /**
     * Gets Hypernym.
     *
     * @return Hypernym
     */
    public Map<String, Hypernym> getHypernyms() {
        return hypernyms;
    }

    /**
     * Sorts the database alphabetically.
     */
    public void sort() {

        //Comparator<Hypernym> comparator = Comparator.comparing(Hypernym::getLemmaLowerCase);
        Comparator<Hypernym> comparator = new Comparator<>() {
            @Override
            public int compare(Hypernym o1, Hypernym o2) {
                return o1.getLemma().compareTo(o2.getLemma());
            }
        };
        List<Map.Entry<String, Hypernym>> list = new ArrayList<>(hypernyms.entrySet());
        list.sort(Map.Entry.comparingByValue(comparator));

        Map<String, Hypernym> result = new LinkedHashMap<>();
        for (Map.Entry<String, Hypernym> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        hypernyms = result;

    }
}


