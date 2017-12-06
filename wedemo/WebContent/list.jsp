<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>果然新鲜</title>
    <link href="css/index.css"rel="stylesheet">
    <link href="css/share.css"rel="stylesheet">
    <script src="js/jquery-1.12.3.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
    <script type="text/javascript">
    	function clickcart() {
    		alert("你还没有登陆！！");
    	}
		function check() {
			var user=$("#checkis").val();
  			$.ajax({
   			type:"GET",
   			url:"check",
   			data:{id:user},
   			success:function(msg){
   				$('#checkiss').html(msg);
   			}
   		});
		}
</script>
</head>
<body>
<!--顶部导航-->
<div class="headr">
    <div class="heard-con">
        <img src="images/logo.jpg" style="margin-top: 7px;float: left;position: absolute">
        <div class="headr-nav">
            <ul>
                <li><a href="list?pageNum=1"style="color: #4AB344"><span style="color: #4AB344">首页</span></a> </li>
                <li><a href="hot.html">蔬果热卖</a> </li>
                <li><a href="produ.html">全部产品</a> </li>
                <li><a href="consult.html">最新资讯</a></li>
                <li><a href="touch.html">联系我们</a> </li>
                <c:if test="${user.name!=null }" >
                	<li><a href="#" >[${user.name }],</a><a>退出</a></li>
                </c:if>
                <c:if test="${user.name==null }" >
                	<div id="deng" class="buttn fk-pd5MallActBtns" style="border-color: white;margin-top: 27px;" onmouseover="this.style.cursor='hand' " >
                   [登陆] 
            	</div>
            	<div class="f-buyCountBtn">
                    <div  class="f-countBtn mallJian"></div>
                    <div  class="f-countBtn disableMallJian"></div>
                </div>
                </c:if>
            </ul>
            <div class="sptopfoot">
                <div class="spbottom"  >
                </div>
            </div>
        </div>
        <c:if test="${user==null }">
        	<div class="headr-right" onclick="clickcart()">
            <i id="showc" class="iconfont" style="font-size: 16px;margin-right: 10px">&#xe7d5;</i>
            我的购物车 ∨
        </div>
        </c:if>
        <c:if test="${user!=null }">
        	<div class="headr-right">
            <i id="showc" class="iconfont" style="font-size: 16px;margin-right: 10px">&#xe7d5;</i>
            我的购物车 ∨
            <c:if test="${cart==null&&user!=null }">
            	<div class="hr-car">
                <i class="iconfont"style="font-size: 40px;margin-right: 10px">&#xe633;</i>
                您的购物车内暂时没有任何产品。
            	</div>
            </c:if>
        </div>
        </c:if>
    </div>
</div>

<!--顶部导航结束-->
<!--banner图片-->
<div class="her-banner">

</div>
<!--banner图片结束-->
<!--主页内容-->
<div class="content">
    <div class="ban-boot clear">
        <div class="ban-zs">
            <img src="images/ban-1.jpg" width="100%">
        </div>
        <div class="ban-zs">
            <img src="images/ban-2.jpg" width="100%">
        </div>
        <div class="ban-zs">
            <img src="images/ban-3.jpg" width="100%">
        </div>
    </div>
    <!--果园推荐开始-->
    <div class="recommand clear">
        <div class="rec-nav clear">
            <h2>果园推荐 <span>RECOMMAND</span></h2>
        </div>
        <div class="rec-cont clear">
            <div class="rec-left">
                <img src="images/rc-0.jpg">
            </div>

            <div class="rec-right">
				<c:forEach items="${page.list }" var="p">
                <div class="rcr">
                    <div class="rcr-top">
                        <img src="images/${p.name}.jpg" width="100%">
                    </div>
                    <div class="rcr-bot">
                        <div class="rb-top">
                            ${p.description }
                        </div>
                            <div class="second_P">
                                <span class="fk-prop">￥</span>
                                <span class="fk-prop-price">
                                    ${p.price }<span class="fk-prop-p">.00</span>
                                </span>
                                <span class="second_Marketprice">￥0.00</span>
                            </div>
                        <div class="buy">
                            <a class="second_mallBuy" href="product?id=${p.id }">
                                <span style="color: white;">购买</span>
                            </a>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <div >
            	<div style="float: left;width: 300px; " >
            	</div>

           		<div style="float: left;width:880px;float: left;text-align: center;
           		height: 42px;margin-left: 32%;margin-bottom: 55px;" >  
                	<div style="line-height: 42px;padding: 0 15px;float: left;
                	width: 80px;margin-left: -3%;"><a href="list?pageNum=${page.prePageNum }">
                	上一页
                	</a></div> 
                	<div style="width: 80px;line-height: 42px;padding: 0 15px;
                	float: right; margin-right: 58%;mar"> <a href="list?pageNum=${page.nePageNum }">
                	下一页
                	</a></div> 
            	</div>
        	</div>
            </div>
        </div>
    </div>

    <!--果园推荐结束-->
