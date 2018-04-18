<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport" id="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

<title>保健品行业动态,保健品新闻,直销行业动态,云尚大事纪,云尚上市计划,云尚互联网平台 - 云尚</title>
<meta name="keywords" content="保健品行业动态,保健品新闻,直销行业动态,云尚大事纪,云尚上市计划,云尚互联网平台,云尚" />
<meta name="description" content="云尚行业动态主要发布互联网行、直销、大健康领域的市场状况，了解竞争对手的经营以及市场行为。行业动态是企业决策的基础依据，充分了解动态，可以调整销售策略，提升企业竞争能力。云尚服务热线：400-888-2933 。">

<%@ include file="include/inc_css.jsp"%>

</head>
<body mid="m-industrytrends">

	<%@ include file="include/header.jsp"%>

	<div
		style="background-image: url(${staticPath}/static/platform/assets/images/banner_05.png)"
		class="mod-banner"></div>

	<div class="mod-block">
		<div class="cont-width clearfix">
			<div class="home-title gray-title">
				<h2>行业动态</h2>
				<span>行业资讯，动态，热点，你想要的都在这里</span>
			</div>
			<%-- <div class="about-content">
				<ul class="news-list list">
				
					<c:if test="${objs == null}">
					      <div class="ui-warn text-center">
								暂无记录！
							</div>
					</c:if>
					
					<c:forEach var="instance" items="${objs}"
						varStatus="status">
						<c:choose>
							<c:when test="${status.index%2==0}"> 
                                     <li class="animated fadeInLeft wow">   
							</c:when>
							<c:when test="${status.index%2==1}">
							        <li class="even animated fadeInRight wow"> 
							</c:when>
						</c:choose>
  						<a href="/news/${instance.id}">
						<div class="title" style="height:50px" >${instance.title} </div>
						<div id="div_content${ status.index+1 }" style="height: 66px; overflow: hidden;"> ${instance.content} </div>
						<div class="date">时间：<fmt:formatDate value="${ instance.addTime }" pattern="yyyy-MM-dd"/></div>
						</a>
						<i class="news-arrow"></i> 
						</li> 
					</c:forEach> 
				</ul>
				
				
				<i class="paragraph hidden-xs"></i>
			</div> --%>
			 

			

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
                        <div class="tit">${instance.title}</div>
                        <div class="time"><fmt:formatDate value="${ instance.addTime }" pattern="yyyy-MM-dd"/></div>
                        <p class="list_article">${instance.artDesc}</p>
                        <a href="/news/${instance.id}" class="goto">点击了解详情</a>
                        <img class="dynamic" src="${instance.img}" alt="" />
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
		
		 }
		 
	  }
	   
  }); 
 

</script>
 
</body>
</html>
