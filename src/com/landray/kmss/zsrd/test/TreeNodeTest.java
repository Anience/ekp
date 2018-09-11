package com.landray.kmss.zsrd.test;

import java.util.ArrayList;
import java.util.List;

import com.landray.kmss.zsrd.common.Tree;
import com.landray.kmss.zsrd.common.TreeNode;

public class TreeNodeTest {
	public static void main(String[] args) {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();

		TreeNode TreeNode1 = new TreeNode();
		TreeNode1.setId("1");
		TreeNode1.setName("TreeNode1");
		TreeNode1.setParentId(null);
		TreeNode1.setLink(null);
		treeNodes.add(TreeNode1);

		TreeNode TreeNode11 = new TreeNode();
		TreeNode11.setId("11");
		TreeNode11.setName("TreeNode11");
		TreeNode11.setParentId("1");
		TreeNode11.setLink(null);
		treeNodes.add(TreeNode11);

		TreeNode TreeNode111 = new TreeNode();
		TreeNode111.setId("111");
		TreeNode111.setName("TreeNode111");
		TreeNode111.setParentId("11");
		TreeNode111.setLink(null);
		treeNodes.add(TreeNode111);

		TreeNode TreeNode12 = new TreeNode();
		TreeNode12.setId("12");
		TreeNode12.setName("TreeNode12");
		TreeNode12.setParentId("1");
		TreeNode12.setLink(null);
		treeNodes.add(TreeNode12);

		TreeNode TreeNode2 = new TreeNode();
		TreeNode2.setId("2");
		TreeNode2.setName("TreeNode2");
		TreeNode2.setParentId(null);
		TreeNode2.setLink(null);
		treeNodes.add(TreeNode2);

		TreeNode TreeNode21 = new TreeNode();
		TreeNode21.setId("21");
		TreeNode21.setName("TreeNode21");
		TreeNode21.setParentId("2");
		TreeNode21.setLink(null);
		treeNodes.add(TreeNode21);

		TreeNode TreeNode3 = new TreeNode();
		TreeNode3.setId("3");
		TreeNode3.setName("TreeNode3");
		TreeNode3.setParentId(null);
		TreeNode3.setLink(null);
		treeNodes.add(TreeNode3);

		Tree tree = new Tree(treeNodes);
		System.out.println(tree.buildTree());
	}
}
