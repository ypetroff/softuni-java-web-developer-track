class Hex {
    constructor(number) {
        this.value = Number(number);
    }

    valueOf() {
        return this.value;
    }

    toString() {
        return `0x${(this.value.toString(16)).toUpperCase()}`;
    }

    plus(number) {
        return new Hex(this.value + Number(number.valueOf()));
    }

    minus(number) {
        return new Hex(this.value - Number(number.valueOf()));
    }

    parse(string) {
        return parseInt(string, 16);
    }
}
