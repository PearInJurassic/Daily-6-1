import PersonPage from "@/pages/PostPage/PersonPage";
import PageCenterPost from "@/pages/PostPage/components/PageCenter/PageCenterPost";
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path:'/',
    component: PageCenterPost,
  },
  {
    path:'/homepage',
    component:PageCenterPost
  },
  {
    path: '/personpage',
    component: PersonPage
  },
]

const router =new VueRouter({
  routes
})

export default router;