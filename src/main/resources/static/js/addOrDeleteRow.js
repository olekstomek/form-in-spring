$(document).ready(function() {

    $("#idShippingAddressAdd").click(function() {
        $('#tableShippingAddress').append($('<tr>')
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.street}"/></td>').append(" "))
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.zip}"/></td>').append(" "))
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.city}"/></td>').append(" "))
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.state}"/></td>').append(" "))
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.country}"/></td></tr>').append(" "))
          )
    })
    $('#idShippingAddressRemoveOne').click(function() {
        $('#tableShippingAddress tr:last').remove();
    })

    $('#idShippingAddressRemoveAll').click(function() {
        $('#tableShippingAddress tbody:last > tr:not(:first)').remove();
    })

    $("#idContactAdd").click(function() {
        $('#tableContacts').append($('<tr>')
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.name}"/></td>').append(" "))
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.phone}"/></td>').append(" "))
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.email}"/></td>').append(" "))
            .append($('<td><input class="form-control" type="text" th:field="*{shippingAddress.fax}"/></td></tr>').append(" "))
          )
    })

    $('#idContactRemoveOne').click(function() {
        $('#tableContacts tr:last').remove();
    })

    $('#idContactRemoveAll').click(function() {
        $('#tableContacts tbody:last > tr:not(:first)').remove();
    })
})