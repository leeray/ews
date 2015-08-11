//页面跳转
function pageHref(pageUrl){
	window.location.href=pageUrl;
}

//按钮提交
function buttonSubmit(formId,url){
	var form = document.getElementById(formId); 
	form.action=url; 
	form.submit();
}

//查询提交
function querySubmit(formId,url){

	var form = document.getElementById(formId); 
	document.getElementById("view").value=0;
	document.getElementById("pageNo").value=1;
	form.action=url; 
	form.submit();
}


//批量操作提交
function batchSubmit(formId,checkboxName,url){
	var form = document.getElementById(formId); 
	form.action=url; 
	var selectBoxs = document.getElementsByName(checkboxName);
	
	var length = 0
    for(var i = 0 ; i < selectBoxs.length ; i++){
       if(selectBoxs[i].checked){
    	   length++;
       }
    }
	if(length==0){
		Dialog.alert("请选择...");
		return;
    }
	form.submit();
}

//分页提交
function pageSubmit(formId,url){
	var form = document.getElementById(formId); 
	form.action=url; 
	form.submit();
}

//全选、取消全选
function switchSelectBox(checked, checkboxName) {
	var selectBoxs = document.getElementsByName(checkboxName);
	if(selectBoxs.length==undefined){
    	selectBoxs.checked=checked;
    }else{
		for ( var i = 0; i < selectBoxs.length; i++) {
			selectBoxs[i].checked = checked;
		}
    }
}
//获取选中
function getSelectedTopicIds(checkboxName){
    var selectBoxs = document.getElementsByName(checkboxName);
    if(selectBoxs.length==undefined){
    	return selectBoxs.value;
    }else{
	    var ids = "";
	    var split = ""
	    for(var i = 0 ; i < selectBoxs.length ; i++){
	       if(selectBoxs[i].checked){
	          ids += split+selectBoxs[i].value;
	          split = ",";
	       }
	    }
    	return ids;
    }
}



