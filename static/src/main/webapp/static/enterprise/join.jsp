<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>云尚平台官网</title>
    <meta name="keywords" content="健康生活" />
    <meta name="description" content="">
    
	<%@ include file="include/inc_css.jsp"%>

</head>
<body mid="m-join">
    <%@ include file="include/header.jsp"%>


    <div class="mod-banner" style="background-image: url(assets/images/banner-join.jpg)"></div>

    <div class="mod-block clearfix">
        <div class="cont-width">
            <div class="home-title">
                <h2>加盟流程</h2>
                <span>Joining process</span>
            </div>
            <div class="join-process animated bounceIn wow"></div>
        </div>
    </div>

    <div class="join-conditions mod-block clearfix">
        <div class="cont-width">
            <div class="home-title white-title">
                <h2>加盟条件</h2>
                <span>Join conditions</span>
            </div>
            <div class="title">
                面向广大代理商企业，云尚提供便捷线上售卖代理与API代理两种代理模式，同时提供专业技术支持与合作培训
                申请加入后商务经理将及时跟进联系，加盟条件如下
            </div>

            <div class="col-md-4 col-xs-12 animated fadeInLeft wow">
                <div class="join-condition">
                    <img src="assets/images/join-1.png" />
                    <p>加盟商基本要求</p>
                </div>
                1具有一定经济实力和经营能力的法人单位或个体，对围巾市场有一定的认识和了解。2具有长远的经营眼光，强烈的品牌意识。3具有广泛良好的社会关系，有较强的市场开拓能力和管理水平。4. 对事业充满热情，具有较好的心理素质和应变能力，敬业乐业，诚实守信。
            </div>
            <div class="col-md-4 col-xs-12 animated fadeInUpBig wow">
                <div class="join-condition">
                    <img src="assets/images/join-2.png" />
                    <p>店面及专柜基本要求</p>
                </div>
                1. 必须是当地市或镇较繁华的商业路段，保证有一定的人流量。 2. 按照总公司统一的品牌形象店进行装修。
            </div>
            <div class="col-md-4 col-xs-12 animated fadeInRight wow">
                <div class="join-condition">
                    <img src="assets/images/join-3.png" />
                    <p>加盟费/保证金</p>
                </div>
                1. 加盟费:分级而定。2. 保证金，确定合作签订合同时，由总部一次性收取的，作为保证加盟者能恪守合同条款、不损害企业及品牌形象、不转让企业核心技术和机密、不跨越指定区域销售、窜货的保证费用。合同期满后，在不违背各保证条款的前提下如数退还保证金。
            </div>

        </div>
    </div>

    <div class="mod-block animated fadeInUp wow">
        <div class="cont-width clearfix">
            <div class="home-title">
                <h2>在线加盟</h2>
                <span>Join Online</span>
            </div>
            <div class="col-xs-12">
                <form>
                    <div class="clearfix">
                        <div class="col-md-6 pb-20">
                            <input class="form-control" placeholder="请填写您的联系电话" />
                        </div>
                        <div class="col-md-6 pb-20">
                            <input class="form-control" placeholder="请填写您的姓名" />
                        </div>
                        <div class="col-md-12">
                            <textarea class="form-control" rows="8" placeholder="简介"></textarea>
                        </div>
                    </div>
                    <div class="mt-30 text-center">
                        <input type="submit" class="btn btn-default" value="立即申请">
                    </div>
                </form>
            </div>

        </div>
    </div>

    <%@ include file="include/footer.jsp"%>

</body>
</html>