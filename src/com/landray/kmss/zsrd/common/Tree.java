package com.landray.kmss.zsrd.common;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	private StringBuffer html = new StringBuffer();
	private List<TreeNode> nodes;

	public Tree(List<TreeNode> nodes) {
		this.nodes = nodes;
	}

	public String buildTree() {
		html.append("<ul>");
		for (TreeNode node : nodes) {
			String id = node.getId();
			if (node.getParentId() == null) {
				html.append("\r\n<li id='" + id + "'>" + node.getName()
						+ "</li>");
				build(node);
			}
		}
		html.append("\r\n</ul>");
		return html.toString();
	}

	private void build(TreeNode node) {
		List<TreeNode> children = getChildren(node);
		if (!children.isEmpty()) {
			html.append("\r\n<ul>");
			for (TreeNode child : children) {
				String id = child.getId();
				html.append("\r\n<li id='" + id + "'>" + child.getName()
						+ "</li>");
				build(child);
			}
			html.append("\r\n</ul>");
		}
	}

	private List<TreeNode> getChildren(TreeNode node) {
		List<TreeNode> children = new ArrayList<TreeNode>();
		String id = node.getId();
		for (TreeNode child : nodes) {
			if (id.equals(child.getParentId())) {
				children.add(child);
			}
		}
		return children;
	}

}
