$(document).ready(function () {
//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "manageEdit",
            data: {
                id: id
            },
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Edit");
            }
        })
    });
//populate the modal
// add button
    $(this).on("click", "#addButton", function () {
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "manageAdd",
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Add");
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    if (
                        modal.find("input#fullname").val() === "" ||
                        modal.find("input#phonenumber").val() === ""
                    ) {
                        $("input#fullname").attr({"class": "is-invalid form-control"});
                        $("input#phonenumber").attr({"class": "is-invalid form-control"});
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
                url: "manageDelete",
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