<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>我的问答</title>

    <%@ include file="include/inc_css.jsp"%>

</head>
<body class="gray-bg">
<div class="model-wrap">
    <div class="bodily" id="modelTouch" wid="#w-" style="background-image: url(assets/images/bodily/woman.jpg)">
        <div id="w-head" class="item" positionId="53"></div>
        <div id="w-thorax" class="item" positionId="55"></div>
        <div id="w-abdomen" class="item" positionId="56"></div>
        <div id="w-genital" class="item" positionId="57"></div>
        <div id="w-leg" class="item" positionId="54"></div>
        <div id="w-arm" class="item" positionId="54"></div>
  </div>
</div>

<script src="assets/js/jquery-2.1.4.min.js"></script>
<script src="assets/js/page/apparatus.js"></script>

<script>
	function callback() {
		if(isAndroid)
		{
			java.requestCategoryBody($("#modelTouch").find(".overItem").attr("positionId"));
		}
		if(isiOS)
		{
			requestCategoryBody($("#modelTouch").find(".overItem").attr("positionId"));
		}
	}

    scaleStyle($("#modelTouch"), {
        head: $("#w-head"),
        thorax: $("#w-thorax"),
        abdomen: $("#w-abdomen"),
        genital: $("#w-genital"),
        leg: $("#w-leg"),
        arm: $("#w-arm")
    }, callback);

</script>
</body>
</html>