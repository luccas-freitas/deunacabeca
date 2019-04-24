import Vue from "vue";
import Router from "vue-router";
import SorteioList from "./components/SorteioList.vue";
import NovoSorteio from "./components/insert/NovoSorteio.vue";
import BuscarSorteio from "./components/search/BuscarSorteio.vue";
import Sorteio from "./components/Sorteio.vue";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            name: "sorteios",
            alias: "/sorteio",
            component: SorteioList,
            children: [
                {
                    path: "/sorteios/:id",
                    name: "sorteio",
                    component: Sorteio,
                    props: true
                }
            ]
        },
        {
            path: "/add",
            name: "novo",
            component: NovoSorteio
        },
        {
            path: "/search",
            name: "buscar",
            component: BuscarSorteio
        }
    ]
});