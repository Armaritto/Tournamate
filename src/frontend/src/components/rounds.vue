<template>
  <Header></Header>
  <div class="page">
    <div style="margin-top: 30px;">
      <table style="width: 50%">
        <tr v-for="(match, index) in matches" :key="index">
          <div class="match">
            <div class="inmatch">
              <div class="teams">
                {{match.teamA}}
              </div>
            </div>
            <div>
              <div class="center dropdown">
                <div v-if="(match.scoreTeamA === -1) && (match.scoreTeamB === -1)" class="buttons dropbtn" @click="">
                  {{"set result"}}
                  <div class="dropdown-content">
                    <a @click="this.setScore('D',index); console.log('index of match = '+index)">0.5 - 0.5</a>
                    <a @click="this.setScore('P2',index); console.log('index of match = '+index)">0 - 1</a>
                    <a @click="this.setScore('P1',index); console.log('index of match = '+index)">1 - 0</a>
                  </div>
                </div>
                <div v-else class="buttons">
                  {{(match.scoreTeamA + " - " + match.scoreTeamB)}}
                </div>
              </div>
            </div>
            <div class="inmatch">
              <div class="teams">
                {{match.teamB}}
              </div>
            </div>
          </div>
        </tr>
      </table>
    </div>
    <div class="bigBUTTONCLASS">
      <div class="bigBUTTONS">
        <button class="blue-button" @click="generateNewRound() ">
          <div style="display: flex; flex-direction: column; align-items: center">
            <lord-icon
                src="https://cdn.lordicon.com/nizfqlnk.json"
                trigger="hover"
                colors="primary:#213555"
                style="width:100px;height:100px">
            </lord-icon>
            <div>
              <br>
              generate new round
            </div>
          </div>
        </button>
        <router-link :to="{path: '/' + this.tournamentID + '/swissStandings/'}" style="text-decoration: none">
          <button class="blue-button">
            <div style="display: flex; flex-direction: column; align-items: center">
              <lord-icon
                  src="https://cdn.lordicon.com/whrxobsb.json"
                  trigger="hover"
                  colors="primary:#213555"
                  style="width:100px;height:100px">
              </lord-icon>
              <div>
                <br>
                View Standings
              </div>
            </div>
          </button>
        </router-link>
      </div>
      <div>
        <qrcode-vue  :value = "valueQR" :size = "300" :level="H"></qrcode-vue>
      </div>
    </div>
  </div>
</template>

<script>
import QrcodeVue from 'qrcode.vue'
import {defineComponent} from "vue";
import Header from "@/components/Header.vue";
export default defineComponent({
  props: ['id'],
  components: {Header,QrcodeVue},
  data(){
    return{
      valueQR: 'https://localhost:3000/#/ViewStats/',
      size: 300,
      roundNumber: 1,
      tournamentID: this.id ,
      matches:[
      ],
      setScore: function (status,matchNumber){
        fetch("http://localhost:9190/swiss/setMatch?" + new URLSearchParams({
          roundNumber:this.roundNumber,
          matchNumber:matchNumber,
          matchStatus:status.toString(),
          id:this.tournamentID
      }),{
          method: 'PUT'
        })

        switch (status){
          case "D":
            this.matches[matchNumber].scoreTeamA = 0.5;
            this.matches[matchNumber].scoreTeamB = 0.5;
            break;
          case "P1":
            this.matches[matchNumber].scoreTeamA = 1;
            this.matches[matchNumber].scoreTeamB = 0;
            break;
          case "P2":
            this.matches[matchNumber].scoreTeamA = 0;
            this.matches[matchNumber].scoreTeamB = 1;
            break;
        }
      },
      generateNewRound: function(){
        console.log(this.tournamentID+"rounds page haha")
        fetch("http://localhost:9190/swiss/newSwissRound?" + new URLSearchParams({
          id:this.tournamentID
        }),{
          method: 'POST'
        })
            .then(function (response) {
              return response.json()
            })
            .then((data) => {
              console.log(data)
              for(var index in data){
                this.matches.push({
                  teamA: data[index].second.player1.name,
                  teamB: data[index].second.player2.name,
                  scoreTeamA: -1,
                  scoreTeamB: -1
                })
              }
            })
      }
    }
  }
})
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
 .match{
   margin-left: 80px;
   margin-top: 20px;
   border: 4px solid #213555 ;
   padding: 20px 50px;
   border-radius: 60px;
   display: flex;
   width: 100%;
 }
 .inmatch{
   display: flex;
   position: relative;
   justify-content: center;
   flex:1;
 }
 .teams{
   border-radius: 20px;
   border: 2px solid #213555 ;
   padding: 20px 70px;
   font-size: 20px;
 }
 .buttons{
   color: #DDE6ED;
   border-radius: 20px;
   border: 3px solid #CC7469 ;
   padding: 10px 30px;
   background: #CC7469;
 }
 .buttons:hover{
   border: 3px solid #CC7469 ;
 }
 .center{
   top: 50%;
   margin: 0;
   -ms-transform: translateY(-50%);
   transform: translateY(-50%);
   position: relative;
 }
 /* Dropdown Button */
 .dropbtn {
   color: #DDE6ED;
   padding: 16px;
   font-size: 16px;
   cursor: pointer;
 }
 /* The container <div> - needed to position the dropdown content */
 .dropdown {
   position: relative;
   display: inline-block;
 }
 /* Dropdown Content (Hidden by Default) */
 .dropdown-content {
   display: none;
   position: absolute;
   background-color: #DDE6ED;
   min-width: 100px;
   box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
   z-index: 1;
 }
 /* Links inside the dropdown */
 .dropdown-content a {
   color: #213555;
   padding: 6px 16px;
   text-decoration: none;
   display: block;
 }
 /* Change color of dropdown links on hover */
 .dropdown-content a:hover {background-color: #c0c0c0;
 }
 /* Show the dropdown menu on hover */
 .dropdown:hover .dropdown-content {display: block;}
 .page{
   display: flex;
    justify-content: left;
 }
 .bigBUTTONCLASS{
   padding-left: 200px;
 }
 .bigBUTTONS{
   display: flex;
   flex-direction: row;
   justify-content: center;
   min-width: 50px;
 }
 .blue-button {
   display: flex;
   justify-content: center;
   background-color: #DDE6ED;
   color: #213555;
   border: none;
   border-radius: 0;
   margin: 0;
   cursor: pointer;
   transition: background-color 0.3s;
   margin-bottom: -2px;
   padding: 15px;
   font-size: 20px;
 }
 .blue-buttonH:hover {
   background-color: #bcc5cc;
 }
</style>
