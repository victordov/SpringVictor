<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <nav class="navbar navbar-default" role="navigation">
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/student.html">Student</a></li>
                    <li><a href="/university.html" class="active">University</a></li>
                    <li><a href="/student/search.html">Search Student-Course</a></li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="col-md-2"></div>
</div>

<div class="row">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">
        <c:choose>
            <c:when test="${notFound==true}">
                <h2 class="has-error">No universities are present</h2>
            </c:when>
            <c:otherwise>

                <table class="table table-hover table-bordered">
                    <tr>
                        <th>University Name</th>
                        <th>University Address</th>
                        <th>Students</th>
                    </tr>
                    <c:forEach items="${universities}" var="university">
                        <tr>
                            <td>
                                <c:out value="${university.universityName}"/>
                            </td>
                            <td>
                                <c:out value="${university.address}"/>
                            </td>

                            <td>
                                <table class="table">

                                    <c:forEach items="${university.students}" var="student">
                                        <tr>
                                            <td>
                                                <c:out value="${student.name}"/><p>
                                                &nbsp;
                                                <c:out value="${student.lname}"/><p>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </table>
                            </td>

                        </tr>

                    </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </div>


    <div class="col-lg-2"></div>
</div>
