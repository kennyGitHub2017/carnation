<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <title>云尚平台官网</title>
    <meta name="keywords" content="健康生活"/>
    <meta name="description" content="">

	<%@ include file="include/inc_css.jsp"%>

    <style>
        #wait { padding: 5% 0;  text-align: center; box-shadow: 0 2px 2px #ccc inset; line-height: 1.6;}
    </style>

</head>
<body>

<%@ include file="include/header.jsp"%>

<div id="wait">
    <img src="assets/images/500.jpg" />

    <div class="pt-10">
        <p style="padding: 10px 0 30px; font-size: 16px;">很报歉, 服务器繁忙 请稍后重试.</p>
        <p>
            <button class="btn btn-info" style="margin-right: 20px;">返回上一页</button>
            <button class="btn btn-default"> &nbsp; 首 &nbsp; 页 &nbsp; </button>
        </p>
    </div>


</div>

<%@ include file="include/footer.jsp"%>

</body>
</html>