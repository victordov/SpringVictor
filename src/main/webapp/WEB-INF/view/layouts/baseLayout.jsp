<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--<link href="<c:url value="/web-resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />--%>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link href="http://bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>
    <%--<script src="http://code.jquery.com/jquery-1.9.1.js"></script>--%>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
</head>
<body>
<div>
    <div>
        <div>
            <tiles:insertAttribute name="header"/>
            <div></div>
        </div>
        <tiles:insertAttribute name="body"/>
    </div>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>