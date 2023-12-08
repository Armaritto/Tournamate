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
            <div class="active header-right header-rightHovered"  style="text-decoration: none; margin-left: 5px;width:135px;text-align: center">
              Change Photo
            </div>
          </td>
        </tr>
        <tr>
          <td style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px;padding-top: 15px">
            Username
          </td>
        </tr>
        <tr>
          <td style="font-size: 18px;font-family: ubuntu-bold">
            Player Name
          </td>
          <td>
            <div>
              <div class="active header-right header-rightHovered" style="text-decoration: none; margin-left: 5px;width:135px;text-align: center;">
                Change name
              </div>
            </div>
          </td>
        </tr>
        <tr>
          <td style="font-family: ubuntu-bold;font-size: 30px;padding-bottom: 15px;padding-top: 15px">
            Password
          </td>
        </tr>
        <tr>
          <td style="font-size: 18px;font-family: ubuntu-bold">
            *********
          </td>
          <td>
            <div class="active header-right header-rightHovered" style="text-decoration: none;margin-left: 5px;width:135px;text-align: center">
              Change Password
            </div>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="active2 header-right2 header-rightHovered2" style="text-decoration: none;margin-right: 200px;margin-top: 150px;margin-bottom: 50px ;width:135px;text-align: center;background: #213555;
  color: #DDE6ED;">
        Save Changes
      </div>

    </div>
  </div>
  </body>
</template>

<script>
import lottie from "lottie-web";
import { defineElement } from "@lordicon/element";
import Header from "@/components/Header.vue";
// define "lord-icon" custom element with default properties
defineElement(lottie.loadAnimation);
export default {
  components: {Header},
  data() {
    return {
      imageUrl: null,
      username: "",
      name: "",
    };
  },
  methods: {
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
</style>
