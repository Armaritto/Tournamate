<template>
  <Header></Header>
  <head>
    <meta charset="UTF-8">
    <title>Swiss Standings</title>
  </head>
  <body>
  <div>
    <div class="title">
      User Profile
    </div>
    <div>
      <table style="padding-left: 70px">
        <tbody>
        <tr>
          <td style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px">
            Profile Photo
          </td>
          <!-- <td style="grid-column: span 2;"><p>        </p><h1>                   </h1></td> -->
          <div style="white-space: pre;">                                                </div>

          <!-- <td>
            <h1 style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px; align-items: center; align-content: center; display: flex;justify-content: center;">New profile</h1>
          </td> -->
        </tr>
        <tr>
          <td>
            <div class="avatar">
              <lord-icon class = "icon"
                         src="https://cdn.lordicon.com/kthelypq.json"
                         trigger="hover"
                         style="width:70px;height:70px">
              </lord-icon>
            </div>
          </td>
          <td><!-- @click="pickFile-->
            <div type="submit" class="active header-right header-rightHovered" style="text-decoration: none; margin-left: 5px;width:135px;text-align: center;">
                Change Photo
              </div>

          </td>



        </tr>
        <tr>
          <td style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px;padding-top: 15px">
            Username
          </td>
          <td></td>
          <td>
            <div v-if="toggleUsername" style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px; align-items: center; align-content: center; display: flex;justify-content: center;">New Username:</div>
          </td>
        </tr>
        <tr>
          <td style="font-size: 18px;font-family: ubuntu-bold">
            {{ username }}
          </td>
          <td>
            <div>
              <div @click=" usernameToggle()" class="active header-right header-rightHovered" style="text-decoration: none; margin-left: 5px;width:135px;text-align: center;">
                Change name
              </div>
            </div>
          </td>
          <td>
            <input v-if="toggleUsername" type="text" id="username" class="input-box" placeholder="Username"/>
          </td>
        </tr>
        <tr>
          <td style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px;padding-top: 15px">
            Password
          </td>
          <td></td>
          <td>
            <div v-if="displayDynamicComponent" style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px; align-items: center; align-content: center; display: flex;justify-content: center;  "> Old Password:</div>
          </td>

          <td></td>
          <td>

            <div v-if="displayDynamicComponent" style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px; align-items: center; align-content: center; display: flex;justify-content: center;  "> New Password:</div>
          </td>
        </tr>
        <tr>
          <td style="font-size: 18px;font-family: ubuntu-bold">
            *********
          </td>
          <td>
            <div class="active header-right header-rightHovered"  @click="makeVisible()" style="text-decoration: none;margin-left: 5px;width:135px;text-align: center">
              Change Password
            </div>
          </td>
          <td>
            <input v-if="displayDynamicComponent" type="password"  id="oldPass" class="input-box" placeholder="Old Password"/>
          </td>
          <td>
            <!-- <button v-if="displayDynamicComponent">Check</button> -->
          </td>
          <!-- <div style="white-space: pre;"> </div>                              -->
          <td>
            <input v-if="displayDynamicComponent" type="password"  id="newPass" class="input-box" placeholder="New Password"/>
          </td>
        </tr>
        </tbody>
      </table>

      <div @click="storeData(); sendData(); this.$router.replace({path:'/' + this.username + '/createTournament'});" class="active2 header-right2 header-rightHovered2" style="text-decoration: none;margin-right: 200px;margin-top: 0px;-bottom: 50px ;width:135px;text-align: center;background: #213555;
        color: #DDE6ED;">
        Save Changes
      </div>
      <div  style="text-decoration: none; margin-left: 1500px; margin-top: 60px; margin-bottom: 60px ;width:135px; text-align: center; color: #CC7469;">{{ state }}</div>
    </div>


  </div>
  </body>

</template>


