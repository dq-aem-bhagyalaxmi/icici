/**
 * Show/Hide dialog fields based on dropdown selection
 */
(function ($, $document) {
    // Log when script loads
    console.log("Show/hide dialog script loaded");
    
    // Function to initialize show/hide with delay to ensure DOM is ready
    function initializeShowHide() {
        console.log("Initializing show/hide functionality");
        
        // Use a longer delay to ensure elements are fully rendered
        setTimeout(function() {
            // Find the dropdown by its name
            var $dropdown = $("coral-select[name='./selectedOption']");
            console.log("Found dropdown:", $dropdown.length > 0);
            
            if ($dropdown.length === 0) {
                console.error("Dropdown not found!");
                return;
            }
            
            // Try multiple selectors to find the container - more aggressive approach
            var $targetContainer = $(".dynamic-fields");
            
            // If not found, try alternate selectors
            if ($targetContainer.length === 0) {
                $targetContainer = $("[class*='dynamic-fields']");
            }
            
            // If still not found, try to find it by its component type
            if ($targetContainer.length === 0) {
                $targetContainer = $("div.coral-Well").closest(".coral-Form-fieldwrapper");
            }
            
            // If still not found, try the parent that contains all the fields
            if ($targetContainer.length === 0) {
                $targetContainer = $(".showhide-title").closest(".coral-Form-fieldset");
            }
            
            console.log("Found target container:", $targetContainer.length > 0);
            
            if ($targetContainer.length === 0) {
                console.error("Target container not found - using direct field selection instead!");
                // Direct approach - just find the fields directly without the container
                directFieldToggle($dropdown);
                return;
            }
            
            // Find all fields
            var $titleField = $(".showhide-title").closest(".coral-Form-fieldwrapper");
            var $descriptionField = $(".showhide-description").closest(".coral-Form-fieldwrapper");
            var $imageField = $(".showhide-image").closest(".coral-Form-fieldwrapper");
            
            console.log("Fields found - Title:", $titleField.length > 0, 
                        "Description:", $descriptionField.length > 0, 
                        "Image:", $imageField.length > 0);
            
            // Function to update field visibility
            function updateFieldVisibility() {
                // Get the current value
                var selectedValue = $dropdown.val();
                console.log("Selected value:", selectedValue);
                
                // Hide all fields first
                $titleField.hide();
                $descriptionField.hide();
                $imageField.hide();
                
                // Show only the selected field
                if (selectedValue === "title") {
                    $titleField.show();
                } else if (selectedValue === "description") {
                    $descriptionField.show();
                } else if (selectedValue === "image") {
                    $imageField.show();
                }
                
                console.log("Field visibility updated");
            }
            
            // Bind change event
            $dropdown.off("change.showhide").on("change.showhide", function() {
                console.log("Dropdown change detected");
                updateFieldVisibility();
            });
            
            // For Coral UI events
            $dropdown.off("coral-select:change").on("coral-select:change", function() {
                console.log("Coral select change detected");
                updateFieldVisibility();
            });
            
            // Run once on initialization
            updateFieldVisibility();
            console.log("Initial field visibility set");
            
            $dropdown.data("show-hide-initialized", true);
        }, 100); // Increased delay to 1000ms to ensure DOM is ready
    }
    
    // Alternative approach if container isn't found
    function directFieldToggle($dropdown) {
        // Find all fields directly
        var $titleField = $("[name='./title']").closest(".coral-Form-fieldwrapper");
        var $descriptionField = $("[name='./description']").closest(".coral-Form-fieldwrapper");
        var $imageField = $("[name='./imagePath']").closest(".coral-Form-fieldwrapper");
        
        console.log("Direct field approach - Fields found - Title:", $titleField.length > 0, 
                    "Description:", $descriptionField.length > 0, 
                    "Image:", $imageField.length > 0);
        
        if ($titleField.length === 0 && $descriptionField.length === 0 && $imageField.length === 0) {
            console.error("Could not find any fields directly either!");
            return;
        }
        
        // Function to update field visibility
        function updateFieldVisibility() {
            // Get the current value
            var selectedValue = $dropdown.val();
            console.log("Selected value:", selectedValue);
            
            // Hide all fields first
            $titleField.hide();
            $descriptionField.hide();
            $imageField.hide();
            
            // Show only the selected field
            if (selectedValue === "title") {
                $titleField.show();
            } else if (selectedValue === "description") {
                $descriptionField.show();
            } else if (selectedValue === "image") {
                $imageField.show();
            }
            
            console.log("Field visibility updated (direct approach)");
        }
        
        // Bind change event
        $dropdown.off("change.showhide").on("change.showhide", function() {
            console.log("Dropdown change detected");
            updateFieldVisibility();
        });
        
        // For Coral UI events
        $dropdown.off("coral-select:change").on("coral-select:change", function() {
            console.log("Coral select change detected");
            updateFieldVisibility();
        });
        
        // Run once on initialization
        updateFieldVisibility();
        console.log("Initial field visibility set (direct approach)");
        
        $dropdown.data("show-hide-initialized", true);
    }
    
    // Initialize on both events to be safe
    $document.on("foundation-contentloaded", function() {
        console.log("Foundation content loaded event triggered");
        initializeShowHide();
    });
    
    $document.on("dialog-ready", function() {
        console.log("Dialog ready event triggered");
        initializeShowHide();
    });
    
    // Also try to initialize immediately in case events have already fired
    initializeShowHide();
    
})(Granite.$, $(document));