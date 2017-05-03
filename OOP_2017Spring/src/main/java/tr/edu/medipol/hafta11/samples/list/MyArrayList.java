package tr.edu.medipol.hafta11.samples.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The collection library support lambdas expressions. Operations on collections
 * have been largely simplified with this.
 * 
 * The following code shows an example how to create a Collection of type List
 * which is parameterized with <String> to indicate to the Java compiler that
 * only Strings are allowed in this list. Is uses a method reference and the
 * foreach loop from Java 8.
 * 
 * package collections;
 * 
 * http://www.vogella.com/tutorials/JavaCollections/article.html
 *
 */
public class MyArrayList {

    public static void main(String[] args) {

        // create a list using the
        List<String> list = Arrays.asList("Lars", "Simon");

        // alternatively
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Lars");
        anotherList.add("Simon");

        System.out.println("Before Java 8: ");
        for (String str : list) {
            System.out.println(str);
        }
        for (String str : anotherList) {
            System.out.println(str);
        }
        
        // print each element to the console using method references
        System.out.println("Java 8: ");
        list.forEach(System.out::println);
        anotherList.forEach(System.out::println);

    }
}
