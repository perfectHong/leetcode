
package concurrency.artofconcurrency.chapter_four.instance.dynamicproxy.test1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class MainTest {
 public static void main(String[] args) {
      Subject subject = (Subject) new MyInvercationHander().bind(new RealSubject("中国"));
      System.out.println(subject.say("莫建锋",22));
      System.out.println(subject.getAllList("张三"));
      Map<String,Integer> myMap = new HashMap<String, Integer>();
      myMap.put("A",1);
      myMap.put("B",2);
      myMap.put("C",3);
      myMap.put("D",4);
      myMap.put("E",5);
      Set<Map.Entry<String,Integer>> myEntrySet = myMap.entrySet();
      Iterator<Map.Entry<String,Integer>> it = myEntrySet.iterator();
      while(it.hasNext()){
       Map.Entry<String,Integer> entry = it.next();
       System.out.print(entry.getKey()+":");
       System.out.println(entry.getValue());

      }
      System.out.println(new RealSubject("中国").hashCode());
      System.out.println(new RealSubject("中国").equals(new RealSubject("中dd国")));
      String info = new String("1");
      String info1 = new String("1");
      System.out.println(new Integer('1'));
      System.out.println(info.hashCode());
      System.out.println(info1.hashCode());
      System.out.println(info==info1);
      System.out.println(info.equals(info1));
      short i = 1;
      System.out.println(i);
 }
}
