$(document).ready(function () {
//populate the modal
    $(this).on("click", "#editButton", function () {
        var tr = $(this).closest("tr");
        var id = $(tr).find("td.id").html();
        var modal = $('#myModal');
        modal.modal();
        $.ajax({
            url: "vehicleEdit",
            data: {
                id: id
            },
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Edit");
                $('input#fuelconsumption, input#carrying, input#wagonvolume').bind('keyup paste', function(){
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
            url: "vehicleAdd",
            success: function (answer) {
                modal.find(".modal-body").html(answer)
                $("#exampleModalLabel").text("Add");
                $('input#fuelconsumption, input#carrying, input#wagonvolume').bind('keyup paste', function(){
                    this.value = this.value.replace(/[^0-9]/g, '');
                });
                $('#myForm').submit(function (e) {
                    e.preventDefault();
                    if (
                        modal.find("input#fuelconsumption").val() === "" ||
                        modal.find("input#carrying").val() === "" ||
                        modal.find("input#wagonvolume").val() === ""
                    ) {
                        $("input#fuelconsumption").attr({"class": "is-invalid form-control"});
                        $("input#carrying").attr({"class": "is-invalid form-control"});
                        $("input#wagonvolume").attr({"class": "is-invalid form-control"});
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
                url: "vehicleDelete",
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