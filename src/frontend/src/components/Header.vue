<template>
  <head>
    <meta charset="UTF-8">
  </head>

  <div>
    <router-link to="/about">
      <img src="..\Logo.jpeg" alt="logo" id="tournamatelogo" style="padding-left:70px;width:120px;height:120px;position:absolute" class="img-fluid">
    </router-link>
    <br>
    <br>
    <div class="header">
      <a class="logo">TournaMate</a>
      <div class="header-right header-rightHovered">
        <div>
          <router-link to="/profile" class="nav-link">
            <lord-icon class = "icon"
                       src="https://cdn.lordicon.com/kthelypq.json"
                       trigger="hover"
                       style="width:50px;height:50px">
            </lord-icon>
          </router-link>
        </div>
      </div>
      <div class="header-right header-rightHovered">
        <div>
          <router-link to="/about">
            <div class="active" style="text-decoration: none;">
              About
            </div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
  <hr style="margin-top: 100px">


</template>
<script setup>
</script>
