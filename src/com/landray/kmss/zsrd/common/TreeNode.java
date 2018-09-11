package com.landray.kmss.zsrd.common;

public class TreeNode {
    private String id;
    private String parentId;
    private String name;
    private String link;
    private String open;
    private String deptName;

    public TreeNode() {
    }

    public TreeNode(String id, String parentId, String name, String link, String open) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.link = link;
        this.open = open;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}