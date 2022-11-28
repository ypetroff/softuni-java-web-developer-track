class SmartHike {
  constructor(username) {
    this.username = username;
    this.goals = {}; // peakName: 100
    this.listOfHikes = [];
    this.resources = 100;
  }

  addGoal(peak, altitude) {
    if (this.goals.hasOwnProperty(peak)) {
      return `${peak} has already been added to your goals`;
    }

    this.goals[peak] = altitude;
    return `You have successfully added a new goal - ${peak}`;
  }
  // hard or easy
  hike(peak, time, difficultyLevel) {
    if (!this.goals.hasOwnProperty(peak)) {
      throw new Error(`${peak} is not in your current goals`);
    }

    if (this.resources <= 0) {
      throw new Error("You don't have enough resources to start the hike");
    }

    const energyNeeded = time * 10;

    if (energyNeeded > this.resources) {
      return "You don't have enough resources to complete the hike";
    }

    this.resources -= energyNeeded;

    const hike = { peak, time, difficultyLevel };
    this.listOfHikes.push(hike);
    return `You hiked ${peak} peak for ${time} hours and you have ${this.resources}% resources left`;
  }

  rest(time) {
    this.resources = Math.min(100, this.resources + time * 10);

    if (this.resources === 100) {
      return "Your resources are fully recharged. Time for hiking!";
    }

    return `You have rested for ${time} hours and gained ${
      time * 10
    }% resources`; //check if ok
  }
  
  showRecord(criteria) {
    if (this.listOfHikes.length === 0) {
      return `${this.username} has not done any hiking yet`;
    }

    let result = [];
    switch (criteria) {
      case "all":
        const line1 = "All hiking records:";
        const line2 = this.listOfHikes
        .map((x) => `${this.username} hiked ${x.peak} for ${x.time} hours`)
        .join('\n');
        result.push(line1);
        result.push(line2);
        return result.join('\n');
        break;
      case "hard":
        const sortedHard = this.listOfHikes
        .filter((x) => x.difficultyLevel === criteria)
        .sort((a, b) => a.time - b.time);

        if(sortedHard.length < 1) {
            return `${this.username} has not done any ${criteria} hiking yet`
        }

        const currentHard = sortedHard[0];
        return `${this.username}'s best ${criteria} hike is ${currentHard.peak} peak, for ${currentHard.time} hours`
        break;
      case "easy":
        const sorted = this.listOfHikes
        .filter((x) => x.difficultyLevel === criteria)
        .sort((a, b) => a.time - b.time);

        if(sorted.length < 1) {
            return `${this.username} has not done any ${criteria} hiking yet`
        }

        const current = sorted[0];
        return `${this.username}'s best ${criteria} hike is ${current.peak} peak, for ${current.time} hours`
        break;
    }
  }
}

const user = new SmartHike('Vili');
console.log(user.addGoal('Musala', 2925));
console.log(user.addGoal('Rui', 1706));
console.log(user.hike('Musala', 8, 'hard'));
console.log(user.hike('Rui', 3, 'easy'));
console.log(user.hike('Everest', 12, 'hard'));