</div>
<!--每日新品特卖-->
    <div class="rec-bottom clear">
        <div class="rbt-con">
                <div class="banner_1">
                    <img src="images/rb-1.jpg"width="1424px">
                    <img src="images/rb-2.jpg"width="1424px">
                </div>
        </div>
                <ul class="banner-bottom">

                </ul>
    </div>
<div class="content">
    <div class="new-nav clear">
        <div class="nwn-con">
            <div style="text-align: center;">
                <span style="">
                    <span style="font-size: 31px;">
                        <font style="color: rgb(33, 33, 33);" color="#212121">
                        <font style="color: rgb(231, 231, 231);" color="#e7e7e7">
                            ———————
                        </font>
                            <b>&nbsp; 每日新品特卖 &nbsp;</b>
                        </font></span></span>
                <span style="font-size: 31px;">
                <font style="color: rgb(231, 231, 231);" color="#e7e7e7">
                    ———————
                </font>
            </span>
            </div>
       <div style="text-align: center;">
                <font color="#353535" style="">
                    <span style="font-size: 16px;">
                            <font style= color:#888888>
                                新鲜水果每一天，健康生活每一刻
                            </font>
                    </span>
                </font></div>

        </div>


    </div>
    <div class="new-con clear">
        <div class="nec-lift">
            <div class="fk-editor simpleText  ">
                <font color="#4b4b4b">
                    <span style="">
                        <span style="line-height: 29px;">
                            <span style="color: rgb(75, 75, 75); font-size: 16px;">
                                有机生鲜
                            </span>
                            <div style="color: rgb(75, 75, 75);">
                                <span style="font-size: 20px;">
                                    天然无污染水果
                                </span>
                            </div>
                        </span>
                    </span>
                    <div style="color: rgb(75, 75, 75);">
                        <span style="font-size: 20px;">
                            <br>
                        </span>
                    </div>
                    <div>
                        <font style="color: rgb(243, 151, 0);" color="#f39700">
                    <b>
                        <span style="font-size: 42px;">6.8</span>
                    </b><span style="font-size: 42px;">
                    <b>折</b>
                    <span style="font-size: 18px;">
                        <font style="color: rgb(53, 53, 53);" color="#353535">起</font>
                    </span></span></font></div>
                </font>
            </div>
            <div class="xiqing">
                <a  href="/col.jsp?id=105"style="color: white">查看详情 &gt;</a>
            </div>
        </div>
        <div class="nec-right">
            <img src="images/nw-1.jpg">

        </div>

    </div>
    <div class="new-bottom clear">
        <div class="nw-b">
            <img src="images/nw-2.jpg">
        </div>
        <div class="nw-b">
            <img src="images/nw-3.jpg">
        </div>
        <div class="nw-b">
            <img src="images/nw-4.jpg">
        </div>
        <div class="nw-b" style="margin:0">
            <img src="images/nw-5.jpg">
        </div>
    </div>
    <!--每日新品特卖结束-->
    <!--蔬果资讯-->
    <div class="fruits">
        <div class="fru-nav">
            <div class="fk-editorb ">
                <font style="color: rgb(103, 141, 30);" color="#678d1e">蔬果资讯</font>
            </div>
            <font style="color: rgb(53, 53, 53);float: right" color="#353535">更多资讯</font>
        </div>
        <div class="fru-lift">
            <div class="frl-nav">
                <ul>
                    <li>品种</li>
                    <li>地区</li>
                    <li>价格</li>
                  <span>时间</span>
                </ul>
            </div>
            <div class="txtMarquee-top">
                <div class="bd">
                    <ul class="infoList">

                        <li><p>苹果</p>
                            <p>河南省济源市</p>
                            <p >5.5/kg</p>
                            04-09
                        </li>
                        <li><p> 西瓜</p>
                            <p>	内蒙古鄂尔多斯</p>
                            <p >10/kg</p>
                            04-09
                        </li>
                        <li><p>葡萄</p>
                            <p>新疆乌鲁木齐</p>
                            <p >19/kg</p>
                            04-09
                        </li>
                        <li><p>车厘子</p><p>河南省郑州市</p><p>	58.5/kg</p> 04-09</li>
                        <li><p>菜心	</p><p>河南省新乡市</p><p>	5.5/kg</p>	04-09</li>
                        <li><p>西兰花</p>	<p>河南省信阳市</p><p>	3.5/kg</p>	04-09</li>
                        <li><p>苹果	</p><p>河南省济源市</p><p>	5.5/kg	</p>04-09</li>
                        <li><p>西瓜	</p><p>内蒙古鄂尔多斯</p><p>10/kg</p>	04-09</li>
                        <li><p>葡萄	</p><p>新疆乌鲁木齐	</p><p>19/kg</p>	04-09</li>
                        <li><p>菜心	</p><p>河南省新乡市</p><p>	5.5/kg	</p>04-09</li>
                        <li><p>西兰花</p><p>	河南省信阳市</p><p>	3.5/kg	</p>04-09</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="fru-right">
            <div id="slideBox" class="slideBox">
                <div class="hd">
                    <!--<ul><li>蜜橘首发</li>-->
                        <!--<li>智利车厘子</li>-->
                        <!--<li>进口青苹果</li>-->
                    <!--</ul>-->
                    <ul><li>1</li><li>2</li><li>3</li></ul>
                </div>
                <div class="bd">
                    <ul>
                        <li><a href="#" target="_blank"><img src="images/fr-1.jpg" /></a></li>
                        <li><a href="#" target="_blank"><img src="images/fr-2.jpg" /></a></li>
                        <li><a href="#" target="_blank"><img src="images/fr-3.jpg" /></a></li>
                    </ul>
                </div>

            </div>

        </div>
    </div>
    <!--蔬果资讯结束-->
