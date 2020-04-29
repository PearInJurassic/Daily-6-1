<template>
    <div id="center">
        <ContentMain></ContentMain>
        <div class="SpaceForSideBar"></div>
        <SideBar></SideBar>
    </div>
</template>

<script>
  import ContentMain from "@/pages/PostPage/components/Content/ContentPostMain";
  import SideBar from "@/pages/PostPage/components/SideBar/SideBar";

  export default {
    name: "PostPageCenter",
    components: {
      ContentMain,
      SideBar,
    }
  }
</script>

<style scoped>

</style>