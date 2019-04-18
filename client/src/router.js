import Vue from "vue";
import Router from "vue-router";
import SorteioList from "./components/List/SorteioList.vue";
import NovoSorteio from "./components/Novo/NovoSorteio.vue";
import BuscarSorteio from "./components/Busca/BuscarSorteio.vue";
import Sorteio from "./components/Sorteio/Sorteio.vue";

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