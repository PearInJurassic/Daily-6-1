<template>
    <div class="home">
        <el-button @click="Visible=true">hello</el-button>
        <el-dialog
                :visible.sync="Visible"
                title="选择地区"
                width="400px">
            <div class="map">
                <country></country>
            </div>
            <span class="list">
            <el-select v-model="value" placeholder="请选择你所在的区块">
                <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>

        </span>
            <span clss="list">
            <el-button type="primary" plain @click="geApitData">确定</el-button>
        </span>
        </el-dialog>






    </div>
</template>

<script>
    // @ is an alias to /src
    import country from '@/pages/Map/country.vue'

    export default {
        name: 'Home',
        components: {
            country
        },
        data() {
            return {
                Visible: false,
                options: [{
                    value: '1',
                    label: '区域1'
                }, {
                    value: '2',
                    label: '区域2'
                }, {
                    value: '3',
                    label: '区域3'
                }, {
                    value: '4',
                    label: '区域4'
                }, {
                    value: '5',
                    label: '区域5'
                }, {
                    value: '6',
                    label: '区域6'
                }, {
                    value: '7',
                    label: '区域7'
                }, {
                    value: '8',
                    label: '区域8'
                }, {
                    value: '9',
                    label: '区域9'
                }],
                value: ''
            }
        },
        methods: {
            geApitData() {
                //获取城市名
                // eslint-disable-next-line no-unused-vars
                var n = this.$store.state.area;
                //选择的区块编号
                // eslint-disable-next-line no-unused-vars,no-undef
                var num = item.value
                console.log(n);
                console.log(num);
            }
        }
    }
</script>

<style scoped lang="less">
    .map {
        width: 100%;
        height: 100%;
        z-index: -5
    }
.list{

    z-index: 5;
}
</style>