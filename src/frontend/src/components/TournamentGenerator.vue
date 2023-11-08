<template>
  <head>
    <meta charset="UTF-8">
    <title>TournaMate - Swiss Tournament</title>
  </head>
  <body>
  <img src="..\Logo.jpeg" alt="logo" id="tournamatelogo" style="padding-left:70px;width:120px;height:120px;position:absolute">
  <br>
  <br>
  <div class="header">
    <a class="logo">TournaMate</a>
    <div class="header-right header-rightHovered">
      <lord-icon class = "icon"
                 src="https://cdn.lordicon.com/kthelypq.json"
                 trigger="hover"
                 style="width:50px;height:50px">
      </lord-icon>
    </div>
    <div class="header-right header-rightHovered">
      <a class="active">
        About
      </a>
    </div>
  </div>
  <br>
  <br>
  <br>
  <br>
  <hr>
  <div class="title">
    Lorem Ipsum
  </div>
  <div class="content">
    <table>
      <tr>
        <th>Rank</th>
        <th>Team Name</th>
        <th>Points</th>
        <th>Win</th>
        <th>Draw</th>
        <th>Lose</th>
      </tr>
      <!-- Repeat this row for each team -->
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr><tr>
      <td>1</td>
      <td>Team E</td>
      <td>25</td>
      <td>24</td>
      <td>20</td>
      <td>17</td>
    </tr><tr>
      <td>1</td>
      <td>Team E</td>
      <td>25</td>
      <td>24</td>
      <td>20</td>
      <td>17</td>
    </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>



      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>
      <tr>
        <td>1</td>
        <td>Team E</td>
        <td>25</td>
        <td>24</td>
        <td>20</td>
        <td>17</td>
      </tr>

      <!-- ... -->
    </table>
  </div>
  </body>
</template>


<script>
import lottie from "lottie-web";
import { defineElement } from "@lordicon/element";

// define "lord-icon" custom element with default properties
defineElement(lottie.loadAnimation);

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
  font-size: 50px;
  color: #095f59;
  font-family: ubuntu-bold;
  display: flex;
  justify-content: center;
  padding-top: 20px;

}
////////////////////////////
.header {
  position: relative;
  overflow: hidden;
  padding: 20px 10px;
  max-width: 200px;
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
}
.header a.logo {
  font-size: 60px;
  font-weight: bold;
  padding-left: 210px;
}
.header-right {
  float: right;
  margin-right: 70px;
  border-radius: 7px;
  color: #686762;
}
.header-rightHovered:hover{
  background: #f6f3eb;
}
.content{
  padding-top: 20px;
  padding-bottom: 70px;
  display: flex;
  justify-content: center;
}
.content table {
  width: 50%;
  border-collapse: separate;
  border:solid #095F59FF 4px;
  align-content: center;
  border-radius: 20px;
}

.content th, .content td {
  border: 2px solid #095f59;
  padding: 8px;
  text-align: center;
}
.content td{
  background-color: #fdcf6e;
  align-content: center;
  font-size: 20px;
}

.content th {
  background-color: #095f59;
  border-top: none;
  color: #fdcf6e;
  align-content: center;
  font-size: 20px;
}
.navigationHeader {
  display: grid;
  font-size: 3rem;
  grid-template-columns: repeat(5, 1fr);
  grid-auto-flow: column;
  grid-auto-columns: 1fr;
  align-items: center;
}
</style>
