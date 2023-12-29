<template>
  <head>
    <meta charset="UTF-8">
    <title>Swiss Standings</title>
  </head>
  <Header></Header>
  <body>
  <div>
    <div class="title" v-if="roomName !== ''">
      {{roomName + " ID is: " + this.tournamentID}}
    </div>
    <div class="title" v-else>
      Room ID is {{this.tournamentID}}
    </div>
    <div class="content">
      <table class="my-table">
        <thead>
        <tr>
          <th>Rank</th>
          <th>Team Name</th>
          <th>Points</th>
          <th>Win</th>
          <th>Draw</th>
          <th>Lose</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(team, index) in teams" :key="index">
          <td>{{ index + 1 }}</td>
          <td>{{ team.name }}</td>
          <td>{{ team.points }}</td>
          <td>{{ team.win }}</td>
          <td>{{ team.draw }}</td>
          <td>{{ team.lose }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
  </body>
</template>

<script>
/////
import lottie from "lottie-web";
import { defineElement } from "@lordicon/element";
import Header from "@/components/Header.vue";
import rounds from "@/components/rounds.vue";
// define "lord-icon" custom element with default properties
defineElement(lottie.loadAnimation);
////
export default {
  name: 'SwissStandings',
  components: {Header},
  props: ['id'],
  data(){
    return{
      roomName: '',
      fantasyScore: '',
      tournamentID: this.id,
      teams: [],
      screenWidth: window.innerWidth,
      getResults: function(){
        fetch("http://localhost:9190/swiss/?" + new URLSearchParams({
          id:this.tournamentID
        }),{
          method: 'GET'
        })
            .then(function (response) {
              return response.json()
            })
            .then((data) => {
              console.log(data)
              this.teams = [];
              for(var index in data){
                this.teams.push({
                  name: data[index].name,
                  points: data[index].score / 2,
                  win: data[index].numOfWins,
                  draw: data[index].numOfDraws,
                  lose: data[index].numOfLosses,
                })
              }
            })
      }
    }
  },
  mounted() {
    this.getResults();
  }
}
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
#tournamatelogo{
  font-size: small;
}
.title{
  font-size: 40px;
  color: #213555;
  font-family: ubuntu-bold;
  display: flex;
  justify-content: center;
  padding-top: 20px;


  padding-bottom: 20px;


}

.header a {
  float: left;
  text-align: center;
  padding: 12px;
  font-size: 18px;
  line-height: 25px;
  border-radius: 4px;
  font-family: ubuntu-bold;
  color: #213555;
  text-decoration: none;
}
.header a.logo {
  font-size: 320%;
  font-weight: bold;
  padding-left: 210px;
}
.active{
  padding: 12px;
}
.header-right {
  float: right;
  margin-right: 70px;
  border-radius: 7px;
  color: #213555;
}
.header-rightHovered:hover{
  background: #ebebeb;
  cursor:pointer;
}
.content{
  padding-top: 20px;
  padding-bottom: 70px;
  display: flex;
  justify-content: center;
  overflow: hidden;
}
.content table {
  width: 70%;
  border-collapse: collapse;
  border:solid #213555 3px;
  align-content: center;
  border-radius: 20px;
  overflow: hidden;
}
.content th, .content td {
  border: 2px solid #213555;
  padding: 10px;
  text-align: center;
}
.content td{
  background-color: #bbccd7;
  align-content: center;
  font-size: 20px;

}
.content th {
  background-color: #27374D;
  border-top: none;
  color: #FFC1A2;
  align-content: center;
  font-size: 20px;
}
@media(max-width: 700px) {
  test{
    grid-template-columns: minmax(100px,1fr);
  }
}
body {
  font-family: ubuntu-regular;
}
</style>

