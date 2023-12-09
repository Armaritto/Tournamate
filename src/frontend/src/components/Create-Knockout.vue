<template>
  <Header></Header>

  <div class="types">
    <router-link to="/createTournament">
      <p style="color: #27374D;">Swiss</p>
    </router-link>
    <p style="font-family: ubuntu-bold">Knockout</p>
    <router-link to="/createRoundRobin">
      <p style="color: #27374D;">Round Robin</p>
    </router-link>
    <router-link to="/createGroups">
      <p style="color: #27374D;">Groups</p>
    </router-link>
  </div>
</template>
<script setup>
  import Header from "@/components/Header.vue";
</script>


<style>
.types{
  font-size: 17px;
  display: flex;
  justify-content: space-around;
}

.types p:visited{
  color: #27374D;
}

.types router-link {
  text-align: center;
  flex-grow: 1;
}
body {
  font-family: Arial, sans-serif;
}


</style>
