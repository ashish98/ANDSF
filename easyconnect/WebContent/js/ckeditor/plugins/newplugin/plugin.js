
var strings = [];
var smsTemplateLanguages = [];

function setArray(arr){
	strings = arr;
}

function setSMSTemplateLanguages(languagearr){
	smsTemplateLanguages = languagearr;
}

(function(){
	var o = { exec:function(p){
				 var p={};
				 url="GetSomeData.js";
				 $.post(url,p,function(response){
						response=eval(response);
						if(editorInstance){
						//CKEDITOR.instances[editorInstance.name].insertHtml(response[0].value+'<br/>');
						editorInstance.insertHtml(response[0].value+'<br/>');
						}
						else
							alert(response[0].value);
				});
			}
	};
	
	CKEDITOR.plugins.add('newplugin',{
					init:function(editor){
						/*editor.addCommand('newplugin',o);
						editor.ui.addButton('newplugin',{label:'My New Plugin',icon:this.path+'newplugin.png',command:'newplugin'});						
						if(editor.addMenuItems)editor.addMenuItem("newplugin",{label:'New Plugin',command:'newplugin',group:'clipboard',order:9});						
						if(editor.contextMenu)editor.contextMenu.addListener(function(){
							return { "newplugin": CKEDITOR.TRISTATE_OFF};
						});*/
																		
						// add the menu to the editor
						/*editor.ui.addRichCombo('webin',
						{
							label: 		'Select Tag',
							title: 		'Select Tag',							
							voiceLabel: '-Select Tag-',
							className: 	'cke_format',
							order:9,
							multiSelect:false,
							panel:
							{
								css: [ editor.config.contentsCss, CKEDITOR.skin.getPath('editor') ],
								voiceLabel: editor.lang.panelVoiceLabel
							},

							init: function()
							{
								this.startGroup( "Insert Content" );
								for (var i in strings)
								{
									this.add(strings[i][0], strings[i][1], strings[i][2]);
								}
							},

							onClick: function( value )
							{
								editor.focus();
								editor.fire( 'saveSnapshot' );
								editor.insertHtml(value);
								editor.fire( 'saveSnapshot' );
							}
						});
						*/
						if(smsTemplateLanguages != null && smsTemplateLanguages.length > 0){
							editor.ui.addRichCombo('webinTemplateLanguage',
							{
								label: 		'Language',
								title: 		'Language',							
								voiceLabel: '-Language-',
								className: 	'cke_format',
								order:9,
								multiSelect:false,
								panel:
								{
									css: [ editor.config.contentsCss, CKEDITOR.skin.getPath('editor') ],
									voiceLabel: editor.lang.panelVoiceLabel
								},
	
								init: function()
								{
									this.startGroup( "Insert Content" );
									for (var i in smsTemplateLanguages)
									{
										this.add(smsTemplateLanguages[i][0], smsTemplateLanguages[i][1], smsTemplateLanguages[i][2]);
									}
								},
	
								onClick: function( value )
								{
									editor.focus();
									editor.fire( 'saveSnapshot' );
									editor.insertHtml(value);
									editor.fire( 'saveSnapshot' );
								}
							});
						}
				}
	});
})();