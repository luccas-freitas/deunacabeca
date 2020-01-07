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
            :format="momentFormat"
    />
  </div>
</template>

<script>
import DatePicker from "vue2-datepicker";
import moment from "moment"

export default {
  name: "dataLancamento",
  props: ["sorteio"],
  components: { DatePicker },
  data() {
    return {
      momentFormat: {
        stringify: (date) => {
          moment.locale("pt-br");
          return date ? moment(date).format('LL') : ''
        },
        parse: (value) => {
          return value ? moment(value, 'L').toDate() : null
        }
      },
      lang: "pt-br"
    };
  }
};
</script>
