<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-offset-4 col-4"></div>
<ul class="nav nav-tabs">
    <li class="active"><a href="#">Student</a></li>
    <li><a href="/university.html">University</a></li>
</ul>

<div class="row">
    <div class="col-4"></div>
    <div class="col-4">
        <c:choose>
        <c:when test="${notFound==true}">
            <p>Invalid student</p>

            <p class="has-error">Please provide valid id</p>
        </c:when>
        <c:otherwise>
        <form:form commandName="student" action="/student.html" method="post">
            <form:errors path="*" cssClass="error" />
        <fieldset>
            <legend>Student Edit</legend>
        </fieldset>
                <form:hidden path="id"/>
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name" cssClass="has-error help-block has-error control-label"></form:errors>
            </div>

            <%--<div class="form-group">--%>
                <%--<form:label path="lname">Last Name</form:label>--%>
                <%--<form:input path="lname" cssClass="form-control"/>--%>
                <%--<form:errors path="lname"  cssClass="has-error help-block has-error control-label"></form:errors>--%>
            <%--</div>--%>
            <button type="submit" value="Submit" class="btn btn-default">Submit</button>
            </form:form>
            </c:otherwise>
            </c:choose>


    </div>
    <div class="col-4"></div>
</div>