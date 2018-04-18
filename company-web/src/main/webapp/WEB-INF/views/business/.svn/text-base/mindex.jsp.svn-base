<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <%@ include file="/WEB-INF/views/include/taglib.jsp"%>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="email=no">
    <link href="${staticPath}/static/Investing/css/base.min.css" type="text/css" rel="stylesheet">
    <link href="${staticPath}/static/Investing/css/mcss.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	//给时间对象原型添加Format方法
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
</script>
<script type="text/javascript">
function getData(id,level){					
	jQuery.post("load_areaAct", {
		"pid" : id,
		"level" : level
	}, function(res) {
		if(res.code == 1){
			// 处理级联
			jQuery("#area" + level).empty();
			jQuery("#area" + level).append(
					"<option value=''>请选择</option>");
			jQuery.each(res.data.areaList, function(index, item) {				
				if(item.id=="${cid}"){
			    	  jQuery("#area"+level).append("<option value='"+item.id+"' selected='selected'>"+item.areaName+"</option>");
			    	  
			      }
			      else{
			    	  jQuery("#area"+level).append("<option value='"+item.id+"'>"+item.areaName+"</option>");
			      }
			});
			
			
			
			///
			
			
			
			// 处理列表1
			var str1="",data1=res.data.readNews;									
			
			for(var i1=0,iCount=data1.length;i1<iCount;i1++){
				if(i1==0){
					str1+="<div class='newslist news curr'>";
					str1+="<p class='tit'>"+data1[i1].title+"</p>";
					str1+="<p class='content'>";
					str1+=data1[i1].actDesc;
					str1+="</p>";
					str1+="<div class='time fn-clear'>";
					if(new Date().Format("yyyy-MM-dd hh:mm:ss")>data1[i1].enrollBg){
						if(new Date().Format("yyyy-MM-dd hh:mm:ss")<data1[i1].enrollEnd){
						str1+="<a href='javascript:void(0)' onclick='show_submit("+data1[i1].id+")' class='bm'>点击报名</a> ";
						}
					}
					str1+="<span class='date'>报名时间："+data1[i1].enrollBg.substring(5,10) +"至"+data1[i1].enrollEnd.substring(5,10)+"</span><span class='act_time'>活动时间："+data1[i1].actBg.substring(5,10) +"至"+data1[i1].actEnd.substring(5,10)+"</span>";
					str1+="</div>";
					str1+="<div class='act_img'>";
					str1+="<img src="+data1[i1].img+">";
					str1+="</div>";
					str1+="</div>";												
				
				}else{
					str1+="<div class='newslist news'>";
					str1+="<p class='tit'>"+data1[i1].title+"</p>";
					str1+="<p class='content'>";
					str1+=data1[i1].actDesc;
					str1+="</p>";
					str1+="<div class='time fn-clear'>";
					if(new Date().Format("yyyy-MM-dd hh:mm:ss")>data1[i1].enrollBg){
						if(new Date().Format("yyyy-MM-dd hh:mm:ss")<data1[i1].enrollEnd){
						str1+="<a href='javascript:void(0)' onclick='show_submit("+data1[i1].id+")' class='bm'>点击报名</a> ";
						}
					}
					str1+="<span class='date'>报名时间："+data1[i1].enrollBg.substring(5,10) +"至"+data1[i1].enrollEnd.substring(5,10)+"</span><span class='act_time'>活动时间："+data1[i1].actBg.substring(5,10) +"至"+data1[i1].actEnd.substring(5,10)+"</span>";
					str1+="</div>";
					str1+="<div class='act_img'>";
					str1+="<img src="+data1[i1].img+">";
					str1+="</div>";
					str1+="</div>";	
				}
			}
			if(data1.length==0){
				str1+="<div class='newslist news curr'>";
				str1+="<p class='tit'></p>";
				str1+="<p class='content'>";
				str1+="暂无数据";
				str1+="</p>";
				str1+="<p class='content'>";
				str1+="</p>";
				str1+="<div class='act_img'>";
				str1+="</div>";
				str1+="</div>";		
			}
			str1+="<div class='cir fn-clear'>";
			str1+="<div class='inline-table'>";
			str1+="<span class='curr'></span>";
			if(iCount>1){
				for(var ii1=0;ii1<iCount-1;ii1++){
					str1+="<span></span>";
				}
			}										
			str1+="</div>";
			str1+="</div>";									
			jQuery("#Data1Container").html(str1);
//res.data.readNews
//res.data.bgNews
//res.data.endActNews
			var str2="",data2=res.data.bgNews,pageSize=10,link;
			for(var i2=0,count2=data2.length;i2<count2;i2++){
				if(i2%pageSize==0){
					if(i2!=0){
						str2+="</ul>";
						str2+="</div>";
						str2+="<div class='newslist listdiv'>";
						str2+="<ul class='list fn-clear'>";	
						link="${yesPath}/actnews/"+data2[i2].id;
						str2+="<li><span>活动时间:"+data2[i2].enrollBg.substring(5,10) +"至"+data2[i2].enrollEnd.substring(5,10)+"</span><a href='"+link+"'>"+data2[i2].title+"</a></li>";
					}else{
						str2+="<div class='newslist listdiv curr'>";
						str2+="<ul class='list fn-clear'>";
						link="${yesPath}/actnews/"+data2[i2].id;
						str2+="<li><span>活动时间:"+data2[i2].enrollBg.substring(5,10) +"至"+data2[i2].enrollEnd.substring(5,10)+"</span><a href='"+link+"'>"+data2[i2].title+"</a></li>";					}																			
					
				}else{
					link="${yesPath}/actnews/"+data2[i2].id;
					str2+="<li><span>活动时间:"+data2[i2].enrollBg.substring(5,10) +"至"+data2[i2].enrollEnd.substring(5,10)+"</span><a href='"+link+"'>"+data2[i2].title+"</a></li>";
				}
				
			}								
			str2+="</ul>";
			str2+="</div>";
			
			var pageCount=Math.ceil(count2/pageSize);
			str2+="<div class='cir fn-clear'>";		
			str2+="<div class='inline-table'>";
			str2+="<span class=\"curr\"></span>";
			if(pageCount>1){
				for(var q=0;q<pageCount-1;q++){
					str2+="<span></span>";
				}
			}
			str2+="</div>";
			str2+="</div>";
			$("#Data2Container").html(str2);
			
			
			var str3="",data3=res.data.endActNews,pageSize3=10,link;
			for(var i3=0,count3=data3.length;i3<count3;i3++){
				if(i3%pageSize3==0){
					if(i3!=0){
						str3+="</ul>";
						str3+="</div>";
						str3+="<div class='newslist listdiv'>";
						str3+="<ul class='list fn-clear'>";	
						link="${yesPath}/actnews/"+data3[i3].id;
						str3+="<li><span>活动时间:"+data3[i3].enrollBg.substring(5,10) +"至"+data3[i3].enrollEnd.substring(5,10)+"</span><a href='"+link+"'>"+data3[i3].title+"</a></li>";
					}else{
						str3+="<div class='newslist listdiv curr'>";
						str3+="<ul class='list fn-clear'>";
						link="${yesPath}/actnews/"+data3[i3].id;
						str3+="<li><span>活动时间:"+data3[i3].enrollBg.substring(5,10) +"至"+data3[i3].enrollEnd.substring(5,10)+"</span><a href='"+link+"'>"+data3[i3].title+"</a></li>";
					}																			
					
				}else{
					link="${yesPath}/actnews/"+data3[i3].id;
					str3+="<li><span>活动时间:"+data3[i3].enrollBg.substring(5,10) +"至"+data3[i3].enrollEnd.substring(5,10)+"</span><a href='"+link+"'>"+data3[i3].title+"</a></li>";
				}
				
			}								
			str3+="</ul>";
			str3+="</div>";
			
			var pageCount3=Math.ceil(count3/pageSize3);
			str3+="<div class='cir fn-clear'>";		
			str3+="<div class='inline-table'>";
			str3+="<span class=\"curr\"></span>";
			if(pageCount3>1){
				for(var p=0;p<pageCount3-1;p++){
					str3+="<span></span>";
				}
			}
			str3+="</div>";
			str3+="</div>";
			$("#Data3Container").html(str3);
			
		}
		else if(res.code == 0){
		//	alert(data.errMsg);
		}
	}, "json");


}


	jQuery(document).ready(function() {
				//
				//getData();
				
				
				
				jQuery("select").change(function() {
							var level = jQuery(this).attr("level");
							var id = jQuery(this).val();
							jQuery("#area_id").val("");
							for (var i = 3; i > level; i--) {
								jQuery("#area" + i).empty();
								jQuery("#area" + i).append(
										"<option value=''>请选择</option>");
							}
							if (id != "") {
								getData(id,level);
							} else {
								for (var i = level; i <= 4; i++) {
									jQuery("#area" + i).empty();
								}
							}
							
				});
				//
				// <!--#if($!address.id) --> 
				/* <c:if test="${ not empty address.id}">
				jQuery("#area_id").val("${address.areaId}");
				jQuery("#area1").val("${area.parent.parent.id}")
				jQuery("#area2").html(
						"<option>${area.parent.areaName}</option>");
				//	   jQuery("#area3").html("<option>$!area.areaName</option>");

				</c:if>
				// <!-- #if($!user.month_income) --> 
				<c:if test="${ not empty user.month_income}">
				jQuery("#month_income").val("${user.month_income}");
				</c:if> */
			});
	
	//jQuery("#area1").val("${pid}");
	//jQuery("#area2").val("${cid}");
	function initArea3(){
		var level = 2;
		var id = "${pid}";		
		if (id != "") {
			getData(id,level);
		} else {
			for (var i = level; i <= 4; i++) {
				jQuery("#area" + i).empty();
			}
		}
		
	}

	
	initArea3();
	//initArea2();
	//initArea3();

	//
