<template>
  <Header></Header>
  <head>
    <meta charset="UTF-8">
    <title>Swiss Standings</title>
  </head>
  <body>
  <div>
    <div class="about">
      <h1 style="color: #213555">About Tournament Generator</h1>
      <p>Tournament Generator is a web application that helps you generate tournament brackets for any game, match, or competition. We offer a variety of bracket styles and sizes to fit your needs.</p>

      <h2 style="color: #213555">Key Features</h2>
      <ul>
        Choose from various bracket styles and sizes
        <br>
        Generate tournament brackets for any game, match, or competition
        <br>
        Export tournament brackets as PDFs or images
        <br>
        Support for team and individual player rankings
        <br>
        User-friendly interface for easy bracket generation
      </ul>



      <h2 style="color: #213555">Built with Vue.js</h2>
      <p>Tournament Generator is built using Vue.js, a popular JavaScript framework for building user interfaces. Vue.js is known for its simplicity and efficiency, making it a great choice for creating this web application.</p>


        <h2 style="color: #213555">Contribute to the Project</h2>
        <p>We welcome contributions from the community! If you have a feature request, bug report, or would like to contribute code, please visit our
          <a href="https://github.com/Armaritto/Tournamate" target="_blank">GitHub</a>
          repository</p>
        <p></p>
      <section>
        <h2 style="color: #213555">Our Team</h2>
        <table style="display: flex; justify-content: center;">
          <tr>
            <td>
              <div class="team-member">
                <img src= "..\assets\andrew.jpg" style="width:200px;height:200px"/>
                <h3>Andrew Ashraf</h3>
              </div>
            </td>
            <td>
              <div class="team-member">
                <img src= "..\assets\armia.jpg" style="width:200px;height:200px"/>
                <h3>Armia Joseph</h3>
              </div>
            </td>
            <td>
              <div class="team-member">
                <img src= "..\assets\habiba.jpg" style="width:200px;height:200px"/>
                <h3>Habiba Tarek</h3>
              </div>
            </td>
            <td>
              <div class="team-member">
                <img src= "..\assets\karene.jpg" style="width:200px;height:200px"/>
                <h3>Karene Antoine</h3>
              </div>
            </td>
            <td>
              <div class="team-member">
                <img src= "..\assets\pierre.jpg" style="width:200px;height:200px"/>
                <h3>Pierre Jack</h3>
              </div>
            </td>
          </tr>
        </table>
      </section>

    </div>
  </div>
  </body>
</template>

<script>
import {defineComponent} from "vue";
import Header from "@/components/Header.vue";

export default defineComponent({
  components: {Header}
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
.about {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}
.header {
  position: relative;
  overflow: hidden;
  padding: 20px 10px;
  max-width: 200px;
  margin-left: 50px;
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
  margin-left: 8px;
}
.header a.logo {
  font-size: 320%;
  font-weight: bold;
  padding-left: 210px;
}
</style>
