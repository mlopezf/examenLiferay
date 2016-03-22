<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>

<%@page import="com.liferay.portal.model.User"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>





<theme:defineObjects />



	<aui:layout>
	
			<c:choose>
			
				<c:when test="<%=themeDisplay.isSignedIn() %>">
				
					<table class="table table-bordered table-hover table-striped">
					
						<thead class="table-colums">
						
						
							<tr>
														
								<th>NOMBRE</th>
								
								<th>APELLIDOS</th>
								
								<th>MAIL</th>
								
								<th>FECHA DE NACIMIENTO</th>
								
								<th>ID DE USUARIO</th>
							
							</tr>
						
						</thead>
					
						<tbody class="table-data">
						
						
							<c:forEach items="<%=UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount())%>" var="usuario">
							
								<tr>
								
									<td>${usuario.getFirstName()}</td>
									
									<td>${usuario.getLastName()}</td>
									
									<td>${usuario.getEmailAddress()}</td>
									
									<td>${usuario.getBirthday()}</td>
									
									<td>${usuario.getUserId()}</td>
								
								
								
								</tr>
							
							</c:forEach>
						
						</tbody>
					
					</table>
				
				</c:when>
				
			<c:otherwise>Debe logearse para ver los usuarios</c:otherwise>
			
			</c:choose>
		
	</aui:layout>