<template>
  <div class="home">
    <country></country>

  </div>

</template>

<script>
// @ is an alias to /src
import country from '@/pages/Map/country.vue'
//import smallcountry from '@/pages/Map/Mapselect.vue'
// eslint-disable-next-line no-unused-vars
//import fujian from '@/pages/Map/fujian.vue'

export default {
  name: 'Home',
  components: {
    // eslint-disable-next-line vue/no-unused-components
    //fujian
    // eslint-disable-next-line no-undef
    country
    // eslint-disable-next-line vue/no-unused-components
   //smallcountry
  }
}
</script>

<style scoped lang="less">

</style>