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


<style scoped>
@font-face {
  font-family: ubuntu-bold;
  src: url("../../Ubuntu/Ubuntu-Bold.ttf");
}
@font-face {
  font-family: ubuntu-bold-italic;
  src: url("../../Ubuntu/Ubuntu-BoldItalic.ttf");
}
@font-face {
  font-family: ubuntu-italic;
  src: url("../../Ubuntu/Ubuntu-Italic.ttf");
}
@font-face {
  font-family: ubuntu-light;
  src: url("../../Ubuntu/Ubuntu-Light.ttf");
}
@font-face {
  font-family: ubuntu-lightItalic;
  src: url("../../Ubuntu/Ubuntu-LightItalic.ttf");
}
@font-face {
  font-family: ubuntu-medium;
  src: url("../../Ubuntu/Ubuntu-Medium.ttf");
}
@font-face {
  font-family: ubuntu-medium-italic;
  src: url("../../Ubuntu/Ubuntu-MediumItalic.ttf");
}
@font-face {
  font-family: ubuntu-regular;
  src: url("../../Ubuntu/Ubuntu-Regular.ttf");
}
body {
  font-family: ubuntu-regular;
}
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
