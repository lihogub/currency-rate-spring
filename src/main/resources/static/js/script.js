const statusTitle = document.getElementById("status-title")
const statusText = document.getElementById("status-text")
const statusGif = document.getElementById("status-gif")


$.ajax({
    url: "/api/currencies/base",
    success: function( result ) {
        $( "#base-currency" ).val(`${result.ticker} ${result.description}`);
    }
});

$.ajax({
    url: "/api/currencies",
    success: ( result ) => {

        $.each(result, function(key, currency){
            $("#target-currency")
                .append(`<option value="${currency.ticker}">${currency.ticker} ${currency.description}</option>`);
        });

    }
});

$('#target-currency').change(function() {
    fetchStatus(this.value)
});

function fetchStatus(targetCurrencyTicker) {
    $.ajax({
        url: `/api/status/${targetCurrencyTicker}`,
        success: (status) => updateStatusCard(status, targetCurrencyTicker)
    });
}

function updateStatusCard(status, targetCurrencyTicker) {
    const deltaPrice = status.deltaPrice.toFixed(2)
    const absDeltaPrice = Math.abs(deltaPrice)

    if (deltaPrice > 0.0) {
        $( "#status-title" )
            .text(`${targetCurrencyTicker} increased by ${absDeltaPrice}`)
            .css('color', 'green');
    } else if (deltaPrice < 0.0) {
        $( "#status-title" )
            .text(`${targetCurrencyTicker} decreased by ${absDeltaPrice}`)
            .css('color', 'red');
    } else {
        $( "#status-title" )
            .text(`${targetCurrencyTicker} is stable`)
            .css('color', 'black');
    }

    $( "#status-gif" )
        .attr("src", status.gifUrl);
}