<%--
  Created by IntelliJ IDEA.
  User: vdovgaliuc
  Date: 8/12/13
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:message key="Size.student.name" />
<div class="row">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">
        <form:form commandName="student" method="post">
            <fieldset>
                <legend>Insert new Student</legend>
            </fieldset>


            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name" cssClass="has-error help-block has-error control-label"></form:errors>
            </div>

            <div class="form-group">
                <form:label path="lname">Last Name</form:label>
                <form:input path="lname" cssClass="form-control"/>
                <form:errors path="lname" cssClass="has-error help-block has-error control-label"></form:errors>
            </div>

            <button type="submit" value="Submit">Submit</button>
        </form:form>
    </div>
    <div class="col-lg-2"></div>
</div>