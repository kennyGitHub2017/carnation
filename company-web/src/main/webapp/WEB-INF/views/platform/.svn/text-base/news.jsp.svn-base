<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport" id="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

<title>云尚大事纪,云尚上市计划,云尚最新动态,云尚新闻,云尚健康资讯,云尚互联网平台,云尚蓝莓基地 - 云尚</title>
<meta name="keywords" content="云尚大事纪,云尚上市计划,云尚最新动态,云尚新闻,云尚健康资讯,云尚互联网平台,云尚蓝莓基地,云尚" />
<meta name="description" content="云尚公司动态主要是发布企业最新动态，如新闻事件、热点话题、人物动态、新品上市、优惠活动、荣誉奖项、市场会议等等快速了解企业的最新进展。云尚服务热线：400-888-2933 。">

<%@ include file="include/inc_css.jsp"%>
<style>
.list_article a{color:#424242}
</style>
</head>
<body mid="m-news">

	<%@ include file="include/header.jsp"%>

	<div
		style="background-image: url(${staticPath}/static/platform/assets/images/banner_04.png)"
		class="mod-banner"></div>

	<div class="mod-block">
		<div class="cont-width clearfix">
			<div class="home-title gray-title">
				<h2>公司动态</h2>
				<span>以三网合一的健康调理为核心的健康管理</span>
			</div>
		</div>
		<div class="company-news_list">
            <ul>
            	<c:if test="${objs == null}">
			     	 <div class="ui-warn text-center">
						暂无记录！
					</div>
				</c:if>
				<c:forEach var="instance" items="${objs}" varStatus="status">
				<c:choose>
					<c:when test="${status.index%2==0}"> 
                                   <li class="odd">   
					</c:when>
					<c:when test="${status.index%2==1}">
					        <li class="even"> 
					</c:when>
				</c:choose>
                    <div class="company-news_list_mes">
                    	<span class="number">${ status.index+1 }</span>
                        <div class="tit"><a href="/news/${instance.id}">${instance.title}</a></div>
                        <div class="time"><fmt:formatDate value="${ instance.addTime }" pattern="yyyy-MM-dd"/></div>
                        <p class="list_article"><a href="/news/${instance.id}">${instance.artDesc}</a></p>
                        <a href="/news/${instance.id}" class="goto">点击了解详情</a>
                        <a class="dynamic" href="/news/${instance.id}">
                        	<img src="${instance.img}" alt="" />
                        </a>                        
                    </div>
                </li>
                </c:forEach>
            </ul>
        </div>
        <nav class="text-center">
		 <ul class="pagination">
       		  ${gotoPageHTML}
   		 </ul> 
		</nav>
	</div>


	<%@ include file="include/footer.jsp"%>

<script type="text/javascript" >

   $(function(){
	  var rows =parseInt("${rows}"); 
	  for(var i = 1;i<= rows;i++)
	  {
		 var i_t=i;
		 
		 
		 if($("#div_content"+i_t)[0]!=undefined)
		 {
			 var newHtmlElements = $("#div_content"+i_t).html().replace(/<[^>].*?>/g,"");  //clear elements
			 
			 if(newHtmlElements.length>90)
			 {
				 $("#div_content"+i_t+"").html(newHtmlElements.substring(0,90)+"..."); 
				 
			 }	 
			 //$("#div_content"+i_t+" p")[0].innerHTML= $("#div_content"+i_t+" p")[0].innerHTML.substring(0,90)+"...";
			 //$("#div_content"+i_t+"").html($("#div_content"+i_t+" p")[0].innerHTML); 
		
		 }
		 
	  }
	   
  }); 
 

</script>
 
</body>
</html>