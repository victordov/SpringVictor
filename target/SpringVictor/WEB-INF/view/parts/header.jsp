<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div>
    <h2>
        <a href="/index.html">Winify Sprig</a>
    </h2>

    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <nav class="navbar navbar-default" role="navigation">
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/student.html">Student</a></li>
                        <li><a href="/university.html">University</a></li>
                        <li><a href="/student/search.html">Search Student-Course</a></li>
                    </ul>
                    <div id="nav-account" class="pull-right">
                        <ul class="nav">
                            <sec:authorize access="authenticated" var="authenticated"/>
                            <c:choose>
                                <c:when test="${authenticated}">
                                    <li id="greeting">
                                        <div>
                                            Welcome
                                            <sec:authentication property="name" />
                                        </div>
                                    </li>
                                    <c:url var="logoutUrl" value="/logout.html"/>
                                    <li>
                                        <a id="navLogoutLink" href="${logoutUrl}">Logout</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <c:url var="loginUrl" value="/login.html"/>
                                    <li>
                                        <a id="navLoginLink" href="${loginUrl}">Login</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>
            </nav>

        </div>
        <div class="col-md-2"></div>
    </div>
</div>


