<template>
    <div class="DateInput">
        <table class="date">
            <tr>
                <td></td>
                <td>年</td>
            </tr>
            <tr>
                <td></td>
                <td>月</td>
            </tr>
            <tr>
                <td></td>
                <td>日</td>
            </tr>
        </table>
    </div>
</template>

<script>

  export default {
    name: "DateInput",
    components: {
      
    },

  } 

</script>


<style lang="less" scoped>
    .date {
        border: 1px solid black;
        font-family: Arial;   
        border-collapse: collapse;   
        width: 200px;
        height: 150px;
        }
    .date th, .date td {   
    border: 1px solid black;   
    }   
    .in {
        border: 1px solid black;   
        font-family: Arial;   
        border-collapse: collapse;   
        width: 100%;
        height: 100%;
        text-align: center;
    }


</style>