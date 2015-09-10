
(function($) {
 
	$.fn.collapsibleCheckboxTree = function(initStat, options, collapseimage, expandimage) {
		var defaults = {
			checkParents : false, // When checking a box, all parents are checked
			checkChildren : true, // When checking a box, all children are checked
			uncheckChildren : true, // When unchecking a box, all children are unchecked
			initialState : initStat // Options - 'expand' (fully expanded), 'collapse' (fully collapsed) or default
		};
		
		if(collapseimage!=null){
			collapseimage = "<img src='"+collapseimage+"' width=16px height=16px/>";
		}else{
			collapseimage = '+';
		}
		if(expandimage!=null){
			expandimage = "<img src='"+expandimage+"' width=16px height=16px/>";
		}else{
			expandimage = "-";
		}
		var options = $.extend(defaults, options); 
		this.each(function() {
						   
			var $root = this;
					   
			// Add button
			var elementExpandButton= document.getElementById("expand");
			var elementCollapseButton= document.getElementById("collapse");
			
			if(elementExpandButton==null && elementCollapseButton==null){
			$(this).before('<button id="expand">Expand All</button>&nbsp;<button id="collapse">Collapse All</button>');
			}

			// Hide all except top level
			$("ul", $(this)).addClass('hide');
			// Check parents if necessary
			if (defaults.checkParents) {
				$("input:checked").parents("li").find("input[type='checkbox']:first").attr('checked', true);
				alert($("input:checked").parents("li"));
			}
			// Check children if necessary
			if (defaults.checkChildren) {
				$("input:checked").parent("li").find("input[type='checkbox']").attr('checked', true);
			}
			// Show checked and immediate children of checked
			$("li:has(input:checked) > ul", $(this)).removeClass('hide');
			// Add tree links
			$("li", $(this)).prepend('<span>&nbsp;</span>');
			$("li:has(> ul:not(.hide)) > span", $(this)).addClass('expanded').html(expandimage);
			$("li:has(> ul.hide) > span", $(this)).addClass('collapsed').html(collapseimage);
			
			// Checkbox function
			$("input[type='checkbox']", $(this)).click(function(){
				
				// If checking ...
				if ($(this).is(":checked")) {
					
					// Show immediate children  of checked
					$("> ul", $(this).parent("li")).removeClass('hide');
					// Update the tree
					$("> span.collapsed", $(this).parent("li")).removeClass("collapsed").addClass("expanded").html(expandimage);
					
					// Check parents if necessary
					if (defaults.checkParents) {
						$(this).parents("li").find("input[type='checkbox']:first").attr('checked', true);
					}
					
					// Check children if necessary
					if (defaults.checkChildren) {
						$(this).parent("li").find("input[type='checkbox']").attr('checked', true);
						// Show all children of checked
						$("ul", $(this).parent("li")).removeClass('hide');
						// Update the tree
						$("span.collapsed", $(this).parent("li")).removeClass("collapsed").addClass("expanded").html(expandimage);
					}
					
					
				// If unchecking...
				} else {
					
					// Uncheck children if necessary
					if (defaults.uncheckChildren) {
						$(this).parent("li").find("input[type='checkbox']").attr('checked', false);
						// Hide all children
						$("ul", $(this).parent("li")).addClass('hide');
						// Update the tree
						$("span.expanded", $(this).parent("li")).removeClass("expanded").addClass("collapsed").html(collapseimage);
					}
				}
				
			});
			
			// Tree function
			$("li:has(> ul) span", $(this)).click(function(){
					
				// If was previously collapsed...
				if ($(this).is(".collapsed")) {
					
					// ... then expand
					$("> ul", $(this).parent("li")).removeClass('hide');
					// ... and update the html
					$(this).removeClass("collapsed").addClass("expanded").html(expandimage);
				
				// If was previously expanded...
				} else if ($(this).is(".expanded")) {
					
					// ... then collapse
					$("> ul", $(this).parent("li")).addClass('hide');
					// and update the html
					$(this).removeClass("expanded").addClass("collapsed").html(collapseimage);
				}
				
			});
			
			// Button functions
			
			// Expand all
			$("#expand").click(function () {
				// Show all children			 
				$("ul", $root).removeClass('hide');
				// and update the html
				$("li:has(> ul) > span", $root).removeClass("collapsed").addClass("expanded").html(expandimage);
				return false;
			});
			// Collapse all
			$("#collapse").click(function () {
				// Hide all children				   
				$("ul", $root).addClass('hide');
				// and update the html
				$("li:has(> ul) > span", $root).removeClass("expanded").addClass("collapsed").html(collapseimage);
				return false;
			});
			// Wrap around checked boxes
			$("#default").click(function () {
				// Hide all except top level  
				$("ul", $root).addClass('hide');
				// Show checked and immediate children of checked
				$("li:has(input:checked) > ul", $root).removeClass('hide');
				// and update the html
				$("li:has(> ul:not(.hide)) > span", $root).removeClass('collapsed').addClass('expanded').html(expandimage);
				$("li:has(> ul.hide) > span", $root).removeClass('expanded').addClass('collapsed').html(collapseimage);
				return false;
			});
			
			switch(defaults.initialState) {
				case 'expand':
					$("#expand").trigger('click');
					break;
				case 'collapse':
					$("#collapse").trigger('click');
					break;
			}
			
		});
		
		return this;
		
	};
	
})(jQuery);
