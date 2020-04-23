<template>
    <div class="SideBar">
        <SideBarInformation></SideBarInformation>
        <SideBarRecent></SideBarRecent>
    </div>
</template>

<script>
    import SideBarInformation from "@/components/SideBar/SideBarInformation";
    import SideBarRecent from "@/components/SideBar/SideBarRecent";
    export default {
    name: "SideBar",
    components:{
      SideBarInformation,
      SideBarRecent
    }
  }
</script>

<style scoped lang="less">
    @outlineColor:#989899;
    .SideBar {
        width: 315px;
        height: 600px;
        border:1px solid @outlineColor;
        padding-top: 30px;
    }
</style>