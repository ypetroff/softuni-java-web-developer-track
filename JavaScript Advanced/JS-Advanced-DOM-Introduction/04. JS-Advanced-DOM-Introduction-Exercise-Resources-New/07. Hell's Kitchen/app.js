function solve() {
  document.querySelector("#btnSend").addEventListener("click", onClick);

  function onClick() {
    //["PizzaHut - Peter 500, George 300, Mark 800", "TheLake - Bob 1300, Joe 780, Jane 660"]

    let input = document.querySelector("#inputs textarea").value;
    let restaurantsAndTheirEmployees = JSON.parse(input);

    let restaurantsObj = [];

    for (let i = 0; i < restaurantsAndTheirEmployees.length; i++) {
      let [restaurant, ...employees] =
        restaurantsAndTheirEmployees[i].split(" - ");

      let listOfEmployeesAndTheirSalaries = employees[0].split(", ");

      let employeesObj = [];

      for (
        let index = 0;
        index < listOfEmployeesAndTheirSalaries.length;
        index++
      ) {
        let [name, salary] = listOfEmployeesAndTheirSalaries[index].split(" ");
        let currentEmployee = { name, salary: Number(salary) };
        employeesObj.push(currentEmployee);
      }

      if (!restaurantsObj.some((x) => x.name === restaurant)) {
        let currentRestaurant = {
          name: restaurant,
          restaurantEmployees: employeesObj,
          get avgSalary() {
            // debugger;
            return Number(
              this.restaurantEmployees
                .map((x) => x.salary)
                .reduce((acc, s) => acc + s, 0) /
                this.restaurantEmployees.length
            );
          },
          get bestSalary() {
            return Number(
              Math.max(...this.restaurantEmployees.map((x) => x.salary))
            );
          },
        };
        restaurantsObj.push(currentRestaurant);
      } else {
        let index = restaurantsObj.findIndex((x) => x.name === restaurant);
        restaurantsObj[index].restaurantEmployees.push(...employeesObj);
      }
    }
    let bestAvgSalary = Math.max(...restaurantsObj.map((x) => x.avgSalary));
    //debugger;
    let index = restaurantsObj.findIndex((x) => x.avgSalary === bestAvgSalary);
    let theBestRestaurant = restaurantsObj[index];
    document.querySelector("#bestRestaurant p").textContent = `Name: ${theBestRestaurant.name} Average Salary: ${theBestRestaurant.avgSalary.toFixed(2)} Best Salary: ${theBestRestaurant.bestSalary.toFixed(2)}`;
/// ^^^ selector could be #bestRestaurant > p | vvv the same below
    document.querySelector("#workers p").textContent =
      theBestRestaurant.restaurantEmployees
        .sort((a, b) => b.salary - a.salary)
        .map((x) => `Name: ${x.name} With Salary: ${x.salary}`)
        .join(" ");
  }
}
