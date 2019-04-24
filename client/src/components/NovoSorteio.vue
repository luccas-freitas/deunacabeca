<template>
  <form @submit.prevent="saveSorteio">
    <div class="submitform">
      <div v-if="!submitted">
        <br>
        <div class="form-group">
          <label>Loteria:</label>
          <select
            class="form-control"
            v-model="sorteio.loteria"
            @change="loteriaType(sorteio.loteria)"
            required>
            <option value disabled hidden>Selecione uma Loteria</option>
            <option value="0">PT-RIO</option>
            <option value="1">PR</option>
            <option value="2">FEDERAL</option>
            <option value="3">MEGA SENA</option>
            <option value="4">QUINA BR</option>
          </select>
        </div>

        <div class="form-group">
          <label>Horário:</label>
          <select v-if="sorteio.loteria < 2"
            class="form-control"
            v-model="sorteio.horario"
            required>
            <option value disabled hidden>Selecione um Horário</option>
            <option value="0">11:20</option>
            <option value="1">14:20</option>
            <option value="2">16:20</option>
            <option value="3">18:20</option>
            <option value="5">21:20</option>
          </select>

          <select v-else class="form-control" v-model="sorteio.horario" required>
            <option value disabled hidden>Selecione um Horário</option>
            <option value="4">19:00</option>
          </select>
        </div>

        <div class="form-group">
          <label>Data:</label>
          <br>
          <date-picker v-model="sorteio.data" 
            :lang="lang" 
            :input-attr="{ 
              required: true 
            }"
            :width="300">
          </date-picker>
        </div>

        <div v-if="sorteio.loteria < 3" class="form-group">
          <label>Resultados:</label>
          <div v-for="(item, index) in sorteio.resultados" :key="index">
            <Bicho :id="index" :sorteio="sorteio"></Bicho>
          </div>

          <div class="form-group">
            <label>Soma:</label>
            <input type="number" class="form-control" v-model="sorteio.soma"
              readonly>
          </div>
          <br>
        </div>

        <div v-else class="form-group">
          <label>Resultados:</label>
          <div v-for="(item, index) in sorteio.resultados" :key="index">
            <Loto :id="index" :sorteio="sorteio"></Loto>
          </div>
          <br>
        </div>

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
import http from "../http-common";
import DatePicker from "vue2-datepicker";
import Bicho from "./Bicho.vue";
import Loto from "./Loto.vue";

export default {
  name: "novo",
  components: { DatePicker, Bicho, Loto },
  props: ["loteria"],
  data() {
    return {
      sorteio: {
        id: 0,
        soma: 0,
        loteria: "",
        horario: "",
        data: "",
        resultados: []
      },
      submitted: false,
      lang: "pt-br"
    };
  },
  methods: {
    /* eslint-disable no-console */
    loteriaType(loteria) {
      if (loteria < 2)
        this.sorteio.resultados = [
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          },
          {
            valor: 0,
            animal: ""
          }
        ];
      else
        this.sorteio.resultados = [
          {
            valor: 0
          },
          {
            valor: 0
          },
          {
            valor: 0
          },
          {
            valor: 0
          },
          {
            valor: 0
          }
        ];
    },
    getSoma() {
      this.sorteio.soma = (
        this.sorteio.resultados[1].valor +
        this.sorteio.resultados[2].valor +
        this.sorteio.resultados[3].valor +
        this.sorteio.resultados[4].valor +
        this.sorteio.resultados[5].valor
      );
    },
    saveSorteio() {
      var data = {
        loteria: this.sorteio.loteria,
        horario: this.sorteio.horario,
        data: this.sorteio.data,
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
