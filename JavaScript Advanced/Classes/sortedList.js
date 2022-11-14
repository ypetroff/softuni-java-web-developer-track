class List {
    constructor() {
        this.numbers = [];
        this.size = 0;
    }

    add(number) {
        this.numbers.push(number);
        this.numbers.sort((a, b) => a - b);
        this.size++;
    }

    remove(index) {
        if (index >= 0 && index < this.numbers.length) {
            this.numbers.splice(index, 1);
            this.size--;
        }
    }

    get(index) {
        if (index >= 0 && index < this.numbers.length) {
            return this.numbers[index];
        }
    }
}
