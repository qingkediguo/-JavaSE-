package aa.编程基础;

public class H_二维数组 {
	public static void main(String[] args) {
		// 数据类型[][] 数组名 = new 数据类型[m][];
		// m:表示这个二维数组有多少个一维数组。
		// 列数没有给出，可以动态的给。这一次是一个变化的列数。
		// 基本格式：
		// 数据类型[][] 数组名 = new 数据类型[][]{{元素1,元素2...},{元素1,元素2...},{元素1,元素2...}};
		// 简化版格式：
		// 数据类型[][] 数组名 = {{元素1,元素2...},{元素1,元素2...},{元素1,元素2...}};

		// int[] arr = new int[3];
		// System.out.println(arr);//[I@1fb8ee3 @左边是实体的类型。 @右边是实体的哈希值。

		// int[][] arr = new int[3][2];//创建一个二维数组，该数组中有3个一维数组，每一个一维数组中有2个元素。
		// System.out.println(arr);//直接打印二维数组。 [[I@c17164
		// System.out.println(arr[0]);//直接打印二维数组中的角标0的一维数组。 [I@1fb8ee3
		// System.out.println(arr[0][0]);//直接打印二维数组中的角标0的一维数组中角标为0的元素。 //0

		// int[][] arr = new int[3][];
		// System.out.println(arr);//直接打印二维数组。 [[I@c17164
		// System.out.println(arr[0]);//直接打印二维数组中的角标0的一维数组。null
		// System.out.println(arr[0][0]);//直接打印二维数组中的角标0的一维数组中角标为0的元素。//
		// NullPointerException

		// int[][] arr = new int[3][2];
		// System.out.println(arr.length);//打印二维数组的长度。其实就是一维数组的个数。
		// System.out.println(arr[1].length);//打印二维数组中角标为1一维数组的长度。
		int sum = 0;
		int[][] arr = { { 3, 1, 7 }, { 5, 8, 2, 9 }, { 4, 1 } };
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				System.out.print(arr[x][y] + ",");
				sum += arr[x][y];
			}
			System.out.println();
		}
		System.out.println("sum=" + sum);
		// 甲：30 59 28 17
		// 乙；37 60 22 19
		// int[] arr = {{30,59,28,17},{37,60,22,19}};
		int[][][] arr1 = new int[3][2][4];
		System.out.println(arr1);
	}
}

/*
 * 数组的定义：数组是相同类型数据的集合，描述的是相同类型的若干个数据按照一定的先后顺序排
 * 列组合而成，其中每一个数据称作一个数组元素，每个数组元素可以通过一个下标杢访问它们。
 * 数组的四个基本特点：1.长度固定，一旦被创建它的长度就是丌可改发的；2.其元素类型必须是相
 * 同类型，丌允许出现混合类型；3.数组中的元素可以是任何数据类型，包括基本数据类型和引用数
 * 据类型；4.数组发量属亍引用类型，数组也可以看做是对象，数组中的每个元素相弼亍该对象的成
 * 员发量，数组本身就是对象，Java中对象是在堆中的，因此数组无论保存原始类型还是其他对象类 型，数组本身是在堆中的。
 * 数组的下标合法区间是[0,length-1]。
 * 
 * 数组的拷贝：System.arrayCopy（源数组，从哪开始，目标数组，从哪开始贴，粘几个）。 数组排序：Arrays.sort（被排序的数组）。
 * 二分法查找：Arrays.binarySearch（哪个数组，数组中的什么元素）。 填充：Arrays.fill（a， 2， 4,
 * 100）。//将数组a中2到4的索引的元素替换为100
 * 获取数组的长度：数组.length，如a.length，获叏数组a的元素个数；a[0].length，表示获取二维数组中第一个数组的长度。
 * 数组的遍历：可以使用for循环戒者for嵌套循环（对于二维数组），也可以使用增强for循环组进行遍历，增强for循环格式：for（变量类型
 * 变量名：被遍历的数组）
 */