<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<meta name="viewport" id="viewport"content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<title>加盟云尚,创业投资项目,互联网项目加盟,云尚加盟商,云尚加盟平台,云尚招商中心,云尚招商加盟,云尚创业平台,云尚创业项目,云尚上市,如何加盟云尚 - 云尚</title>
<meta name="keywords" content="颠覆行业，零距离解决传统盈利模式。看懂趋势，了解云尚大健康的功能、市场布局和市场收益，加盟云尚帮您建立源源不断的财富管道。云尚服务热线：400-888-2933 。" />
<link href="${staticPath}/static/Investing/css/base.min.css" type="text/css" rel="stylesheet">
<link href="${staticPath}/static/Investing/css/css.css" type="text/css" rel="stylesheet">
<%@ include file="/WEB-INF/views/platform/include/inc_css.jsp"%>
<style>
.news .content{height:96px;overflow:hidden}
</style>
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

<body mid="m-investmentact">
	<%@ include file="/WEB-INF/views/platform/include/header.jsp"%>
	
	<div class="top">
		<div class="main"></div>
	</div>
	<div class="centerContainer">
		<div class="born">
			<div class="titleWrap">
				<div class="title">
					<span>“云尚大健康”顺势而生</span>
				</div>
			</div>
			<div class="tab_btn">
				<ul class="fn-clear">
					<li class="curr">健康产业趋势</li>
					<li>互联网+健康</li>
					<li>政府及政策支持</li>
					<li>云尚大健康</li>
				</ul>
			</div>
			<div class="tab_img_view small-hidden">
				<div class="containdiv fn-clear">
					<div class="b1"></div>
					<div class="b2"></div>
					<div class="b3"></div>
					<div class="b4"></div>
				</div>
			</div>
		</div>
		<div class="include small-hidden">
			<div class="titleWrap">
				<div class="title">
					<span>“云尚大健康”聚势合力</span>
				</div>
			</div>
			<div class="fourp">
				<div class="include_div one">
					<span class="ico"></span>
					<p class="f_title">健康检测</p>
					<p class="content">基于个人健康数据和管理个人健康的一站式服务，让健康管理从单一治疗到“治疗、预防、保健、康复、养生”转型，从为个人治病到为家庭成员健康生活管理的服务升级，涉及“衣、食、住、行”等多个方面，给予广大民众科学合理的全方位健康解决方案。</p>
				</div>
				<div class="include_div two">
					<span class="ico"></span>
					<p class="f_title">健康调理</p>
					<p class="content">利用世界最先进的健康检测一体机，以物理疗法为手段，结合亚健康检测仪、中医体质辨识表、心理测评表、疲劳评估表等现代检查手段，做到“健康监测、健康评估、健康干预、健康跟踪”。并通过大数据库的基数比对，利用云计算的测算手段，能及时的为用户提供个体化、科学且客观的体征测试报告。</p>
				</div>
				<div class="include_div three">
					<span class="ico"></span>
					<p class="f_title">线上线下</p>
					<p class="content">依托大平台海量用户,聚合所有健康生活相关的线上线下商家和商户，整合不同的消费者需求。健康消费全新经营模式灵活自由，把单打独斗变成抱团合作，通过全新循环经济模式构筑移动蓝海。</p>
				</div>
				<div class="include_div four">
					<span class="ico"></span>
					<p class="f_title">合作共赢</p>
					<p class="content">将健康、互联网、金融与消费创富四大朝阳产业融于一体，通过天、地、人三网一体的立体营销模式，迅速推动了移动“互联网+健康+消费增值“的全面结合，让平台上的每个参与者都能合作共赢，是一个利国、利民、利商的事业平台。</p>
				</div>
			</div>
		</div>
		<div class="nature">
			<div class="titleWrap">
				<div class="title">
					<span>“云尚大健康”行业翘楚</span>
				</div>
			</div>
			<div class="introduce fn-clear">
				<div class="right">
					<p class="t">企业简介</p>
					<p class="m">云尚大健康综合服务平台（简称“云尚大健康”）是吉林云尚集团斥巨资历经几年，精心打造的直销行业以分析个人健康数据和管理个人健康的健康服务平台。以健康管理+B2C+O2O的复合商业模式，构筑了多种商业形态。通过互联网裂变式分享打造了中国健康直销互联网产业新业态。</p>
				</div>
				<img src="${staticPath}/static/Investing/images/introduce.png">
			</div>
