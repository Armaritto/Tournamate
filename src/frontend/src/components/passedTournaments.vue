
<template>
  <Header :username="username"></Header>
<h1>Past Tournaments</h1>
  <router-link :to="{path: '/' + this.username + '/createTournament'}">
    <p class="new">New Tournament</p>
  </router-link>

  <router-link v-for="t in this.tournamentsSwiss" :to="{path: '/' + t[1]+ '/rounds/'}">
    <p>{{t[0]}}</p>
  </router-link>

  <router-link v-for="t in this.tournamentsRoundRobin" :to="{path: '/' + t[1]+ '/roundsRobin/'}">
    <p>{{t[0]}}</p>
  </router-link>

</template>

<script>
import Header from "@/components/Header.vue";

export default{
  data(){
    return{
      tournamentsSwiss : [],
      tournamentsRoundRobin : []
    }
  },
  components: {Header},
  props:['username'],
  mounted(){

    console.log(this.username)
    fetch("http://localhost:9190/getSwissTournament/"+ this.username +"?",{
      method: 'GET'
    })
        .then(function (response) {
          console.log(response)
          return response.json()
        })
        .then((data) => {this.tournamentsSwiss = data;
          console.log(this.tournamentsSwiss)
        })
    fetch("http://localhost:9190/getRoundRobinTournament/"+ this.username +"?",{
      method: 'GET'
    })
        .then(function (response) {
          console.log(response)
          return response.json()
        })
        .then((data) => {this.tournamentsRoundRobin = data
        console.log(this.tournamentsRoundRobin)
        })

  }
}
</script>

<style>
  p .new{
    font-size: large;
  }
</style>
