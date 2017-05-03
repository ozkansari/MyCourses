package tr.edu.medipol.hafta11.samples.list;

import java.util.Arrays;
import java.util.List;

/**
 * The removeIf method allows to remove list items based on a condition.
 * 
 * http://www.vogella.com/tutorials/JavaCollections/article.html
 *
 */
public class RemoveIfList {
        public static void main(String[] args) {
                System.out.println("Demonstration of removeIf");
                List<String> l1 = createList();
                // remove all items which contains an "x"
                l1.removeIf(s-> s.toLowerCase().contains("x"));
                l1.forEach(s->System.out.println(s));
        }

        private static List<String>  createList() {
                return Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X");
        }
}
