$(function () {
    alert(1111);
    $.ajax({
        url:"http://localhost:8087/home/getProductByBrandId",
        data:{},
        dataType:"json",
        type:"get",
        success:function (data) {
            var html="";
            for( var i = 0 ; i <data.dataList.length;i++){

         html+='   <ul class="newest_brands_list">'
                html+='          <li class="newest_brand clearfix"><a class="newest_brand_show clearHover" href="../brandhome.html#?brandId=2720069&mt=12.12593.r125909.16827&acm=1.mce.2.12593.0.0.16827_125909"'
                html+='      target="_blank"> <img alt="'+data.dataList[i].name+'" src="'+data.dataList[i].logo+'"/>'
                html+='       </a>'
                html+='         <ul class="clearfix">'
                var temp = data.dataList[i];
                if(data.dataList[i].list){
                    for( var j=0;j<data.dataList[i].list.length;j++){
                        if(data.dataList[i].id==data.dataList[i].list[j].brandId){
                            console.log(data.dataList[i].list[j]);
                            html+='        <li class="newest_brand_product"><a class="img_url" href="/web/toSelectDetail?id='+data.dataList[i].list[j].id+'"'
                            html+='    target="_blank"> <img src="'+data.dataList[i].list[j].pic+'"></img>'
                            html+='        </a> <a class="product_title" href="/web/toSelectDetail?id='+data.dataList[i].list[j].id+'"'
                            html+='     target="_blank">'+data.dataList[i].list[j].name+'</a>'
                            html+='        <p class="product_price"><span>&yen;&nbsp;119.00</span> &nbsp;&nbsp;'
                            html+='    <span>&yen;&nbsp;170.00</span></p></li>'
                            if(j==9){
                                break;
                            }
                        }


                    }

                }

                html+='    </ul>'
                html+='    </li>'
                html+='    </ul>'
                if(i==4){
                    break;

                }


            }
            console.log(html);
            $('#pinPaiCount').html(html);

        },
        error:function () {
            alert("系统异常");
        }
    })


    $.ajax({
        url:"http://localhost:8087/home/getCarousel",
        data:{},
        dataType:"json",
        type:"get",
        success:function (data) {

            var html="";
            for (var i = 0;i<data.dataList.length;i++){
        html+='<li class="today_brand"><a href="/brand/home?brandId=7421112" target="_blank" target="_blank">'
         html+=' <img alt="arTees" src="'+data.dataList[i].logo+'"/> </a></li>'
                    if(i==6){
                        break;
                    }
            }
            html+=' <li class="today_brand"><a class="aLink" href="/brand/settled/" target="_blank"><span'
            html+=' class="allBrandLink caret-right">全部品牌</span></a></li>'
            $('#productBrandPic').html(html);
        },
        error:function () {
            alert("系统异常");
        }
    })

})