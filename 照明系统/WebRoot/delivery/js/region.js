
//从后台拿数据
$(function(){
    var reg;
    var province;
    //地图
    var map = new BMap.Map("allmap");
    //物流中心所在区域
    $.ajax({
        type:'post',
        aysnc:false,
        url:'../Company_province',
        success:function(data){
            if(data){
                province = data.province;
                map.centerAndZoom(province,9);  //初始化地图.12是市级,15更精细
                map.enableScrollWheelZoom();//启用滚轮放大缩小
                map.enableContinuousZoom();
            }
        }
    })
    $.ajax({
        type:'post',
        aysnc:false,
        url:'../Company_getMap',
        success:function(data){
            if(data){
             
                var region = data.companyList;
                for(var i = 0; i< region.length; i++){
                    var point = new BMap.Point(region[i].longitude,region[i].latitude);
                    var state = region[i].state;
                    var myicon;
                    if(state == 0){
                        myicon = new BMap.Icon("../img/location.png",new BMap.Size(100,100));
                    }else if(state == 6){//将来是六6 认证经销商
                        myicon = new BMap.Icon("../img/red.png",new BMap.Size(100,100));
                    }else{
                        myicon = new BMap.Icon("../img/blue.png",new BMap.Size(100,100));
                    }
                    var companyname = region[i].companyname;
                    var marker = new BMap.Marker(point,{icon:myicon});
                    map.addOverlay(marker);
                }
               
            }
        }
    })
    map.addEventListener("click", function(e){   //点击事件    
        alert("123");
    });   
})

