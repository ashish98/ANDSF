// Taken from jquery UI Combobox Example
( function($) {
	$.widget( "ui.combobox", {
		options: {
			icon:  false
		},
		_create: function() {
			var self = this;
			var select = this.element.hide(),
				selected = select.children( ":selected" ),
				value = selected.val() ? selected.text() : "";
			select.focus()
			var input = $( "<input>" )
				.insertAfter( select )
				.val( value )
				.autocomplete({
					delay: 0,
					minLength: 0,
					source: function( request, response ) {
						var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
						response( select.children( "option" ).map(function() {
							var text = $( this ).text();
							if ( this.value && ( !request.term || matcher.test(text) ) ) {
								return {
									label: text.replace(
										new RegExp(
											"(?![^&;]+;)(?!<[^<>]*)(" +
											$.ui.autocomplete.escapeRegex(request.term) +
											")(?![^<>]*>)(?![^&;]+;)", "gi"
										), "<strong>$1</strong>" ),
									value: text,
									option: this
								};
						}
						}) );
					},
					focus: function( event, ui ) {
						self._trigger( "focus", event, { item: ui.item } )
						event.ui = ui;
						if(self.options.onfocustopics ) {
							$.each(self.options.onfocustopics .split(','), function(i, fts) {
								select.publish(fts, { item: ui.item }, event);
							});
						}
					},
					select: function( event, ui ) {
						ui.item.option.selected = true;
						self._trigger( "select", event, { item: ui.item } )
						event.ui = ui;
						if(self.options.onselecttopics) {
							$.each(self.options.onselecttopics.split(','), function(i, sts) {
								select.publish(sts, { item: ui.item }, event);
							});
						}
					},
					change: function( event, ui ) {
						if ( !ui.item ) {
							var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( $(this).val() ) + "$", "i" ),
								valid = false;
							select.children( "option" ).each(function() {
								if ( this.value.match( matcher ) ) {
									this.selected = valid = true;
									return false;
								}
							});
							if ( !valid ) {
								// remove invalid value, as it didn't match anything
								$( this ).val( "" );
								select.val( "" );
								return false;
							}
						}
						self._trigger( "change", event, { item: ui.item } );
						event.ui = ui;
						if(self.options.oncha) {
							$.each(self.options.oncha.split(','), function(i, cts) {
								select.publish(cts, { item: ui.item }, event);
							});
						}
					}
				})
				.addClass( "ui-widget ui-widget-content ui-corner-left" );

				input.data( "autocomplete" )._renderItem = function( ul, item ) {
					return $( "<li></li>" )
						.data( "item.autocomplete", item )
						.append( "<a>" + item.label + "</a>" )
						.appendTo( ul );
				};

				if(self.options.icon === true) {
					var height = input.outerHeight();
					var button = $( "<button type='button'>&nbsp;</button>" )
					.attr( "tabIndex", -1 )
					.attr( "title", "Show All Items" )
					.button({
						icons: {
							primary: "ui-icon-triangle-1-s"
						},
						text: false
					})
					.css( "marginLeft", "-1px" )
					.css( "width", height )
					.css( "height", height )
					.insertAfter( input )
					.removeClass( "ui-corner-all" )
					.addClass( "ui-corner-right ui-button-icon" )
					.click(function(e) {
						e.preventDefault();
						// close if already visible
						if ( input.autocomplete( "widget" ).is( ":visible" ) ) {
							input.autocomplete( "close" );
							return;
						}

						// pass empty string as value to search for, displaying all results
						input.autocomplete( "search", "" );
						input.focus();
					});

					button.find(".ui-button-icon-only .ui-button-text").css( "padding", "0.35em" );
					button.css( "margin", 0 ).css( "padding", "0.48em 0 0.47em 0.45em;" );;
					button.position({
						of: input,
						my: "left center" ,
						at: "right center" ,
						offset: "0 0"
					});
				}
		}
	});
})(jQuery);
