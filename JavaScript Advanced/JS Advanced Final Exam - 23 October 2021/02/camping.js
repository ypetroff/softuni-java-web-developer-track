class SummerCamp {
  constructor(organizer, location) {
    this.organizer = organizer;
    this.location = location;
    this.priceForTheCamp = {
      child: 150,
      student: 300,
      collegian: 500,
    };
    this.listOfParticipants = [];
  }

  registerParticipant(name, condition, money) {
    if (
      condition !== "child" &&
      condition !== "student" &&
      condition !== "collegian"
    ) {
      throw new Error("Unsuccessful registration at the camp.");
    }

    const index = this.listOfParticipants.findIndex((x) => x.name === name);

    if (index !== -1) {
      return `The ${name} is already registered at the camp.`;
    }

    if (this.priceForTheCamp[condition] > money) {
      return "The money is not enough to pay the stay at the camp.";
    }

    const participant = {
      name,
      condition,
      power: 100,
      wins: 0,
    };
    this.listOfParticipants.push(participant);
    return `The ${name} was successfully registered.`;
  }

  unregisterParticipant(name) {
    const index = this.listOfParticipants.findIndex((x) => x.name === name);

    if (index === -1) {
      throw new Error(`The ${name} is not registered in the camp.`);
    }
    this.listOfParticipants.splice(index, 1);
    return `The ${name} removed successfully.`;
  }

  timeToPlay(typeOfGame, participant1, participant2) {
    let index = this.verifyPlayer(participant1);

    const player1 = this.listOfParticipants[index];
    if (typeOfGame === "Battleship") {
      player1.power += 20;
      return `The ${player1.name} successfully completed the game ${typeOfGame}.`;
    } else if (typeOfGame === "WaterBalloonFights") {
      index = this.verifyPlayer(participant2);

      const player2 = this.listOfParticipants[index];

      if (player1.condition !== player2.condition) {
        throw new Error("Choose players with equal condition.");
      }

      let winner = "";
      const p1Power = player1.power;
      const p2Power = player2.power;

      if (p1Power > p2Power) {
        winner = player1.name;
        player1.wins += 1;
      } else if (p1Power < p2Power) {
        winner = player2.name;
        player2.wins += 1;
      }
      return winner.length > 0
      ? `The ${winner} is winner in the game ${typeOfGame}.`
      : 'There is no winner.';
    }
  }

  toString () {
    const line1 = `${this.organizer} will take ${this.listOfParticipants.length} participants on camping to ${this.location}`;
    const line2 =this.listOfParticipants.sort((a, b) => b.wins - a.wins)
    .map(x => `${x.name} - ${x.condition} - ${x.power} - ${x.wins}`)
    .join('\n');
    return [line1, line2].join('\n');
  }

  verifyPlayer(name) {
    const index = this.listOfParticipants.findIndex((x) => x.name === name);

    if (index === -1) {
      throw new Error("Invalid entered name/s.");
    }
    return index;
  }
}

const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
//console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));

console.log(summerCamp.toString());

