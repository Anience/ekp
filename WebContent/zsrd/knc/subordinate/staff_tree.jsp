<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<%@ include file="/resource/jsp/htmlhead.jsp" %>
<script>
    Com_IncludeFile("jquery.js");
    Com_IncludeFile("ztree.js");
    Com_IncludeFile("zTreeStyle.css", "style/zTreeStyle/");
</script>
<style type="text/css">
    div.content_wrap {
        width: 600px;
        height: 250px;
    }

    div.content_wrap div.left {
        float: left;
        width: 250px;
    }

    div.content_wrap div.right {
        float: right;
        width: 340px;
    }

    div.zTreeDemoBackground {
        width: 250px;
        text-align: left;
    }

    ul.ztree {
        border: 0px solid #617775;
        background: #f0f6e4;
        width: 220px;
        height: 200px;
    }

    #todo-list {
        border: 1px solid grey;
        padding: 10px;
        border-collapse: collapse;
        width: 500px;
    }

    #todo-list tr, #todo-list tr td {
        border: 1px solid lightgrey;
        padding: 5px;
    }

    #todo-list tbody tr, #todo-list tbody tr td {
        color: red;
    }
</style>
<SCRIPT type="text/javascript">
    var setting = {
        data: {
            simpleData: {
                enable: true,
                pIdKey: "parentId"
            }
        },
        async: {
            enable: true,
            url: "<%=request.getContextPath()%>/zsrd/knc/subordinate/subordinate.do?method=getPersonPostTreeList"
        },
        callback: {
            beforeClick: beforeClick,
            onClick: onClick,
            onAsyncSuccess: onAsyncSuccess
        }
    };

    var zNodes = [{
        id: 1,
        pId: 0,
        name: "生产经营部长",
        open: true
    }, {
        id: 11,
        pId: 1,
        name: "物资分部主任"
    }, {
        id: 111,
        pId: 11,
        name: "物资购销专责"
    }];
    var log, className = "dark";
    function onAsyncSuccess(event, treeId, treeNode, msg) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = zTree.getNodes();
        //console.log(nodes);
        if (nodes.length <= 0) {
            $("#treeDemo").html("未找到任何下属！").css({"font-size": "12px"});
        } else {
            zTree.expandAll(true);
        }

    }
    function beforeClick(treeId, treeNode, clickFlag) {
        //className = (className === "dark" ? "" : "dark");
        //showLog("[ " + getTime() + " beforeClick ]&nbsp;&nbsp;" + treeNode.name);
        if (treeNode.parentId) {
            return true;
        }
        return false;
    }
    function onClick(event, treeId, treeNode, clickFlag) {
        var html = "";
        var content = "";
        //console.log(treeNode);
        //console.log(treeNode.parentId);
        $.ajax({
            type: 'GET',
            url: "<%=request.getContextPath()%>/zsrd/knc/subordinate/subordinate.do?method=getSubStaffTodoCount",
            data: {postname: treeNode.id},
            success: function (data) {
                console.log("sssssss");
                console.log(data.length);

                $.each(data, function (idx, obj) {
                    content += "<tr><td>" + treeNode.name + "</td><td>" + obj[1] + "</td>" +
                    " <td><a " +
                    "href='<%=request.getContextPath()%>/zsrd/knc/subordinate/subordinate.do?method=getSubStaffTodoDetailList&type=todo&fd_id=" + obj[0] + "'>"
                    + obj[2] + "</a></td>" +
                    " <td><a " +
                    "href='<%=request.getContextPath()%>/zsrd/knc/subordinate/subordinate.do?method=getSubStaffTodoDetailList&type=done&fd_id="
                    + obj[0] + "'>" + obj[3] + "</a></td>"
                    + "</tr>";
                });


            },
            complete: function () {
                html = "<table id='todo-list'><thead><tr><td>岗位</td><td>姓名</td><td>待办</td><td>已办</td></tr></thead>";
                html += "<tbody>";
                html += content;
                html += "</tbody>";
                $(".right").empty().append(html);


            }
        });


    }
    function selectTreeNode() {
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getNodesByParam("name", "物资分部主任", null);
        if (nodes.length>0) {
            treeObj.selectNode(nodes[0]);
        }
    }
    $(document).ready(function () {
        //console.log(11111);
        $.fn.zTree.init($("#treeDemo"), setting, null);
    });
    //-->
</SCRIPT>
<div class="content_wrap">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
    <div class="right">

    </div>
</div>