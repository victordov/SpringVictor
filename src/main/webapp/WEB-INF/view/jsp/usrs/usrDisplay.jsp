<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <c:choose>
            <c:when test="${notFound==true}">
                <p>Invalid User</p>

                <p class="has-error">Please provide valid username</p>
            </c:when>
            <c:otherwise>
                <form action="/usrs/${registeredUser.username}.html" method="post">

                      <input type="hidden" name="username" value="<c:out value='${userDb.username}' />" />
                <table>

                    <select name="idAuthority">
                        <c:forEach items="${authorities}" var="auth">
                            <option value="<c:out value="${auth.id}" />"><c:out
                                    value="${auth.roleName}"/></option>
                        </c:forEach>
                    </select>

                </table>
                    <button type="submit">Submit</button>
                </form>
            </c:otherwise>
        </c:choose>


    </div>
    <div class="col-md-4"></div>
</div>