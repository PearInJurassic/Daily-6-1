import PersonPage from "@/pages/PostPage/PersonPage";
import PageCenterPost from "@/pages/PostPage/components/PageCenter/PageCenterPost";
import TimeaxisPage from "@/pages/Timeaxis/TimeaxisPage";
import Home from "@/pages/Timeaxis/components/VIewComponents/Home";
import Vue from "vue";
import VueRouter from "vue-router";
import About from "@/pages/Timeaxis/components/VIewComponents/About";
import WorkLine from "@/pages/Timeaxis/components/VIewComponents/WorkLine";
import MoodLine from "@/pages/Timeaxis/components/VIewComponents/MoodLine";
import Other from "@/pages/Timeaxis/components/VIewComponents/Other";
import OthersPage from "@/pages/PostPage/OthersPage";
import fujian from "@/pages/Map/fujian";
import MapPage from "@/pages/Map/MapPage";

Vue.use(VueRouter);

const routes = [
  {
    path:'',
    component: PageCenterPost,
  },
  {
    path:'/postpage/:id',
    component: PageCenterPost,
  },
  {
    path:'/homepage/:id',
    component:PageCenterPost
  },
  {
    path: '/personpage/:id',
    component: PersonPage
  },
  {
    path: '/timeaxispage/:id',
    component: TimeaxisPage,
    children:[
      {
        path:'',
        component:Home
      },
      {
        path:'about',
        component: About
      },
      {
        path: 'workline',
        name: 'WorkLine',
        component: WorkLine
      },
      {
        path: 'moodline',
        name: 'MoodLine',
        component: MoodLine
      },
      {
        path: 'other',
        name: 'Other',
        component: Other
      },
    ]
  },
  {
    path: '/others/:id',
    component: OthersPage
  },
  {
    path: '/mapspage/:id',
    component: MapPage,
    children: [

    ]
  },
  {
    path: '/fujian',
    component: fujian
  }

]

const router =new VueRouter({
  mode: 'hash',
  routes
})

export default router;