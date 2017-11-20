package cb.Java设计模式_极难度_慢慢理解_都很重要;

import java.util.ArrayList;
import java.util.Iterator;

/*
组合模式(Composite)：		// 【经常用】
	组合模式有时又叫部分-整体模式，将对象组合成树形结构来表示“部分-整体”层次结构。组合模式在处理树形结构的问题时比较方便。
	应用场景：
		将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树等。
	总结：
		组合能让客户以一致的方式处理个别对象以及对象组合。
*/

class TreeNode {
	private String name; // 节点名字
	private TreeNode parent;
	private ArrayList<TreeNode> children = new ArrayList<TreeNode>();

	public TreeNode(String name) {
		this.name = name;
	}

	// 对相关属性进行封装
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	// 对孩子节点的增删查操作
	public void add(TreeNode node) {
		children.add(node);
	}

	public void delete(TreeNode node) {
		children.remove(node);
	}

	public Iterator<TreeNode> getChildren() {		// 【只能对孩子节点进行遍历】
		return children.iterator();
	}
}

public class B_5组合设计模式_很重要 {
	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode("A");
		TreeNode bNode = new TreeNode("B");
		TreeNode cNode = new TreeNode("C");
		TreeNode dNode = new TreeNode("D");
		rootNode.add(bNode);
		rootNode.add(cNode);
		cNode.add(dNode);
		Iterator<TreeNode> iterator = rootNode.getChildren();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}
}
