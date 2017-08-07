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