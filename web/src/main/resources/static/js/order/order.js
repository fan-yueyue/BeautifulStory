$(function(){
    $.ajax({
        url:"http://localhost:8086/orderTable/list",
        data:{},
        dataType:"json",
        success:function (data) {
            var color = ""
            var type = ""
            var a = ""
            var b = ""
            var date1 = ""
            var date2 ="";
            var date3 = "";
            var caozuo = "";
            var pname = "";
            var size = "";
            for(var i = 0;i<data.length;i++){
                color = data[i].productAttr.split('"')[7];
                type = data[i].productAttr.split('"')[15];
                date1 = new Date(data[i].paymentTime).toLocaleString();
                date2 =Date.parse(new Date());
                date3 = Date.parse(new Date(data[i].paymentTime))+259200000;

                if(data[i].sp1 == 1 && new Date(date3) <= new Date(date2)){
                    updateSp14(data[i].id);
                }

                if(data[i].sp1 == 1){
                    b ="待付款"
                }else if(data[i].sp1 == 2){
                    b ="等待发货"
                    caozuo = '<a href="*">查看物流</a><br/>'
                }else if(data[i].sp1 == 3){
                    b ="交易成功"
                        $.ajax({
                            url:"http://localhost:8086/comment/listCom2",
                            data:{
                                //这是id 不是productId 写错了 不想改了
                                "orderTimeId":data[i].id
                            },
                            type:"get",
                            dataType:"json",
                            async: false,
                            success:function (data66) {
                                size=data66.length
                            },error:function () {
                                alert("失败");
                            }
                        })
                    //商品id 图片 名字
                    if(size == 0){
                        caozuo = '<a href="#javascript:;"onclick="com(this)" id="'+data[i].id+'" productId="'+data[i].productId+'" img="'+data[i].productPic+'" name="'+data[i].productName+'">评论</a><br/>'
                    }else if(size == 1){
                        caozuo = '<a href="#javascript:;"onclick="com2(this)" id="'+data[i].id+'" productId="'+data[i].productId+'" img="'+data[i].productPic+'" name="'+data[i].productName+'">查看评论</a><br/>'
                    }
                }else if(data[i].sp1 == 4){
                    b ="交易取消"
                    caozuo = '<a href="*">删除订单</a>'
                }

                a+='<div class="order-section unpaid" data-payid="'+data[i].orderSn+'">\n' +
                    '                        <table class="order-table">\n' +
                    '                            <tbody>\n' +
                    '                            <tr class="order-table-header">\n' +
                    '                                <td colspan="7">\n' +
                    '                                    <div class="order-info fl">\n' +
                    '                                    <span class="no"> 订单编号：\n' +
                    '                                    <span class="order_num"> '+data[i].orderSn+' </span>\n' +
                    '                                    </span> <span class="deal-time"> 成交时间：'+date1+' </span>\n' +
                    '                                        <a class="明瑞教育</span> </a>\n' +
                    '                                    </div>\n' +
                    '                                    <a href="javascript:;" class="mogutalk_btn" data-bid="1172u55i#28">\n' +
                    '                                        <span class="icon icon-contact">联系商家</span>\n' +
                    '                                    </a>\n' +
                    '                                </td>\n' +
                    '                            </tr>\n' +
                    '                            <tr class="order-table-item last">\n' +
                    '                                <td class="goods">\n' +
                    '                                    <a class="pic" href="https://shop.mogu.com/detail/1mmjiga" title="查看宝贝详情" hidefocus="true" target="_blank">\n' +
                    '                                        <img src="'+data[i].productPic +'" alt="查看宝贝详情" width="70">\n' +
                    '                                    </a>\n' +
                    '                                    <div class="desc">\n' +
                    '                                        <p>\n' +
                    '                                            <a href="https://shop.mogu.com/detail/1mmjiga" target="_blank">'+data[i].productName+'</a>\n' +
                    '                                            <a class="snapshot" href="https://order.mogu.com/trade/snap?orderId=11sz6zx6rk2" target="_blank">[交易快照]</a>\n' +
                    '                                        </p>\n' +
                    '                                        <p>颜色:'+color+'</p>\n' +
                    '                                        <p>型号：'+type+'</p>\n' +
                    '                                        <ul class="ui-tags-list clearfix">\n' +
                    '                                            <li class="ui-tags-item">\n' +
                    '                                                <img class="ui-tag-pic" src="./订单列表_蘑菇街_files/idid_ifrtkztgmyyggnrrgyzdambqhayde_18x18.png" alt="">\n' +
                    '                                                <div class="ui-tag-text ui-hide">\n' +
                    '                                                    <a class="ui-tag-link" href="https://www.mogu.com/rule/mogu?categoryId=326&amp;ruleId=892">7天无理由退货</a>\n' +
                    '                                                    <span class="ui-icon-arrow"></span>\n' +
                    '                                                </div>\n' +
                    '                                            </li>\n' +
                    '                                        </ul>\n' +
                    '                                    </div>\n' +
                    '                                </td>\n' +
                    '                                <td class="price">\n' +
                    '                                    <p class="price-old">'+data[i].productPrice+'</p>\n' +
                    '                                    <p>'+data[i].realAmount+'</p>\n' +
                    '                                </td>\n' +
                    '                                <td class="quantity">'+data[i].productQuantity+'</td>\n' +
                    '                                <td class="aftersale">  </td>\n' +
                    '                                <td class="total" rowspan="1">\n' +
                    '                                    <p class="total-price">￥ '+data[i].realAmount+'</p>\n' +
                    '                                    <p>      <span>(全国包邮)</span> </p>\n' +
                    '                                </td>\n' +
                    '                                <td class="status" rowspan="1">\n' +
                    '                                    <p class="wait_pay">  '+b+'  </p>\n' +
                    '                                    <a href="https://order.mogu.com/order/detail4buyer?orderId=91654506276821" class="order-link go-detail-link" target="_blank">订单详情</a>\n' +
                    '                                </td>\n' +
                    '                                <td rowspan="1">'+caozuo+'</td>\n' +
                    '                            </tr>\n'
                   if(b=="待付款" && new Date(date3) >= new Date(date2)){
                       a+='                            <tr class="order-table-footer">\n' +
                       '                                <td colspan="4">\n' +
                       '                                    <ul>\n' +
                       '                                        <li>\n' +
                       '                                            <p class="timer" data-time="1568">还剩0天0时26分</p>\n' +
                       '                                        </li>\n' +
                       '                                        <li>\n' +
                       '                                            <a class="order-link order-cancel" href="javascript:;" data-payid="91654506266821">取消订单</a>\n' +
                       '                                        </li>\n' +
                       '                                    </ul>\n' +
                       '                                </td>\n' +
                       '                                <td class="total">\n' +
                       '                                    <span class="sub">总计：</span>￥'+data[i].realAmount+'\n' +
                       '                                </td>\n' +
                       '                                <td class="status">\n' +
                       '                                    <p class="wait_pay">等待付款</p>\n' +
                       '                                </td>\n' +
                       '                                <td class="other">\n' +
                       '                                    <a class="order-btn primary order-pay" target="_blank" name="'+data[i].id+'" href="#javascript:;"onclick="updateSp13(this.name)">付款</a>\n' +
                       '                                </td>\n' +
                       '                            </tr>\n' +
                       '                            </tbody>\n' +
                       '                        </table>\n' +
                       '                    </div>'
                   }else if(b=="待付款"){
                       a+='                            </tbody>\n' +
                           '                        </table>\n' +
                           '                    </div>'
                   }
                console.log(data[i])
            }
            $("#orderWrap").html(a);

        },error:function () {
            alert("失败");
        }
    })
})
 function updateSp14(id){
     $.ajax({
         url:"http://localhost:8086/orderTable/updateSp14",
         data:{
             id:id
         },
         type:"post",
         dataType:"json",
         success:function (data) {
            //location.reload();
         },error:function () {
             alert("失败");
         }
     })
 }
    function com(obj){
    //跳转页面到评论新增页面 把订单列表主键id 传过去 就是orderTimeId
        location.href="http://localhost:8089/orderController/comment?id="+$(obj).attr("id");
    }
function com2(obj){
    //跳转页面到评论修改页面 把订单列表主键id 传过去 就是orderTimeId
    location.href="http://localhost:8089/orderController/comment2?id="+$(obj).attr("id");
}
    function qww(){
        $.ajax({
            url:"http://localhost:8086/orderTable/commentList",
            data:{
                "id":$(obj).attr("id"),
            },
            type:"post",
            dataType:"json",
            success:function (data) {
                console.log(data)
                $("#productPic").html('<img src="'+data[0].productPic+'" width="370" height="353" />');
            },error:function () {
                alert("失败");
            }
        })
    }
    //付款
function updateSp13(id){
    $.ajax({
        url:"http://localhost:8086/orderTable/updateSp13",
        data:{
            id:id
        },
        type:"post",
        dataType:"json",
        success:function (data) {

            location.reload();
            alert("付款成功")
        },error:function () {
            alert("失败");
        }
    })
}