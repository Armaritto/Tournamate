<template>
    <body>
        <div id="right">
          <meta charset="UTF-8">
        <h1 style="color:#e2f4ff; font-size: 50px;">Sign up</h1>
        <div class="sign-up">
            <form>
                <input type="text" id="fname" class="input-box" placeholder="First Name"/>
                <input type="text" id="lname" class="input-box" placeholder="Last Name"/>
                <input type="text" id="username" class="input-box" placeholder="Username"/>
                <input type="email" id="email" class="input-box" placeholder="Your Email"/>
                <input type="password" id="pass" class="input-box" placeholder="Password"/>
                <input type="password" id="confPass" class="input-box" placeholder="Confrim Password"/>
                <div class="display" style="color: #CC7469">{{ condition }}</div>
                <router-link to="/">
                  <p style="font-size:10px; color:#DDE6ED;" class="other">Already have an account? Login.</p>
                 </router-link>

                <button type="button" class="signUp-btn" style="font-family: bold;" @click="storeData();signUp()">Cerate Account</button>

                <router-link to="/createTournament">
                  <p style="font-size:10px; color:#DDE6ED;" class="other">Continue as a guest.</p>
                 </router-link>
            </form>
        </div>
        </div>
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
     </div>
    </body>
</template>


<script>
export default ({
  data(){
    return{
      fromBack:"",
      firstName:"",
      lastName:"",
      username:"",
      email:"",
      password:"",
      confPass:"",
      condition:""
    };
  },
    methods:{

        storeData(){
          this.firstName = document.getElementById("fname").value
          this.lastName = document.getElementById("lname").value
          this.username = document.getElementById("username").value
          this.email = document.getElementById("email").value
          this.password = document.getElementById("pass").value
          this.confPass = document.getElementById("confPass").value
        },

        signUp(){
          fetch("http://localhost:9190/signup", {
           method: "post",
           headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },

          //make sure to serialize your JSON body
          body: JSON.stringify({
            firstname: this.firstName,
            lastname:this.lastName,
            username: this.username,
            email: this.email,
            password: this.password,
            passConfirm: this.confPass
          })
        })
        .then(response => {
            return response.text();
          })
          .then(data => {
            this.fromBack = data;
            if(this.fromBack!=="signUpSuccess"){
              this.condition=this.fromBack;
            }
            else{
              location.replace("http://localhost:3000/#/createTournament")
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
    display: flex;
    justify-content:center;
    align-items:center;
    text-align: center;
    flex-direction: column;
    border-radius: 40px;
}

.title{
    color: #27374D;
    font-size: 50px;
}


.sign-up{
    width: 300px;
    padding: 10px;
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

.signUp-btn{
    color:#27374D;
    background-color:#DDE6ED; ;
    width: 40%;
    padding: 10px;
    border-radius: 20px;
    font-size: 12px ;
    cursor: pointer;
}

.signUp-btn:hover{
    background-color: #bbccd7;
}





</style>




