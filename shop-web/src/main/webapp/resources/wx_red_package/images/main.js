$(function(){
    var mobile   = /Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent);
    var touchstart = mobile ? "touchstart" : "mousedown";
    var touchend = mobile ? "touchend" : "mouseup";
    var touchmove = mobile ? "touchmove" : "mousemove";

    var musicFirst=true;

    //可调节的参数
    var loadingPath='images/';

    //初始化阻止屏幕双击，当有表单页的时候，要关闭阻止事件，否则不能输入文字了，请传入false值，再次运行即可
    initPreventPageDobuleTap(true);
  	initPageMotion();

    //初始化动画
    function initPageMotion(){
        $(".main").fadeIn(500,function(){
            // motionObj['page'+1].play();
        });
    }
    var invitationCode=$("#invitationCode").val();
    var LinkArray=['talk_lxlt.htm?invitationCode='+invitationCode,'talk_hb.htm?invitationCode='+invitationCode,'talk_zxc.htm?invitationCode='+invitationCode,'talk_ds.htm?invitationCode='+invitationCode,'talk_zwj.htm?invitationCode='+invitationCode];
    var nameArray=['六小龄童','黄渤','周星驰','悟空(大圣归来)','张卫健'];


    var randoS=Math.floor(Math.random()*2+1);


	updateShareContent(randoS,nameArray);

    function addTouchLink(){

        for(var i=1; i<=12;i++){
            var hammertime = new Hammer(document.getElementById('msg'+i));
            hammertime.on("tap", function (e) {
                var nowm=parseInt(e.target.id.substring(3,e.target.id.length))-1;
                var linkname = LinkArray[nowm];
                location.href=linkname;  
                // console.log(e.target);
               /*  _czc.push(["_trackEvent", "首页", "明星", nameArray[nowm], 1, "moment"+(nowm+1)]);*/
            });
        }
    }
    addTouchLink();

    //阻止屏幕双击以后向上位移.当有表单页的时候，要关闭阻止事件，否则不能输入文字了
    function initPreventPageDobuleTap(isPreventPageDobuleTap){
        if(isPreventPageDobuleTap){
            $('.page').on(touchstart,function(e){
                e.preventDefault()
            })


            
            $('.page').off(touchstart);
        }
    }
    //动态修改时间
    var myDate = new Date();
    var hour= myDate.getHours();
    var mit= myDate.getMinutes();

    function setTime(){
        if(parseInt(mit) <10 ){
            mit = '0'+mit;
        }
        $('.time').text(hour+':'+mit);
    }
    setTime();
})

/*function writeUrlKey(){  alert();
	
	 $.ajax({
         type: "post",
         url: "write_url_key.htm",
         data:"key=yse",
         dataType: "json",
         async:false,//使用同步的Ajax请求
         success: function (result) {
  		   
         },error: function (XMLHttpRequest, textStatus, errorThrown) { 
      	      alert(errorThrown); 
         }
     });
}
*/