</script>
</head>
<body>
    <div class="mtop">
        <img src="${staticPath}/static/Investing/images/mlogo.png">
    </div>
    <div>
        <img src="${staticPath}/static/Investing/images/mtop.jpg">
    </div>
    <div class="born">
        <div class="titleWrap">
            <div class="title">
                <span>云尚——市场前景</span>
            </div>
        </div>
        <p class="p_words">30年前，积极投资的人成了今天理财观念的案例；15年前，投资互联网的人成了今天投资方向的案例；现在，投资云尚健康管理平台的您，将是改变大众生活方式的案例！</p>
        <div class="tab_btn">
            <ul class="fn-clear">
                <li class="curr">健康产业趋势</li>
                <li>互联网+ 趋势</li>
                <li>云尚健康管理</li>
                <li>政府及政策支持</li>
            </ul>
        </div>
        <div class="tab_img_view">
            <div class="containdiv fn-clear">
                <div class="b1">
                    <img src="${staticPath}/static/Investing/images/slide1.jpg">
                    <p>2016年开始，不管是在中国，还是在全球，健康产业愈发吸睛又吸金。随着社会发展和人们生活水平的普遍提高，以及人类生活方式的改变，以生物技术和生命科学为先导，涵盖医疗卫生、营养保健、健身休闲等健康服务功能的健康产业必将成为21世纪第一项新兴的引导全球经济发展和社会进步的重要产业。</p>
                    <p>我国的健康产业恰恰是国家高速发展经济的下一突破口。健康产业早已被国际经济学界确定为："无限广阔的兆亿产业"。</p>
                </div>
                <div class="b2">
                    <img src="${staticPath}/static/Investing/images/slide2.jpg">
                    <p>互联网、尤其是移动互联网对各行各业的影响早已触及筋骨，“互联网+”俨然是经济增长绕不开的话题，互联网+健康更是映入资本市场、民生领域的两眼新星。</p>
                    <p>近几年，随着智能手机普及范围日益扩大、穿戴式设备的走俏、越来越多的专业人士和医疗机构选择跳出体制。移动互联网技术在不断加速发展，健康产业“移动化”也得到了足够重视，并向更深更广的领域渗透。在移动互联网的深远影响下，健康产业将会呈现出越发广阔的新面貌，移动互联网也将带领健康产业跃居龙头。</p>
                </div>
                <div class="b3">
                    <img src="${staticPath}/static/Investing/images/slide3.jpg">
                    <p>云尚作为新形态下的健康产业品牌和平台的代表，早已不满足于仅仅是提供健康信息亦或健康产品。</p>
                    <p>“对用户生命周期给予持续性的服务”这一理念就是云尚个人健康管理平台的信念。</p>
                    <p>健康管理有别于以往健康产业的主要原因在于,它包括了一个人健康生活从初生到衰老的方方面面,随着人们生活水平的提高以及健康意识的普及，未来人们对移动化的健康需求势必会成爆发式增长。借助网络力量构筑的健康平台，势必会站在爆发的风口浪尖。</p>
                </div>
                <div class="b4">
                    <img src="${staticPath}/static/Investing/images/slide4.jpg">
                    <p>我国大健康产业发展面临良好的政策环境。在政府层面，国家重视以人为本，提出了切实可行的新医改方案和“健康中国2020”的健康发展战略。</p>
                    <p>这一政策可谓将“健康强国”作为一项基本国策，提高到了一个国家战略的高度，未来政府医疗健康投入将持续增加。2015年习总书记在震动互联网产业的互联网大会上的讲话，重点谈到了网络与移动医疗保健的建设，国家政策的支持、大量资金的流入、社会对健康的需求，全面预示着2016将是健康产业井喷的一年。</p>
                </div>
            </div>
        </div>
    </div>
    <div class="product">
        <div class="titleWrap">
            <div class="title">
                <span>云尚——平台项目</span>
            </div>
        </div>
        <p class="p_words">平台为什么是平台？因为它永远不像表面看上去那么简单；因为它包含一个市场该有的一切；因为每一位加盟的商家总能在意想不到的地方获得收益！</p>
        <div class="fourTab">
            <ul>
                <li class="curr">
                    <p>异业联盟</p>
                    <div>聚合所有健康生活有关的商家、整合不同层级.消费者的需求、邀请每个商业领域的伙伴、服务各个经营档次的营销个体、把单打独斗变成集团优势、把娟娟细流汇成汪洋大海、全新循环经济模式就在——云尚异业联盟。</div>
                </li>
                <li>
                    <p>移动支付</p>
                    <div>支付手段五花八门，支付花招层出不穷，是否深感无所适从？网络支付搭配银行卡收单：安全？稀松！高效？平常！移动支付手续费分成才是重点，不但方便、还能创收的支付手段就在——云尚移动支付。</div>
                </li>
                <li>
                    <p>健康商城</p>
                    <div>依托大平台海量用户，基于云数据精准定位，健康消费釜底抽薪，全新经营模式灵活自由 高端营销理念名利双收，移动蓝海邀您泛舟，健康消费塑造健康生活就在——云尚健康商城。</div>
                </li>
                <li>
                    <p>积分通兑</p>
                    <div>各大主流平台的各类积分，均可在云尚平台兑换消费。我们就是网络商场的硬通货，不必再为数不清的鸡肋积分烦心，不必再被固定平台的积分所束缚。把积分优惠最大化就在——云尚积分通兑换。</div>
                </li>
            </ul>
        </div>
    </div>
    <div class="youshi">
        <div class="titleWrap">
            <div class="title">
                <span>云尚——平台优势</span>
            </div>
        </div>
        <p class="p_words">用户口袋里的私人医生；商家手边的理财顾问；运营商眼中的提款机！使用云尚，健康就是财富；加入云尚，财富因为健康！</p>
        <div class="qiantai">
            <img src="${staticPath}/static/Investing/images/qiantai.jpg">
            <div class="tit">企业简介</div>
            <p class="intro">云尚，是一个健康管理综合服务平台，为所有人提供恰到好处的服务。在为用户提供最专业的健康管理服务同时，把买卖商品的商家、提供服务的企业、平台海量的用户有机的结合起来。形成一个独特的，循环的，带着机遇的全新经济运营主体。</p>
            <div class="swNews">
                <div class="tit"><a href="javascript:void(0)" class="more">更多</a>商务动态</div>
                <ul class="list fn-clear">
                    <li class="fn-clear"><span class="time">2015-12-28</span><a href="#"> 南宁市级运营商加盟，助力云尚健康事业</a> </li>
                    <li class="fn-clear"><span class="time">2015-12-28</span><a href="#"> 南宁市级运营商加盟，助力云尚健康事业</a> </li>
                    <li class="fn-clear"><span class="time">2015-12-28</span><a href="#"> 南宁市级运营商加盟，助力云尚健康事业</a> </li>
                    <li class="fn-clear"><span class="time">2015-12-28</span><a href="#"> 南宁市级运营商加盟，助力云尚健康事业</a> </li>
                    <li class="fn-clear"><span class="time">2015-12-28</span><a href="#"> 南宁市级运营商加盟，助力云尚健康事业</a> </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="yunying">
        <div class="titleWrap">
            <div class="title">
                <span>云尚——运营详解</span>
            </div>
        </div>
        <p class="p_words">中国的市场，说大非常大，13亿人的基数独一无二；说小非常小，僧多粥少的场面背后是无数个揣着中国梦的国人！太多的人在画大饼，更多的人想切蛋糕。成为云尚的运营商，和这个最具潜力的健康平台一起飞翔，抢占市场先机，实现创富人生！</p>
        <img src="${staticPath}/static/Investing/images/map.png" class="map"/>
        <div class="tit">活动动态</div>
        <div class="newsContainer fn-clear">
            <div class="actNews">
                <div class="actNews">
					
					<div class="select_city">
						<ul class="fn-clear">
							<li class="first">
								<select id="area1" name="area1" level="2" class="base_select_check">
									<option value="">请选择...</option>
									
									<c:set var="count" value="0" />
									<c:forEach var="area" items="${areas}">
										<c:set var="count" value="${count+1}" />
										<c:choose>
											<c:when test="${area.id eq pid}">
												<option value="${area.id}" selected="selected">${area.areaName}</option>
											</c:when>
											<c:otherwise>
												<option value="${area.id}">${area.areaName} 
													</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</li>
							<li>
							    <select id="area2" name="area2" level="3" class="base_select_check">
									<option value="">请选择...</option>
							    </select>
							</li>
							<li><select id="area3" name="area3" level="4"
								class="base_select_check">
									<option value="">请选择...</option>
							</select></li>
							<input id="area_id" name="area_id" type="hidden"
								value="$!address.areaId" />
						</ul>
					</div>
                <div class="actTabs">
                    <div class="status"><ul class="fn-clear">
                        <li class="curr">准备中</li>
                        <li>进行中</li>
                        <li>已完成</li>
                    </ul></div>
                    <div class="Container">
                        <div id="Data1Container" class="statusDiv curr">
                            
                        </div>
                        <div id="Data2Container" class="statusDiv">
                            
                        </div>
                        <div id="Data3Container" class="statusDiv"></div>
                    </div>
                </div>
            </div>
            <div class="allNews">
                <p class="tit"><a href="javascript:void(0)">更多</a> 全国资讯</p>
             <!--   <ul>
                    <img src="${staticPath}/static/Investing/images/allnews.png">
                    <li><span>2015-01-01</span><a href="#">南宁市级运营商加盟，助力云尚健康事业</a> </li>
                    <li><span>2015-01-01</span><a href="#">南宁市级运营商加盟，助力云尚健康事业</a> </li>
                    <li><span>2015-01-01</span><a href="#">南宁市级运营商加盟，助力云尚健康事业</a> </li>
                    <li><span>2015-01-01</span><a href="#">南宁市级运营商加盟，助力云尚健康事业</a> </li>
                    <li><span>2015-01-01</span><a href="#">南宁市级运营商加盟，助力云尚健康事业</a> </li>
                </ul>  -->
				<ul>
						<img src="${staticPath}/static/Investing/images/allnews.png">
						<c:forEach items="${objs2}" var="news" varStatus="obj">
							<li><span><fmt:formatDate value="${news.addTime}" pattern="yyyy-MM-dd" /></span>
								<a href="${yesPath}/news/${news.id}" title="${news.title}">${news.title}</a>
							</li>
						</c:forEach>
					</ul>
            </div>
        </div>
        <div>
            <div class="tit">运营商收益</div>
            <p class="p_words">云尚平台问世尚不足一年，在尤其注重积累与拓展、脸熟和用户才是王道的网络市场，为什么会受到广泛的关注并取得如此耀眼的成绩？不是因为天命所归，挟大势而来；也不是因为巨额的投资，用钱堆品牌；而是因为平台超前的经济理念和过硬的技术资本，使用户真真切切受益，运营商实实在在得利！</p>
            <div class="shouyi"><img src="${staticPath}/static/Investing/images/shouyi.jpg" /></div>
            <div class="tit">运营商扶持</div>
            <p class="p_words">全方位市场扶持，只要你肯来，我们拼命帮！<br/>为保障运营商稳步、有序地开展业务，保证运营商和平台同步腾飞，云尚建立了完善的市场扶持体系和专业的运营团队。从前期市场指导，到中期运营管理，再到后期运营协助；从商圈选址，到市场启动，再到市场管理，360全方位的运营扶持为您搭桥铺路，助您步步为营，直达财富彼岸！因为我们坚信只有运营商做得好，公司才能发展好；只有运营商赚大钱，公司才能赚到钱！</p>
            <div class="shouyi"><img src="${staticPath}/static/Investing/images/coop.jpg" /></div>
        </div>
    </div>
    <div class="join">
        <div class="titleWrap">
            <div class="title">
                <span>云尚——伙伴招募</span>
            </div>
        </div>
        <p class="p_words">抓住机遇，一步登天；放过机会，追悔莫及！80年代下海经商是如此，90年代买房置地是如此，上一个十年投身电商是如此，这个十年云尚亦是如此！</p>
        <div class="shouyi"><img src="${staticPath}/static/Investing/images/tiaojian.png" /></div>
        <div class="shouyi mt10"><img src="${staticPath}/static/Investing/images/liucheng.png" /></div>
    </div>
    <div class="apply">
        <div class="titleWrap">
            <div class="title">
                <span>云尚——申请加盟</span>
            </div>
        </div>
        <div class="info">
            <div class="basic">
                <span class="name">*姓名:<input type="text" id="userName" placeholder="请输入您的姓名"> </span>
                <span class="phone">*电话:<input type="text" id="phone" placeholder="请输入您的电话"> </span><br/>
                <span class="email">邮箱:<input type="text" id="email" placeholder="请输入您的邮箱"/> </span>
            </div>
            <div class="message fn-clear">
                <span class="text"><span>*</span>留言：</span>
                <textarea id="message" placeholder="留下您的意见或建议..."></textarea>
            </div>
            <div class="sub">
                <a href="javascript:void(0)" id="join_submit" class="submit">提交</a>
            </div>
        </div>
    </div>
    <div class="banq">
        <p>版权所有:云尚</p>
        <p>服务热线:xxxxxxxx</p>
    </div>
    <div class="bottom">
        <ul>
            <li>
                <a href="#">市场前景</a>
            </li>
            <li>
                <a href="#">平台项目</a>
            </li>
            <li>
                <a href="#">运营详解</a>
            </li>
            <li>
                <a href="#">伙伴招募</a>
            </li>
            <li>
                <a href="#">联系我们</a>
            </li>
        </ul>
    </div>
    <div class="model"></div>
    <div class="baoming">
        <div class="title">活动报名<a class="close" href="javascript:void(0)">×</a> </div>
        <div class="input">*姓名:<input type="text" id="act_name" placeholder="请输入您的姓名"> </div>
        <div class="input">*电话:<input type="text" id="act_mobile" placeholder="请输入您的电话"> </div>
        <div class="input email"><span class="xing">*</span>邮箱:<input id="act_email" type="text" placeholder="请输入您的邮箱地址"> </div>
        <div class="input message"><span class="fl"><span class="xing">*</span>留言:</span><textarea id="act_message" placeholder="留下您的建议或意见..."></textarea> </div>
        <a href="javascript:void(0)" id="act_submit">提交</a>
    </div>
    <div class="tips">姓名不能为空</div>
    <script type="text/javascript" src="${staticPath}/static/Investing/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
    var email_regExp = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/, mobile_regExp = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
	function show_submit(id) {
		$(".model,.baoming").show();
		$("#actid").val(id);
	}

	function keyupBaoming() {
		var name = $("#act_name").val();
		var mobile = $("#act_mobile").val();
		if (name != "" && mobile_regExp.test(mobile)) {
			$("#act_submit").addClass("curr");
		} else {
			$("#act_submit").removeClass("curr");
		}
	}

	function keyupJoin() {
		var name = $("#userName").val();
		var mobile = $("#phone").val();
		if (name != "" && mobile_regExp.test(mobile)) {
			$("#join_submit").addClass("curr");
		} else {
			$("#join_submit").removeClass("curr");
		}
	}

	$("#act_name,#act_mobile").keyup(function() {
		keyupBaoming();
	});

	$("#userName,#phone").keyup(function() {
		keyupJoin();
	});

	$(".baoming .title .close").click(function() {
		$("#act_name").val("");
		$("#act_mobile").val("");
		$("#act_email").val("");
		$("#act_message").val("");
		$(".model,.baoming").hide();
		$("#act_submit").attr("aaa", "");
	});
	
	//模拟alert
    var tips= jQuery(".tips");
    function alertBox(str){

        if(tips.css("display")=="block") return;
        tips.fadeIn();
        tips.html(str);
        window.setTimeout(function(){
            tips.fadeOut();
        },2500);
    }

	jQuery("#act_submit").click(
			function() {
				if ($("#act_submit").attr("aaa") == "aaa")
					return;
				var name = $("#act_name").val(), mobile = $("#act_mobile")
						.val(), email = $("#act_email").val(), message = $(
						"#act_message").val();

				if (name == "") {
					alertBox("请输入姓名");
					return;
				} else if (!mobile_regExp.test(mobile)) {
					alertBox("请输入正确的电话");
					return;
				} else if (email != "" && !email_regExp.test(email)) {
					
					alertBox("请输入正确的电子邮件");
					return;
				}
				$("#act_submit").attr("aaa", "aaa");
				$.ajax({

					type : 'GET',

					url : "applySave",

					data : {
						name : name,
						mobile : mobile,
						email : email,
						message : message,
						actId : $("#actid").val()
					},

					success : function(data) {
						if (data.code == 1) {
							alertBox("申请成功！");
							$("#act_submit").removeClass("curr");
							$("#act_submit").attr("aaa", "");
							$("#act_name").val("");
							$("#act_mobile").val("");
							$("#act_email").val("");
							$("#act_message").val("");
						} else if (data.code == 0) {

							alertBox("申请失败！");
						}
					},

					dataType : "json"

				});

			});
	
	
	jQuery("#join_submit").click(
			function() {
				if ($("#join_submit").attr(
						"aaa") == "aaa")
					return;
				var name = $("#userName").val(), mobile = $(
						"#phone").val(), email = $(
						"#email").val(), message = $(
						"#message").val();
				if (name == "") {
					alertBox("请输入姓名");
					return;
				} else if (!mobile_regExp
						.test(mobile)) {
					alertBox("请输入正确的电话");
					return;
				} else if (email != ""
						&& !email_regExp
								.test(email)) {
					alert(email);
					alertBox("请输入正确的电子邮件");
					return;
				}
				$("#join_submit").attr("aaa",
						"aaa");
				$
						.ajax({

							type : 'GET',

							url : "applyJoin",

							data : {
								name : name,
								mobile : mobile,
								email : email,
								message : message,
								type : 1
							},

							success : function(
									data) {
								if (data.code == 1) {
									alertBox("申请成功！");
									$(
											"#join_submit")
											.removeClass(
													"curr");
									$(
											"#join_submit")
											.attr(
													"aaa",
													"");
									$(
											"#userName")
											.val(
													"");
									$("#phone")
											.val(
													"");
									$("#email")
											.val(
													"");
									$(
											"#message")
											.val(
													"");
								} else if (data.code == 0) {

									alertBox("申请失败！");
								}
							},

							dataType : "json"

						});

			});

    
    
        jQuery(document).ready(function(){
            //图片轮播
            (function(){
                var i= 0,containdiv=jQuery(".containdiv"),btn=jQuery(".tab_btn ul li"),stoparea=$(".tab_img_view,.tab_btn"),timeid=null;
                jQuery(".tab_btn ul li").click(function(){
                    jQuery(this).addClass("curr").siblings("li").removeClass("curr");
                    i=btn.index(this);
                    animatePic();
                });

                stoparea.hover(function(){
                    clearInterval(timeid);
                },function(){
                    autoRun();
                });

                function autoRun(){
                    timeid= setInterval(function(){
                        i++;
                        if(i==4) i=0;
                        jQuery(".tab_btn ul li").eq(i).trigger("click");
                    },5000);
                }

               // autoRun();
                $(".tab_img_view .containdiv div").eq(0).show();
                function animatePic(){
                    $(".tab_img_view .containdiv div").eq(i).show().siblings("div").hide();
                }

            })();

            //平台项目选项卡
            $(".fourTab ul li p").click(function(){
                $(this).parent().addClass("curr").siblings("li").removeClass("curr");
            });


            $(".actTabs .status").delegate("ul li","click",function(){
                $(this).addClass("curr").siblings("li").removeClass("curr");
                var index=$(".actTabs .status ul li").index(this);
                $(".actTabs .Container .statusDiv").eq(index).addClass("curr").siblings(".statusDiv").removeClass("curr");
            });

            $(".actTabs .Container").delegate(".statusDiv .cir .inline-table span","click",function(){
                // var index= $(".actTabs .Container .statusDiv .cir .inline-table span").index(this);
                var index= $(this).parent().find("span").index(this);
                $(this).parent().find("span").eq(index).addClass("curr").siblings("span").removeClass("curr");
                $(this).parent().parent().parent().find(".newslist").eq(index).addClass("curr").siblings(".newslist").removeClass("curr");
            });
            
            

        });
        window.onload=function(){
            $(".model").width($(document).width()).height($(document).height());
        }
        
      
    </script>

</body>
</html>