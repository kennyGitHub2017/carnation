/*
 * 日期插件
 * 滑动选取日期（年，月，日）
 * V1.1
 */
(function ($) {
    $.fn.date = function (options,Ycallback,Ncallback) {
        //插件默认选项
        var that = $(this);
        var nowdate = new Date();
        var indexY=1,indexM=1,indexD=1;
        var indexH=1,indexI=1,indexS=0;

        var initY=parseInt(nowdate.getHours());
        var initM=parseInt(nowdate.getMinutes());

        var yearScroll=null,monthScroll=null,dayScroll=null;
        var HourScroll=null,MinuteScroll=null,SecondScroll=null;
        $.fn.date.defaultOptions = {
            beginyear:0,                 //日期--年--份开始
            endyear:23,                   //日期--年--份结束
            beginmonth:0,                   //日期--月--份结束
            endmonth:59,                    //日期--月--份结束
        }
        //用户选项覆盖插件默认选项
        var opts = $.extend( true, {}, $.fn.date.defaultOptions, options );


        createUL();      //动态生成控件显示的日期
        init_iScrll();   //初始化iscrll
        extendOptions(); //显示控件


        refreshDate();
        bindButton();


        function refreshDate(){
            yearScroll.refresh();
            monthScroll.refresh();
            yearScroll.scrollTo(0, initY*40, 100, true);
            monthScroll.scrollTo(0, initM*40, 100, true);
        }

        function resetIndex(){
            indexY=1;
            indexM=1;
            indexD=1;
        }

        function bindButton(){
            resetIndex();
            $("#dateconfirm").unbind('click').click(function () {
                if(typeof Ycallback=="function"){
                    Ycallback(indexY-1,indexM-1);
                }
            });
            $("#datecancle").click(function () {
                $("#datePage").hide();
                $("#dateshadow").hide();
                Ncallback(false);
            });
        }
        function extendOptions(){
            $("#datePage").show();
        }
        //日期滑动
        function init_iScrll() {
            var strY = $("#yearwrapper ul li:eq("+indexY+")").html().substr(0,$("#yearwrapper ul li:eq("+indexY+")").html().length-1);
            var strM = $("#monthwrapper ul li:eq("+indexM+")").html().substr(0,$("#monthwrapper ul li:eq("+indexM+")").html().length-1)
            yearScroll = new iScroll("yearwrapper",{snap:"li",vScrollbar:false,
                onScrollEnd:function () {
                    indexY = (this.y/40)*(-1)+1;
                }});
            monthScroll = new iScroll("monthwrapper",{snap:"li",vScrollbar:false,
                onScrollEnd:function (){
                    indexM = (this.y/40)*(-1)+1;
                }});
        }



        function  createUL(){
            CreateDateUI();
            $("#yearwrapper ul").html(createYEAR_UL());
            $("#monthwrapper ul").html(createMONTH_UL());
        }
        function CreateDateUI(){
            var str = ''+
                '<div id="datePage" class="page">'+
                '<section>'+
                '<div id="datemark">:</div>'+
                '<div id="datescroll">'+
                '<div id="yearwrapper">'+
                '<ul></ul>'+
                '</div>'+
                '<div id="monthwrapper">'+
                '<ul></ul>'+
                '</div>'+
                '</div>'+
                '</section>'+
                '</div>'
            $("#datePlugin").html(str);
        }
        function addTimeStyle(){
            $("#datePage").css("height","380px");
            $("#datePage").css("top","60px");
            $("#yearwrapper").css("position","absolute");
            $("#yearwrapper").css("bottom","200px");
            $("#monthwrapper").css("position","absolute");
            $("#monthwrapper").css("bottom","200px");
            $("#daywrapper").css("position","absolute");
            $("#daywrapper").css("bottom","200px");
        }
        //创建 --时-- 列表
        function createYEAR_UL(){
            var str="<li>&nbsp;</li>";
            for(var i=opts.beginyear; i<=opts.endyear;i++){
                if(i<10){
                    i="0"+i
                }
                str+='<li>'+i+'</li>'
            }
            return str+"<li>&nbsp;</li>";;
        }
        //创建 --分-- 列表
        function createMONTH_UL(){
            var str="<li>&nbsp;</li>";
            for(var i=opts.beginmonth;i<=opts.endmonth;i++){
                if(i<10){
                    i="0"+i
                }
                str+='<li>'+i+'</li>'
            }
            return str+"<li>&nbsp;</li>";;
        }

    }
})(jQuery);
