class Person {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    get fullName() {
        return `${this.firstName} ${this.lastName}`;
    }

    set fullName(value) {
        let [firstName, lastName] = value.split(' ');

        if (firstName && lastName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }
    }
}