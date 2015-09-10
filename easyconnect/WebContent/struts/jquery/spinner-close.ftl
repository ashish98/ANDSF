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
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">
<script type='text/javascript'>
jQuery(document).ready(function () {
	var options_${escapedOptionId?html} = {};
	options_${escapedOptionId?html}.type = 'text';
  <#if parameters.max??>
	options_${escapedOptionId?html}.max = ${parameters.max?c};
  </#if>
  <#if parameters.min??>
	options_${escapedOptionId?html}.min = ${parameters.min?c};
  </#if>
  <#if parameters.step??>
	options_${escapedOptionId?html}.step = ${parameters.step?c};
  </#if>
  <#if parameters.prefix?if_exists != "">
	options_${escapedOptionId?html}.prefix = "${parameters.prefix?html}";
  </#if>
  <#if parameters.suffix?if_exists != "">
	options_${escapedOptionId?html}.suffix = "${parameters.suffix?html}";
  </#if>
  <#if parameters.showOn?if_exists != "">
	options_${escapedOptionId?html}.showOn = "${parameters.showOn?html}";
  </#if>
  <#if parameters.point?if_exists != "">
	options_${escapedOptionId?html}.point = "${parameters.point?html}";
  </#if>
  <#if parameters.mouseWheel?exists>
	options_${escapedOptionId?html}.mouseWheel = ${parameters.mouseWheel?string};
  </#if>
  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/action.ftl" />
  <#include "/${parameters.templateDir}/jquery/container.ftl" />
  <#include "/${parameters.templateDir}/jquery/draggable.ftl" />
  <#include "/${parameters.templateDir}/jquery/droppable.ftl" />
  <#include "/${parameters.templateDir}/jquery/resizable.ftl" />
  <#include "/${parameters.templateDir}/jquery/selectable.ftl" />
  <#include "/${parameters.templateDir}/jquery/sortable.ftl" />

  <#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });
</script>
