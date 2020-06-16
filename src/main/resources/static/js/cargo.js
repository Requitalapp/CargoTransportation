$(document).ready(function () {
//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "cargoEdit",
            data: {
                id: id
            },
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Edit");
                $('input#cargocost, input#volume, input#weight').bind('keyup paste', function(){
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
            url: "cargoAdd",
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Add");
                $('input#cargocost, input#volume, input#weight').bind('keyup paste', function(){
                    this.value = this.value.replace(/[^0-9]/g, '');
                });
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    if (
                        modal.find("input#cargocost").val() === "" ||
                        modal.find("input#volume").val() === "" ||
                        modal.find("input#weight").val() === ""
                    ) {
                        $("input#cargocost").attr({"class": "is-invalid form-control"});
                        $("input#volume").attr({"class": "is-invalid form-control"});
                        $("input#weight").attr({"class": "is-invalid form-control"});
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
                url: "cargoDelete",
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