function loadimg(t){
    var e=t.getAttribute("height"),i=t.getAttribute("width");
    e||(e=t.offsetHeight),i||(i=t.offsetWidth);
    var r=i,s=e,h=550;
    r>h&&(t.setAttribute("width",h),s=parseInt(e*(h/i)),t.setAttribute("height",s)),t.setAttribute("align","center")
}

function cssImgResize(t,e,i){
    var r=new Image;
    r.src=t.src;
    var s=r.height,h=r.width;
    s||(s=t.offsetHeight),h||(h=t.offsetWidth);
    var a,g,n,f,u=h,b=s,d=e/i,o=h/s;d>o?(u=e,b=parseInt(s*(u/h)),f=g=0,a=n=parseInt((b-i)/2)):(b=i,u=parseInt(h*(b/s)),a=n=0,f=g=parseInt((u-e)/2)),t.setAttribute("width",u),t.setAttribute("height",b),t.style.margin=0-a+"px "+(0-f)+"px"
}