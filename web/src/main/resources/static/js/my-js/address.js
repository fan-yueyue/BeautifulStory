$(function(){
    realod();
})
    //页面加载
    function realod() {
        $.ajax({
            url: "http://localhost:8085/umsMenberReceiveAddress/selectMemberId",
            type: "GET",
            dataType: "json",
            success: function (data) {
                console.log(data)
                var address = '';
                var html="";
                html ='<option value="0">'+"请选择"+'</option>';
                address = '<div class="addressbox_warp">';
                for(var i = 0;i<data.addressList.length;i++){
                   if(data.addressList[i].pid==1){
                       html+='<option value="'+data.addressList[i].id+'">'+data.addressList[i].province+'</option>';
                   }
                    address += '<div class="addressbox" id="J_sAddrWrap"><div class="__addressPop"><dl class="address_pop">'
                    +  '<input type="hidden" class="J_addressid" name="addressId" value="2117639690"><dt>省：</dt>'
                    +   '<dd class="pt_ie6hack"><i class="needicon">*</i>'
                        +   '<select name="province" id="province" onchange="getProvince(this)"  class="J_province J_select w140 vm">'
                        +   '</select><label class="dt" for="">市：</label>'
                        +   '<select name="city" id="city" onchange="getCity(this)" class="J_city J_select w100 vm"></select>'
                        +   '<label class="dt" for="">区：</label><select name="region" id="region" class="J_area J_select w100 vm">'
                        +   '</select><span class="prompt"></span></dd>'
                        +   '<dt>邮政编码：</dt><dd><i class="needicon">*</i>'
                        +  '<input type="text" data-type="c" data-errormsg="请填写正确的邮政编码" data-normal="" class="text formsize_normal J_postcode J_form vm" name="postCode"><span class="prompt"></span></dd><dt>街道地址：</dt>'
                        +  '<dd><i class="needicon">*</i>'
                        +  '<textarea  data-type="*" name="detailAddress" data-min="5" data-max="100" data-normal="请填写街道地址，最少5个字，最多不能超过100个字" data-errormsg="请填写街道地址，最少5个字，最多不能超过100个字" class="textarea formsize_large J_street J_form" cols="30" rows="3">' + '</textarea><span class="prompt breakline">请填写街道地址，最少5个字，最多不能超过100个字</span></dd><dt>收货人姓名：</dt><dd><i class="needicon">*</i><input type="text" data-type="*"  data-errormsg="请填写收货人" data-normal="" class="text formsize_normal J_name J_form vm" name="name"><span class="prompt"></span></dd><dt>手机：</dt><dd><i class="needicon">*</i><input type="text" data-type="phone" data-errormsg="请填写正确的联系号码" data-normal="" class="text formsize_normal J_mobile J_form vm" name="phoneNumber"><span class="prompt"></span></dd><dt></dt><dd class="pt10 oper_btn">'
                        + '<input type="button" value="确认地址" id="addAdd" onclick="updateAdd();"/>'
                    + '<input type="hidden"  id="hiddenId"/>'
                    + '<input type="button" value="取消"/>'
                    + '</dd></dl></div></div>'
                    + '</div>';
                }
                for (var i = 0; i < data.dataList.length; i++) {
                    var aaa = data.dataList[i].id;
                    address += '<div class="addr_section default" aid="' + data.dataList[i].memberId + '">';
                    address += '<ul class="clearfix"> <li class="name">' + data.dataList[i].name + '</li> <li class="addr" data-province="' + data.dataList[i].province + '" data-city="' + data.dataList[i].city + '" data-area="' + data.dataList[i].region + '" data-street="' + data.dataList[i].detailAddress + '">' + data.dataList[i].province + "-" + data.dataList[i].city + "-" + data.dataList[i].region + "-" + data.dataList[i].detailAddress + '</li>';
                    address += ' <li class="zcode">' + data.dataList[i].postCode + '</li>';
                    address += '<li class="mobile">' + data.dataList[i].phoneNumber + '</li>';
                    address += '<li class="oper">';
                    address += '<a href="#javascript:;" class="J_default" name="' + data.dataList[i].id + '" onclick="defaultAddress(this.name)">默认地址</a>';
                    address += '<a href="#javascript:;" name="' + data.dataList[i].id + '" class="edit" onclick="updateAddress(this.name)">编辑</a>';
                    address += ' <input type="button" value="新增地址" id="addAddress" onclick="addAddress()"/>';
                    address += '<a href="#javascript:;" name="' + data.dataList[i].id + '" onclick="deleteAddress(this.name)" >删除</a>';
                    address += '</li>';
                    address += '<li class="enaddr"></li>';
                    address += '</ul>';
                    address += '</div>';
                }
                address += '</div>';
                $("#J_s_addr_edit").html(address);
               $('#province').html(html)
            }, error: function(){
                alert("报错")
            }
        })
    }

