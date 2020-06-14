
package concurrency.artofconcurrency.chapter_four.instance.dynamicproxy.test1;
import java.util.ArrayList;
import java.util.List;
public class RealSubject implements Subject {
 private String name;
 public RealSubject(String name) {
  this.name = name;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 @Override
 public String say(String name, int age) {
  return "名字:" + name + "_年龄:" + age;
 }
 @Override
 public List<Person> getAllList(String name) {
  List<Person> list = new ArrayList<Person>();
  list.add(new Person("A", 20));
  list.add(new Person("B", 20));
  list.add(new Person("C", 20));
  list.add(new Person("D", 20));
  System.out.println(name);
  return list;
 }
 @Override
 public int hashCode() {
  return 10010;
 }
 @Override
 public boolean equals(Object obj) {
  if(obj instanceof RealSubject){
   RealSubject real = (RealSubject)obj;
   System.out.println("getName():"+real.getName());
   System.out.println("this.name:"+this.name);
   if(real.getName()==this.name){
     System.out.println("相同");
   }else{
    System.out.println("不相同");
   }
  }
  return true;
 }
}
