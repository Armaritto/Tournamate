<template>
    <body>
        <div id="left">
            <div class="welcome">
                <h1 class="title">Welcome to your
                   TournaMate!!</h1>
                 <p style="color: #27374D;">Enjoy your rounds!</p>
            </div>   
            <p class="footer"><a href="#" style="color:#27374D;">About us</a></p>
        </div>

        <div id="right">
        <meta charset="UTF-8">
        <h1 style="color:#e2f4ff; font-size: 50px;">Login</h1>
        <div class="log-in">
            <form>
                    <!-- <br><br><br><br><br><br> -->
                <input type="text" class="input-box" placeholder="Username"/>
                <!-- <br> -->
                <input type="password" class="input-box" placeholder="Password"/>
            
                <p style="font-size:10px" class="other"><a href="#" style=" color:#DDE6ED;">Create new account? Sign up.</a></p>
                <button type="button" class="login-btn">Login</button>
                <p style="font-size:10px" class="other"><a href="#" style=" color: #DDE6ED">Continue as a guest.</a></p>
                
            </form>
        </div>
     </div>

    </body>

<!-- <div class="background">
    <meta charset="UTF-8">
    <h1>Log In</h1>
</div> -->
</template>
<script>


export default ({
    

    methods:{
        login(){

        }

    }
})
</script>




<style scoped>

#body{
    margin: 0;
    padding: 0;    
}

#left {
    width:50%;
    height:100vh;
    float:left;
    background-color:#bbccd7;
    display: flex;
    justify-content:center;
    align-items:center;
    text-align: center;
}
#right {
    width:50%;
    height:100vh;
    float:left;
    background-color:#27374D;
    /* display: block; */
    display: flex;
    justify-content:center;
    align-items:center;
    text-align: center;
    flex-direction: column;

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
