const myMixin = {
    data() {
        return {
            id: 13,
        };
    },
    methods: {
        logMessage() {
            console.log(this.id);
        },
    },
};

export default myMixin;