<%-- 			<div class="swNews">
				<div class="tit">
					<a href="http://zs.ysysgo.com/merchantsNews" class="more">更多</a>商务动态
				</div>
				<ul class="list fn-clear">
					<c:forEach items="${objs}" var="news" varStatus="obj">
						<li class="fn-clear"><span class="time"><fmt:formatDate
									value="${news.addTime}" pattern="yyyy-MM-dd" /></span>
									<a href="${yesPath}/news/${news.id}" title="${news.title}">${news.title}</a>
						</li>
					</c:forEach>
				</ul>
			</div> --%>
		</div>
		<div class="money">
			<div class="titleWrap">
				<div class="title">
					<span>“云尚大健康”抢占商机</span>
				</div>
			</div>
			<p class="p_words">这是一场跑马圈的机会，这个市场有着超乎我们想象空间的巨大商机！成为“云尚大健康”的运营商，您才能把握机会，全赢财富！</p>
			<div class="img_fenbu"></div>
			<div class="newsContainer fn-clear">
				<%-- <div class="actNews">
					<div class="act_title">活动动态</div>
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
						<div class="status">
							<ul class="fn-clear">
								<li class="curr">准备中</li>
								<li>进行中</li>
								<li>已完成</li>
							</ul>
						</div>
						<div class="Container">

							<div id="Data1Container" class="statusDiv curr">
							</div>

							<div id="Data2Container" class="statusDiv">								
							</div>

							<div id="Data3Container" class="statusDiv">								
							</div>
						</div>
					</div>
				</div> --%>
				<div class="allNews">
					<p class="tit">
						<a href="${yesPath}/e/news">更多</a>加盟动态
					</p>
					<ul>
						<%-- <img src="${staticPath}/static/Investing/images/allnews.png">
						<c:forEach items="${objs2}" var="news" varStatus="obj">
							<li><span><fmt:formatDate value="${news.addTime}" pattern="yyyy-MM-dd" /></span>
								<a href="${yesPath}/news/${news.id}" title="${news.title}">${news.title}</a>
							</li>
						</c:forEach> --%>
						<c:forEach items="${objs2}" var="news" varStatus="obj">
						<li>
							<a href="${yesPath}/news/${news.id}">
								<img class="news_img" alt="" src="${news.img}">
								<span class="news_mes">${news.title}…[详细]</span>
							</a>
						</li>
						</c:forEach>
					</ul>
				</div>
			</div>

			
			<div class="lixian">
				<div class="titleWrap">
					<div class="title">
						<span>“云尚大健康”日进斗金</span>
					</div>
				</div>
				<!--  运营商收益  -->
				<div class="income">
					<p class="tit">运营商收益</p>
					<p class="content">云尚平台问世尚不足一年，在尤其注重积累与拓展、脸熟和用户才是王道的网络市场，为什么会受到广泛的关注并取得如此耀眼的成绩？不是因为天命所归，挟大势而来；也不是因为巨额的投资，用钱堆品牌；而是因为平台超前的经济理念和过硬的技术资本，使用户真真切切受益，运营商实实在在得利！</p>
					<div class="income_img small-hidden"></div>
				</div>
				<!--  运营商扶持  -->
				<div class="support fn-clear">
					<span class="support_img"></span>
					<p class="tit">运营商扶持</p>
					<p class="content">全方位市场扶持，只要你肯来，我们拼命帮！</p>
					<p class="content">为保障运营商稳步、有序地开展业务，保证运营商和平台同步腾飞，云尚建立了完善的市场扶持体系和专业的运营团队。从前期市场指导，到中期运营管理，再到后期运营协助；从商圈选址，到市场启动，再到市场管理，360全方位的运营扶持为您搭桥铺路，助您步步为营，直达财富彼岸！因为我们坚信只有运营商做得好，公司才能发展好；只有运营商赚大钱，公司才能赚到钱！</p>
				</div>
			</div>
			
			<div class="lixian">
				<div class="titleWrap">
					<div class="title">
						<span>“云尚大健康”礼贤纳士</span>
					</div>
				</div>
				<div class="lixian_img"></div>
			</div>
			<div class="join">
				<div class="titleWrap">
					<div class="title">
						<span>“云尚大健康”申请加盟</span>
					</div>
				</div>
				<div class="info small-hidden">
					<div class="basic">
						<span class="name">*姓&nbsp;&nbsp;名:<input type="text"
							id="userName" placeholder="请输入您的姓名">
						</span> <span class="phone">*电&nbsp;&nbsp;话:<input type="text"
							id="phone" placeholder="请输入您的电话号码">
						</span> <span class="email">邮&nbsp;&nbsp;箱:<input type="text"
							id="email" placeholder="请输入您的邮箱" />
						</span>
					</div>
					<div class="message fn-clear">
						<span class="text"><span>*</span>留&nbsp;&nbsp;言：</span>
						<textarea id="message" placeholder="留下您的意见或建议..."></textarea>
					</div>
					<a href="javascript:void(0)" class="join_submit" id="join_submit"
						class="submit">提交</a>
				</div>
				<div class="info large-hidden">
					<div class="basic">
						<span class="name">*姓&nbsp;&nbsp;名:<input type="text"
							id="userName" placeholder="请输入您的姓名">
						</span>
					</div>
					<div class="basic">
						<span class="name">*电&nbsp;&nbsp;话:<input type="text"
							id="phone" placeholder="请输入您的电话号码">
						</span>
					</div>
					<div class="basic">
						<span class="name"> 邮&nbsp;&nbsp;箱:<input type="text"
							id="email" placeholder="请输入您的邮箱" />
						</span>
					</div>
					<div class="message fn-clear">
						<span class="text"><span>*</span>留&nbsp;&nbsp;言：</span>
						<textarea id="message" placeholder="留下您的意见或建议..."></textarea>
					</div>
					<a href="javascript:void(0)" class="join_submit" id="join_submit"
						class="submit">提交</a>
				</div>
			</div>
		</div>
			
	</div>
	
	<div class="model"></div>
	<div class="float" style="display: none;">
		<img src="${staticPath}/static/Investing/images/float.png" /> <a
			href="http://wpa.qq.com/msgrd?V=3&uin=3323200633&Site=yunesheng&Menu=no"
			target="_blank" class="qq qq1"></a> <a
			href="http://wpa.qq.com/msgrd?V=3&uin=3137676417&Site=yunesheng&Menu=no"
			target="_blank" class="qq qq2"></a>
	</div>
	<div class="baoming">
		<div class="title">
			活动报名<a class="close" href="javascript:void(0)">×</a>
		</div>
		<div class="input">
			*姓名:<input id="act_name" type="text" placeholder="请输入您的姓名">
		</div>
		<div class="input">
			*电话:<input id="act_mobile" type="text" placeholder="请输入您的电话号码">
		</div>
		<div class="input email">
			<span class="xing">*</span>邮箱:<input id="act_email" type="text"
				placeholder="请输入您的邮箱地址">
		</div>
		<div class="input message">
			<span class="fl"><span class="xing">*</span>留言:</span>
			<textarea id="act_message" placeholder="留下您的建议或意见..."></textarea>
		</div>
		<a href="javascript:void(0)" class="act_submit" id="act_submit">提交</a>
	</div>
	<input type="hidden" id="actid" value="1" />
	<div class="tips">姓名不能为空</div>
	${success} ${fail}
	<script type="text/javascript"
		src="${staticPath}/static/Investing/js/jquery-1.11.3.min.js"></script>
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

		jQuery(document)
				.ready(
						function() {
							//图片轮播
							(function() {
								var i = 0, containdiv = jQuery(".containdiv"), btn = jQuery(".tab_btn ul li"), stoparea = $(".tab_img_view,.tab_btn"), timeid = null;
								jQuery(".tab_btn ul li").click(
										function() {
											jQuery(this).addClass("curr")
													.siblings("li")
													.removeClass("curr");
											i = btn.index(this);
											animatePic();
										});

								stoparea.hover(function() {
									clearInterval(timeid);
								}, function() {
									autoRun();
								});

								function autoRun() {
									timeid = setInterval(function() {
										i++;
										if (i == 4)
											i = 0;
										jQuery(".tab_btn ul li").eq(i).trigger(
												"click");
									}, 5000);
								}

								autoRun();

								function animatePic() {
									containdiv.stop().animate({
										marginLeft : -1200 * i + "px"
									}, 500, "linear");
								}

							})();

							$(".actTabs .status").delegate(
									"ul li",
									"click",
									function() {
										$(this).addClass("curr").siblings("li")
												.removeClass("curr");
										var index = $(".actTabs .status ul li")
												.index(this);
										$(".actTabs .Container .statusDiv").eq(
												index).addClass("curr")
												.siblings(".statusDiv")
												.removeClass("curr");
									});

							$(".actTabs .Container").delegate(
									".statusDiv .cir .inline-table span",
									"click",
									function() {
										// var index= $(".actTabs .Container .statusDiv .cir .inline-table span").index(this);
										var index = $(this).parent().find(
												"span").index(this);
										$(this).parent().find("span").eq(index)
												.addClass("curr").siblings(
														"span").removeClass(
														"curr");
										$(this).parent().parent().parent()
												.find(".newslist").eq(index)
												.addClass("curr").siblings(
														".newslist")
												.removeClass("curr");
									});
							//申请加盟

							jQuery("#join_submit")
									.click(
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

																	alertBox("申请sb！");
																}
															},

															dataType : "json"

														});

											});

						});
		window.onload = function() {
			$(".model").width($(document).width()).height($(document).height());
		}

		//模拟alert
		var tips = jQuery(".tips");
		function alertBox(str) {

			if (tips.css("display") == "block")
				return;
			tips.fadeIn();
			tips.html(str);
			window.setTimeout(function() {
				tips.fadeOut();
			}, 2500);
		}
		</script>
		<%@ include file="/WEB-INF/views/platform/include/footer.jsp"%>
		
</body>
</html>