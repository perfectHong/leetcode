package utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map<K, Collection<V>>���͵�map
 * <p>
 * ÿ�η���һ����ֵ��ʱ�� �Ὣֵ���ڸü���Ӧ�ļ����У�������ϲ����ڣ��򴴽��µļ���
 * 
 * @since U8C 2.1
 * @version 2018-3-28 ����2:56:48
 * @author luojw
 */
public class MapCollection<K, V, T extends Collection<V>> implements Cloneable,
    Serializable {

  private static final long serialVersionUID = 6291574578918137188L;

  private Map<K, T> map;

  /** ���ϵ����� */
  protected Class<? extends Collection> collectionType;

  /**
   * Ĭ��HashMap
   * 
   * @param collectionType ���ϵ�����
   */
  public MapCollection(Class<? extends Collection> collectionType) {
    this(new HashMap<K, T>(), collectionType);
  }

  /**
   * ���췽��
   * 
   * @param map ����Map����
   * @param collectionType ���ϵ�����
   */
  public MapCollection(Map<K, T> map, Class<? extends Collection> collectionType) {
    this.map = map;
    this.collectionType = collectionType;
  }

  /**
   * ���
   */
  public void clear() {
    this.map.clear();
  }

  /**
   * �Ƿ����key
   * 
   * @param key
   * @return
   */
  public boolean containsKey(Object key) {
    return this.map.containsKey(key);
  }

  /**
   * �Ƿ����ֵ
   * 
   * @param o �������ϻ��߾����ֵ
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
   * ��ȡ����
   * 
   * @param key
   * @return
   */
  public T get(Object key) {
    return this.map.get(key);
  }

  /**
   * �Ƿ�Ϊ��
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
   * ��ż���
   * 
   * @param key
   * @param collection ����
   * @return
   */
  public T put(K key, T collection) {
    return this.map.put(key, collection);
  }

  /**
   * ��ŵ���ֵ
   * 
   * @param key
   * @param value ����ֵ
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
   * �����ϵ�ȫ�����ݷŽ�ȥ
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
   * ������Ž�ȥ
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
   * ����ͨmap������ȫ������
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
   * ��ͬ���͵�����ȫ������
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
   * ����ͨmap������ȫ������
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
   * ��key�����������Ƴ�
   * 
   * @param key
   * @return
   */
  public T remove(Object key) {
    return this.map.remove(key);
  }

  /**
   * ���ݳ���
   * 
   * @return
   */
  public int size() {
    return this.map.size();
  }

  /**
   * ת����ʵ�����͵�map
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
   * ��ȡ����ֵ�ļ���
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
   * �������϶���
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
