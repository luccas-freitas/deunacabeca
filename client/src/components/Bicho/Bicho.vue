<template>
    <span>
        <slot> {{ animal }} </slot>
    </span>
</template>

<script>
export default {
    name: "Bicho",
    props: ["resultado"],
    data() {
        return {
            animal: "teste " + this.resultado
        }
    },
    methods: {
        /* eslint-disable no-console */
        getGrupo() {
            this.animal = "teste"
            /*var res = parseInt(this.resultado);
            if(res % 100 >= 1 && res % 100 <= 4)
                this.animal = "Avestruz";
            if(res % 100 >= 5 && res % 100 <= 8)
                this.animal = "Aguia";
            if(res % 100 >= 9 && res % 100 <= 12)
                this.animal = "Burro";
            if(res % 100 >= 13 && res % 100 <= 16)
                this.animal = "Borboleta";
            if(res % 100 >= 17 && res % 100 <= 20)
                this.animal = "Cachorro";
            if(res % 100 >= 21 && res % 100 <= 24)
                this.animal = "Cabra";
            if(res % 100 >= 25 && res % 100 <= 28)
                this.animal = "Carneiro";
            if(res % 100 >= 29 && res % 100 <= 32)
                this.animal = "Camelo";
            if(res % 100 >= 33 && res % 100 <= 36)
                this.animal = "Cobra";
            if(res % 100 >= 37 && res % 100 <= 40)
                this.animal = "Coelho";
            if(res % 100 >= 41 && res % 100 <= 44)
                this.animal = "Cavalo";
            if(res % 100 >= 45 && res % 100 <= 48)
                this.animal = "Elefante";
            if(res % 100 >= 49 && res % 100 <= 52)
                this.animal = "Galo";
            if(res % 100 >= 53 && res % 100 <= 56)
                this.animal = "Gato";
            if(res % 100 >= 57 && res % 100 <= 60)
                this.animal = "Jacare";
            if(res % 100 >= 61 && res % 100 <= 64)
                this.animal = "Leao";
            if(res % 100 >= 65 && res % 100 <= 68)
                this.animal = "Macaco";
            if(res % 100 >= 69 && res % 100 <= 72)
                this.animal = "Porco";
            if(res % 100 >= 73 && res % 100 <= 76)
                this.animal = "Pavao";
            if(res % 100 >= 77 && res % 100 <= 80)
                this.animal = "Peru";
            if(res % 100 >= 81 && res % 100 <= 84)
                this.animal = "Touro";
            if(res % 100 >= 85 && res % 100 <= 88)
                this.animal = "Tigre";
            if(res % 100 >= 89 && res % 100 <= 92)
                this.animal = "Urso";
            if(res % 100 >= 93 && res % 100 <= 96)
                this.animal = "Veado";
            if(res % 100 >= 97 || res % 100 == 0)
                this.animal = "Vaca";*/
        }
        /* eslint-enable no-console */
    }
}
</script>