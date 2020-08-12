package utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map<K, Collection<V>>类型的map
 * <p>
 * 每次放入一个键值对时， 会将值放在该键对应的集合中，如果集合不存在，则创建新的集合
 * 
 * @since U8C 2.1
 * @version 2018-3-28 下午2:56:48
 * @author luojw
 */
public class MapCollection<K, V, T extends Collection<V>> implements Cloneable,
    Serializable {

  private static final long serialVersionUID = 6291574578918137188L;

  private Map<K, T> map;

  /** 集合的类型 */
  protected Class<? extends Collection> collectionType;

  /**
   * 默认HashMap
   * 
   * @param collectionType 集合的类型
   */
  public MapCollection(Class<? extends Collection> collectionType) {
    this(new HashMap<K, T>(), collectionType);
  }

  /**
   * 构造方法
   * 
   * @param map 传入Map对象
   * @param collectionType 集合的类型
   */
  public MapCollection(Map<K, T> map, Class<? extends Collection> collectionType) {
    this.map = map;
    this.collectionType = collectionType;
  }

  /**
   * 清空
   */
  public void clear() {
    this.map.clear();
  }

  /**
   * 是否包含key
   * 
   * @param key
   * @return
   */
  public boolean containsKey(Object key) {
    return this.map.containsKey(key);
  }

  /**
   * 是否包含值
   * 
   * @param o 包含集合或者具体的值
   * @return
   */
  public boolean containsValue(Object o) {
    if (o instanceof Collection) {
      return this.map.containsValue(o);
    }
    for (T collection : this.map.values()) {
      if (collection.contains(o)) {
        return true;
      }
    }
    return false;
  }

  public Set<Entry<K, T>> entrySet() {
    return this.map.entrySet();
  }

  /**
   * 获取集合
   * 
   * @param key
   * @return
   */
  public T get(Object key) {
    return this.map.get(key);
  }

  /**
   * 是否为空
   * 
   * @return
   */
  public boolean isEmpty() {
    return this.map.isEmpty();
  }

  public Set<K> keySet() {
    return this.map.keySet();
  }

  /**
   * 存放集合
   * 
   * @param key
   * @param collection 集合
   * @return
   */
  public T put(K key, T collection) {
    return this.map.put(key, collection);
  }

  /**
   * 存放单个值
   * 
   * @param key
   * @param value 单个值
   */
  public void put(K key, V value) {
    T collection = this.map.get(key);
    if (collection == null) {
      collection = this.newCollection();
      this.map.put(key, collection);
    }
    collection.add(value);
  }

  /**
   * 将集合的全部数据放进去
   * 
   * @param key
   * @param collection
   */
  public void putAll(K key, T c) {
    T collection = this.map.get(key);
    if (collection == null) {
      this.map.put(key, c);
    }
    else {
      collection.addAll(c);
    }
  }

  /**
   * 将数组放进去
   * 
   * @param key
   * @param collection
   */
  public void putAll(K key, V[] array) {
    T collection = this.map.get(key);
    if (collection == null) {
      collection = this.newCollection();
      this.map.put(key, collection);
    }
    collection.addAll(Arrays.asList(array));
  }

  /**
   * 将普通map的数据全部放入
   * 
   * @param m
   */
  public void putAll(Map<K, V> m) {
    if (m == null || m.size() == 0) {
      return;
    }
    for (Entry<K, V> entry : m.entrySet()) {
      this.put(entry.getKey(), entry.getValue());
    }
  }

  /**
   * 将同类型的数据全部放入
   * 
   * @param m
   */
  public void putAll(MapCollection<K, V, T> m) {
    if (m == null || m.size() == 0) {
      return;
    }
    for (Entry<K, T> entry : m.entrySet()) {
      this.putAll(entry.getKey(), entry.getValue());
    }
  }

  /**
   * 将普通map的数据全部放入
   * 
   * @param m
   */
  @SuppressWarnings("unchecked")
  public void putAllMap(Map<K, ? extends Collection<V>> m) {
    if (m == null || m.size() == 0) {
      return;
    }
    for (Entry<K, ? extends Collection<V>> entry : m.entrySet()) {
      this.putAll(entry.getKey(), (T) entry.getValue());
    }
  }

  /**
   * 将key的所有数据移除
   * 
   * @param key
   * @return
   */
  public T remove(Object key) {
    return this.map.remove(key);
  }

  /**
   * 数据长度
   * 
   * @return
   */
  public int size() {
    return this.map.size();
  }

  /**
   * 转换成实际类型的map
   * 
   * @return
   */
  public Map<K, T> toMap() {
    return this.map;
  }

  @Override
  public String toString() {
    return this.map.toString();
  }

  /**
   * 获取所有值的集合
   * 
   * @return
   */
  public T values() {
    T values = this.newCollection();
    for (T collection : this.map.values()) {
      values.addAll(collection);
    }
    return values;
  }

  /**
   * 创建集合对象
   * 
   * @return
   */
  @SuppressWarnings("unchecked")
  protected T newCollection() {
    try {
      return (T) this.collectionType.newInstance();
    }
    catch (InstantiationException e) {
    }
    catch (IllegalAccessException e) {
    }
    return null;
  }

}
