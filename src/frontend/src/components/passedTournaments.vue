
<template>
  <Header :username="username"></Header>
<h1>Passed Tournaments</h1>
</template>

<script>
import Header from "@/components/Header.vue";

export default{
  components: {Header},
  props:['username'],
  mounted(){
    console.log(this.username)
  }
}
</script>

<style scoped>

</style>
