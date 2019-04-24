<template>
  <div class="form-group">
    <label>Data:</label>
    <br>
    <date-picker
      v-model="sorteio.data"
      :lang="lang"
      :input-attr="{ 
              required: true 
            }"
      :width="300"
    ></date-picker>
  </div>
</template>

<script>
import DatePicker from "vue2-datepicker";

export default {
  name: "dataLancamento",
  props: ["sorteio"],
  components: { DatePicker },
  data() {
    return {
      lang: "pt-br"
    };
  }
};
</script>
