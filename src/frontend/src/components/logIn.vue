<template>
    <body>
        <div id="left">
            <div class="welcome">
              <table>
                <tr>
                  <h1 class="title">Welcome to your
                    TournaMate!!
                  </h1>
                </tr>
                <tr>
                  <router-link to="/about">
                    <img src="..\Logo.jpeg" alt="logo" id="tournamatelogo" style="width:500px;height:500px;" class="img-fluid">
                  </router-link>
                </tr>
                <tr>
                  <p style="color: #27374D;">Enjoy your rounds!</p>
                </tr>
              </table>
            </div>
<!--          <div class="footer">-->
<!--              <p >About us</p>-->
<!--          </div>-->
        </div>
        <div id="right">
        <meta charset="UTF-8">
        <h1 style="color:#e2f4ff; font-size: 50px;">Login</h1>
        <div class="log-in">
            <form>
                <input type="text" class="input-box" id="username" placeholder="Username/Email"/>
                <input type="password" class="input-box" id="pass" placeholder="Password"/>
                <div class="display" style="color: #CC7469;">{{ condition }}</div>
                <router-link to="/NewAccount">
                  <p style="font-size:10px; color:#DDE6ED;" class="other">Create new account? Sign up.</p>
                 </router-link>
                <!-- <p style="font-size:10px" class="other"><a href="#" style=" color:#DDE6ED;">Create new account? Sign up.</a></p> -->

                <button type="button" class="login-btn" @click="storeData();login()">Login</button>

                <router-link to="/createTournament">
                  <p style="font-size:10px; color:#DDE6ED;" class="other">Continue as a guest.</p>
                 </router-link>
                <!-- <p style="font-size:10px" class="other"><a href="#" style=" color: #DDE6ED">Continue as a guest.</a></p> -->

            </form>
        </div>
     </div>
    </body>
</template>
<script>

  // const width = window.innerWidth
  // const height = window.innerHeight
  export default ({
  data(){
    return{
      fromBack:"",
      username:"",
      password:"",
      condition:""
    };
  },
    methods:{
        storeData(){
          this.username = document.getElementById("username").value
          this.password = document.getElementById("pass").value
        },

        login(){
          fetch("http://localhost:9190/login", {
           method: "post",
           headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },

          //make sure to serialize your JSON body
          body: JSON.stringify({
            usernameOrEmail: this.username,
            password: this.password
          })
        })
        .then(response => {
            return response.text();
          })
          .then(data => {
            this.fromBack = data;
            if(this.fromBack!=="loginSuccess"){
              this.condition=this.fromBack;
            }
            else{
                 location.replace("http://localhost:3000/#/createTournament")
              // window.location.href = "http://localhost:3000/createTournament"
              // window.open("http://localhost:3000/#/createTournament")
            }
          });

     },
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
#body{
    margin: 0;
    padding: 0;
}
#left {
    width:50%;
    height:98vh;
    float:left;
    background-color:#DDE6ED;
    display: flex;
    justify-content:center;
    align-items:center;
    text-align: center;
}
#right {
    width:50%;
    height:96vh;
    float:left;
    background-color:#27374D;
    /* display: block; */
    display: flex;
    justify-content:center;
    align-items:center;
    text-align: center;
    flex-direction: column;
    border-radius: 40px;
    /* margin-top:26px; */
}

.title{
    color: #27374D;
    font-size: 50px;
    /* margin: 10px; */
}

.footer{
    position: absolute;
    bottom: 0;
    /* left: 0;  */
    /* z-index: 10; */
}

.log-in{
    width: 300px;
    padding: 10px;
    /* margin: 8% auto 0; */
    text-align: center;
}

.input-box{
    border-radius: 20px;
    padding: 10px;
    margin: 10px 0;
    width: 80%;
    border: 4px solid #DDE6ED;;
    outline: none;
}

.login-btn{
    color:#27374D;
    background-color:#DDE6ED; ;
    width: 40%;
    padding: 10px;
    border-radius: 20px;
    font-size: 20px ;
}

.login-btn:hover{
    background-color: #bbccd7;
}

.other:hover{
    color: #bbccd7;
}



</style>
