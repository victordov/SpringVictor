<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: vdovgaliuc
  Date: 8/15/13
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
         <h1>Test</h1>
<table>
    <tr>
        <td>
            <c:out value="${host}" />
        </td>
        <td>
            <c:out value="${uri}" />
        </td>
        <td>
            <c:out value="${entity_id}" />
        </td>
        <td>
            <c:out value="${users}" />
        </td>
        <td>
            <c:out value="${password}" />
        </td>
        <td>
            <c:out value="${response_format}" />
        </td>
        <td>
            <c:out value="${className}" />
        </td><td>
        <c:out value="${methodName}" />
    </td>

    </tr>
</table>


<table>
    <tr>
        <td>
            Created: <c:out value="${xq.createTime}" />
        </td>
    </tr>
    <tr>
        <td>
            Last Updated: <c:out value="${xq.lastUpdated}" />
        </td>
    </tr>
    <tr>
        <td>
            <c:out value="${xq.request}" />
        </td>
    </tr>
    <tr>
        <td>
            <c:out value="${xq.response}" />
        </td>
    </tr>
</table>
</body>
</html>