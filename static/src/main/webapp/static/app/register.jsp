<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>注册</title>

    <%@ include file="include/inc_css.jsp"%>

</head>
<body>

    <div class="reg-wrap">
        <h1 class="text-center"><img src="assets/images/logo.png"></h1>
        <div class="reg-title"> 注册成功后，即可下载云尚APP用于登录，并赠送 <span class="c-blue">20</span> 积分。</div>
        <form id="regForm" method="post" action="">
            <ul class="list reg-form">
                <li class="item item-ico">
                    <i class="icon-lock"></i><input type="text" class="text" name="phone" placeholder="请输入手机号" />
                </li>
                <li class="item item-ico">
                    <i class="icon-phone2"></i><input type="password" class="text" name="password" placeholder="6-14位，建议数字、字母、符号组合" />
                </li>
                <li class="item">

                    <div class="fr">
                        <input type="button" value="发送验证码" class="btn btn-blue" id="mobile_verify_code_generic" onclick="generic_mobile_verify_code()" />
                        <span id="time_out_generic"></span>
                    </div>
                    <div class="v-code">
                        <input type="password" placeholder="请输入验证码" class="text" name="verifycode" />
                    </div>
                </li>
                <li class="item">
                    <input type="submit" value="立即注册" class="btn btn-blue btn-block" />
                </li>
                <li class="text-right fz-s" >
                    <a href="#">下载云尚APP</a>
                </li>
            </ul>
        </form>
        <p class="text-center reg-copyright">
            版权所有：云尚<br>
            服务热线：xxxxxxxx
        </p>


    </div>



    <!--<div class="fixed-bottom-bar double-btn-bar pt-10">-->
        <!--<button class="btn btn-blue">附近医院</button>-->
        <!--<button class="btn btn-blue">咨询专家</button>-->
    <!--</div>-->

    <script src="assets/js/jquery-2.1.4.min.js"></script>
    <script src="assets/js/jquery-validate.min.js"></script>

    <script>
        var time=60;
        var time_id="";
        function generic_mobile_verify_code(){
            jQuery("#mobile_verify_code_generic").hide();
            countDown();
            time_id=setInterval(countDown,1000);
            jQuery.post("xxx",{"type":"password_vetify_code"},function(data){


            },"text");
        }
        function countDown(){
            --time;
            jQuery("#time_out_generic").html(time+"秒后可重试");
            if(time==0){
                clearInterval(time_id);
                jQuery("#time_out_generic").html("");
                jQuery("#mobile_verify_code_generic").show();
                time=10;
            }
        }



        $("#regForm").validate({
            rules: {
                phone: "required",
                password: "required",
                verifycode: "required"
            },
            messages: {
                phone: "请输入您的手机号码",
                password: "请输入您的注册密码",
                verifycode: "请输入您的验证码"
            }
        });
    </script>

</body>
</html>