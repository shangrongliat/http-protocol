<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<html>
<head>
    <title>第一个网页</title>
</head>
<body>
<h3><spring:message code="msg"></spring:message> ,<spring:message code="current"></spring:message>：${now}</h3>

<input id="showContent" style="width:700px;height:30px; font:400 18px Arial" /> <br/>
<button id="sendGetNoParameter"  class="btn btn-info btn-block" style="font:400 18px Arial;" >点击发送无参数get请求</button>
<br/>
<button id="sendGet"  class="btn btn-info btn-block" style="font:400 18px Arial;" >点击发送get请求</button>
<button id="sendPost"  class="btn btn-info btn-block" style="font:400 18px Arial;">点击发送post请求</button>
<button id="sendHead" class="btn btn-info btn-block" style="font:400 18px Arial;">点击发送head请求</button>
<%--<button id="btnhead">点击发送head请求</button>--%>
<br/>
<%--   http://127.0.0.1:18080/api/request/state/model/   --%>
<a href="http://127.0.0.1:18080/index2">希望能跳到下一页</a>
<br/>
<a href="http://127.0.0.1:18080/index3">可以跳到下一页吗</a>

<script>
    $(function () {

        $('#sendGetNoParameter').click(function () {
            //http://127.0.0.1:18080/api/request/model/post
            var uri = document.getElementById("showContent").value;
            $.get(uri);
        });

        $('#sendGet').click(function () {
            //http://127.0.0.1:18080/api/request/model/post
            var uri = document.getElementById("showContent").value;
            $.get(
                uri+'?name=Jerry&value=65',
                function (result) {
                    alert(JSON.stringify(result));
                    // $('#content').text(JSON.stringify(result));
                }
            );
        });

        $('#sendPost').click(function () {
            //http://127.0.0.1:18080/api/request/model/post
            var uri = document.getElementById("showContent").value;
            $.post(
                uri,
                {
                    name: 'Tom',
                    age: '69'
                },
                function (result) {
                    alert(JSON.stringify(result));
                    // $('#content').text(JSON.stringify(result));
                }
            );
        });

        $('#sendHead').click(function () {
            var uri = document.getElementById("showContent").value;
            var http = new XMLHttpRequest();
            http.open('HEAD', uri);
            http.onreadystatechange = function () {
                console.log(this.readyState);
                console.log(this.DONE);
                console.log(http.status)
            };
            http.send();
        });
    });

</script>
</body>
</html>
