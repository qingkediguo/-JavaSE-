package ar.Character;

/*
 * Character 类在对象中包装一个基本类型 char 的值
 * 此外，该类提供了几种方法，以确定字符的类别（小写字母，数字，等等），并将字符从大写转换成小写，反之亦然
 * 
 * 构造方法：
 * 		Character(char value)
 */
public class A_Character基础 {
	@SuppressWarnings("deprecation")			// 【Java9过时，暂时不知道用什么替代】
	public static void main(String[] args) {
		// 创建对象
		// Character ch = new Character((char) 97);
		Character ch = new Character('a');
		System.out.println("ch:" + ch);
	}
}