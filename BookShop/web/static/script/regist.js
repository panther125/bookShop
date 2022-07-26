function $(id) {
    return document.getElementById(id);
}

function preRegist() {

    var unameText = $("unameText");
    var unameSpan = $("unameSpan");
    // 6~16位数字和字母组成
    var patter = /[0-9a-zA-Z]{6,16}/;

    if(!patter.test(unameText.value)){
        unameSpan.style.visibility="visible";
        return false;
    }else {
        unameSpan.style.visibility="hidden";
    }

    var pwdText = $("pwdText");
    var pwdSpan = $("pwdSpan");
    // 长度至少8位
    var patter2 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9a-zA-Z]{8,16}$/;
    if(!patter2.test(pwdText.value)){
        pwdSpan.style.visibility="visible";
        return false;
    }else {
        pwdSpan.style.visibility="hidden";
    }

    var pwdText2 = $("pwdText2");
    var pwdSpan2 = $("pwdSpan2");
    if(pwdText.value !== pwdText2.value){
        pwdSpan2.style.visibility = "visible";
        return false;
    }else{
        pwdSpan2.style.visibility = "hidden";
    }

    var emailText = $("emailText");
    var emailSpan = $("emailSpan");
    var patter3 = /^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+[\.]{1})+[a-zA-Z]+$/;
    if(!patter3.test(emailText.value)){
        emailSpan.style.visibility = "visible";
        return false;
    }else{
        emailSpan.style.visibility = "hidden";
    }

    return true;

}

var xmlHttpRequest;
function createXMLHttpRequest() {
    // 兼容ie浏览器
    if(window.xmlHttpRequest){
        xmlHttpRequest = new xmlHttpRequest();
    }else if(window.ActiveXObject){
        // ie
        try{
            xmlHttpRequest = new  ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
    
}

function ckUname(uname) {
    
    createXMLHttpRequest();
    // param [method, url,asyhnchron]
    xmlHttpRequest.open("GET","user.do?operate=ckUname&uname="+uname,true);

    // 回调函数
    xmlHttpRequest.onreadystatechange = ckUnameCB();

    // 发送请求
    xmlHttpRequest.send();
}
function ckUnameCB() {
    if(xmlHttpRequest.readyState === 4 && xmlHttpRequest.status ===200){
        var responseText = xmlHttpRequest.responseText;
        alert(responseText);
    }
}