class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
    }

    increase(number) {
        this.innerLength += number;
    }

    decrease(number) {
        this.innerLength -= number;

        if (this.innerLength < 0) {
            this.innerLength = 0
        }
    }

    toString() {
        if (this.innerLength == 0) {
            return '...';
        }

        if (this.innerString.length > this.innerLength) {
            return `${this.innerString.slice(0, this.innerLength - this.innerString.length)}...`;
        }

        return this.innerString;
    }
}