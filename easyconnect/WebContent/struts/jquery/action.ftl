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
  <#if parameters.targets?if_exists != "">
	options_${escapedOptionId?html}.targets = "${parameters.targets?html}";
  </#if>
  <#if parameters.hrefUrl?if_exists != "">
	options_${escapedOptionId?html}.href = "${parameters.hrefUrl?html}";
  <#else>
	options_${escapedOptionId?html}.href = "#";
  </#if>
  <#if parameters.hrefParameter?if_exists != ""> 
	options_${escapedOptionId?html}.hrefparameter = "${parameters.hrefParameter?string}";
  </#if>
  <#if parameters.formIds?exists>
	options_${escapedOptionId?html}.formids = "${parameters.formIds?html}";
  </#if>
  <#if parameters.onClickTopics?exists>
	options_${escapedOptionId?html}.onclick = "${parameters.onClickTopics?html}";
  </#if>
  <#if parameters.indicator?exists>
	options_${escapedOptionId?html}.indicatorid = "${parameters.indicator?html}";
  </#if>
  <#if parameters.loadingText?exists>
	options_${escapedOptionId?html}.loadingtext = "${parameters.loadingText?html}";
  </#if>
  <#if parameters.errorText?exists>
	options_${escapedOptionId?html}.errortext = "${parameters.errorText?html}";
  </#if>
  <#if parameters.errorElementId?exists>
	options_${escapedOptionId?html}.errorelementid = "${parameters.errorElementId?html}";
  </#if>
  <#if parameters.dataType?exists>
	options_${escapedOptionId?html}.datatype = "${parameters.dataType?html}";
  </#if>
  <#if parameters.requestType?exists>
	options_${escapedOptionId?html}.requesttype = "${parameters.requestType?html}";
  </#if>
  <#if parameters.effect?exists>
	options_${escapedOptionId?html}.effect = "${parameters.effect?html}";
	<#if parameters.effectDuration?exists>
	options_${escapedOptionId?html}.effectduration = ${parameters.effectDuration?html};
	</#if>  
	<#if parameters.effectMode?exists>
	options_${escapedOptionId?html}.effectmode = "${parameters.effectMode?html}";
	</#if>  
	<#if parameters.effectOptions?exists>
	options_${escapedOptionId?html}.effectoptions = ${parameters.effectOptions?html};
	<#else>
	options_${escapedOptionId?html}.effectoptions = {};
	</#if>  
  </#if>  
  <#if parameters.timeout?exists>
	options_${escapedOptionId?html}.timeout = ${parameters.timeout?html};
  </#if>
  <#if parameters.listenTopics?exists>
	options_${escapedOptionId?html}.listentopics = "${parameters.listenTopics?html}";
  </#if>
  <#if parameters.onEffectCompleteTopics?exists>
	options_${escapedOptionId?html}.oneffect = "${parameters.onEffectCompleteTopics?html}";
  </#if>
   <#if parameters.clearForm?default(false)>
	options_${escapedOptionId?html}.clearform = true;
    </#if>
   <#if parameters.resetForm?default(false)>
	options_${escapedOptionId?html}.resetform = true;
    </#if>
   <#if parameters.iframe?default(false)>
	options_${escapedOptionId?html}.iframe = true;
    </#if>
   <#if parameters.replaceTarget?default(false)>
	options_${escapedOptionId?html}.replaceTarget = true;
    </#if>
