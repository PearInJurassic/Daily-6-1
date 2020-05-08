<template>
  <div class="home">
    <country></country>
  </div>
</template>

<script>
// @ is an alias to /src
import country from '@/components/country.vue'

export default {
  name: 'Home',
  components: {
    country
  }
}
</script>
