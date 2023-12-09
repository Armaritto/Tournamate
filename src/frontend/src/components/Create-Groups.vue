<template>
  <Header></Header>

  <div class="types">
    <router-link to="/createTournament">
      <p style="color: #27374D;">Swiss</p>
    </router-link>
    <router-link to="/createKnockout">
      <p style="color: #27374D;">Knockout</p>
    </router-link>
    <router-link to="/createRoundRobin">
      <p style="color: #27374D;">Round Robin</p>
    </router-link>
    <p style="font-family: ubuntu-bold">Groups</p>
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
  text-align: center; /* Center the text within each router-link */
  flex-grow: 1; /* Allow each router-link to take equal space */
}
</style>
