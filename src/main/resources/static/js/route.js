$(document).ready(function () {
//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "routeEdit",
            data: {
                id: id
            },
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Edit");
                $('input#distance').bind('keyup paste', function(){
                    this.value = this.value.replace(/[^0-9]/g, '');
                });
            }
        })
    });
//populate the modal
// add button
    $(this).on("click", "#addButton", function () {
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "routeAdd",
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Add");
                $('input#distance').bind('keyup paste', function(){
                    this.value = this.value.replace(/[^0-9]/g, '');
                });
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    if (
                        modal.find("input#startpoint").val() === "" ||
                        modal.find("input#endpoint").val() === "" ||
                        modal.find("input#distance").val() === ""
                    ) {
                        $("input#startpoint").attr({"class": "is-invalid form-control"});
                        $("input#endpoint").attr({"class": "is-invalid form-control"});
                        $("input#distance").attr({"class": "is-invalid form-control"});
                        return false;
                    }
                    $.ajax({
                        method: "POST",
                        data: $('#myForm').serialize(),
                        success: function () {
                            location.reload();
                        }
                    })
                    // return false;
                });
            }
        })
    });
//add button

//delete button
    $(this).on("click", "#deleteButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        if (confirm("Delete this entry?")) {
            $.ajax({
                url: "routeDelete",
                data: {
                    id: id
                },
                success: function () {
                    location.reload();
                }
            });
        }

    });
//delete button
})