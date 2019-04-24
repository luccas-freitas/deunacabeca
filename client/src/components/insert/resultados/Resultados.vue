<template>
  <div class="form-group">
    <div v-if="sorteio.loteria < 3" class="form-group">
      <label>Resultados:</label>
      <div v-for="(item, index) in sorteio.resultados" :key="index">
        <Bicho :id="index" :sorteio="sorteio"></Bicho>
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
        <Loto :id="index" :sorteio="sorteio"></Loto>
      </div>
      <br>
    </div>
  </div>
</template>

<script>
import Bicho from "./Bicho.vue";
import Loto from "./Loto.vue";

export default {
  name: "resultados",
  props: ["sorteio"],
  components: { Bicho, Loto }
};
</script>
