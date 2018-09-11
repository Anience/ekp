<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/sys/ui/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
 #table_list td{
 }


</style>

   <table style="border-collapse:collapse;size: 2px;" border="1">
       <tr style="text-align: center;">
          <th>序号</th>
          <th>部门名称</th>
          <th>人员</th>
          <th>工作内容</th>
          <th>来源程序</th>
          <th>处理时长</th>
          <th>到达日期</th>
          <th>处理日期</th>
       </tr>
       <c:forEach items="${list}" var="obj" varStatus="vstatus">
        <tr style="text-align:center;height: 30px;">
          <td>${vstatus.index+1}</td>
          <td>${obj[0]}</td>
          <td>${obj[1]}</td>
          <td>${obj[2]}</td>
          <td>${obj[3]}</td>
			<c:choose>
				<c:when test="${obj[6] < '60'}">
				 <td>${obj[6]}分钟</td> 
                  </c:when>
				<c:otherwise>
				 <td>${obj[6]/60}小时</td>
                </c:otherwise>
			</c:choose>
          <td>${obj[4]}</td>
          <td>${obj[5]}</td>
       </tr>             
       </c:forEach>
   </table>
</body>
</html>