<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 class="contacts">Uploads</h1>

<div class="row">

    <div class="col-md-4"></div>

    <div class="col-md-4">
        <form:form modelAttribute="uploadItems" method="post" enctype="multipart/form-data">
            <div id="fileTable">
                <c:forEach items="${uploadItems.uploadItemList}" var="uploadItem" varStatus="status">
                    <div class="form-group">
                        <form:label path="uploadItemList[${status.index}].fileName">File name</form:label>
                        <form:input path="uploadItemList[${status.index}].fileName" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="uploadItemList[${status.index}].fileData">File</form:label>
                        <form:input path="uploadItemList[${status.index}].fileData" type="file"
                                    cssClass="form-control"/>
                    </div>
                </c:forEach>

            </div>
            <button type="submit" class="btn btn-default">Submit</button>
            <button type="button" class="btn btn-default" id="addFile">Add a file</button>

        </form:form>
    </div>
    <div class="col-md-4"></div>
</div>
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

<script>
    $(document)
            .ready(
            function () {
                //add more file components if Add is clicked
                $('#addFile')
                        .click(
                        function () {
                            var fileIndex = $('#fileTable .form-group').length / 2;
                            if (fileIndex > -1) {
                                $('#fileTable')
                                        .append(
                                                '<div class="form-group">' +
                                                        '<label for="uploadItemList' + fileIndex + '.fileName">File name</label>'
                                                        + '   <input name="uploadItemList[' + fileIndex + '].fileName" class="form-control"/>'
                                                        + '</div>' +
                                                        '<div class="form-group">' +
                                                        '<label for="uploadItemList' + (fileIndex) + '.fileData">File</label>'
                                                        +
                                                        '   <input type="file" name="uploadItemList[' + (fileIndex) + '].fileData" class="form-control"/>'
                                                        + '</td>' +
                                                        '</tr>');
                            }

                        });

            });
</script>
