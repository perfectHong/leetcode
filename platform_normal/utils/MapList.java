package utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Map<K, List<V>>类型的map
 * 
 * @since U8C 2.1
 * @version 2018-3-28 下午2:56:57
 * @author luojw
 */
public class MapList<K, V> extends MapCollection<K, V, List<V>> {

	private static final long serialVersionUID = 6291574578918137188L;

	/**
	 * 默认HashMap, ArrayList
	 */
	public MapList() {
		this(ArrayList.class);
	}

	/**
	 * 默认HashMap
	 * 
	 * @param listClazz
	 *            List的类型，如ArrayList.class
	 */
	public MapList(Class<? extends List> listClazz) {
		super(listClazz);
	}

	/**
	 * 默认ArrayList
	 * 
	 * @param map
	 *            传入自定义Map
	 */
	public MapList(Map<K, List<V>> map) {
		this(map, ArrayList.class);
	}

	/**
	 * @param map
	 *            传入自定义Map
	 * @param listClazz
	 *            List的类型，如ArrayList.class
	 */
	public MapList(Map<K, List<V>> map, Class<? extends List> listClazz) {
		super(map, listClazz);
	}

	/**
	 * 创建LinkedHashMap类型的MapList
	 * 
	 * @return
	 */
	public static <K, V> MapList<K, V> newLinkedMapList() {
		return new MapList<K, V>(new LinkedHashMap<K, List<V>>());
	}

}
