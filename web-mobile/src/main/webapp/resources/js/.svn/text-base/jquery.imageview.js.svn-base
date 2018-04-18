/**
 * Created by JG-yes on 2016/1/21.
 */


;(function ( $, window, document, undefined ) {

    var pluginName = "imageview",
        defaults = {
                rotate:0,
                scaleX:1,
                scaleY:1
        };


    function Plugin ( element, options ) {
        this.element = element;
        this.settings = $.extend( {}, defaults, options );
        this._image = defaults;
        this._name = pluginName;
        this.init();
    }

    //���ߺ���
    function isNumber(n) {
        return typeof n === 'number' && !isNaN(n);
    }


    $.extend(Plugin.prototype, {
        init: function () {
            var that=this;
            $(this.element).dblclick(function(){
                var _this=this;
                $("body").append($("<div id='model' class='model'></div>"));
                $(".model").height($(document).height());
                timeid= setTimeout(function(){
                    $(".model").css("opacity",1);
                    var src=$(_this).attr("src");
                    var str="<div id=\"imageView\" class=\"imageView\" style=\"width:" +$(document).width()+"px;height:"+$(document).height()+"px \"><img src="+src+" /><div class='btn_container'><a class=\"rotate\" href=\"javascript:void(0)\" >旋转</a><a class=\"bigger\" href=\"javascript:void(0)\" >放大</a><a class=\"smaller\" href=\"javascript:void(0)\" >缩小</a><a class=\"close\" href=\"javascript:void(0)\" >关闭</a></div></div>";
                    $("body").append(str);
                    var img=$(".imageView img");
                    img.css("margin-left",-img.width()/2+"px").css("margin-top",-img.height()/2+"px");
                    $(document).on("click","#imageView .bigger",function(){
                        that.bigger();
                    });
                    $(document).on("click","#imageView .smaller",function(){
                        that.smaller();
                    });
                    $(document).on("click","#imageView .rotate",function(){
                        that.rotate();
                    });
                    $(document).on("click","#imageView .close",function(){
                        that.closeImageView();
                    });
                },1);
            });
        },
        getTransform:function(options) {
            var transforms = [];
            var rotate = options.rotate;
            var scaleX = options.scaleX;
            var scaleY = options.scaleY;
            if (isNumber(rotate)) {
                transforms.push('rotate(' + rotate + 'deg)');
            }
            if (isNumber(scaleX) && isNumber(scaleY)) {
                transforms.push('scale(' + scaleX + ',' + scaleY + ')');
            }
            return transforms.length ? transforms.join(' ') : 'none';
        },
        doTransform:function (){
            var that=this;
            $("#imageView img").css({
                transform: that.getTransform(this._image)
            });
        },
        rotate:function(){
            this._image.rotate+=90;
            this.doTransform();
        },
        bigger:function(){
            this._image.scaleX+=0.4;
            this._image.scaleY+=0.4;
            this.doTransform();
        },
       smaller:function(){
           this._image.scaleX-=0.4;
           this._image.scaleY-=0.4;
           if(this._image.scaleX<=0.2){
               this._image.scaleX=0.2;
               this._image.scaleY=0.2;
           }
           this.doTransform();
        },
        closeImageView:function(){
            $("#model").remove();
            $("#imageView").remove();
        }

    });

    $.fn[ pluginName ] = function ( options ) {
        this.each(function() {
            if ( !$.data( this, "plugin_" + pluginName ) ) {
                $.data( this, "plugin_" + pluginName, new Plugin( this, options ) );
            }
        });
        return this;
    };

})( jQuery, window, document );
