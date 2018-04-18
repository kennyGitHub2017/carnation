function PhoneView(){
	this.init();
}
PhoneView.prototype.constructor=PhoneView;
PhoneView.prototype={
	init:function(){
		this.deviceDom=document.createElement('div');
		this.deviceDom.className='device';
		var html='<a href="javascript:;" class="close-btn">×</a>\
   				<div class="status-bar"></div>\
				<div class="window" id="window">\
			  		<iframe src="" width="320" height="549" frameborder="0" id="iframe"></iframe>\
 			 		<div id="qrcode" title="" class=""></div>\
				</div>\
				<div id="qrcode-btn"></div>';
		this.deviceDom.innerHTML=html;
		document.body.appendChild(this.deviceDom);
		var closeBtn=document.querySelector('.device .close-btn');
		closeBtn.onclick=function(){
			this.hide();
		}.bind(this);
		this.qrcode = new QRCode(document.getElementById("qrcode"), {
            width : 200,//设置宽高
            height : 200
        });
        var qrcodeBtn=document.getElementById("qrcode-btn"),
    	oQrcode=document.getElementById('qrcode');
	    qrcodeBtn.onclick=function(){
	    	oQrcode.classList.contains('show')?oQrcode.className="":oQrcode.classList.add('show');
	    }
	},
	show:function(url){
		this.url=url;
		var iframe=document.getElementById('iframe');
		iframe.src=url;
		this.deviceDom.style.display='block';
		this.makeQrcode();
	},
	hide:function(){
		this.deviceDom.style.display='none';
	},
	makeQrcode:function(){
		this.qrcode.makeCode(this.url);
	}
}