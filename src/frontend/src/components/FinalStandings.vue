<template>
  <Header></Header>
  <body>
  <h1 class="winners">
    Congratulations to our Winners !!
  </h1>
  <div class="podium" style="display: flex; justify-content: center ">
    <div>
    </div>
    <div class="container podium">
      <div class="podium__item">
        <p class="podium__city">{{second}}</p>
        <div class="podium__rank second">2</div>
      </div>
      <div class="podium__item">
        <p class="podium__city">{{first}}</p>
        <div class="podium__rank first">1</div>
      </div>
      <div class="podium__item">
        <p class="podium__city">{{third}}</p>
        <div class="podium__rank third">3</div>
      </div>
    </div>
  </div>
  </body>

</template>

<script>
import Header from "@/components/Header.vue";

export default {
  name: 'finalStandings',
  components: {Header},
  props: ['id'],
  data(){
    return{
      tournamentID: this.id,
      podium: [],
      first: '',
      second: '',
      third: '',
      getFinalStandings: function(){
        fetch("http://localhost:9190/swiss/?" + new URLSearchParams({
          id:this.tournamentID
        }),{
          method: 'GET'
        })
            .then(function (response) {
              return response.json()
            })
            .then((data) => {
              for(var index in data){
                this.podium.push({
                  name: data[index].name,
                })
              }
              this.first = this.podium[0].name
              this.second = this.podium[1].name
              this.third = this.podium[2].name
              // console.log(this.podium[0].name)
            })

      }
    }
  },
  mounted(){
    this.getFinalStandings();
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

.container {
  display: flex;
  align-items: flex-end;
}

.podium__item {
  width: 200px;
}

.podium__rank {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 35px;
  color: #fff;
}

.podium__city {
  text-align: center;
  font-size: 30px;
}

.podium__number {
  width: 27px;
  height: 75px;
}

.podium .first {
  min-height: 300px;
  font-size: 120px;
  color: gold;
  background:
  linear-gradient(
      #C8756D,
      #B0677C,
      #8E6083,
      #675A7E
  );
}

.podium .second {
  min-height: 200px;
  color: silver;
  background:
      linear-gradient(
          #081235,
          #572856
      );
}

.podium .third {
  color: saddlebrown;
  min-height: 100px;
  background: #B9CAD4
}

.winners{
  font-size: 90px;
  color: #213555;
  display: flex;
  justify-content: center;
}
</style>
