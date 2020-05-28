<template>
    <div id="fujian">
    </div>

</template>

<script>
    import BMapGL from 'BMap'
    //import axios from 'axios'

    export default {
        name: 'fujian',
        created() {
            this.geApitData(this.$route.query.n);
        },
        data() {
            return {

                test: [],
                nineblock:[],
                //地区数据(以城市为单位)，暂时只存放了福建的城市
                colorblock:[],
                // eslint-disable-next-line no-undef
                colormap,
                area: [
                    [
                        {
                            "name": "福州市",
                            "id": "10001",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 119.10,//经度
                            "lati": 25.80,//纬度
                            "data": []//对应的12块地区的帖子数
                        },
                        {
                            "name": "莆田市",
                            "id": "10002",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 118.75,//经度
                            "lati": 25.23,//纬度
                            "data": []//对应的12块地区的帖子数
                        },
                        {
                            "name": "泉州市",
                            "id": "10003",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 118.57,//经度
                            "lati": 24.68,//纬度
                            "data": []//对应的12块地区的帖子数
                        },
                        {
                            "name": "厦门市",
                            "id": "10004",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 117.98,//经度


                            "lati": 24.38,//纬度
                            "data": []//对应的12块地区的帖子数
                        },
                        {
                            "name": "漳州市",
                            "id": "10005",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 117.45,//经度
                            "lati": 24.32,//纬度
                            "data": []//对应的12块地区的帖子数
                        },
                        {
                            "name": "龙岩市",
                            "id": "10006",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 116.83,//经度
                            "lati": 24.90,//纬度
                            "data": []//对应的12块地区的帖子数
                        },
                        {
                            "name": "三明市",
                            "id": "10007",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 117.42,//经度
                            "lati": 26.07,//纬度
                            "data": []//对应的12块地区的帖子数
                        },
                        {
                            "name": "南平市",
                            "id": "10008",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 117.87,//经度
                            "lati": 27.15,//纬度
                            "data": []//对应的12块地区的帖子数
                        },
                        {
                            "name": "宁德市",
                            "id": "10009",
                            "color": [],//对应的12块地区显示的渲染颜色
                            "long": 119.42,//经度
                            "lati": 26.57,//纬度
                            "data": []//对应的12块地区的帖子数
                        }
                    ],//福建省


                ],
                //色块和本块数据的关系
                colorlist: [
                    {
                        "color": "#CCEEFF",
                        "start": 0,
                        "end": 100
                    },
                    {
                        "color": "#77DDFF",
                        "start": 101,
                        "end": 1000
                    },
                    {
                        "color": "#33CCFF",
                        "start": 1001,
                        "end": 5000
                    },
                    {
                        "color": "#00BBFF",
                        "start": 5001,
                        "end": 10000
                    },
                    {
                        "color": "#0066FF",
                        "start": 10001,
                        "end": 100000
                    },
                ]
            }
        },
        methods: {
            async functionx(bid)
            {
                let that =this
                try  {
                    await that.axios.get(`${that.GLOBAL.apiUrl}/area/getarealistbybelongareaid`, {
                        params: {
                            belongAreaId: bid
                        }
                    }).then((response) => {
                        that.nineblock = response.data.areaList
                        console.log(response.data)

                    })
                }
                catch(error){console.log(error)}
            },
             async geApitData(pro_name) {
                // eslint-disable-next-line no-unused-vars
                var blockid=0;
                // eslint-disable-next-line no-unused-vars
                let that =this

                // eslint-disable-next-line no-undef

                         try {
                             await that.axios.get(`${that.GLOBAL.apiUrl}/area/getareabyname`, {
                                 params: {
                                     areaName: pro_name
                                 }
                             }).then((response) => {

                                 blockid = response.data.area.areaId
                                 //console.log(response.data.area.areaId)
                                 // eslint-disable-next-line no-undef
                                 that.functionx(blockid)
                             })

                         }
                         catch(error){console.log(error)}
                 console.log(that.nineblock)
            },


            createMap() {
                /* eslint-disable */
                // 创建Map实例
                console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
                var map = new BMapGL.Map("fujian")
                // 初始化地图,设置中心点坐标和地图级别
                map.centerAndZoom(new BMapGL.Point(this.$route.query.x, this.$route.query.y), 11)
                //添加地图类型控件
                map.addControl(new BMapGL.MapTypeControl({
                    mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]
                }))
                // 设置地图显示的城市 此项是必须设置的
                map.setCurrentCity("北京")
                //开启鼠标滚轮缩放
                map.enableScrollWheelZoom(true)
                /* eslint-enable */
                this.colormap=map
                //给区块染色

                //先定义好每块的颜色




                // for (var i = 0; i < this.area.length; i++)
                var num = 0
                for (var n = 0; n < 9; n++)
                    for (var temp = 0; temp < this.colorlist.length; temp++) {
                        if (this.nineblock[num].bubbleNum >= this.colorlist[temp].start && this.nineblock[num].bubbleNum <= this.colorlist[temp].end) {
                            this.colorblock.push(this.colorlist[temp].color);
                            console.log(this.colorlist[temp].color);
                            num++;
                            console.log("+++");
                            break;

                        }

                    }

                function add_overlay() {
                    this.colormap.addOverlay(rectangle);         //增加矩形
                }

//console.log("?");
                var m1 = 0;
                for (var i2 = this.$route.query.x-0.2; i2 < this.$route.query.x + 0.25; i2 += 0.15)
                    for (var n2 = this.$route.query.y-0.28; n2 < this.$route.query.y + 0.02; n2 += 0.15) {
                        var pStart = new BMapGL.Point(i2, n2);
                        var pEnd = new BMapGL.Point(i2 + 0.15, n2 + 0.15);
                        var rectangle = new BMapGL.Polygon([
                            new BMapGL.Point(pStart.lng, pStart.lat),
                            new BMapGL.Point(pEnd.lng, pStart.lat),
                            new BMapGL.Point(pEnd.lng, pEnd.lat),
                            new BMapGL.Point(pStart.lng, pEnd.lat)
                        ], {
                            strokeColor: "white",
                            strokeWeight: 2,
                            strokeOpacity: 0.5,
                            fillColor: this.colorblock[m1],
                        });  //创建矩形
                        //添加覆盖物
                        m1++;
                        //console.log("!");
                        add_overlay();

                    }


                    }
            //},

        },
        computed: {

            gettest() {
                return this.test;
            }
        },
        watch: {
            //监听时间轴开始日期变化
            gettest() {
                this.createMap()
            },
            //监听九块数组

        },
        mounted() {
            this.createMap()
        }
    }
</script>
<style scoped>
    #fujian {
        min-height: 100vh;
    }
</style>