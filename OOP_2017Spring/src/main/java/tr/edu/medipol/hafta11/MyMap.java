package tr.edu.medipol.hafta11;

import java.util.ArrayList;
import java.util.List;

/*--
 * http://www.vogella.com/tutorials/JavaDatastructures/article.html
 */

class MyEntry<K, V> {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
                this.key = key;
                this.value = value;
        }

        public K getKey() {
                return key;
        }

        public V getValue() {
                return value;
        }

        public void setValue(V value) {
                this.value = value;
        }
}

public class MyMap<K, V> {
  private List< MyEntry<K,V> > elemanlar = new ArrayList<>();
  
  public void put(K anahtar, V deger) {
      elemanlar.add( new MyEntry(anahtar, deger) );
  }
  
  public V get( K anahtar) {
    
    for( MyEntry<K,V> entry : elemanlar ) {
      
      if( entry.getKey().equals( anahtar ) ) {
          return  entry.getValue();
      }
    
    }  
         
    return null;
      
  }
}
