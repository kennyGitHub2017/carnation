function getMonthdata(num){
	var obj={};
	var date=new Date();
	var year=date.getFullYear();
	var month=date.getMonth()+1;
	obj.year=(month+num)>12?year+1:year;
	tempMonth=(month+num)>12?month+num-12:month+num;
	obj.month=tempMonth>9?tempMonth:"0"+tempMonth;
	date.setDate(1);
	if(month+num>12){
		date.setFullYear(year+1);
		date.setMonth(month+num-13);
	}else{
		date.setMonth(month+num-1);
	}
	obj.li_num=date.getDay();
	
	function getDaysInOneMonth(year, month){  
	  month = parseInt(month, 10);  
	  var d= new Date(year, month, 0);  
	  return d.getDate();  
	}		
    obj.daycount= getDaysInOneMonth(obj.year,tempMonth);		
	return obj;
}

function addZero(num){
	return num<10?"0"+num:num;
}

function makeDateJump(curr,target,dataValue){
	var diff=target-curr;
	switch(diff){
		case 0:
			return '今天';
			break;
		case 1:
			return '明天';
			break;
		case 2:
			return '后天';
			break;
		default:
			return "周"+"日一二三四五六".split("")[new Date(dataValue).getDay()];
			break;						
	}
}

function getQueryPar(name) {
   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
   var r = window.location.search.substr(1).match(reg);
   if (r!=null) return (r[2]); return null;
}


Date.prototype.Format = function (fmt) { 
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