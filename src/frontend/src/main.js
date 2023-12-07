import { createApp } from 'vue';
import { createRouter, createWebHashHistory } from 'vue-router';

import SwissStandings from './components/SwissStandings.vue';
import About from './components/about-us.vue';
import Profile from './components/user-profile.vue';
import logIn from './components/logIn.vue'
const router = createRouter({
    mode: 'history',
    history: createWebHashHistory(),
    // base: __dirname,
    routes: [
      { path: '/', component: logIn },
        { path: '/SwissStandings', component: SwissStandings },
        { path: '/about', component: About },
        { path: '/profile', component: Profile },

    ]
});

const app = createApp({
    template: `
    <div>
      <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
           
          </ul>
        </div>
      </nav>
      <router-view class="view"></router-view>
    </div>
  `
});

app.use(router);
app.mount("#app");
