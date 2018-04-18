<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>找不到页面</title>

    <%@ include file="include/inc_css.jsp"%>
    <style>
        #wait { padding: 5% 0;  text-align: center; box-shadow: 0 2px 2px #ccc inset; line-height: 1.6;}
    </style>
</head>

<body>

<div id="wait">
    <img src="assets/images/404.jpg" />

    <div class="pt-10">
        <p style="padding: 30px 0; font-size: 16px;">很抱歉，你来晚了一步，它已经任性的消失了... <br>
            你要坚强些，继续发掘别的页面去吧.</p>
    </div>


</div>

</body>
</html>