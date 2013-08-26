<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 class="contacts">Uploads</h1>

<form:form modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>
                <form:label path="fileName">
                    <spring:message code="label.videoName"/>
                </form:label>
            </td>
            <td>
                <form:input path="fileName"/>
                <div>
                    <form:errors path="fileName" cssClass="error"/>
                </div>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="fileData">
                    <spring:message code="label.browseToUpload"/>
                </form:label>
            </td>
            <td>
                <form:input path="fileData" type="file"/>
                <div>
                    <form:errors path="fileData" cssClass="error"/>
                </div>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" class="suggestionsButton"
                       value="<spring:message code="label.uploadvideo"/>"/>
            </td>
        </tr>
    </table>
</form:form>

<link rel="stylesheet"
      href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"/>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
    $(function () {
        $(".datePickers input").datepicker({
            showOn: "button",
            buttonImage: "resources/images/calendar.png",
            buttonImageOnly: true,
            dateFormat: 'yy-mm-dd'
        });
    });
    $("#datepicker").datepicker("option", "dateFormat", $(this).val());
</script>
