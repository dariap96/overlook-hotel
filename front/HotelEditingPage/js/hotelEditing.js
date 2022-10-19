function changeFloors(elem) {
    console.log(elem)
}

function changeRoomsCount(elem) {
    console.log(elem)

    remove()
}

function vipStatusChanged(elem) {
    console.log(elem)
    console.log(elem.checked)
}

function priceChanged(elem) {
    console.log(elem)
}

function personCountChanged(elem) {
    console.log(elem)
}

function floorChanged(elem) {
    console.log(elem)
}

function fetchHotelInfo() {
    $('#count-of-floors').val('3')
    $('#count-of-rooms').val('3')
}

function fetchRooms() {
    makeRoomSection(1, true, 100, 1, 1)
    makeRoomSection(2, false, 200, 4, 2)
    makeRoomSection(3, true, 300, 2, 1)
}

function makeRoomSection(roomNumber, isVip, price, numberOfPeople, floor) {
    let section = $(`
    <div class="section">
        <div class="inner-section">
            Номер: <input type="text" disabled class="input" autofocus="false" required="false"
                placeholder="0" value="${roomNumber}" style="margin: 0 5px ;" />
        </div>
        <div class="inner-section">
            Статус VIP: <input type="checkbox" class="cbx" id="cbx${roomNumber}" onchange="vipStatusChanged(this)" data="${roomNumber}""
                style="display:none" />
            <label for="cbx${roomNumber}" style="margin: 0 5px;" class="toggle"><span></span></label>
        </div>
        <div class="inner-section">
            Цена: <input type="text" class="input" autofocus="false" required="false" placeholder="0"
                style="margin: 0 5px ;" value=${price} onfocusout="priceChanged(this)" data="${roomNumber}"" />
        </div>
        <div class="inner-section">
            Количество человек: <input type="text" class="input" autofocus="false" required="false" placeholder="0"
                style="margin: 0 5px ;" value=${numberOfPeople} onfocusout="personCountChanged(this)" data="${roomNumber}"" />
        </div>
        <div class="inner-section">
            Этаж: <input type="text" class="input" autofocus="false" required="false" placeholder="0"
                style="margin: 0 5px ;" value=${floor} onfocusout="floorChanged(this)" data="${roomNumber}"" />
        </div>
    </div>
    `).appendTo($('#rooms-sections'))

    $(`#cbx${roomNumber}`).prop('checked', isVip)
}

function reload() {
    $('#rooms-sections').empty()
}
