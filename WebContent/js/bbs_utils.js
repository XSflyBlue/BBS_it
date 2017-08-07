/*!
 * BBS Utis
 */

//处理null值，text：处理的文本，symbol：如果为空优先考虑替代的符号
function bbs_dealNull(text,symbol){
	if(text == null){
		if(symbol != null){
			return symbol;
		}else{
			return "";
		}
	}else{
		return text;
	}
}

//获取URL参数
function GetQueryString(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}
//时间格式化
Date.prototype.format = function (fmt) { //author: meizz
	  var o = {
	    "M+": this.getMonth() + 1, //月份
	    "d+" : this.getDate(), //日
		"H+" : this.getHours(), //小时（24制）
		"m+" : this.getMinutes(), //分
		"s+" : this.getSeconds(), //秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度
		"S" : this.getMilliseconds()//毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

function date_fmt(date){
	return new Date(date).format('yyyy-MM-dd HH:mm:ss');
}