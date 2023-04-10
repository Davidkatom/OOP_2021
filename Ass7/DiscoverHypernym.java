/**
 * @author David Shnaiderov - 209198308
 * Finds all the hypernyms the lemma is a hyponym of.
 * args[0] - corpus location
 * args[1] - Lemma to search
 * User ID - shnaidd1
 */
public class DiscoverHypernym {
    /**
     * Finds all the hypernyms the lemma is a hyponym of.
     *
     * @param args args[0] - corpus location args[1] - Lemma to search
     */
    public static void main(String[] args) {
        CreateHypernymDatabase createHypernymDatabase = new CreateHypernymDatabase();
        HypernymDatabase database = createHypernymDatabase.createDatabase(args[0]);
        String lemma = args[1];

        for (Hypernym hypernym : database.getHypernyms().values()) {
            for (Hyponym hyponym : hypernym.getHyponyms()) {
                if (hyponym.getLemma().equals(lemma)) {
                    System.out.println(hypernym.getLemma() + ": " + "(" + hyponym.getOccurrences() + ")");
                    break;
                }
            }
        }
    }
}
