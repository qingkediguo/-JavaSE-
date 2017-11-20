package be.Map子类;

import java.util.HashMap;
import java.util.Set;

/*
 * HashMap:是基于哈希表的Map接口实现。
 * 哈希表的作用是用来保证键的唯一性的。					// 【加强记忆：但凡是看到了哈希表的都是具有唯一性的】
 * 
 * HashMap<String,String>
 * 键：String
 * 值：String
 */
public class A_HashMap简介 {
	public static void main(String[] args) {
		// 创建集合对象
		HashMap<String, String> hm = new HashMap<String, String>();

		// 创建元素并添加元素
		// String key1 = "it001";
		// String value1 = "马云";
		// hm.put(key1, value1);

		hm.put("1", "马云");
		hm.put("3", "马化腾");
		hm.put("4", "乔布斯");
		hm.put("5", "张朝阳");
		hm.put("2", "裘伯君");
		hm.put("1", "比尔盖茨");		// 【这里直接把1覆盖了】

		// 遍历
		Set<String> set = hm.keySet();					// 【这一段自己多写写,很容易就写错】
		for (String key : set) {
			String value = hm.get(key);
			System.out.println(key + "---" + value);
		}
	}
}