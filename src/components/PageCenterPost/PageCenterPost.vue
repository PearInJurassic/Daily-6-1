<template>
    <div id="center">
        <ContentMain></ContentMain>
        <div class="SpaceForSideBar"></div>
        <SideBar></SideBar>
    </div>
</template>

<script>
  import ContentMain from "@/components/Content/ContentMain";
  import SideBar from "@/components/SideBar/SideBar";

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