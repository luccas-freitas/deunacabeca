<template>
  <form @submit.prevent="saveSorteio">
    <div class="submitform">
      <div v-if="!submitted">
        <br>
        <loteria :sorteio="sorteio"></loteria>
        <horario :sorteio="sorteio"></horario>
        <dataLancamento :sorteio="sorteio"></dataLancamento>
        <resultados :sorteio="sorteio"></resultados>

        <input class="btn btn-success" type="submit" value="Inserir">
      </div>

      <div v-else>
        <h4>Inserido com sucesso!</h4>
        <button class="btn btn-success" v-on:click="novoSorteio">Novo</button>
      </div>
    </div>
  </form>
</template>

<script>
import http from "../../http-common";
import Loteria from "./components/Loteria.vue";
import Horario from "./components/Horario.vue";
import dataLancamento from "./components/Data.vue";
import Resultados from "./components/resultados/Resultados.vue";
import moment from "moment";

export default {
  name: "novo",
  components: { Loteria, Horario, dataLancamento, Resultados },
  props: ["loteria"],
  data() {
    return {
      sorteio: {
        id: 0,
        soma: 0,
        loteria: "",
        horario: "",
        data: "",
        concurso: "",
        resultados: []
      },
      submitted: false
    };
  },
  methods: {
    /* eslint-disable no-console */
    saveSorteio() {
      var data = {
        loteria: this.sorteio.loteria,
        horario: this.sorteio.horario,
        data: moment(this.sorteio.data).format('L'),
        concurso: this.sorteio.concurso,
        resultados: this.sorteio.resultados.map(({ valor, animal }) => ({
          valor,
          animal
        })),
        soma: this.sorteio.soma
      };
      http
        .post("/sorteios", data)
        .then(response => {
          this.sorteio.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

      this.submitted = true;
    },
    novoSorteio() {
      this.submitted = false;
      this.sorteio.resultados = {};
      this.sorteio = {};
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>
