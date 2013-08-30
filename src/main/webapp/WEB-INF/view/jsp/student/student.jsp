<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<div class="row">
    <div class="col-lg-2">




    </div>
    <div class="col-lg-8">
        <sec:authorize ifAllGranted="ROLE_ADMIN">
            <p>Yey, you are admin</p>
        </sec:authorize>
        <c:choose>
            <c:when test="${notFound==true}">
                <h2 class="has-error">No students are added</h2>
            </c:when>
            <c:otherwise>
                <div>
                    <form:form action="/student/new.html" commandname="" method="get">
                        <button class="btn btn-success">Insert</button>
                    </form:form>
                </div>

                <table class="table table-hover table-bordered">
                    <tr>
                        <th>Student Name</th>
                        <th>Course Name</th>
                        <th>University</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td>
                                <c:out value="${student.name}"/>
                                &nbsp;
                                <c:out value="${student.lname}"/>

                            </td>

                            <td>
                                <table class="table">

                                    <c:forEach items="${student.curses}" var="curs">
                                        <tr>
                                            <td>
                                                <c:out value="${curs.cursName}"/><p>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </table>
                            </td>
                            <td>
                                <c:out value="${student.university.universityName}"/>
                            </td>
                            <td>
                                <form:form action="/student/edit/${student.id}.html" commandname="" method="put">
                                    <button type="submit">Edit</button>
                                </form:form>
                            </td>
                            <td>
                                <form:form action="/student/${student.id}.html" commandname="" method="delete">
                                    <button type="submit">Delete</button>
                                </form:form>
                            </td>

                        </tr>

                    </c:forEach>
                </table>

            </c:otherwise>
        </c:choose>
    </div>


    <div class="col-lg-2"></div>
</div>
