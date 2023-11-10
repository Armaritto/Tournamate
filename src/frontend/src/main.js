import { createApp } from 'vue';
import { createRouter, createWebHashHistory } from 'vue-router';

import SwissStandings from './components/SwissStandings.vue';
import About from './components/about-us.vue';

const router = createRouter({
    mode: 'history',
    history: createWebHashHistory(),
    // base: __dirname,
    routes: [
        { path: '/', component: SwissStandings },
        { path: '/about', component: About },
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

// new Vue({
//     router,
//     template: `
//     <div>
//       <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
//         <div class="collapse navbar-collapse" id="navbarNav">
//           <ul class="navbar-nav">
//             <li class="nav-item"><router-link to="/" class="nav-link">Home</router-link></li>
//             <li class="nav-item"><router-link to="/about" class="nav-link">About</router-link></li>
//             <li class="nav-item"><router-link to="/contact" class="nav-link">Contact</router-link></li>
//           </ul>
//         </div>
//       </nav>
//       <router-view class="view"></router-view>
//     </div>
//   `
// }).$mount('#app');
