    <div id="hyevent_news" class="join-conditions mod-block home-news">
        <div class="cont-width">
            <div class="home-title white-title">
                <h2>行业资讯</h2>
                <span>Industry News</span>
            </div>
            <div class="news-industry clearfix">
                <div class="col-md-7 animated slideInLeft wow">
                    <img src="${article.img}" height="350" width="550"/>
                </div>
                <div class="news-industry-cont animated slideInRight wow">
                    <a href="${yesPath}/news/${article.id}" class="news-industry-link">
                        <div class="title">${article.title}</div>
                        <div class="date">［${article.addTime?string("yyyy-MM-dd")!''}］</div>
    					<#if (article.artDesc)?? && ((article.artDesc)?length > 60)>
					    ${article.artDesc?substring(0,60)}..   
					    <#else>  
					    ${(article.artDesc)!''}  
					    </#if>
                    </a>
                    <div class="news-page">
                    	<#if preId??>
                    	<a href="javascript:gotoHYEventsFunc(${preId});">&lt;</a>
						</#if>
                    	<#if nextId??>
                    	<a href="javascript:gotoHYEventsFunc(${nextId});">&gt;</a>
                    	</#if>
					</div>
                </div>
            </div>
        </div>
    </div>