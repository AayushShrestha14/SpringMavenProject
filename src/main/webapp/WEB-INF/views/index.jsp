<%-- 
    Document   : index
    Created on : Jun 5, 2018, 10:51:18 AM
    Author     : dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://code.jquery.com/jquery.min.js"></script>
    </head>
    <body>
        <h1>Student List</h1>
        <div id="view"></div>
        <div id="detail" style="display:none">
            <div>
                <label>Name:</label>
                <input type="text" name="name"/>
            </div>
            <div>
                <label>Email:</label>
                <input type="text" name="email"/>
            </div>
            <div>
                <label>Status:</label>
                <input type="checkbox" name="status"/>
            </div>
        </div>
        <script>
            var baseURL = "${pageContext.request.contextPath}";
            var studentData=null;
            $(document).ready(function () {
                
                var $view = $("#view");
                $view.html("<h1>Loading......</h1>");
                var url = baseURL + "/student/json";
                $.get(url, function (res) {
                    //$view.html(data);
                    studentData=res.data;
                    var $ul = $("<ul/>");
                    $.each(res.data, function (i, s) {
                        $link = $("<a href='#'/>")
                                .html(s.first_name + " " + s.middle_name + " " + s.last_name + "(" + s.email + ")")
                                .on('click', function () {
                                    showDetail(s.id);
                                });
                        $("<li/>")
                                .append($link)
                                .appendTo($ul);

                    });
                    $view.html("").append($ul);
                });
            });

            function showDetail(id) {
                /*$.getJSON(baseURL + "/student/json/" + id, function (data) {
                    var $detail = $("#detail");
                   
                    if(data.middle_name){
                    (data.name=data.first_name+" " + data.middle_name+ " " +data.last_name);
                    }else{
                        data.name=data.first_name + " " + data.last_name;
                    }                                                      
                    $detail.find("input[name=name]").val(data.name);
                    $detail.find("input[name=email]").val(data.email);
                    $detail.find("input[name=status]").prop('checked',data.status);
                    $detail.show();
                });*/
        
                //console.log(studentData);
                var student=null;
                $.each(studentData,function(i,s){
                    if(s.id===id){
                        student=s;
                        detailView(s);
                    }
                });

                if(student===null){
                    $.getJSON(baseURL + "/student/json/" + id, function (data) {
                        detailView(data);
                    });
                }           
            }
            
            function detailView(data){
                var $detail = $("#detail");
                   
                    if(data.middle_name){
                    (data.name=data.first_name+" " + data.middle_name+ " " +data.last_name);
                    }else{
                        data.name=data.first_name + " " + data.last_name;
                    }                                                      
                    $detail.find("input[name=name]").val(data.name);
                    $detail.find("input[name=email]").val(data.email);
                    $detail.find("input[name=status]").prop('checked',data.status);
                    $detail.show();
            }
        </script>    
    </body>
</html>
