(function ($, Coral) {
    $(document).on("foundation-contentloaded", function () {
        function toggleFields(selectionValue) {
            $(".coral-Form-field.selection-dependent").closest(".coral-Form-fieldwrapper").hide();

            if (selectionValue === "text") {
                $(".field-text").closest(".coral-Form-fieldwrapper").show();
            } else if (selectionValue === "richtext") {
                $(".field-richtext").closest(".coral-Form-fieldwrapper").show();
            } else if (selectionValue === "image") {
                $(".field-image").closest(".coral-Form-fieldwrapper").show();
            }
        }

        const selectionDropdown = $("select[name='./selectionType']");
        toggleFields(selectionDropdown.val());

        selectionDropdown.on("change", function () {
            toggleFields($(this).val());
        });
    });
})(jQuery, Coral);
