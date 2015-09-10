/*!
 * jquery.grid.struts2.js
 *
 * Integration of jqGrid with struts 2
 *
 * Requires use of jquery.struts2.js
 *
 * Copyright (c) 2012 Johannes Geppert http://www.jgeppert.com
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 */

/*global jQuery, window  */
/*jslint evil: true */

(function($) {
	"use strict";

	/**
	 * Bind jqGrid to Struts2 Component
	 */
	$.struts2_jquery_grid = {

		lastselectedrow : '',
		navigatorButtons : function($elem, buttons, pager) {
			var self = this;
			$.each(buttons, function(name, options) {
				if(options.title) {
					if(options.title === "seperator"){
						$elem.jqGrid('navSeparatorAdd', pager);
					}
					else if (options.topic || options.onclick){
						var bopts = {};
						if(options.id) {
							bopts.id = options.id;
						}
						if(options.title) {
							bopts.title = options.title;
						}
						if(options.position) {
							bopts.position = options.position;
						}
						if(options.caption) {
							bopts.caption = options.caption;
						}
						else {
							bopts.caption = '';
						}
						if(options.icon) {
							bopts.buttonicon = options.icon;
						}
						else{
							bopts.buttonicon = "ui-icon-gear";
						}
						
						if(options.topic) {
							bopts.onClickButton = function() { 
								var params = {};
								params.grid = $elem;
	
								self.publishTopic($elem, options.topic, params);
							};
						}
						else if (options.onclick) {
							bopts.onClickButton = options.onclick;
						}
						
						$elem.jqGrid('navButtonAdd', pager, bopts); 
					}
				}
			});
		},
		parseGridParams : function($elem, o, params) {
			var self = this;
			if (o.onselectrowtopics || (o.editurl && o.editinline === true)) {
				params.onSelectRow = function(id, status) {
					var data = {},
						oneditbefor = null,
						onsuccess = null,
						onerror = null,
						onaftersave = null;
					
					data.id = id;
					data.status = status;
					data.grid = $elem;
	
					self.publishTopic($elem, o.onalw, data);
					$.struts2_jquery.publishTopic($elem, o.onselectrowtopics, data);
					if (o.editurl && o.editinline === true && o.navinline === false) {
						if (self.lastselectedrow !== '') {
							$elem.jqGrid('restoreRow',	self.lastselectedrow);
						}
						self.lastselectedrow = id;
	
						if (o.oneibefore) {
							oneditbefor = function() {
								self.publishTopic($elem, o.oneibefore, data);
							};
						}
						if (o.oneisuccess) {
							onsuccess = function(response) {
								var d = {};
								d.response = response;
								self.publishTopic($elem, o.oneisuccess, d);
								if(response.status >= 400) {
									return false;
								}
								else {
									return true;
								}
							};
						}
						if (o.oneierror) {
							onerror = function(rowid, response) {
								var d = {};
								d.rowid = rowid;
								d.response = response;
								self.publishTopic($elem, o.oneierror, d);
							};
						}
						if (o.oneisave) {
							onaftersave = function(rowid, response) {
								var d = {};
								d.rowid = rowid;
								d.response = response;
								self.publishTopic($elem, o.oneisave, d);
							};
						}
	
						//$elem.jqGrid('editRow', id, true);
						$elem.jqGrid('editRow', id, true, oneditbefor,
								onsuccess, null, null, onaftersave, onerror,
								null);
					}
				};
			}
	
			if (o.oncesuccess) {
				params.afterSaveCell = function(rowid, cellname, value, iRow, iCol) {
					var d = {};
					d.rowid = rowid;
					d.cellname = cellname;
					d.value = value;
					d.iRow = iRow;
					d.iCol = iCol;
					self.publishTopic($elem, o.oncesuccess, d);
				};
			}
	
			if (o.onceerror) {
				params.errorCell = function(response, status) {
					var d = {};
					d.response = response;
					d.status = status;
					self.publishTopic($elem, o.onceerror, d);
				};
			}
	
			if (o.onselectalltopics) {
				params.onSelectAll = function(ids, status) {
					var data = {};
					data.ids = ids;
					data.status = status;
					data.grid = $elem;
	
					self.publishTopic($elem, o.onalw, data);
					self.publishTopic($elem, o.onselectalltopics, data);
				};
			}
			if (o.onbef) {
				params.loadBeforeSend = function(xhr) {
	
					var orginal = {};
					orginal.xhr = xhr;
					orginal.proceed = true;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onbef, orginal);
					
					return orginal.proceed;
				};
			}
	
			if (o.onpagingtopics) {
				params.onPaging = function(pgButton) {
	
					var orginal = {};
					orginal.pgButton = pgButton;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onpagingtopics, orginal);
				};
			}
	
			if (o.onsortcoltopics) {
				params.onSortCol = function(index, iCol, sortorder) {
	
					var orginal = {};
					orginal.index = index;
					orginal.iCol = iCol;
					orginal.sortorder = sortorder;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onsortcoltopics, orginal);
				};
			}
	
			if (o.oncellselecttopics) {
				params.onCellSelect = function(rowid, iCol, cellcontent, e) {
	
					var orginal = {};
					orginal.rowid = rowid;
					orginal.iCol = iCol;
					orginal.cellcontent = cellcontent;
					orginal.e = e;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.oncellselecttopics, orginal);
				};
			}
			
			if (o.onclickgroup) {
				params.onClickGroup = function(groupid, collapsed ) {
	
					var orginal = {};
					orginal.groupid = groupid;
					orginal.collapsed = collapsed;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onclickgroup, orginal);
				};
			}
			
			if (o.ondblclickrow) {
				params.ondblClickRow = function(rowid, iRow, iCol, e) {
	
					var orginal = {};
					orginal.rowid = rowid;
					orginal.iRow = iRow;
					orginal.iCol = iCol;
					orginal.e = e;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.ondblclickrow, orginal);
				};
			}
			
			if (o.onrightclickrow) {
				params.onRightClickRow = function(rowid, iRow, iCol, e) {
	
					var orginal = {};
					orginal.rowid = rowid;
					orginal.iRow = iRow;
					orginal.iCol = iCol;
					orginal.e = e;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onrightclickrow, orginal);
				};
			}
	
			params.gridComplete = function() {

				var daos = o.draggableoptions,
				dao = window[daos],
				doos = o.droppableoptions,
				doo = window[doos],
				soos = o.sortableoptions,
				soo = window[soos],
				ros = o.resizableoptions,
				ro = window[ros],
				ddo = {},
				navparams = {},
				fpara = {};

				if(!$elem.data('_s2jg_init')) {
					$elem.data('_s2jg_init', true);
					if (o.draggable && o.droppable) {
						self.log('drag and drop for grid : ' + o.id);
						if (!self.loadAtOnce) {
							self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.draggable" + self.minSuffix + ".js", "js/base/jquery.ui.droppable" + self.minSuffix + ".js" ]);
						}
						

						if (!dao) {
							dao = eval("( " + daos + " )");
						} else {
							dao = {};
						}
						dao.drap = self.pubTops($elem, o.onalw, o.draggableondragtopics);
	
						if (!doo) {
							doo = eval("( " + doos + " )");
						} else {
							doo = {};
						}
						doo.activate = self.pubTops($elem, o.onalw, o.droppableonactivatetopics);
						doo.deactivate = self.pubTops($elem, o.onalw, o.droppableondeactivatetopics);
						doo.start = self.pubTops($elem, o.onalw, o.droppableonstarttopics);
						doo.stop = self.pubTops($elem, o.onalw, o.droppableonstoptopics);
	
						ddo.drag_opts = dao;
						ddo.drop_opts = doo;
						ddo.connectWith = o.connectWith;
						ddo.onstart = self.pubTops($elem, o.onalw, o.draggableonstarttopics);
						ddo.onstop = self.pubTops($elem, o.onalw, o.draggableonstoptopics);
						ddo.ondrop = self.pubTops($elem, o.onalw, o.droppableondroptopics);
						$elem.jqGrid('gridDnD', ddo);
					}
	
					
					if (o.sortableRows) {
						self.log('sortable rows for : ' + o.id);
						
						if (!soo) {
							soo = eval("( " + soos + " )");
						} else {
							soo = {};
						}
						soo.beforeStop = self.pubTops($elem, o.onalw, o.sortableonbeforestoptopics);
						soo.stop = self.pubTops($elem, o.onalw, o.sortableonstoptopics);
						soo.start = self.pubTops($elem, o.onalw, o.sortableonstarttopics);
						soo.sort = self.pubTops($elem, o.onalw, o.sortableonsorttopics);
						soo.activate = self.pubTops($elem, o.onalw, o.sortableonactivatetopics);
						soo.deactivate = self.pubTops($elem, o.onalw, o.sortableondeactivatetopics);
						soo.over = self.pubTops($elem, o.onalw, o.sortableonovertopics);
						soo.out = self.pubTops($elem, o.onalw, o.sortableonouttopics);
						soo.remove = self.pubTops($elem, o.onalw, o.sortableonremovetopics);
						soo.receive = self.pubTops($elem, o.onalw, o.sortableonreceivetopics);
						soo.change = self.pubTops($elem, o.onalw, o.sortableonchangetopics);
						soo.update = self.pubTops($elem, o.onalw, o.sortableonupdatetopics);
						$elem.jqGrid('sortableRows', soo);
					}
	
					if (o.navigator) {
						navparams.add = o.navigatoradd;
						navparams.del = o.navigatordel;
						navparams.edit = o.navigatoredit;
						navparams.refresh = o.navigatorrefresh;
						navparams.search = o.navigatorsearch;
						navparams.view = o.navigatorview;
						navparams.cloneToTop = o.cloneToTop;
						$elem.jqGrid('navGrid', self.escId(o.pager), navparams,
								o.navigatoreditoptions, o.navigatoraddoptions,
								o.navigatordeleteoptions, o.navigatorsearchoptions,
								o.navigatorviewoptions);
						
						if(o.editinline === true && o.navinline === true) {
							$elem.jqGrid('inlineNav',self.escId(o.pager));
						}
						if(o.navigatorextrabuttons) {
							self.navigatorButtons($elem, o.navigatorextrabuttons, self.escId(o.pager));
						}
					}
					if (o.filter) {
						if (o.filteroptions) {
							fpara = o.filteroptions;
						}
						$elem.jqGrid('filterToolbar', fpara);
					}
					if (o.frozen) {
						$elem.jqGrid('setFrozenColumns');
					}
					
					if (o.resizable) {
						if (!self.loadAtOnce) {
							self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.resizable" + self.minSuffix + ".js" ]);
						}
						if (!ro) {
							ro = eval("( " + ros + " )");
						} else {
							ro = {};
						}
						ro.start = self.pubTops($elem, o.onalw,	o.resizableonstarttopics);
						ro.stop = self.pubTops($elem, o.onalw, o.resizableonstoptopics);
						ro.resize = self.pubTops($elem, o.onalw, o.resizableonresizetopics);
						$elem.jqGrid('gridResize', ro);
					}
				}
				if (o.ongridcompletetopics) {
					self.publishTopic($elem, o.onalwaystopics, {});
					self.publishTopic($elem, o.ongridcompletetopics, {});
				}
			};
	
			if (o.onfocustopics) {
				params.beforeSelectRow = function(rowid, e) {
	
					var orginal = {};
					orginal.rowid = rowid;
					orginal.e = e;
	
					self.publishTopic($elem, o.onalw, orginal);
					self.publishTopic($elem, o.onfocustopics, orginal);
				};
			}
	
			if (o.reloadtopics) {
				$.each(o.reloadtopics.split(','), function(i, rts) {
					$elem.subscribe(rts, '_s2j_reloadgrid', o);
				});
			}
			if (!params.loadtext && self.defaults.loadingText !== null) {
				params.loadtext = self.defaults.loadingText;
			}

			params.loadComplete = self.pubCom($elem, o.onalw, o.oncom, null,
					null, o);
			params.loadError = self
					.pubErr($elem, o.onalw, o.onerr, o.errortext);

			if (o.grouping) {
				self.require("js/plugins/grid.grouping.js");
			}

			if (o.editurl) {
				self.require("js/plugins/grid.filter.js");
				self.require("js/plugins/grid.formedit.js");
				if (o.editinline) {
					self.require("js/plugins/grid.inlinedit.js");
				}
			}

			if (o.cellurl) {
				self.require("js/plugins/grid.celledit.js");
			}

			if (o.navigator) {
				self.require("js/plugins/grid.formedit.js");
			}

			if (o.navigatorsearch) {
				self.require("js/plugins/grid.filter.js");
			}
			
			if (o.subgrid) {
				self.require("js/plugins/grid.subgrid.js");
				params.subGrid = true;

				// gridview can't be true when using the subgrid feature
				params.gridview = false;
				params.subGridRowExpanded = function(subgrid_id, row_id) {
					
					var orginal = {},
						so = o.subgridoptions,
						subgridtableid = subgrid_id.replace(/(:|\.)/g, '\\$1') + "_table",
						subgrid = $(self.escId(subgrid_id)),
						subgridhtml = "<table id='" + subgridtableid + "' class='scroll'></table>",
						to = so.url.indexOf('?');
					
					orginal.proceed = true;
					
					if(o.onsgrowexpanded){
						orginal.row_id = row_id;
						orginal.subgrid_id = subgrid_id;
		
						self.publishTopic($elem, o.onalw, orginal);
						self.publishTopic($elem, o.onsgrowexpanded, orginal);
					}
					row_id = escape(row_id);
					if(orginal.proceed) {
						if ((so.pager && so.pager !== "") || so.navigator) {
							subgridhtml = subgridhtml + "<div id='" + subgrid_id.replace(/(:|\.)/g, '\\$1')+ "_pager'></div>";
							so.pager = subgrid_id.replace(/(:|\.)/g, '\\$1') + "_pager";
							so.navigatoraddoptions = $.extend(true,so.navigatoraddoptions||{}, {editData:{rowid:row_id}});
							so.navigatoreditoptions = $.extend(true,so.navigatoreditoptions||{}, {editData:{rowid:row_id}});
							so.navigatordeleteoptions = $.extend(true,so.navigatordeleteoptions||{}, {delData:{rowid:row_id}});
						}
						
						$.each(so.colModel, function(i, col) {
							if(col.editoptions && col.editoptions.dataUrl){
								if(col.editoptions.dataUrl.indexOf("rowid") > 0) {
									col.editoptions.dataUrl = self.changeParam(col.editoptions.dataUrl, "rowid", row_id);
								}
								else {
									col.editoptions.dataUrl = self.addParam(col.editoptions.dataUrl, "rowid="+row_id);
								}
							}
							if(col.searchoptions && col.searchoptions.dataUrl){
								if(col.searchoptions.dataUrlindexOf("rowid") > 0) {
									col.searchoptions.dataUrl = self.changeParam(col.searchoptions.dataUrl, "rowid", row_id);
								}
								else {
									col.searchoptions.dataUrl = self.addParam(col.searchoptions.dataUrl, "rowid="+row_id);
								}
							}
						});
						
						subgrid.html(subgridhtml);
						
						if (so.url) {
							if (to > 0) {
								so.url = so.url.substring(0, to);
							}
							so.url = so.url + "?id=" + row_id;
						}
						subgrid = $(self.escId(subgridtableid));
						so = self.parseGridParams(subgrid, so, so);
	
						subgrid.jqGrid(so);
					}
				};
			} else {
				params.gridview = true;
			}
			
			if (o.url) {
				var data = '';
				if (o.formids) {
					if (!self.loadAtOnce) {
						self.require("js/plugins/jquery.form" + self.minSuffix + ".js");
					}
					$.each(o.formids.split(','), function(i, fid) {
						var query = $(self.escId(fid)).formSerialize();
						if (data !== '') {
							data = data + '&' + query;
						} else {
							data = query;
						}
					});
				}
				params.url = self.addParam(o.url, data);
			}			
			return params;
		},
		grid : function($elem, o) {
			var self = this,
				params = {};
			self.log('grid for : ' + o.id);
			self.require("i18n/grid.locale-" + self.gridLocal + ".js",
					function() {
						$.jgrid.no_legacy_api = true;
						$.jgrid.useJSON = true;
					});
			self.require("js/plugins/jquery.jqGrid.min.js");
			self.requireCss("themes/ui.jqgrid.css");
			if(o.sortable || o.sortableRows) {
				if (!self.loadAtOnce) {
					self.require( [ "js/base/jquery.ui.widget" + self.minSuffix + ".js", "js/base/jquery.ui.mouse" + self.minSuffix + ".js", "js/base/jquery.ui.sortable" + self.minSuffix + ".js" ]);
				}
			}
			$.extend(params, o);

			$elem.data('_s2jg_init', false);
			
			params = self.parseGridParams($elem, o, params);

			$elem.jqGrid(params);
		}
	};

	// Extend it from orginal plugin
	$.extend(true, $.struts2_jquery_grid, $.struts2_jquery);
	$.struts2_jquery_grid.debugPrefix = "[struts2_jquery_grid] ";

	// Register handler for reloading grid
	$.subscribeHandler('_s2j_reloadgrid', function(event, data) {
		var s2jg = $.struts2_jquery_grid,
			o = {},
			formdata = '',
			grid;

		$.extend(o, event.data);
		if (o.id) {

			if (o.url && o.formids) {
				if (o.formids) {
					if (!s2jg.loadAtOnce) {
						s2jg.require("js/plugins/jquery.form" + s2jg.minSuffix + ".js");
					}
					$.each(o.formids.split(','), function(i, fid) {
						var query = $(s2jg.escId(fid)).formSerialize();
						if (formdata !== '') {
							formdata = formdata + '&' + query;
						} else {
							formdata = query;
						}
					});
				}
				o.url = s2jg.addParam(o.url, formdata);
			}
			grid = $(s2jg.escId(o.id));
			grid.jqGrid('setGridParam', {
				url : o.url
			});
			s2jg.log('reload grid ' + o.id);
			grid.trigger("reloadGrid");
		}
	});

})(jQuery);
