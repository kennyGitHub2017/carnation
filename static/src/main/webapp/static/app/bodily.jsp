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
    <div class="bodily" id="modelTouch" wid="#m-" style="background-image: url(assets/images/bodily/male.jpg)">
        <div id="m-head" class="item" positionId="53"></div>
        <div id="m-thorax" class="item" positionId="55"></div>
        <div id="m-abdomen" class="item" positionId="56"></div>
        <div id="m-genital" class="item" positionId="57"></div>
        <div id="m-leg" class="item" positionId="54"></div>
        <div id="m-arm" class="item" positionId="54"></div>
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
        head: $("#m-head"),
        thorax: $("#m-thorax"),
        abdomen: $("#m-abdomen"),
        genital: $("#m-genital"),
        leg: $("#m-leg"),
        arm: $("#m-arm")
    }, callback);

</script>
</body>
</html>