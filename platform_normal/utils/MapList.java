package utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Map<K, List<V>>���͵�map
 * 
 * @since U8C 2.1
 * @version 2018-3-28 ����2:56:57
 * @author luojw
 */
public class MapList<K, V> extends MapCollection<K, V, List<V>> {

	private static final long serialVersionUID = 6291574578918137188L;

	/**
	 * Ĭ��HashMap, ArrayList
	 */
	public MapList() {
		this(ArrayList.class);
	}

	/**
	 * Ĭ��HashMap
	 * 
	 * @param listClazz
	 *            List�����ͣ���ArrayList.class
	 */
	public MapList(Class<? extends List> listClazz) {
		super(listClazz);
	}

	/**
	 * Ĭ��ArrayList
	 * 
	 * @param map
	 *            �����Զ���Map
	 */
	public MapList(Map<K, List<V>> map) {
		this(map, ArrayList.class);
	}

	/**
	 * @param map
	 *            �����Զ���Map
	 * @param listClazz
	 *            List�����ͣ���ArrayList.class
	 */
	public MapList(Map<K, List<V>> map, Class<? extends List> listClazz) {
		super(map, listClazz);
	}

	/**
	 * ����LinkedHashMap���͵�MapList
	 * 
	 * @return
	 */
	public static <K, V> MapList<K, V> newLinkedMapList() {
		return new MapList<K, V>(new LinkedHashMap<K, List<V>>());
	}

}
