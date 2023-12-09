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
  <body>
  <div class="flex-container">
    <div class="create-room">
      <h1>Create Room</h1>
        <label for="room-name">Room Name:</label>
        <input type="text" id="room-name" name="room-name">
        <br>
      <div class="delete deleteH" style="border: none; position: absolute;margin-left: 430px; margin-top: 10px"  @click="addTeam()">
        <div style="display: flex; flex-direction: column; align-items: center">
          <lord-icon
              src="https://cdn.lordicon.com/hqymfzvj.json"
              trigger="hover"
              colors="primary:#213555"
              style="width:40px;height:40px">
          </lord-icon>
          <div>
            Add Team
          </div>
        </div>
      </div>
        <label for="team-name">Team Name:</label>
        <input type="textbox" id="team-name" name="team-name">

        <br>
        <label for="total-rounds">Total number of Rounds:</label>
        <input type="text" id="NUMBEROFROUNDS" name="number of rounds">
        <br>
        <router-link to="/rounds">
          <div class="delete deleteH" style="border: none;" @click="finalizeParameters()">
            <div style="display: flex; flex-direction: column; align-items: center">
              <lord-icon
                  src="https://cdn.lordicon.com/oqdmuxru.json"
                  trigger="hover"
                  colors="primary:#213555"
                  style="width:40px;height:40px">
              </lord-icon>
              <div>
                Create Room
              </div>
            </div>
          </div>
        </router-link>

    </div>
    <div style="padding-left: 300px">
        <div class="create-room-teams">
          <table>
            <tr>
              <td>
                <div style="align-content: center; align-items: center; justify-content: center">
                  <h1>Teams</h1>
                </div>
              </td>
              <td>
                <div class="delete deleteH" style="border: none;" @click="shuffle()">
                  <div style="display: flex; flex-direction: column; align-items: center">
                    <lord-icon
                        src="https://cdn.lordicon.com/rsbokaso.json"
                        trigger="hover"
                        colors="primary:#213555"
                        style="width:40px;height:40px">
                    </lord-icon>
                    <div>
                      Shuffle
                    </div>
                  </div>
                </div>
              </td>

            </tr>
            <tr v-for="(team, index) in teams" :key="index">
              <div style="display: flex;align-content: center; align-items: center; justify-content: center">
                <div style="align-content: center; align-items: center; justify-content: center; font-size: 20px">
                  {{team}}
                </div>
                <div>
                  <div class="delete deleteH" @click="remove(index)" style="display: flex; flex-direction: column; align-items: center; border: none; border-radius: 10px">
                    <lord-icon
                        src="https://cdn.lordicon.com/wpyrrmcq.json"
                        trigger="hover"
                        style="width:30px;height:30px">
                    </lord-icon>
                  </div>
                </div>
              </div>
            </tr>
          </table>
      </div>
    </div>
  </div>
  </body>
</template>


<script>
import myMixin from "@/components/myMixin";
function arrayRemove(arr, value) {
  return arr.filter(function (v) {
    return v != value;
  });
}
import Header from "@/components/Header.vue";
import rounds from "@/components/rounds.vue";
export default {
  name: 'SwissStandings',
  components: {Header},
  mixins: [myMixin],
  data(){
    return{
      roomName: '',
      teams: [],
      tournamentID: 13,
      numberOfRounds: '',
      addTeam: function(){
        var name = document.getElementById('team-name').value
        this.teams.push(name)
      },
      remove: function(index){
        this.teams = arrayRemove(this.teams,this.teams[index])
      },
      finalizeParameters: function(){
        this.roomName = document.getElementById('room-name').value
        this.numberOfRounds = document.getElementById('NUMBEROFROUNDS').value
        fetch("http://localhost:8080/swiss/newSwissTournament?"+ new URLSearchParams({
          name: this.roomName,
          numOfRound: this.numberOfRounds,
          list: this.teams
        }),{
          method: 'POST'
        })
            .then(function (response) {
              return response.json()
            })
            .then((data) => {
              //this.tournamentID = Number(data)
              //this.id = data;

              myMixin.data().id = data;
              console.log(myMixin.data().id)
            })
      },
      shuffle: function (){
        fetch("http://localhost:8080/shuffle?"+ new URLSearchParams({
          list: this.teams
        }),{
          method: 'POST'
        })
            .then(function (response) {
              return response.json()
            })
            .then((data) => {
              console.log(data)
              this.teams = data
            })
      }
    }
  }
}
</script>

<style>
.types{
  color: #213555;
  font-size: 17px;
  display: flex;
  justify-content: space-around;
}
.types p:visited{
  color: #213555;
  text-decoration: none;
}
.types p:active{
  color: #213555;
  text-decoration: none;
}
.types router-link {
  text-align: center;
  flex-grow: 1;
}
.create-room {
  width: 500px;
  padding: 20px;
  border-radius: 20px;
  border: 4px solid #213555 ;
}
.create-room-teams {
  width: 500px;
  padding: 20px;
  border-radius: 20px;
  border: 4px solid #213555 ;
  justify-content: center;
  display: flex;

}
.buttons{
  color: #DDE6ED;
  border-radius: 20px;
  border: 3px solid #CC7469 ;
  padding: 10px 30px;
  background: #CC7469;
}
.createTournament-button {
  color: #DDE6ED;
  padding: 16px;
  font-size: 16px;
  cursor: pointer;
  background: #CC7469;
  border: 3px solid #CC7469 ;
}
h1 {
  text-align: center;
  margin-bottom: 20px;
  color: #213555;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"] {
  width: 100%;
  padding: 8px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 3px;
}
input[type="textbox"] {
  width: 80%;
  padding: 8px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 3px;
}
select {
  width: 100%;
  padding: 8px;
  margin-bottom: 15px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

button[type="submit"] {
  width: 100%;
  padding: 8px;
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
  font-size: 16px;
  border-radius: 3px;
}

button[type="submit"]:hover {
  background-color: #45a049;
}
.flex-container {
  padding-left: 150px;
  padding-top: 50px;
  display: flex;
}
.delete{
  background-color: #DDE6ED;
}
.deleteH:hover{
  background-color: #c1c9d0;
  cursor: pointer;
}
.blue-buttonH:hover {
  background-color: #bcc5cc;
}
</style>
