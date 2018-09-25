/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cache.ehcache;

import net.sf.ehcache.*;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.store.disk.DiskStore;
import org.junit.Test;

/**
 * @author Costin Leau
 * @author Stephane Nicoll
 * @author Juergen Hoeller
 */
public class EhCacheCacheTests2  {
	@Test
	public void test(){
		//获取缓存管理器：
		CacheManager	cacheManager = new CacheManager(new Configuration().name("EhCacheCacheTests")
				.defaultCache(new CacheConfiguration("default", 100)));
		Cache nativeCache = new Cache(new CacheConfiguration(("testCache"), 100));
		cacheManager.addCache(nativeCache);
		DiskStorePathManager diskStorePathManager = cacheManager.getDiskStorePathManager();
		DiskStore diskStore = DiskStore.create(nativeCache);
		Status status = cacheManager.getStatus();
		System.out.println(status.intValue());
		org.springframework.cache.Cache cache = new EhCacheCache(nativeCache);
		System.out.println("the cache name is :"+cache.getName());
		Element a = new Element("a", 1);
		a.setTimeToLive(0);
		Element b = new Element("b", 2);
		b.setTimeToLive(0);
		//在缓存中添加元素：
//		cache.
		nativeCache.put(a);

		System.out.println(System.getProperty("java.io.tmpdir"));
		Element a1 = nativeCache.get("a");
		System.out.println("a1="+a1);
//		System.out.println(a1.getObjectKey()+"="+ a1.getObjectValue());
	}

	@Test
	public void testEhcacheUtils(){
		EhcacheUtil ehcacheUtil = EhcacheUtil.getInstance();
		Cache myCache1 = ehcacheUtil.get("myCache1");
		Element a = new Element("a", 1);
		Element b = new Element("b", 2);
		Element c = new Element("c", 2);

		myCache1.put(a);
		myCache1.put(b);
		myCache1.put(c);
		Element a1 = myCache1.get("a");
		System.out.println(a1);
		long creationTime = a.getCreationTime();
		System.out.println(String.format("%s=%s",a1.getObjectKey(),a1.getObjectValue()));
	}

	@Test
	public void test3(){
		 String ehcacheXmlClasspath="/org/springframework/cache/ehcache/testEhcache.xml";
		EhcacheUtil2 ehcacheUtil2 = EhcacheUtil2.newInstance(ehcacheXmlClasspath);
		ehcacheUtil2.put("myCache1","a",1);
		ehcacheUtil2.put("myCache1","b",2);
		ehcacheUtil2.put("myCache1","c",3);
		System.out.println(EhcacheUtil2.getCache("myCache1"));
		System.out.println(EhcacheUtil2.getElementValue("myCache1","a"));
		EhcacheUtil2.removeElement("myCache1","a");
		System.out.println(EhcacheUtil2.getElementValue("myCache1","a"));

	}
}
