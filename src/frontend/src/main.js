import { createApp } from 'vue';
import { createStore } from 'vuex'
import { createRouter, createWebHashHistory } from 'vue-router';
import SwissStandings from './components/SwissStandings.vue';
import About from './components/about-us.vue';
import Profile from './components/user-profile.vue';
import logIn from './components/logIn.vue';
import rnds from './components/rounds.vue';
import CreateTournament from './components/Create-tournament.vue';
import CreateKnockout from './components/Create-Knockout.vue';
import CreateRobin from './components/Create-Robin.vue';
import CreateGroups from './components/Create-Groups.vue';
import NewAccount from './components/SignUp.vue';
import rnds_Robin from './components/rounds-Robin.vue'
import RoundRobinStandings from "@/components/RoundRobinStandings.vue";
import ViewPlayerStandingMobile from "@/components/ViewPlayerStandingMobile.vue";
const router = createRouter({
    mode: 'history',
    history: createWebHashHistory(),
    // base: __dirname,
    routes: [
        { path: '/', component: logIn },
        { path: '/SwissStandings', component: SwissStandings },
        { path: '/about', component: About },
        { path: '/profile', component: Profile },
        { path: '/createTournament', component: CreateTournament},
        { path: '/rounds', component: rnds},
        { path: '/createKnockout', component: CreateKnockout},
        { path: '/createRoundRobin', component: CreateRobin},
        { path: '/createGroups', component: CreateGroups},
        { path: '/NewAccount', component: NewAccount},
        { path: '/roundsRobin', component: rnds_Robin},
        { path: '/RoundRobinStandings', component: RoundRobinStandings},
        { path: '/ViewStats', component: ViewPlayerStandingMobile}

    ]
});
const store = createStore({
    state () {
        return {
            id: 0
        }
    },
    mutations: {
        increment (state) {
            state.count++
        }
    }
})

const app = createApp({
    template: `
    <div>
      <router-view></router-view>
    </div>
  `
});
app.use(router);
app.use(store);
app.mount("#app");