</div>
<!--主页内容结束-->
<!--底部-->
<div class="footer">
    <div class="ft-con">
        <div class="ft-top">
            <img src="images/fot-1.jpg">
        </div>
        <div class="ft-bo">
            <div class="ft-b">
                <h3>服务保障</h3>
                <p>正品保证</p>
                <p>7天无理由退换</p>
                <p>退货返运费</p>
                <p>7X15小时客户服务</p>

            </div>
            <div class="ft-b">
                <h3>支付方式</h3>
                <p>公司转账</p>
                <p>货到付款</p>
                <p>在线支付</p>
                <p>分期付款</p>

            </div>
            <div class="ft-b">
                <h3>商家服务</h3>
                <p>商家入驻</p>
                <p>培训中心</p>
                <p>广告服务</p>
                <p>服务市场</p>

            </div>
            <div class="ft-b">
                <h3>服务保障</h3>
                <p>免运费</p>
                <p>海外配送</p>
                <p>EMS</p>
                <p>211限时达</p>

            </div>

        </div>
        <div class="banq">
            <p>©2016 果然新鲜 版权所有</p>
            <p>手机版 | 本站使用<span><img src="images/ft.jpg"></span>凡科建站搭建 | 管理登录</p>
        </div>

    </div>

</div>
<!--底部结束-->
<!--弹框-->
<div class="popup">
    <div class="login">
        <div class="del">×</div>
        <div class="lg-cont">
            <div class="lhd">
                <ul>
                    <li class="active">登录</li>
                    <li>注册</li>
                </ul>
                <div class="lhdfoot">
                    <div class="lhdbottom"  >
                    </div>
                </div>

            </div>
            <div class="lbd">
            	<form action="${ctx }/login" method="post">
            		<div class="lbd1"style="display: block">
                    <div id="memberLoginAcct" class="J_memberLoginItem memberLoginDialogItem">
                        <input name="id" id="memberAcct" class="generateInput memberAcctInput" type="text" value="" placeholder="账号">
                    </div>
                    <div id="memberLoginPwd" class="J_memberLoginItem memberLoginDialogItem itemSpace">
                        <input name="password" id="memberPwd" class="generateInput memberPwdInput" type="password" placeholder="密码" />
                    </div>
                    <div>
                        <div><input class="middle loginButton" type="submit" value="登陆" /></div>
                    </div>
                    <div class="bott"></div>
                </div>
            	</form>
                <form action="${ctx }/regist" method="post"><div class="lbd1">
                    <div class="msv">
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input id="checkis" name="id" type="text" placeholder="账号" onblur="check()">
                            </div>
                            <div class="itemRight"><text id="checkiss" >*</text></div>
                        </div>
                        <div class="memberSignupItem ">
                            <div class="itemMiddle">
                                <input name="password" type="password" id="memberSignupPwd" placeholder="密码" maxlength="50">
                            </div>
                            <div class="itemRight">*</div>
                        </div>
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input type="password" id="memberSignupRepwd" placeholder="确认密码" maxlength="50">
                            </div>
                            <div class="itemRight">*</div>
                        </div>
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input id="name" name="name" placeholder="姓名" class="userAddItem isCheckUAI" type="text" maxlength="50">
                            </div>
                            <div class="itemRight">*</div>
                        </div>
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input id="email" name="email" placeholder="邮箱" class="userAddItem" type="text" maxlength="50">
                            </div>
                            <div class="itemRight"></div>
                        </div>
                        <div class="memberSignupItem">
                            <div class="itemMiddle">
                                <input id="phone" name="tel" placeholder="电话" class="userAddItem" type="text" maxlength="50">
                            </div>
                            <div class="itemRight"></div>
                        </div>
                        <div class="memberSignupItem_remark">
                            <div class="itemMiddle">
                                <textarea id="memberSignupRemark" placeholder="留言" maxlength="200"></textarea>
                            </div>
                            <div class="itemRight"></div>
                        </div>
                        <div class="memberSignupItem_captcha">
                            <div class="itemMiddle" style="float:left;width: 150px;">
                                <input id="memberSignupCaptcha" type="text" maxlength="4" placeholder="验证码">
                            </div>
                            <div class="itemRightp">
                                <img alt="" id="memberSignupCaptchaImg" class="memberSignupCaptchaImg" onclick="Site.changeCaptchaImg(this)" title="看不清，换一张" src="images/validateCode.jpg">
                            </div>
                        </div>
                   </div>
                    <div>
                        <div><input class="middle loginButton" type="submit" value="注册" /></div>
                    </div>
                    <div class="bott"></div>
                </div>
                </form>
                
            </div>

        </div>
    </div>
</div>
<!--弹框结束-->
</body>
<script src="js/index.js"></script>
<script src="js/orange.js"></script>
</html>