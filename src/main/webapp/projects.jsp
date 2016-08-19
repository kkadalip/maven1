<%@ include file="imports.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="html_head.jsp"%>
<title>JVR | Projects</title>

<style type="text/css">
</style>

<script type="text/javascript">
	$(document).ready(function() { //window.onload = function () { 
		$("#header_li_projects").addClass("active");
	});
</script>
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="container">	
		<!-- <h3>PROJECT GROUPS AND LINKS:</h3> -->
		<!-- example link: 
		<a href="et/projektid/projektid?action=show_project&amp;project_id=5">Eramute grupp Seedri ja Remmelga t�navate vahelisel alal P�rnus</a><br>
		-->
		<c:if test="${!empty projectGroups}">
			<c:forEach items="${projectGroups}" var="projectGroup">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">${projectGroup.name}</h3>
						</div>
						<div class="panel-body">
								<c:forEach items="${projectGroup.childProjects}" var="project">
									<a href="<c:url value="/projects/${project.id}"/>">${project.name}</a><br> <!-- et/projektid/projektid?action=show_project&amp;project_id=4 -->
								</c:forEach>
						</div>
					</div>
			</c:forEach>
		</c:if>
		
		<div class="panel panel-default">
		  	<div class="panel-heading">
			  	<h3 class="panel-title">People (${fn:length(persons)})</h3>
		  	</div>
		  	<div class="panel-body">
	    		<c:forEach items="${persons}" var="item">
					<c:out value="${item.firstName} ${item.lastName}" /><br>
				</c:forEach>
		  	</div>
		</div>
		
		<div class="panel panel-default">
		  	<div class="panel-heading">
			  	<h3 class="panel-title">Project Groups (${fn:length(projectGroups)})</h3>
		  	</div>
		  	<div class="panel-body">
				<c:forEach items="${projectGroups}" var="item">
					<c:out value="${item.name}" /><br>
				</c:forEach>
		  	</div>
		</div>
		
		<div class="panel panel-default">
		  	<div class="panel-heading">
			  	<h3 class="panel-title">Projects (${fn:length(projects)})</h3>
		  	</div>
		  	<div class="panel-body">
				body
		  	</div>
	  	</div>
		
		<!--
		<c:forEach items="${projects}" var="project">
			<div class="panel panel-default">
			  	<div class="panel-heading">
				  	<h3 class="panel-title"><b><c:out value="${project.name}" /></b></h3>
			  	</div>
	  		  	<div class="panel-body">
					id: ${project.id}<br>
					grupp: ${project.projectGroup.name}<br>
					aadresse on ${fn:length(project.addresses)} t�kki<br>
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
						kaast��: 
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
						�ldpind: ${project.sizeQuantity}m<sup>2</sup><c:if test="${!empty project.apartmentsQuantity}">, ${project.apartmentsQuantity} korterit</c:if><br>
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