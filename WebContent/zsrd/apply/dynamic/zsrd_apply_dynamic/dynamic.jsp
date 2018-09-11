<%--
  Created by IntelliJ IDEA.
  User: HXQH
  Date: 2017-7-5
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/sys/ui/jsp/common.jsp"%>
<html>
<head>
</head>
<body>
<table style="font-size: 90%;width:100%;">
    <c:forEach var="obj" items="${list}" begin="0" end="7">
        <tr style="height: 20px;">
            <td width="20%" style="color: tomato;font-size: 80%;">[${obj[0]}]</td>
            <td width="52%">
                <c:set var="object1" value="${obj[1]}"/>
                <c:if test="${fn:length(object1)>'15'}">
                <c:set var="object2" value="${fn:substring(object1, 0, 15)}"/>
                <a target="_blank" title='${object1}' style="text-decoration: none;color: black" href="http://localhost:8080/ekp/zsrd/apply/dynamic/zsrd_apply_dynamic/zsrdApplyDynamic.do?method=view&fdId=${obj[4]}">
                        ${object2}...</a></td>
            </c:if>
            <c:if test="${fn:length(object1)<='15'}">
                <a target="_blank" title='${object1}' style="text-decoration: none;color: black" href="http://localhost:8080/ekp/zsrd/apply/dynamic/zsrd_apply_dynamic/zsrdApplyDynamic.do?method=view&fdId=${obj[4]}">
                        ${object1}</a></td>
            </c:if>
            <td width="10%" style="color: #9e9e9e;font-size: 80%;">${obj[2]}</td>
            <td width="18%" style="color: #9e9e9e;font-size: 80%;">${obj[3]}</td>
        </tr>
    </c:forEach>
</table>
 <div style="float:right;font-size: 80%;top:100%;">
    <a href="http://localhost:8080/ekp/zsrd/apply/dynamic/zsrd_apply_dynamic/index.jsp" target="view_window" style="text-decoration:none;out-line: none;color: black;">更多</a>
    </div>
</body>
</html>