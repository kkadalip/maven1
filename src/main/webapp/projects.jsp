<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="imports.jsp"%>

<!DOCTYPE html>
<html lang="${language}">
<head>
<%@ include file="html_head.jsp"%>
<title>JVR | Projects</title>

<style type="text/css">
</style>

<script type="text/javascript">
	$(document).ready(function() { //window.onload = function () { 
		$("#header_li_projects").addClass("active");
	});
</script>
<!-- 
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto">
<style>
  .container {
    font-family: 'Roboto', serif;
  }
</style>
 -->
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="mainTitleProjectsContainer">
		<span class="mainTitleProjects">${fn:length(projects)} <fmt:message key="projects.main.title"/></span>
	</div>
	<div class="container">
		<c:if test="${!empty projectGroups}">
			<c:forEach items="${projectGroups}" var="projectGroup">
				<div class="projectGroupBackground">
					<div class="projectGroupTitle">
						<span><fmt:message key="${projectGroup.name}"/></span> <!-- ${projectGroup.name} -->
						<span class="projectGroupChildProjectsAmount">${fn:length(projectGroup.childProjects)}</span>
					</div>
					<c:forEach items="${projectGroup.childProjects}" var="project">
							<div class="projectBackground">
								<div class="projectLink">
									<a class="projectLink" href="<c:url value="/projects/${project.id}"/>">
										<img class="projectThumbnail" src="${pageContext.request.contextPath}/static/images/${projectGroup.imagesRootFolder}/${project.imagesRootFolder}/thumbnail.png" alt="Thumbnail">
										<span class="projectTitle"><fmt:message key="${project.name}"/></span>
										 <!-- et/projektid/projektid?action=show_project&amp;project_id=4 -->
										<span class="projectYear">${project.planningStartYear}</span>
									</a>
								</div>
							</div>
						
					</c:forEach>
				</div>
			</c:forEach>
		</c:if>
		
	
		<!-- GOOD OLD: -->
		<!-- example link: 
		<a href="et/projektid/projektid?action=show_project&amp;project_id=5">Eramute grupp Seedri ja Remmelga tänavate vahelisel alal Pärnus</a><br>
		-->
		<!-- 
		<div class="brightBackground col-md-12">
			<h3>Projektid (${fn:length(projects)})</h3><br>
			<c:if test="${!empty projectGroups}">
				<c:forEach items="${projectGroups}" var="projectGroup">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">${projectGroup.name}</h3>
							</div>
							<div class="panel-body">
									<c:forEach items="${projectGroup.childProjects}" var="project">
										<img src="<c:url value="/static/images/${projectGroup.imagesRootFolder}/${project.imagesRootFolder}/thumbnail.png"/>" alt="Thumbnail">
										<a href="<c:url value="/projects/${project.id}"/>">${project.name} (${project.planningStartYear})</a><br>
									</c:forEach>
							</div>
						</div>
				</c:forEach>
			</c:if>
		</div>
		-->
		<!-- et/projektid/projektid?action=show_project&amp;project_id=4 -->
		 
		<!-- 
		<div class="panel panel-default">
		  	<div class="panel-heading">
			  	<h3 class="panel-title">Inimesed (${fn:length(persons)})</h3>
		  	</div>
		  	<div class="panel-body">
	    		<c:forEach items="${persons}" var="item">
					<c:out value="${item.firstName} ${item.lastName}" /><br>
				</c:forEach>
		  	</div>
		</div>
		-->
		
		<!--
		<div class="panel panel-default">
		  	<div class="panel-heading">
			  	<h3 class="panel-title">Projektide grupid (${fn:length(projectGroups)})</h3>
		  	</div>
		  	<div class="panel-body">
				<c:forEach items="${projectGroups}" var="item">
					<c:out value="${item.name}" /><br>
				</c:forEach>
		  	</div>
		</div>
		-->
		 
		<!--
		<c:forEach items="${projects}" var="project">
			<div class="panel panel-default">
			  	<div class="panel-heading">
				  	<h3 class="panel-title"><b><c:out value="${project.name}" /></b></h3>
			  	</div>
	  		  	<div class="panel-body">
					id: ${project.id}<br>
					grupp: ${project.projectGroup.name}<br>
					aadresse on ${fn:length(project.addresses)} tükki<br>
					<c:forEach items="${project.addresses}" var="address">
						aadress: ${address.city}, ${address.street} ${address.streetType} ${address.building}
						<br>
					</c:forEach>
					<c:if test="${!empty project.planningStartYear}">
						projekt: ${project.planningStartYear}<c:if test="${!empty project.planningEndYear}"> - ${project.planningEndYear}</c:if><br>
					</c:if>
					<c:if test="${!empty project.buildingStartYear}">
						ehitus: ${project.buildingStartYear}<c:if test="${!empty project.buildingEndYear}"> - ${project.buildingEndYear}</c:if><br>
					</c:if>
					 <c:if test="${fn:length(project.architects) > 1}">
					 	arhitektid: 
					 </c:if>
					 <c:if test="${fn:length(project.architects) == 1}">
					 	arhitekt: 
					 </c:if>
					<c:forEach items="${project.architects}" var="architect" varStatus="loop">
						 ${architect.firstName} ${architect.lastName}${loop.last ? '<br>' : ','} 
					</c:forEach>
					<c:forEach items="${project.originalAuthors}" var="originalAuthor">
						hoone algne autor: ${originalAuthor.firstName} ${originalAuthor.lastName}
						<br>
					</c:forEach>
					<c:if test="${!empty project.contributors}">
						kaastöö: 
						<c:forEach items="${project.contributors}" var="contributor" varStatus="loop">
							${contributor.firstName} ${contributor.lastName}${loop.last ? '<br>' : ','} 
						</c:forEach>
					</c:if>
					<c:if test="${!empty project.constructors}">
						 <c:if test="${fn:length(project.constructors) > 1}">
						 	konstruktorid: 
						 </c:if>
						 <c:if test="${fn:length(project.constructors) == 1}">
						 	konstruktor: 
						 </c:if>
						<c:forEach items="${project.constructors}" var="constructor" varStatus="loop">
							${constructor.firstName} ${constructor.lastName}${loop.last ? '<br>' : ','}
						</c:forEach>
					</c:if>
					<c:forEach items="${project.interiorDesigners}" var="interiorDesigner">
						sisekujundaja: ${interiorDesigner.firstName} ${interiorDesigner.lastName}
						<br>
					</c:forEach>
					<c:forEach items="${project.landscapeArchitects}" var="landscapeArchitect">
						maastikuarhitekt: ${landscapeArchitect.firstName} ${landscapeArchitect.lastName}
						<br>
					</c:forEach>
					<c:forEach items="${project.lightsDesigners}" var="lightsDesigner">
						sisekujundaja: ${lightsDesigner.firstName} ${lightsDesigner.lastName}
						<br>
					</c:forEach>
					<c:if test="${!empty project.sizeQuantity}">
						üldpind: ${project.sizeQuantity}m<sup>2</sup><c:if test="${!empty project.apartmentsQuantity}">, ${project.apartmentsQuantity} korterit</c:if><br>
					</c:if>
					<c:if test="${!empty project.prizeComment}">
						preemia: ${project.prizeComment}<br>
					</c:if>
				</div>
			</div>
			<br>
		</c:forEach>
		<br>
		 -->
		 
 		<!-- 
		scheme: ${scheme}<br>
		serverName: ${serverName}<br>
		serverPort: ${serverPort}<br>
		pathInfo: ${pathInfo}<br>
		servletPath: ${servletPath}<br>
		contextPath: ${contextPath}<br>
		host: ${host}<br>
		url: ${url}<br>
		uri: ${uri}<br>
		
		Selected project:<br>
		${selectedProject.id}<br>
		${selectedProject.name}<br>
		 -->
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>