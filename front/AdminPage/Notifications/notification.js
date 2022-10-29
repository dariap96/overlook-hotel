function makeNotification(name, room, message) {
    let section = $(`
    <section>
    <p class="post_info">
        <span class="label_post">
            От кого: 
            <span class="post_id">${name}</span>
        </span>
        <span class="label_user_id">
            Из комнаты №: 
            <span class="user_id">${room}</span>
        </span>
    </p>
    <p class="text_post">
        ${message}
    </p>
    </section>
    `).appendTo($('#main'))
}
