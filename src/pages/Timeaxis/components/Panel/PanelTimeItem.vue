<template>
    <div>
    <div>
        <div class="cd-timeline-block">
            <div class="cd-timeline-img cd-picture">
                <img alt="动态图片" src="@/assets/NavBar/TimeLine.png">
            </div>
            <div class="cd-timeline-content" style="float:left">
                <div class="insertmap">
                    <p style="position:absolute;left:5px;top:5px">
                        {{recordItem.record.recordCreateTime}}
                    </p>
                    <el-image :src=recordItem.record.recordImg alt="Picture"
                              fit="scale-down"
                              style="width: 150px;height:150px;top:20px">
                    </el-image>
                </div>
                <div class="contentpage">
                    <h2 style="display:inline;position:absolute;left:280px;top:40px">
                        {{recordItem.record.recordContent}}
                    </h2>
                    <el-button :style="{ display: visibleDelete }" @click="fun(i)" circle class="DeleteBtn"
                               icon="el-icon-delete" type="danger"></el-button>
                    <a class="cd-read-more" href="http://www.helloweba.com/view-blog-285.html"
                       style="position:absolute;left:240px;bottom:50px"
                       target="_blank">查看全文</a>
                </div>
            </div>
        </div>
<!--        <div class="cd-timeline-block"-->
<!--             v-if="(i%2!==0 && (recordData.record.timeAxisType===axisTypeName || axisTypeName===''))">-->
<!--            <div class="cd-timeline-img cd-picture">-->
<!--                <img alt="Picture" src="@/assets/NavBar/TimeLine.png">-->
<!--            </div>-->
<!--            <div class="cd-timeline-content" style="float:right">-->
<!--                <div class="insertmap">-->
<!--                    <p style="position:absolute;left:5px;top:5px">-->
<!--                        {{recordData.record.recordCreateTime}}-->
<!--                    </p>-->
<!--                    <el-image :src=recordData.record.recordImg alt="Picture"-->
<!--                              fit="scale-down"-->
<!--                              style="width: 150px;height:150px;top:20px"></el-image>-->
<!--                </div>-->
<!--                <div class="contentpage">-->
<!--                    <h2 style="display:inline;position:absolute;left:280px;top:40px">-->
<!--                        {{recordData.record.recordContent}}-->
<!--                    </h2>-->
<!--                    <el-button :style="{ display: visibleDelete }" @click="fun(i)" circle class="DeleteBtn"-->
<!--                               icon="el-icon-delete" type="danger"></el-button>-->
<!--                    <a class="cd-read-more" href="http://www.helloweba.com/view-blog-285.html"-->
<!--                       style="position:absolute;left:240px;bottom:50px"-->
<!--                       target="_blank">查看全文</a>-->
<!--                </div>-->
<!--            </div>-->

<!--        </div>-->
    </div>
    </div>
</template>

<script>
  export default {
    name: "PanelTImeItem",
    props:{
      recordItem:{
        required:true,
      }
    }
  }
</script>

<style scoped>

</style>