<template>
  <body>
  <div class="card">
    <div class="profile-top">
      <img class="background-pic" src="./images/bg-pattern-card.svg" alt="background" />
      <img class="profile-pic" src="./images/image-victor.jpg" alt="profile pic" />
    </div>
    <div class="profile-info">
      <!--      <div style="position: absolute">-->
      <!--        <lord-icon-->
      <!--            src="https://cdn.lordicon.com/rqptwppx.json"-->
      <!--            trigger="hover"-->
      <!--            stroke="bold"-->
      <!--            colors="primary:#081234,secondary:#cc7469"-->
      <!--            style="width:30px;height:30px">-->
      <!--        </lord-icon>-->
      <!--      </div>-->
      <p class="name">{{this.teamName}}</p>
    </div>

    <div class="profile-stats">
      <div class="profile-stats-section">
        <p id="rank" class="number">{{this.ranking}}</p>
        <small>Ranking</small>
      </div>

      <div class="profile-stats-section">
        <p id="points" class="number">{{this.points}}</p>
        <small>Points</small>
      </div>

      <div class="profile-stats-section">
        <p id="wins" class="number">{{this.nWins}}</p>
        <small>Wins</small>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
import swal from 'sweetalert';
export default {
  props: ['id'],
  data(){
    return{
      statusS: '',
      teamName: '',
      tournamentID: this.id,
      ranking: '',
      points: '',
      roomName: '',
      nWins: '',
      fantasyScore: '',
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
      },
      getParam: async function(){
        this.getResults();
        swal("Enter Your Name in tournament:", {
          content: "input",
        })
            .then((value) => {
              console.log("debug")
              this.teamName = value;
              for(let i=0; i < this.teams.length; i++){
                if(this.teams[i].name.toLowerCase() === this.teamName.toLowerCase()){
                  this.ranking = i+1;
                  this.points = this.teams[i].points;
                  this.nWins = this.teams[i].win;
                }
              }
            });
      }
    }
  },
  mounted() {
    this.getParam();
  }
}
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Kumbh+Sans:wght@400;700&display=swap");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html {
  font-size: 18px;
  font-family: "Kumbh Sans", sans-serif;
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat, no-repeat;
  background-position: right 50vw bottom 50vh, left 50vw top 50vh;
  overflow: hidden;
}

.card {
  z-index: 5;
  background: white;
  border-radius: 20px;
  box-shadow: 0 0 15px rgba(99, 99, 99, 0.493);
}
.card .profile-top {
  position: relative;
  margin-bottom: 3.8rem;
}
.card .profile-top img.background-pic {
  border-radius: 20px 20px 0 0;
  width: 100%;
}
.card .profile-top img.profile-pic {
  border-radius: 50%;
  position: absolute;
  left: 50%;
  bottom: -35%;
  transform: translateX(-50%);
  border: white solid 6px;
}
@media (max-width: 400px) {
  .card .profile-top img.profile-pic {
    width: 100px;
    bottom: -40%;
  }
}
.card .profile-info .name {
  text-align: center;
  font-weight: bold;
  color: hsl(229, 23%, 23%);
}
.card .profile-info .name span {
  color: hsl(227, 10%, 46%);
  font-weight: lighter;
  margin-left: 0.3rem;
}
.card .profile-info .city {
  margin-top: 0.7rem;
  text-align: center;
  color: hsl(227, 10%, 46%);
  font-weight: lighter;
  font-size: 0.8rem;
}
.card .profile-stats {
  display: flex;
  justify-content: space-evenly;
  margin-top: 1.5rem;
  padding: 1.5rem 0;
  border-top: 1px rgb(223, 223, 223) solid;
}
.card .profile-stats-section {
  text-align: center;
}
.card .profile-stats-section .number {
  font-weight: bold;
  font-size: 1.1rem;
  margin-bottom: 0.1rem;
  color: hsl(229, 23%, 23%);
}
.card .profile-stats-section small {
  font-weight: lighter;
  font-size: 0.58rem;
  letter-spacing: 1.7px;
  color: hsl(227, 10%, 46%);
}
@media (max-width: 400px) {
  .card {
    width: 85%;
  }
}
</style>

<style lang="scss" scoped>// ========= COLORS ===========
//Primary
$dark-cyan: hsl(185, 75%, 39%);
$very-dark-desaturated-blue: hsl(229, 23%, 23%);
$dark-grayish-blue: hsl(227, 10%, 46%);

//Neutral
$dark-gray: hsl(0, 0%, 59%);

// ========= TYPOGRAPHY ===========
@import url("https://fonts.googleapis.com/css2?family=Kumbh+Sans:wght@400;700&display=swap");
$kumbhSans-font: "Kumbh Sans", sans-serif;
$font-size: 18px; // Name and stats

// ========= RESETS/DEFAULTS ===========
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
html {
  font-size: $font-size;
  font-family: $kumbhSans-font;
}

// ========= MAIN STYLE ===========
body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  position: relative;
  background-image: url("./images/bg-pattern-top.svg"), url("./images/bg-pattern-bottom.svg");
  background-repeat: no-repeat, no-repeat;
  background-position: right 50vw bottom 50vh, left 50vw top 50vh;
  overflow: hidden;
}

.card {
  z-index: 5;
  background: white;
  border-radius: 20px;
  box-shadow: 0 0 15px rgba(99, 99, 99, 0.493);

  .profile-top {
    position: relative;
    margin-bottom: 3.8rem;
    img.background-pic {
      border-radius: 20px 20px 0 0;
      width: 100%;
    }
    img.profile-pic {
      border-radius: 50%;
      position: absolute;
      left: 50%;
      bottom: -35%;
      transform: translateX(-50%);
      border: white solid 6px;

      @media (max-width: 400px) {
        width: 100px;
        bottom: -40%;
      }
    }
  }

  .profile-info {
    .name {
      text-align: center;
      font-weight: bold;
      color: $very-dark-desaturated-blue;
      span {
        color: $dark-grayish-blue;
        font-weight: lighter;
        margin-left: 0.3rem;
      }
    }
    .city {
      margin-top: 0.7rem;
      text-align: center;
      color: $dark-grayish-blue;
      font-weight: lighter;
      font-size: 0.8rem;
    }
  }

  .profile-stats {
    display: flex;
    justify-content: space-evenly;
    margin-top: 1.5rem;
    padding: 1.5rem 0;
    border-top: 1px rgb(223, 223, 223) solid;

    &-section {
      text-align: center;
      .number {
        font-weight: bold;
        font-size: 1.1rem;
        margin-bottom: 0.1rem;
        color: $very-dark-desaturated-blue;
      }
      small {
        font-weight: lighter;
        font-size: 0.58rem;
        letter-spacing: 1.7px;
        color: $dark-grayish-blue;
      }
    }
  }

  @media (max-width: 400px) {
    width: 85%;
  }
}
</style>
