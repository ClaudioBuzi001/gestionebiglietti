<!doctype html>
<%@page import="it.prova.gestionebiglietti.model.Biglietto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Delete Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Confermi eleminazione?</h5>
					    </div>
					     <c:set var="bigliettoInPagina" value="${biglietto_eliminare}"/>
					     
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Provenienza</dt>
							  <dd class="col-sm-9">${bigliettoInPagina.provenienza}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Destinazione:</dt>
							  <dd class="col-sm-9">${bigliettoInPagina.destinazione}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9">${bigliettoInPagina.prezzo}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data:</dt>
							  <dd class="col-sm-9"><fmt:formatDate pattern="dd-MM-yyyy" value="${bigliettoInPagina.data }"/></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					    
						    <form method="post" action="ExecuteDeleteArticoloServlet" >
								<input type="hidden" name="idBiglietto" value="${bigliettoInPagina.id }"> 
						        <a href="ExecuteListBigliettiServlet" class='btn btn-outline-secondary' style='width:80px'>
						            <i class='fa fa-chevron-left'></i> Back
						        </a>
						        <button type="submit" name="deleteSubmiut" value="deleteSubmiut" id="deleteSubmiut" class="btn btn-primary">Conferma</button>
						        
					        </form>
					    </div>
					    
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>