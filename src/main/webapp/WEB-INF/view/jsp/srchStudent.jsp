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
                    <li><a href="/university.html">University</a></li>
                    <li><a href="/student/search.html" class="active">Search Student-Course</a></li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="col-md-2"></div>
</div>

<div class="row">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">
        <form action="search.html" method="post" role="form">
            <fieldset>
                <legend>Student Course Search</legend>
            </fieldset>

            <div class="form-group">
                <label for="courseName">Course name</label>

                <div class="col-lg-3">
                    <input name="courseName" id="courseName" path="courseName" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="studentName">Student name</label>

                <div class="col-lg-3">
                    <input name="studentName" id="studentName" path="studentName" class="form-control" disabled="true"/>
                </div>
            </div>

            <div class="col-lg-3">
                <button type="submit" class="btn btn-default" id="submitFormBtn" disabled="true">Submit</button>
            </div>
        </form>

        <c:choose>
            <c:when test="${emptyPage==true}">
            </c:when>
            <c:otherwise>
                <br/>

                <p>You have search for: <c:out value="${courseName}"/></p>
                <c:choose>
                    <c:when test="${empty studentList}">
                        <h2 class="has-error">No students found for this course with this name</h2>
                    </c:when>
                    <c:otherwise>

                        <table class="table table-hover table-bordered">
                            <caption>Students for this course</caption>
                            <tr>
                                <th>Student Name</th>
                                <th>Student Last Name</th>
                            </tr>
                            <c:forEach items="${studentList}" var="student">
                                <tr>
                                    <td>
                                        <c:out value="${student.name}"/>
                                    </td>
                                    <td>
                                        <c:out value="${student.lname}"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>

    </div>

    <div class="col-lg-2"></div>
    <script>

        $(document).ready(function () {
            $(formEnDis);
        });
        function enableDisable(trueFalse) {
            $("#studentName").prop('disabled', trueFalse);
            $("#submitFormBtn").prop('disabled', trueFalse);
        }
        ;

        var formEnDis = $("#courseName").on('keyup', function () {
            if ($("#courseName").val() == "") {
                enableDisable(true);
            } else {
                enableDisable(false);
            }
        });
    </script>
</div>
