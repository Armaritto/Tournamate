<template>
  <Header></Header>
  <div class="types">
      <p style="font-family: ubuntu-bold">Swiss</p>
    <router-link to="/createKnockout">
      <p style="color: #27374D;">Knockout</p>
    </router-link>
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
  color: #27374D;
  font-size: 17px;
  display: flex;
  justify-content: space-around;
}
.types p:visited{
  color: #27374D;
  text-decoration: none;
}
.types p:active{
  color: #27374D;
  text-decoration: none;
}
.types router-link {
  text-align: center;
  flex-grow: 1;
}

</style>
