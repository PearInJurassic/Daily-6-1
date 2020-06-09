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
                flag:false,
                susu:1,
                nineblock:[],
                highLightBlock:[],
                //地区数据(以城市为单位)，暂时只存放了福建的城市
                colorblock:[],
                colorblock2:[],
                // eslint-disable-next-line no-undef

                //色块和本块数据的关系
                colorlist: [
                    {
                        "color": "#CCEEFF",
                        "start": -1,
                        "end": 0
                    },
                    {
                        "color": "#77DDFF",
                        "start": 1,
                        "end": 10
                    },
                    {
                        "color": "#33CCFF",
                        "start": 11,
                        "end": 100
                    },
                    {
                        "color": "#00BBFF",
                        "start": 101,
                        "end": 1000
                    },
                    {
                        "color": "#0066FF",
                        "start": 1001,
                        "end": 100000
                    },
                ]
            }
        },
        methods: {

             async geApitData(proname) {
                // eslint-disable-next-line no-unused-vars
                var blockid=0;
                // eslint-disable-next-line no-unused-vars
                let test = new Array(9)
                 // eslint-disable-next-line no-unused-vars
                 var that=this
                test=[0,0,0,0,0,0,0,0,0]
                // eslint-disable-next-line no-undef

                         try {
                             await that.axios.get(`${that.GLOBAL.apiUrl}/area/getarealistbybelongareaname`, {
                                 params: {
                                     belongAreaName: proname
                                 }
                             }).then((response) => {
                                // console.log(response.data)
                                 test=response.data.areaList
                                 console.log(test)
                                 that.createMap()
                             })

                         }

                         catch(error){console.log(error)}
                 that.nineblock=test

                 this.$store.commit('setCity',this.$route.query.n);
            },


            createMap() {
                /* eslint-disable */
                // 创建Map实例



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

                //给区块染色

                //先定义好每块的颜色

                if( this.flag==false) {
                    // for (var i = 0; i < this.area.length; i++)
                    var num = 0
                    for (var n = 0; n < 9; n++)
                        for (var temp = 0; temp < 5; temp++) {
                            if (this.nineblock[num].bubbleNum >= this.colorlist[temp].start && this.nineblock[num].bubbleNum <= this.colorlist[temp].end) {
                                this.colorblock.push(this.colorlist[temp].color);
                                num++;
                                break;
                            }
                        }
                }



                function add_overlay() {
                    map.addOverlay(rectangle);         //增加矩形
                }

//console.log("?");
               if(this.flag==false) {
                   var m1 = 0;
                   for (var n2 = this.$route.query.y - 0.28; n2 < this.$route.query.y + 0.02; n2 += 0.15)
                   for (var i2 = this.$route.query.x - 0.2; i2 < this.$route.query.x + 0.25; i2 += 0.15)
                        {

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
               else {
                   // eslint-disable-next-line no-redeclare
                   var m1 = 0;
                   // eslint-disable-next-line no-redeclare
                   for (var n2 = this.$route.query.y - 0.28; n2 < this.$route.query.y + 0.02; n2 += 0.15)
                       // eslint-disable-next-line no-redeclare
                   for (var i2 = this.$route.query.x - 0.2; i2 < this.$route.query.x + 0.25; i2 += 0.15)
                       // eslint-disable-next-line no-redeclare
                        {

                           // eslint-disable-next-line no-redeclare
                           var pStart = new BMapGL.Point(i2, n2);
                           // eslint-disable-next-line no-redeclare
                           var pEnd = new BMapGL.Point(i2 + 0.15, n2 + 0.15);
                           // eslint-disable-next-line no-redeclare
                           var rectangle = new BMapGL.Polygon([
                               new BMapGL.Point(pStart.lng, pStart.lat),
                               new BMapGL.Point(pEnd.lng, pStart.lat),
                               new BMapGL.Point(pEnd.lng, pEnd.lat),
                               new BMapGL.Point(pStart.lng, pEnd.lat)
                           ], {
                               strokeColor: "white",
                               strokeWeight: 2,
                               strokeOpacity: 0.5,
                               fillColor: this.colorblock2[m1],
                           });  //创建矩形
                           //添加覆盖物
                           m1++;
                           //console.log("!");
                           add_overlay();

                       }
               }

                    }
            //},

        },
        computed: {

            getnineblock() {
                return this.nineblock;
            },
            gethighlight() {
                return this.$store.state.highLight;
            },

        },
        watch: {
            //监听时间轴开始日期变化
            nineblock() {
                this.createMap()
            },
            //监听九块数组
            gethighlight() {
                //console.log(this.$store.state.highLight)
                //收到高亮id列表后进行高亮操作
                this.highLightBlock = this.$store.state.highLight;
                this.colorblock2=this.colorblock;
                //console.log(this.highLightBlock)
                for(var i = 0;i<this.highLightBlock.length;i++){
                    // eslint-disable-next-line no-unused-vars
                    //his.highLightBlock[i]
                    this.highLightBlock[i]=this.highLightBlock[i]%10
                }
                for(var n=0;n<9;n++) {
                    for(var k=0;k<this.highLightBlock.length;k++) {
                        if(this.highLightBlock[k]==n+1) {

                            this.colorblock2[n]="orange"
                        }
                    }
                }
                this.flag=true;
                console.log(this.colorblock2);
                this.createMap()
            }
        },
        mounted() {

        }
    }
</script>
<style scoped>
    #fujian {
        min-height: 100vh;
    }
</style>