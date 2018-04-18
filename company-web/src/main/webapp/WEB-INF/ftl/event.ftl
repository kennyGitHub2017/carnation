<#if (events?size > 0)>
<div id="event_news" class="mod-block clearfix">
    <div class="cont-width">
        <div class="home-title">
            <h2>招商资讯</h2>
            <span>Investment Information</span>
        </div>
        <div class="home-news-list news-list row J_business">
			<#list events as event>
				<div class="col-md-6 home-news-item animated fadeIn wow">
                    <a href="${yesPath}/news/${event.id}">
                    	<#if event.img??>
  							<img src="${event.img}" />
						<#else>
						  	<img src="${staticPath}/static/enterprise/assets/images/pic/p-logo.png">
						</#if>
                        <div class="title">${event.title}</div>
                        <span class="date">[${event.addTime?string("yyyy-MM-dd")!''}]</span>
                        <div class="cont" style="height: 75px;">
                            <#if (event.artDesc)?? && ((event.artDesc)?length > 36)>
						    ${event.artDesc?substring(0,36)}..   
						    <#else>  
						    ${(event.artDesc)!''}  
						    </#if>  
                        </div>
                    </a>
                </div>
			</#list>
        </div>
        <nav class="text-center">
            <nav class="text-center">
			 	 <ul class="pagination" mark="J_business">
	       		  ${gotoPageAjaxHTML}
		   		 </ul> 
				</nav>
            </nav>
        </div>
    </div>
	</#if>