$(function(){
    $("#pinPai").click(function () {
        window.location.href="/web/toBrandStreet";
    })

})

function loadLunBo(){
    $.ajax({
        url:"http://localhost:8087/home/getCarousel",
        data:{},
        dataType:"json",
        success:function (data) {

            if(data.code==200){
                var html="";
                for(var i =0 ;i<data.dataList.length;i++){


                    html+='   <li id="slide-1" class="slide">'
                    html+=' <img src="'+data.dataList[i].bigPic+'" alt="img1" />'
                    html+='</li>'
                    html+=' <ul class="nav-dots">'

                    html+='   <li class="dot"><a href="#"'+data.dataList[i].bigPic+'"></a></li>'

                    html+='  </ul>'
                }
                html+='<ul class="nav-arrows">\n' +
                    '    <li class="arrow-left"></li>\n' +
                    '    <li class="arrow-right"></li>\n' +
                    '  </ul>'
                $('#lunBo').html(html)

                console.log(html);

            }



        },error:function () {
            alert("失败");
        }
    })
}
