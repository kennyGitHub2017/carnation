$(function(){
    var mobile   = /Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent);
    var touchstart = mobile ? "touchstart" : "mousedown";
    var touchend = mobile ? "touchend" : "mouseup";
    var touchmove = mobile ? "touchmove" : "mousemove";

    var canplayMessageVoice = false;
    var u = navigator.userAgent;
    if (u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) {
        //安卓手机
    } else if (u.indexOf('iPhone') > -1) {
        //苹果手机
        canplayMessageVoice = true;
    } else if (u.indexOf('Windows Phone') > -1) {
        //winphone手机
    }


    var musicFirst=true;
    var motionObj = {};

    //可调节的参数
    // var loadingPath='../Public/images/';
   // var loadingPath='images/';
    
    var loadingPath= $('#talkImgUrl').val();
    //初始化音乐
    var _music;
    function intsound(){
        var sounds = [
            {src: "bg9.mp3", id: 1},
            {src: "wzl1.mp3", id: 2},
            {src: "wzl2.mp3", id: 3},
            {src: "wzl3.mp3", id: 4}
        ];
        createjs.Sound.alternateExtensions = ["ogg"];
        createjs.Sound.registerSounds(sounds, loadingPath);
    }
    intsound();

    initPreventPageDobuleTap(true);
  	initPageMotion();

    //播放消息声音
    function playmessagesSound(){
        _music = createjs.Sound.play('1');
        _music.volume = 0.1;
    }

    //初始化动画
    function initPageMotion(){
        $(".main").fadeIn(500,function(){
            // motionObj['page'+1].play();
            messages();
        });
    }
    
    var _timer;
    var msgID;
    //发消息
    function messages(){
        msgID=1;
        _timer = setInterval(setMS1,1500)
    }
    function setMS1(){
        if(msgID<=5){
            // if(msgID==3) receiveMoney();
            $('#msg'+msgID).fadeIn();
            if(canplayMessageVoice){//苹果可以播放音效
                playmessagesSound();
            }
            if(msgID == 2){
                 clearInterval(_timer);
                 _timer = setInterval(setMS1,4000)
            }
            if(msgID == 4){
                 clearInterval(_timer);
                 _timer = setInterval(setMS1,1500)
            }
        }else{
            clearInterval(_timer);
        }
        msgID++;
    }
    var _jbrVoice1;
    var _jbrVoice2;
    var _jbrVoice3;
    var isTouch1 = true;
    var isTouch2 = true;
    var isTouch3 = true;
    //第一个语音
    $('#msg2').on(touchstart, function(){
        if(isTouch1){
            isTouch2 = true;
            isTouch3 = true;
            stopAnotherVoice('msg3',_jbrVoice2);
            stopAnotherVoice('msg5',_jbrVoice3);
            $('#msg2 .point').hide();
            $('#msg2 .voice>img').attr('src',loadingPath+'voice.gif');
            //添加播放完成事件
            _jbrVoice1 = createjs.Sound.play('2');
            _jbrVoice1.addEventListener("complete", handleClick1);
        }else{
            _jbrVoice1.removeEventListener("complete");
            $('#msg2 .voice>img').attr('src',loadingPath+'voice.jpg');
            _jbrVoice1.stop();
        }
        isTouch1 = !isTouch1;
    })
    //第二个语音
    $('#msg3').on(touchstart, function(){
        if(isTouch2){
            isTouch1 = true;
            isTouch3 = true;
            stopAnotherVoice('msg2',_jbrVoice1);
            stopAnotherVoice('msg5',_jbrVoice3);
            $('#msg3 .point').hide();
            $('#msg3 .voice>img').attr('src',loadingPath+'voice.gif');
            //添加播放完成事件
            _jbrVoice2 = createjs.Sound.play('3');
            _jbrVoice2.addEventListener("complete", handleClick2);
        }else{
            _jbrVoice2.removeEventListener("complete");
            $('#msg3 .voice>img').attr('src',loadingPath+'voice.jpg');
            _jbrVoice2.stop();
        }
        isTouch2 = !isTouch2;
    })
    //第三个语音
    $('#msg5').on(touchstart, function(){
        if(isTouch3){
            isTouch1 = true;
            isTouch2 = true;
            stopAnotherVoice('msg2',_jbrVoice1);
            stopAnotherVoice('msg3',_jbrVoice2);
            $('#msg5 .point').hide();
            $('#msg5 .voice>img').attr('src',loadingPath+'voice.gif');
            //添加播放完成事件
            _jbrVoice3 = createjs.Sound.play('4');
            _jbrVoice3.addEventListener("complete", handleClick3);
        }else{
            _jbrVoice3.removeEventListener("complete");
            $('#msg5 .voice>img').attr('src',loadingPath+'voice.jpg');
            _jbrVoice3.stop();
        }
        isTouch3 = !isTouch3;
    })
    //停掉其他音乐
    function stopAnotherVoice(id,voiceid){
        if(voiceid!=undefined){
            voiceid.stop();
        }
        $('#'+id+' .voice>img').attr('src',loadingPath+'voice.jpg');
    }

    function handleClick1(event) {
        $('#msg1 .voice>img').attr('src',loadingPath+'voice.jpg');
        _jbrVoice1.removeEventListener("complete");
        isTouch1 = true;
    }
    function handleClick2(event) {
        $('#msg3 .voice>img').attr('src',loadingPath+'voice.jpg');
        _jbrVoice2.removeEventListener("complete");
        isTouch2 = true;
    }
    function handleClick3(event) {
        $('#msg5 .voice>img').attr('src',loadingPath+'voice.jpg');
        _jbrVoice3.removeEventListener("complete");
        isTouch3 = true;
    }

    $('#msg4').on(touchstart, function(){
    	var r = $('#red_package_url').val();
    	r=r+"&invitationCode="+$("#invitationCode").val();
    	location.href=r; //'http://www.ysysgo.com';
    })
    //阻止屏幕双击以后向上位移.当有表单页的时候，要关闭阻止事件，否则不能输入文字了
    function initPreventPageDobuleTap(isPreventPageDobuleTap){
        if(isPreventPageDobuleTap){
            $('.page').on(touchstart,function(e){
                e.preventDefault()
            })
        }else{
            $('.page').off(touchstart);
        }
    }

    //var nameArray=['王祖蓝','古巨基','叶世荣','井柏然','刘若英','郭采洁','韩庚','张翰','尚雯婕','陈楚生','滴滴出行','廖凡'];

    var randoS=1;
	//updateShareContent(randoS,nameArray);
	
	
	
})


