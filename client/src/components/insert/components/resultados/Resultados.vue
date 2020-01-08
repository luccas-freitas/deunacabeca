<template>
  <div class="form-group">
    <div v-if="sorteio.loteria < 3" class="form-group">
      <label>Resultados:</label>
      <div v-for="(item, index) in sorteio.resultados" :key="index">
        <label v-if="index+1 < 6">{{ index+1 }}º Prêmio:</label>
        <label v-else>7º Prêmio:</label>
        <Bicho :id="index" :sorteio="sorteio"/>
      </div>

      <div class="form-group">
        <label>Soma:</label>
        <input type="number" class="form-control" v-model="sorteio.soma" readonly>
      </div>
      <br>
    </div>

    <div v-else class="form-group">
      <label>Resultados:</label>
      <div v-for="(item, index) in sorteio.resultados" :key="index">
        <Loto :id="index" :sorteio="sorteio"/>
      </div>
      <div class="form-group">
        <label>Concurso:</label>
        <PatternInput
                class="form-control"
                :regExp="setting.regExp"
                :replacement="setting.replacement"
                v-model="sorteio.concurso"
                :maxlength="4"
                required
        />
      </div>
      <br>
    </div>
  </div>
</template>

<script>
import Bicho from "./Bicho.vue";
import Loto from "./Loto.vue";
import PatternInput from "vue-pattern-input";

export default {
  name: "resultados",
  props: ["sorteio"],
  components: { Bicho, Loto, PatternInput },
  data() {
    return {
      setting: {
        regExp: /^[0\D]*|\D*/g,
        replacement: ""
      }
    };
  }
};
</script>
