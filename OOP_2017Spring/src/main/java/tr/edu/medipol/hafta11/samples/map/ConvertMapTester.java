package tr.edu.medipol.hafta11.samples.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You can convert your keys or values to an array or list. The following code demonstrates that.
 * 
 * http://www.vogella.com/tutorials/JavaCollections/article.html
 *
 */
public class ConvertMapTester {
    public static void main(String[] args) {

        // keys are Strings
        // objects are also Strings
        Map<String, String> map = new HashMap<>();
        fillData(map);

        // convert keys to array
        String[] strings = keysAsArray(map);
        for (String string : strings) {
            System.out.println(string);
        }
        // convert keys to list
        List<String> list = keysAsList(map);
        for (String string : list) {
            System.out.println(string);
        }
    }

    private static void fillData(Map<String, String> map) {
        map.put("Android", "Mobile");
        map.put("Eclipse IDE", "Java");
        map.put("Eclipse RCP", "Java");
        map.put("Git", "Version control system");

    }

    private static String[] keysAsArray(Map<String, String> map) {
        return map.keySet().toArray(new String[map.keySet().size()]);
    }

    // assumes the key is of type String
    private static List<String> keysAsList(Map<String, String> map) {
        List<String> list = new ArrayList<String>(map.keySet());
        return list;
    }

}