//省下拉框获取省下的县
function  getProvince(obj) {
 var id=obj.value;
    $.ajax({
        url:"http://localhost:8085/umsMenberReceiveAddress/selectCity",
        type:"GET",
        data:{"id":id},
        dataType:"json",
        success:function(data){
            console.log(data)
            var html1="";
        for(var i=0;i<data.dataList.length;i++){
            html1+='<option value="'+data.dataList[i].id+'">'+data.dataList[i].city+'</option>';
        }
            $('#city').html(html1);
        },error:function(){
            alert("报错")
        }
    })
}

//市的下拉显示市下的县
function getCity(obj){
    console.log(obj.value);
    var id=obj.value;
    $.ajax({
        url:"http://localhost:8085/umsMenberReceiveAddress/selectCity",
        type:"GET",
        data:{"id":id},
        dataType:"json",
        success:function(data){
            console.log(data)
            var html2="";
            for(var i=0;i<data.dataList.length;i++){
                html2+='<option value="'+data.dataList[i].id+'">'+data.dataList[i].city+'</option>';
            }
            $('#region').html(html2);
        },error:function(){
            alert("报错")
        }
    })
}


//删除
    function deleteAddress(id){
    var id = id;
    $.ajax({
        url:"http://localhost:8085/umsMenberReceiveAddress/delete",
        type:"POST",
        dataType:"json",
        data:{"id":id},
        success:function (data) {
            console.log(data)
            realod();
        },error:function () {
            alert("删除")
        }
    })
}

//增加
function addAddress(){
    $("#J_sAddrWrap").show()
    $("#addAdd").click(function(){
        var province =$('#province option:selected').text();
        console.log(province)
        var city = $('#city option:selected').text();
        console.log(city)
        var region = $('#region option:selected').text();
        console.log(region)
        var postCode= $("input[name='postCode']").val();
        console.log(postCode)
        var detailAddress = $("textarea[name='detailAddress']").val();
        console.log(detailAddress)
        var phoneNumber = $("input[name='phoneNumber']").val();
        var name = $("input[name='name']").val();
        $.ajax({
            url:"http://localhost:8085/umsMenberReceiveAddress/save",
            type:"POST",
            dataType:"json",
            data:{
                "province":province,
                "city":city,
                "region":region,
                "postCode":postCode,
                "detailAddress":detailAddress,
                "phoneNumber":phoneNumber,
                "name":name
            }, success:function (data) {
                console.log(data)
                realod();
            },error:function () {
                alert("报错")
            }
        })
    })
}


//回显地址
function updateAddress(id){
    var id=id;
    //console.log(id);
    $.ajax({
        url:"http://localhost:8085/umsMenberReceiveAddress/selectById",
        type:"GET",
        dataType:"json",
        data:{"id":id},
        success:function (data) {
            console.log(data)
            $('#hiddenId').val(data.dataList[0].id);
            $("#J_sAddrWrap").show()
            $('#province option:selected').text(data.dataList[0].province);
           $('#city option:selected').text(data.dataList[0].city);
            $('#region option:selected').text(data.dataList[0].region);
            $("input[name='postCode']").val(data.dataList[0].postCode);
            $("textarea[name='detailAddress']").val(data.dataList[0].detailAddress);
            $("input[name='phoneNumber']").val(data.dataList[0].phoneNumber);
            $("input[name='name']").val(data.dataList[0].name);
        },error:function(){
            alert("回显报错")
        }
    })

}


//修改地址
function updateAdd(id){
    var id=$('#hiddenId').val();
   // console.log(id);
    var province =$('#province option:selected').text()
    var city = $('#city option:selected').text();
    var region = $('#region option:selected').text();
    var postCode= $("input[name='postCode']").val();
    var detailAddress = $("textarea[name='detailAddress']").val();
    var phoneNumber = $("input[name='phoneNumber']").val();
    var name = $("input[name='name']").val();
    $.ajax({
        url:"http://localhost:8085/umsMenberReceiveAddress/update",
        type:"POST",
        dataType:"json",
        data:{
            "id":id,
            "province":province,
            "city":city,
            "region":region,
            "postCode":postCode,
            "detailAddress":detailAddress,
            "phoneNumber":phoneNumber,
            "name":name
        },
        success:function (data) {
            console.log(data)
            realod();
        },error:function () {
            alert("报错")
        }
    })

}



//默认地址
function defaultAddress(id){
    var id= id;
 $.ajax({
        url:"http://localhost:8085/umsMenberReceiveAddress/defaultAddress",
        data:{"id":id},
        dataType:"json",
        type:"POST",
        success:function(data){
            console.log(data)
            alert("默认地址成功")
        },error:function () {
            alert("报错")
        }
    })
}


