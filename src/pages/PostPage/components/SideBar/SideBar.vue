<template>
    <div class="SideBar" id="SideBar">
        <SideBarInformation></SideBarInformation>
        <SideBarRecent></SideBarRecent>
    </div>
</template>

<script>
    import SideBarInformation from "@/pages/PostPage/components/SideBar/SideBarInformation";
    import SideBarRecent from "@/pages/PostPage/components/SideBar/SideBarRecent";
    import $ from 'jquery';

    $(window).resize(function () {
      let sideBarLeft = $('.ContentCenter').css("right");
      console.log(sideBarLeft)
      $('#SideBar').css("left", "")
    })

    export default {
    name: "SideBar",
    components:{
      SideBarInformation,
      SideBarRecent
    },
  }
</script>

<style scoped lang="less">
    @outlineColor:#989899;
    .SideBar {
        position: fixed;
        z-index: 5;
        width: 315px;
        height: 600px;
        border:1px solid @outlineColor;
        padding-top: 30px;
    }
</style>