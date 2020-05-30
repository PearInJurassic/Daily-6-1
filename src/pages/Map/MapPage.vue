<template>
  <div class="home">
    <country></country>
    <mapselect></mapselect>
  </div>
</template>

<script>
// @ is an alias to /src
import country from '@/pages/Map/country.vue'
import mapselect from '@/pages/Map/MapSelect.vue'
export default {
  name: 'Home',
  components: {
    country,
    mapselect
  }
}
</script>

<style scoped lang="less">

</style>