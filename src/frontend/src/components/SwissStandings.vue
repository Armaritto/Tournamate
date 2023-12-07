<template>
  <head>
    <meta charset="UTF-8">
    <title>Swiss Standings</title>
  </head>
  <body>
  <div>
    <img src="..\Logo.jpeg" alt="logo" id="tournamatelogo" style="padding-left:70px;width:120px;height:120px;position:absolute" class="img-fluid">
    <br>
    <br>
    <div class="header">
      <a class="logo">TournaMate</a>
      <div class="header-right header-rightHovered">
        <div>
            <router-link to="/profile" class="nav-link">
              <lord-icon class = "icon"
                         src="https://cdn.lordicon.com/kthelypq.json"
                         trigger="hover"
                         style="width:50px;height:50px">
              </lord-icon>
          </router-link>
        </div>
      </div>
      <div class="header-right header-rightHovered">
        <div>
          <router-link to="/about">
            <div class="active" style="text-decoration: none;">
              About
            </div>
          </router-link>
        </div>
      </div>
    </div>
    <hr style="margin-top: 100px">
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
// define "lord-icon" custom element with default properties
defineElement(lottie.loadAnimation);
////
export default {
  name: 'SwissStandings',
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
#tournamatelogo{
  font-size: small;
}
.title{
  font-size: 50px;
  color: #213555;
  font-family: ubuntu-bold;
  display: flex;
  justify-content: center;
  padding-top: 20px;
  padding-bottom: 40px;
}
  ////////////////////////////
.header {
  position: relative;
  overflow: hidden;
  padding: 20px 10px;
  max-width: 200px;
  display: grid;
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
</style>

