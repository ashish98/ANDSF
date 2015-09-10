<#--
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->
<#if parameters.parentTheme?if_exists == 'xhtml' || parameters.parentTheme?if_exists == 'css_xhtml' || parameters.parentTheme?if_exists == 'simple'>
	<#if parameters.parentTheme == 'xhtml'>
		<#include "/${parameters.templateDir}/xhtml/controlheader.ftl" />
	</#if>
	<#if parameters.parentTheme == 'css_xhtml'>
		<#include "/${parameters.templateDir}/css_xhtml/controlheader.ftl" />
	</#if>
	<#if parameters.inline?default(false)>
		<#include "/${parameters.templateDir}/simple/hidden.ftl" />
		<div id="${parameters.id?html}_inline"
		<#if parameters.cssStyle?if_exists != "">
		 style="${parameters.cssStyle?html}"<#rt/>
		</#if>
		<#if parameters.cssClass?if_exists != "">
		 class="${parameters.cssClass?html}"<#rt/>
		</#if>
		<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
		<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
		<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
		>
		</div>
	<#else>
		<#include "/${parameters.templateDir}/simple/text.ftl" />
	</#if>
	<#if parameters.parentTheme == 'xhtml'>
		<#include "/${parameters.templateDir}/xhtml/controlfooter.ftl" />
	</#if>
	<#if parameters.parentTheme == 'css_xhtml'>
		<#include "/${parameters.templateDir}/css_xhtml/controlfooter.ftl" />
	</#if>
<#else>
	<#if parameters.inline?default(false)>
		<#include "/${parameters.templateDir}/simple/hidden.ftl" />
		<div id="${parameters.id?html}_inline"
		<#if parameters.cssStyle?if_exists != "">
		 style="${parameters.cssStyle?html}"<#rt/>
		</#if>
		<#if parameters.cssClass?if_exists != "">
		 class="${parameters.cssClass?html}"<#rt/>
		</#if>
		<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
		<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
		<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
		>
		</div>
	<#else>
		<#include "/${parameters.templateDir}/${parameters.parentTheme}/text.ftl" />
	</#if>
</#if>
