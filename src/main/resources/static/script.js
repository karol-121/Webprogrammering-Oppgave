$(function () {
    getTickets(); //henter alle billetter fra serveren når nettsiden blir åpent.
});

function onTicketBuy() {

    //samle verdier fra input felter
    const attributes = [$("#film-option"), $("#ticket-amount"), $("#customer-name"), $("#customer-surname"), $("#customer-phone"), $("#customer-email")];

    //flagg som forteller om data fra formen er gyldig eller ikke
    let correctData = true;

    //gaa gjennom inputfelter og sjekke om de inneholder riktige data
    for (let data of attributes) {
        if (data.val() === "" || data.val() === null) { //dersom verdien fra input er tomt eller null (ugylidg)
            correctData = false;
            //formatere "feedback div" slik at bootstrap kan vise den som feilmelding
            data.next().attr("class", "invalid-feedback");
            data.next().text("Ugylding data! Feltet kan ikke være tom");
        }
    }


    if (correctData) {
        //lage bilett objekt med attributer hentet fra form
        const ticket  = {
            film : attributes[0].val(),
            amount : attributes[1].val(),
            name : attributes[2].val(),
            surname : attributes[3].val(),
            phone : attributes[4].val(),
            email : attributes[5].val()
        };

        //legge bilett til listen
        $.post("/registerTicket", ticket, function (data) {
            if (data) { //dersom svaret er true (biletten ble lagt inn)
                //reset form og slå av bootstrap sin "validering status"
                $("#form-ticket").trigger("reset").attr("class","needs-validation");

                //legg til bilett i eksisterne liste
                getTickets();
            } else {
                alert("noe gikk galt!");
            }
        });


    } else {
        //slå på bootstrap sin "validering status" som vil vise feilmeldingene i formen
        $("#form-ticket").attr("class","needs-validation was-validated");
    }


}

//funksjonen som henter og populerer tabellen med alle biletter som fantes på serveren
function getTickets() {
    $.get("/getTickets", function(data) {
        let tableContent = "";
        for (let t of data) {
            tableContent += "<tr><td>"+t.film+"</td><td>"+t.amount+"</td><td>"+t.name+"</td><td>"+t.surname+"</td><td>"+t.phone+"</td><td>"+t.email+"</td></tr>";
        }
        $("#ticket-registry").html(tableContent);
    });
}

//funksjonen som sender forespørsell til serveren om å slette biletter. Dersom forespørsellen blir vellykket, fjernes det informasjon fra tabellen
function removeTickets() {
    if (confirm("Er du sikkert på at du vil slette alle billetter?")) {
        $.get("/deleteTickets", function (data) {
            if (data) {
                $("#ticket-registry").html("");
            } else {
                alert("noe gikk galt!");
            }
        });

    }
}



