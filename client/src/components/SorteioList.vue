<template>
    <div class="list row">
        <div class="col-md-6">
            <h4>Lista de Sorteios</h4>
            <ul>
                <li v-for="(sorteio, index) in sorteios" :key="index">
                    <router-link :to="{
                        name: 'sorteio',
                        params: {sorteio: sorteio, id: sorteio.id}
                    }">
                        {{sorteio.loteria}}
                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"/>
        </div>
    </div>
</template>

<script>
import http from "../http-common";

export default {
    name: "sorteios",
    data() {
        return {
            sorteios: []
        };
    },
    methods: {
        /* eslint-disable no-console */
        retrieveSorteios() {
            http
                .get("/sorteios")
                .then(response => {
                    this.sorteios = response.data; //JSON Parsed automatically.
                    console.log(response.data);
                })
                .catch(e => {
                    console.log(e);
                });
        },
        refreshList() {
            this.retrieveSorteios();
        }
        /* eslint-enable no-console */
    },
    mounted() {
        this.retrieveSorteios();
    }
}
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>

