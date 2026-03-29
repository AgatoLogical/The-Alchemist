import java.util.*;

public class CombinationManager {
    private static List<Combination> combinations = new ArrayList<>();

    public static void addCombination(Combination combination) {
        combinations.add(combination);
    }

    public Item combineItems(Item item1, Item item2) {
        for (Combination combination : combinations) {
            if (((combination.getParent1() == item1 && combination.getParent2() == item2)
                    || (combination.getParent1() == item2 && combination.getParent2() == item1))) {
                if (!combination.isDiscovered())
                    combination.setDiscovered(true);
                return combination.getChild();
            }
        }

        return null;
    }

    public static String getParent1(String name) {

        String nameOfParent1 = CombinationManager.getParents(name).getParent1().name;
        // System.out.println(nameOfParent1);
        return nameOfParent1;
    }

    public static String getParent2(String name) {
        String nameOfParent2 = CombinationManager.getParents(name).getParent2().name;
        // System.out.println(nameOfParent2);
        return nameOfParent2;
    }

    private static Combination getParents(String name) {
        for (Combination combination : combinations) {
            if (name.equals(combination.getChild().name)) {
                // System.out.println("got parents");
                return combination;
            }
        }
        return null;
    }
}
