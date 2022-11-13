async function getInfo() {
    const stopNameElement = document.getElementById('stopName');
    const listElement = document.getElementById('buses');
 

    const stopId = document.getElementById('stopId').value;
       

        try{
         
            const url = `http://localhost:3030/jsonstore/bus/businfo/${stopId}`;
            stopId.value = '';
            const res = await fetch(url);
            

            if(res.ok == false || res.status !== 200) {
                throw new Error ('Error!');
            }

            const data = await res.json();
            stopNameElement.textContent = data.name;

            
            Object.entries(data.buses).forEach(b => {
                const li = document.createElement('li');
                li.textContent = `Bus ${b[0]} arrives in ${b[1]} minutes`
                listElement.appendChild(li);
            })
            
        }catch(error) {
            stopNameElement.textContent = error;
        }
}
