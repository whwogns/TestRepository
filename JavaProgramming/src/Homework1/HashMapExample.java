package Homework1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer>map = new HashMap<String, Integer>();
		
		map.put("�ſ��", 85);
		map.put("ȫ�浿", 90);
		map.put("���屺", 80);
		map.put("ȫ�浿", 95);
		System.out.println("�� Entry ��:"+map.get("ȫ�浿"));
		System.out.println();
		
		Set<String>keySet = map.keySet();
		Iterator<String>keyIterator= keySet.iterator();
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t"+key+":"+value);
			
		}
		System.out.println();
		 
		map.remove("ȫ�浿");
		System.out.println("�� Entry ��:"+map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		
	}

}
