<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-offset-4 col-4"></div>
<ul class="nav nav-tabs">
    <li><a href="/student.html" class="active">Student</a></li>
    <li><a href="/university.html">University</a></li>
    <li><a href="/student/search.html" >Search Student-Course</a></li>
</ul>

<div class="row">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">
        <c:choose>
            <c:when test="${notFound==true}">
                <h2 class="has-error">No such student</h2>
                <a href="/student/">Go back to students page</a>
            </c:when>
            <c:otherwise>

                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Student Name</th>

                    </tr>
                    <tr>
                        <td>
                            <c:out value="${student.name}"/>
                            &nbsp;
                            <c:out value="${student.lname}"/>

                        </td>
                    </tr>
                </table>

            </c:otherwise>
        </c:choose>
    </div>


    <div class="col-lg-2"></div>
</div>