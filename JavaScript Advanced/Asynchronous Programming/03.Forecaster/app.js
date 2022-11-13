function attachEvents() {
    const locationElement = document.getElementById("location");
    const submitBtn = document.getElementById("submit");
    const forecastElement = document.getElementById("forecast");
    const currentWeatherElement =  document.getElementById('current');
    const upcomingWeatherElement = document.getElementById('upcoming');

    submitBtn.addEventListener("click", getLocation);

    async function getLocation() {
        currentWeatherElement.innerHTML = '';
        upcomingWeatherElement.innerHTML = '';
        forecastElement.style.display = "block";

        try {
            const baseURL = "http://localhost:3030/jsonstore/forecaster/locations";

            const result = await fetch(baseURL);
            const data = await result.json();
            const id = [...data].find(
                (x) => x.name === locationElement.value
            );
               
            const currentConditionURL = `http://localhost:3030/jsonstore/forecaster/today/${id.code}`;
            const ccRes = await fetch(currentConditionURL);
            const ccData = await ccRes.json();
            
            const forecastFor3DaysURL = `http://localhost:3030/jsonstore/forecaster/upcoming/${id.code}`;
            const d3Res = await fetch(forecastFor3DaysURL);
            const d3Data = await d3Res.json();

           
            const divForecasts = elementCreator("div", ["forecasts"], "");


            const symbolCurrent = conditionVisualiser(ccData.forecast.condition);
            

            const conditionSymbolElement = elementCreator(
                "span",
                ["condition", "symbol"],
                symbolCurrent
            );
            divForecasts.appendChild(conditionSymbolElement);
        

            const spanConditionElement = elementCreator("span", ["condition"], "");
            

            const spanLocation = elementCreator(
                "span",
                ["forecast-data"],
                ccData.name
            );
            spanConditionElement.appendChild(spanLocation);


            const degreeVisual = '°'; // °


            const spanDegrees = elementCreator(
                "span",
                ["forecast-data"],
                `${ccData.forecast.low}${degreeVisual}/${ccData.forecast.high}${degreeVisual}`
            );
            spanConditionElement.appendChild(spanDegrees);
            

            const spanConditionText = elementCreator('span', ["forecast-data"], ccData.forecast.condition);
            spanConditionElement.appendChild(spanConditionText);
            divForecasts.appendChild(spanConditionElement);
            currentWeatherElement.appendChild(divForecasts);

           const forecastInfo = elementCreator('span', ['forecast-info'], '');
          

           [...d3Data.forecast].map(({low, high, condition}) => {
            const upcoming = elementCreator('span', ['upcoming'], '');
            const symbol = conditionVisualiser(condition);
            const vis = elementCreator('span', ['symbol'], symbol);
            upcoming.appendChild(vis);
            const temp = elementCreator('span', ["forecast-data"],  `${low}${degreeVisual}/${high}${degreeVisual}`);
            upcoming.appendChild(temp);
            const conditi0n = elementCreator('span', ["forecast-data"], condition);
            upcoming.appendChild(conditi0n);
           

            return upcoming;
           }).forEach((x) => forecastInfo.appendChild(x));
              
           upcomingWeatherElement.appendChild(forecastInfo);
        } catch (error) {
            
            forecastElement.textContent = "Error";
        }
    }

    function conditionVisualiser(condition) {
        let visual = "";

        switch (condition) {
            case "Sunny":
                visual = '☀'; // ☀
                break;
            case "Partly sunny":
                visual = '⛅'; // ⛅
                break;
            case "Overcast":
                visual = '☁'; // ☁
                break;
            case "Rain":
                visual = '☂'; // ☂
                break;
        }
        return visual;
    }

    function elementCreator(type, clazz, content) {
        const element = document.createElement(type);
        [...clazz].forEach((x) => element.classList.add(x));
            element.textContent = content;
        return element;
    }
}

attachEvents();
