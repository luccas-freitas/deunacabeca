<template>
  <div v-if="this.sorteio">
    <h4>Sorteio:</h4>
    <div>
      <label>Loteria:</label>
      {{ this.sorteio.loteria }}
    </div>
    <div>
      <label>Horário:</label>
      {{ this.sorteio.horario }}
    </div>
    <div>
      <label>Resultado:</label>
      <ul>
        <li v-for="(resultado, i) in this.sorteio.resultados" 
            v-bind:key="`${i}-${resultado}`">
            {{ resultado.valor }}
             - 
            {{ resultado.animal }}
        </li>
      </ul>
    </div>
    <div>
      <label>Soma:</label>
      {{ this.sorteio.soma }}
    </div>
    <div>
      <label>Data:</label>
      {{ this.sorteio.data }}
    </div>

    <button class="btn is-small btn-danger" v-on:click="deleteSorteio()">Remover</button>
  </div>
  <div v-else>
    <br>
    <p>Por favor, selecione um sorteio.</p>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "sorteio",
  props: ["sorteio"],
  methods: {
    /* eslint-disable no-console */
    updateActive() {
      var data = {
        id: this.sorteio.id,
        resultados: this.sorteio.resultados,
        soma: this.sorteio.soma,
        loteria: this.sorteio.loteria,
        horario: this.sorteio.horario,
        data: this.sorteio.data
      };

      http
        .put("/sorteio/", this.sorteio.id, data)
        .then(response => {
          this.sorteio.loteria = response.data.loteria;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteSorteio() {
      http
        .delete("/sorteios/" + this.sorteio.id)
        .then(response => {
          console.log(response.data);
          this.$emit("refreshData");
          this.$router.push("/");
        })
        .catch(e => {
          console.log(e);
        });
    }
    /* eslint-enable no-console */
  }
};
</script>