<script>
import axios from 'axios';
import lottie from "lottie-web";
import { defineElement } from "@lordicon/element";
import Header from "@/components/Header.vue";
// define "lord-icon" custom element with default properties
defineElement(lottie.loadAnimation);
export default {
  components: {Header},
  data() {
    return {
      toggleUsername: false,
      displayDynamicComponent: false,
      imageUrl: null,
      username:"",
      newUsername:"",
      oldPassword:"",
      newPassword:"",
      fromBack:"",
      state:"",
      file: null,
    };

  },
  mounted() {
    // Access the attribute in the component's lifecycle hooks
    this.username = this.$route.params.username;
    console.log('Received Attribute:', this.username);
  },
  methods: {
    async uploadPhoto(){
      const formData = new FormData();

            formData.append('file',this.file);
            const response = await axios.post('http://localhost:9190/setProfilePicture'+this.username, formData, {
          headers: {
            'Content-Type': 'multipart/form-data',
          },

        }
        );
        this.fromBack=response.data;
        this.file=null
      },



    handleFile(){
          this.file=document.getElementById('attachment').files[0]
          console.log(this.file);

      },
    // triggerFileInput() {
    //   // Simulate a click on the hidden file input
    //   this.$refs.fileInput.click();
    // },
    // handleFileChange(event) {
    //   // Handle file change event (called when a file is selected)
    //   const file = event.target.files[0];

    //   const formData = new FormData();
    //   formData.append('photo', file);

    //   // Assuming you have an API endpoint for photo upload
    //   // Adjust the URL accordingly
    //   const apiUrl = 'http://localhost:9190/setProfilePicture';

    //   // Use your preferred HTTP library for making the request
    //   // For example, using axios
    //   axios.post(apiUrl, formData)
    //     .then(response => {
    //       console.log('Photo uploaded successfully:', response.data);
    //     })
    //     .catch(error => {
    //       console.error('Error uploading photo:', error);
    //     });
    // },
    storeData(){
      // if(document.getElementById("username").value !== null){
      //   this.newUsername = document.getElementById("username").value
      //   console.log(this.newUsername)
      // }

      // if(document.getElementById("oldPass").value !== null){
      //   this.oldPassword = document.getElementById("oldPass").value
      //   console.log(this.oldPassword)
      // }
      // if( document.getElementById("newPass").value !== null){
      //   this.newPassword = document.getElementById("newPass").value
      //   console.log(this.newPassword)
      // }
      const usernameElement = document.getElementById("username");
      this.newUsername = usernameElement?.value || "";
      console.log(this.newUsername);

      const oldPassElement = document.getElementById("oldPass");
      this.oldPassword = oldPassElement?.value || "";
      console.log(this.oldPassword);

      const newPassElement = document.getElementById("newPass");
      this.newPassword = newPassElement?.value || "";
      console.log(this.newPassword);
    },
    sendData(){
      if(this.newUsername.length!==0){
        console.log("hiiiii");
        fetch("http://localhost:9190/editUsername/"+this.username+"/"+this.newUsername, {
           method: "get",
        })
        .then(response => {
            return response.text();
          })
          .then(data => {
            this.fromBack = data;
            if(this.fromBack==="UserNamesuccess"){
              this.username= this.newUsername;
              console.log(this.username);
              this.state="Saved Changes";
              location.replace("http://localhost:3000/#/"+this.username+"/profile")
            }
            else{
              this.state=this.fromBack;
            }
          });
      }
      if(this.fromBack==="UserNamesuccess"){
              this.username= this.newUsername;
              console.log(this.username);
              this.state="Saved Changes";
              location.replace("http://localhost:3000/#/"+this.username+"/profile")
      }
      if(this.newPassword.length !== 0 && this.newPassword!==null && this.oldPassword.length !== 0 && this.oldPassword!==null ){
        console.log("hiiiii");
        fetch("http://localhost:9190/editPassword/"+this.username+"/"+this.oldPassword+"/"+this.newPassword, {
           method: "get",
        })
        .then(response => {
            return response.text();
          })
          .then(data => {
            this.fromBack = data;
            if(this.fromBack==="passwordsuccess"){
              this.oldPassword= this.newPassword;
              this.state=this.fromBack;
            }
            else{
              this.state=this.fromBack;
            }
          });
      }
      if(this.file !== null){
        this.uploadPhoto();
      }

    },
    usernameToggle(){
      this.toggleUsername= !this.toggleUsername
    },
    makeVisible(){
      this.displayDynamicComponent= !this.displayDynamicComponent
    },
    pickFile() {
      this.$refs.fileInput.click();
    },
    onFilePicked(event) {
      const files = event.target.files;
      let filename = files[0].name;
      if (filename.lastIndexOf(".") <= 0) {
        return alert("Please add a valid image file!");
      }
      const fileReader = new FileReader();
      fileReader.addEventListener("load", () => {
        this.imageUrl = fileReader.result;
      });
      fileReader.readAsDataURL(files[0]);
      this.image = files[0];
    },
    save() {
      // Perform your save operation here
      console.log("Image URL: ", this.imageUrl);
      console.log("Username: ", this.username);
      console.log("Player Name: ", this.name);
    },
  },
};
</script>

<style scoped>

.profile {
  width: 500px;
  margin: 0 auto;
}
.avatar {
  width: 70px;
  height: 70px;
  cursor: pointer;
}

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
  font-size: 45px;
  color: #213555;
  font-family: ubuntu-bold;
  display: flex;
  justify-content: center;
  padding-top: 20px;
  padding-bottom: 40px;
}
.spacer {
      white-space: pre; /* Preserve whitespace */
    }
.active2{
  padding: 20px;
}
.header-right2 {
  font-family: ubuntu-bold;
  font-size: large;
  float: right;
  background: #213555;
  color: #DDE6ED;
  border-radius: 30px;
}
.header-rightHovered2:hover{
  background: #213555;
  cursor:pointer;
}

.header {
  position: relative;
  overflow: hidden;
  padding: 20px 10px;
  max-width: 200px;
  display: contents;
}
.header a {
  float: left;
  text-align: center;
  padding: 12px;
  font-size: 18px;
  line-height: 25px;
  border-radius: 4px;
  font-family: ubuntu-bold;
  color: #081234;
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
  font-family: ubuntu-bold;
  float: right;
  color: #27374D;
  border-style: solid;
  border-color: #213555;
  border-radius: 20px;
}
.header-rightHovered:hover{
  background: #213555;
  color: #DDE6ED;
  cursor:pointer;
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
  background-color: #DDE6ED;
  align-content: center;
  font-size: 20px;
}
.content th {
  background-color: #213555;
  border-top: none;
  color: #DDE6ED;
  align-content: center;
  font-size: 20px;
}
@media(max-width: 700px) {
  test{
    grid-template-columns: minmax(100px,1fr);
  }
}

.edit{
  margin: 0;
      padding: 0;
      display: flex;
      justify-content: flex-start; /* Align content to the start (left) of the page */
      align-items: center;
      height: 100vh;
      text-align: left; /* Align text to the left within the content */
      max-width: 600px; /* Set a maximum width for the content if needed */
      margin: 0 auto; /* Center the content horizontally within the page */
      padding: 20px;
}
.input-box{
    border-radius: 20px;
    padding: 10px;
    margin: 10px 0;
    width: 80%;
    border: 3px solid #213555;;
    outline: none;

}
</style>
