package org.springframework.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.ehcache.core.EhcacheManager;

import java.net.URL;

/**
 * @author qinlinsen
 * @since 2018-09-25
 */
public class EhcacheUtil2 {
	private static EhcacheUtil2 ehcacheUtil2;
	private static  CacheManager cacheManager;

	/**
	 * 用单例模式创建EhcacheUtil2的实例：
	 *@param ehcacheXmlClassPath echcache xml文件所在的类路径
	 * @return 这个工具类EhcacheUtil2
	 */
	public static EhcacheUtil2  newInstance(String ehcacheXmlClassPath) {
		if (ehcacheUtil2 == null) {
			ehcacheUtil2 = new EhcacheUtil2(ehcacheXmlClassPath);
		}
		return ehcacheUtil2;
	}

	private  EhcacheUtil2(String ehcacheXmlClassPath) {
		URL resource = getClass().getResource(ehcacheXmlClassPath);
		cacheManager = CacheManager.create(resource);
	}
	public static void put(String cacheName,String key,Object value){
		Cache cache = cacheManager.getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
	}
	public  static Cache getCache(String cacheName) {
		return cacheManager.getCache(cacheName);
	}

	public static Object getElementValue(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}

	public static void removeElement(String cacheName,String key){
		Cache cache = getCache(cacheName);
		cache.remove(key);
	}
	public static void removeElement(String cacheName,Element element){
		getCache(cacheName).removeElement(element);
	}
}
