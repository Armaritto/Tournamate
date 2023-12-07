<template>
  <Header></Header>
  <div style="margin-top: 30px;">
    <table style="width: 50%">
      <tr v-for="(match, index) in matches" :key="index">
        <div class="match">
          <td>
            <div>
              {{match.teamA}}
            </div>
          </td>
          <td>
            <div>
              score
            </div>
          </td>
          <td>
            <div>
              {{match.teamB}}
            </div>
          </td>
        </div>
      </tr>
    </table>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import Header from "@/components/Header.vue";
export default defineComponent({
  components: {Header},
  data(){
    return{
      matches: [
        {teamA: "team 1" , teamB: "team 2"},
        {teamA: "team 3" , teamB: "team 4"}

      ],

    }
  }
})


</script>

<style scoped>
 .match{
   margin-left: 80px;
   margin-top: 20px;
   border: 3px solid #27374D ;
   padding: 20px;
   border-radius: 20px;

 }
</style>
