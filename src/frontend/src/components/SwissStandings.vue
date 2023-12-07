<template>
  <Header></Header>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
  <div>

    <div class="title">
      Lorem Ipsum
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
// define "lord-icon" custom element with default properties
defineElement(lottie.loadAnimation);
////
export default {
  name: 'SwissStandings',
  components: {Header},
  data(){
    return{
      roomName: '',
      fantasyScore: '',
      teams: [
        {name: 'Team A', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
        {name: 'Team E', points: 25, win: 20, draw: 5, lose: 0 },
      ],
      screenWidth: window.innerWidth,
      updateTeams: function(){

      },
    }
  },
  methods:{
    action(){
      callBackend();
      function callBackend(){
        fetch("/api/messages/backend", {
          method: 'POST',
          body: JSON.stringify({
            msg: ''
          }),
          headers: {
            'Content-type': 'application/json; charset=UTF-8',
          }
        })
            .then(function(response){
              return response.json()})
            .then(function(data){
              console.log(data)
              document.getElementById('board').innerHTML = data.msg;
            })
      }
    },
  }
}
</script>

<style>
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
.title{
  font-size: 50px;
  color: #095f59;
  font-family: ubuntu-bold;
  display: flex;
  justify-content: center;
  padding-top: 20px;
  padding-bottom: 40px;
}
.header a {
  float: left;
  text-align: center;
  padding: 12px;
  font-size: 18px;
  line-height: 25px;
  border-radius: 4px;
  font-family: ubuntu-bold;
  color: #081234;
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
  color: #686762;
}
.header-rightHovered:hover{
  background: #f6f3eb;
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
  border:solid #095F59FF 3px;
  align-content: center;
  border-radius: 20px;
  overflow: hidden;
}
.content th, .content td {
  border: 2px solid #095f59;
  padding: 10px;
  text-align: center;
}
.content td{
  background-color: #fdcf6e;
  align-content: center;
  font-size: 20px;
}
.content th {
  background-color: #095f59;
  border-top: none;
  color: #fdcf6e;
  align-content: center;
  font-size: 20px;
}
@media(max-width: 700px) {
  test{
    grid-template-columns: minmax(100px,1fr);
  }
}
</style>
