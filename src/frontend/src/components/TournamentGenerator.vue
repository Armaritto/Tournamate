<template>
  <div class="col-3" v-for="n in Elements" :key="n">
    <div class="notHover text-white text-center py-3 IsHovered m-1"
         @click="action(n)"
    >
      {{n}}
    </div>
  </div>
  <div id="board" class="rounded-3 m-1 p-3 ">
    {{'who are you?'}}
  </div>
</template>

<script>
let helloMsg = '';
export default {
  name: 'TournamentGenerator',
  data(){
    return{
      Elements: ['Frontend','Backend'],
    }
  },
  methods:{
    action(n){
      helloMsg = n
      callBackend();
      function callBackend(){
        fetch("/api/messages/backend", {
          method: 'POST',
          body: JSON.stringify({
            msg: helloMsg
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
#textBox {
  background: #e87a90;
}
.notHover{
  background: #ffffff;
}
.IsHovered:hover{
  cursor: pointer;
  background: #949494;
}
</style>
