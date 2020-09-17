$(function () {
    $('.del').mouseleave(function () {
        $(this).children("button").css("background-color","red");
    }).mouseenter(function () {
        $(this).children("button").css("background-color","deepskyblue");
    }).mousedown(function () {
        alert("确认？")
    })
    $('.update').mouseleave(function () {
        $(this).children("button").css("background-color","deepskyblue");
    }).mouseenter(function () {
        $(this).children("button").css("background-color","red");
    }).mousedown(function () {

    })
})