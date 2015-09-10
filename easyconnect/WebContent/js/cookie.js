// This script may only be used with the copyright notice intact. JanB.
var w=window; var d=document;
var nav=navigator.appName.indexOf("Microsoft");
var referrer=top.document.referrer
var D=new Date(); 
var Exp=new Date(); Ta=(D.getYear()<1900)?1903:1; Exp.setYear(D.getYear()+Ta);
var TDVal="";

function STBinit() {
STBs=new String(); STBs=cookie("PopupMinim");
Ta=new Array(); if(STBs!=null){Ta=STBs.split("&");}
STBa=new Array(); 
for(x in Ta){ Tb=new Array();Tb=Ta[x].split(":");STBa[Tb[0]]=Tb[1];}
}

function SetC(n){ 
if(typeof(STBa)!="object") STBinit(); d.write((STBa[n]==1)?"<tr id=\""+n+"\" style=\"display:none\">":"<tr id=\""+n+"\">"); }

function STB(n,style){STBs=new String();STBa[n]=(STBa[n]==1)?0:1;
Exp=new Date(); Ta=1; Ta+=(D.getYear()<1900)?1900:0; Exp.setYear(D.getYear()+Ta);
for(id in STBa){STBs+=(STBa[id]==1)?"&"+id+":1":"";}
/*
if(style=="toggle")
{
	for(id in STBa){STBs+=(STBa[id]==1)?"&"+id+":1":"";}
}else if (style=="close")
{
	for(id in STBa){STBs+="&"+id+":1";}
}
else if (style=="open")
{
	for(id in STBa){STBs+="";}
}
*/
d.cookie="PopupMinim="+escape(STBs.substr(1))+"; expires="+Exp.toGMTString();
cval=STBs.substr(1);
if(nav>=0){Ta=eval(n).style.display;
 switch(Ta) {
  case "block": eval(n).style.display = "none"; break;
  case "": eval(n).style.display = "none"; break;
  default : eval(n).style.display = "block"; }}
else{d.location.reload();}
}



function SearchToggle(n){STBs=new String();STBa[n]=(STBa[n]==1)?0:1;
Exp=new Date(); Ta=1; Ta+=(D.getYear()<1900)?1900:0; Exp.setYear(D.getYear()+Ta);
for(id in STBa){STBs+=(STBa[id]==1)?"&"+id+":1":"";}
d.cookie="PopupMinim="+escape(STBs.substr(1))+"; expires="+Exp.toGMTString();
cval=STBs.substr(1);
if(nav>=0){Ta=eval(n).style.display;
 switch(Ta) {
  case "block": eval(n).style.display = "none"; SearchTD.bgColor="#DEDEDC";document.closeopen.src='/images/closed.jpg';setCookie(n,n);break;
  case "": eval(n).style.display = "none"; SearchTD.bgColor="#DEDEDC";document.closeopen.src='/images/closed.jpg';setCookie(n,n);break;
  default : eval(n).style.display = "block"; SearchTD.bgColor="#D9E6F6";document.closeopen.src='/images/open.jpg';DelCookie(n)}}
else{d.location.reload();}
}

function DelCookie(name)
{//deletes the cookie immediately
document.cookie = name + "=; expires=Thu, 01-Jan-70 00:00:01 GMT"
}

function setCookie(name, value) {
	document.cookie = name+"="+escape(value)+"; expires="+Exp.toGMTString();
}

function getCookie(Name) {
	var search = Name + "=";
	if (document.cookie.length > 0)
	{ // if there are any cookies
		offset = document.cookie.indexOf(search) 
		if (offset != -1) 
		{ // if cookie exists 
			offset += search.length;
			// set index of beginning of value
			end = document.cookie.indexOf(";", offset) 
			// set index of end of cookie value
			if (end == -1) 
				end = document.cookie.length;
			return unescape(document.cookie.substring(offset, end))
		}
	}
}

/*
function Close(n){STBs=new String();STBa[n]=(STBa[n]==1)?0:1;
Exp=new Date(); Ta=1; Ta+=(D.getYear()<1900)?1900:0; Exp.setYear(D.getYear()+Ta);
for(id in STBa){STBs+="&"+id+":1";}
d.cookie="PopupMinim="+escape(STBs.substr(1))+"; expires="+Exp.toGMTString();
if(nav>=0){Ta=eval(n).style.display;
 switch(Ta) {
  case "none":eval(n).style.display = "none"; break;
  case "block": eval(n).style.display = "none"; break;
  case "": eval(n).style.display = "none"; break;
  default : eval(n).style.display = "none"; 
  }
}
else{d.location.reload();}
}

function Open(n){STBs=new String();STBa[n]=(STBa[n]==1)?0:1;
Exp=new Date(); Ta=1; Ta+=(D.getYear()<1900)?1900:0; Exp.setYear(D.getYear()+Ta);
for(id in STBa){STBs+="";}
d.cookie="PopupMinim="+escape(STBs.substr(1))+"; expires="+Exp.toGMTString();
if(nav>=0){Ta=eval(n).style.display;
 switch(Ta) {
  case "none":eval(n).style.display = ""; break;
  case "block": eval(n).style.display = ""; break;
  case "": eval(n).style.display = ""; break;
  default : eval(n).style.display = ""; 
  }
}
else{d.location.reload();}
}
*/

function cookie(n){Ta=d.cookie.indexOf(n+"=");Tb=Ta+n.length+1;
if((Ta==-1)||((!Ta)&& (n != d.cookie.substring(0,n.length)))) return null;
Tc=d.cookie.indexOf(";",Tb);if(Tc==-1)Tc=d.cookie.length;
return unescape(d.cookie.substring(Tb,Tc));}
function cookie_s(n,v,e,r){ 
d.cookie=escape(n)+"="+escape(v)+"; expires="+e.toGMTString(); if(r)d.location.reload(); }

