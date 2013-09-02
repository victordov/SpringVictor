<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    document.onload(function () {
        document.getElementById('loginForm').focus();
    });
</script>
<div class="row">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">

        <form id="loginForm" role="form" name="loginForm" action="j_spring_security_check" method="post">
            <c:if test="${not empty param.authfailed}">
    <span id="infomessage" class="errormessage">
    Login failed due to: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
    </span>
            </c:if>
            <c:if test="${not empty param.loggedout}">
    <span id="infomessage" class="successmessage">
    You have been successfully logged out.
    </span>
            </c:if>
            <table>
                <tr>
                    <td>Username</td>
                    <td>
                        <input id="usernameField" type="text" name="j_username"
                               value="<c:out value="${SPRING_SECURITY_LAST_USERNAME}"/>"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input id="passwordField" type="password" name="pass"/></td>
                </tr>

                <tr>
                    <td colspan="2" align="right"><input type="submit" value="Login"/></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="col-lg-2"></div>
</div>