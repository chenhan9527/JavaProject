<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>最新资讯</title>
    <link href="css/touch.css"rel="stylesheet">
    <link href="css/share.css"rel="stylesheet">
    <script src="js/jquery-1.12.3.js"></script>
</head>
<body>
<!--顶部导航-->
<div class="headr">
    <div class="heard-con">
        <img src="images/logo.jpg" style="margin-top: 7px;float: left;position: absolute">
        <div class="headr-nav">
            <ul>
                <li><a href="index.html">首页</a> </li>
                <li><a href="hot.html">蔬果热卖</a> </li>
                <li><a href="produ.html">全部产品</a> </li>
                <li><a href="consult.html" >最新资讯</a></li>
                <li><a href="touch.html"style="color: #4AB344"><span style="color: #4AB344">联系我们</span></a> </li>
            </ul>
            <div class="sptopfoot">
                <div class="spbottom"  >
                </div>
            </div>
        </div>
        <div class="headr-right">
            <i class="iconfont" style="font-size: 16px;margin-right: 10px">&#xe7d5;</i>
            我的购物车 ∨
            <div class="hr-car">
                <i class="iconfont"style="font-size: 40px;margin-right: 10px">&#xe633;</i>
                您的购物车内暂时没有任何产品。
            </div>
        </div>
    </div>
</div>
<!--顶部导航结束-->
<!--banner图片-->
<div class="her-banner">

</div>
<!--banner图片结束-->
<div class="content">
    <!--建议开始-->
    <div class="recommand clear">
        <div class="rec-cont clear">
            <div class="rec-left">
                <div class="classily">
                    <div class="cltop">
                        <p>产品分类</p>
                    </div>
                    <div class="cltcon">
                        <p><a href="#">国产水果</a> </p>
                        <p><a href="#"> 进口水果</a></p>
                        <p style="border-bottom:0px dashed #999999;"><a href="#">新鲜时蔬</a></p>
                    </div>

                </div>
                <div class="service">
                    <div class="cltop">
                        <p>在线客服</p>
                    </div>
                    <div class="sercon">
                       <div class="qqs">
                           <p><a hidefocus="true" href="#">
                               <span class="serOnline-img0 qqImg0">&nbsp;</span>蜜桃
                           </a>
                           </p>
                           <P><a hidefocus="true" href="#">
                               <span class="serOnline-img0 qqImg0">&nbsp;</span>芒果
                           </a>
                           </P>
                       </div>
                        <div class="tims">
                            <div class="marBL-10">
                                <span class="worktime-header-img">&nbsp;</span>
                                <span class="serWorkTimeText"><b>工作时间</b></span>
                            </div>
                            <div class="serOnline-list-v "><span>周一至周五 ：8:30-17:30</span></div>
                            <div class="serOnline-list-v lastData"><span>周六至周日 ：9:00-17:00</span></div>
                        </div>
                    </div>

                </div>

            </div>

            <div class="rec-right">
               
                <div class="fk-editor simpleText  ">
                        <font style="color: rgb(5, 160, 69);" color="#05a045">
                            <span style="font-size: 15px;">
                                &nbsp; &nbsp; &nbsp; &nbsp; * 如有合作需要，请填写以下表单，我们将尽快给您回复，并为您提供最真诚的服务，谢谢您的支持。
                            </span>
                        </font>

                </div>
                <div class="message">
                   
                    <p>收货地址</p>
                    <form action="addAddress" method="post">
                    <div class="siteFormMiddle" style="width: 100px">
                        <select _show="1" class="resize" name="province">
                            <option value="none" style="display: none; ">--省</option>
                            <option value="河北省">河北省</option>
                            <option value="河北省">河北省</option>
                            <option value="河北省">河北省</option>
                        </select>
                    </div>
                    <div class="siteFormMiddle" style="width: 100px">
                        <select _show="1" class="resize" name="city">
                            <option value="none" style="display: none;">--市</option>
                            <option value="石家庄市">石家庄市</option>
                            <option value="">保保定市定市</option>
                            <option value="邯郸">邯郸</option>
                        </select>
                    </div>
                    <div class="siteFormMiddle" style="width: 100px">
                        <select _show="1" class="resize" name="district">
                            <option value="none" style="display: none; ">--县</option>
                            <option value="裕华区">裕华区</option>
                            <option value="裕华区">裕华区</option>
                            <option value="裕华区">裕华区</option>
                        </select>
                    </div>
                    <div class="siteFormMiddle" style="width: 100px" >
                        <input type="text" value="详细地址" style=" height: 32px;" name="detail"/>
                    </div>
                   
                   <div class="siteFormMiddle" style="margin-left:150px;width: 100px">
                         <input type="submit"style="width: 66px; height: 33px;" value="添加" />
                   </div>
                   <form action="addAddress" method="post">
                </div>
				

            </div>


        </div>
    </div>

    <!--建议结束-->
</div>
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
</body>
<script src="js/touch.js"></script>
</html>