<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<link rel="stylesheet"
	href="CSS/tooltip.css">
 <script src="JS/DeltagerValidator.js" defer></script>		
 
<title>Påmelding</title>
</head>
<body>
	
	<h2>Påmelding til Fest</h2> 
	<form  name="form" method="post" class="pure-form pure-form-aligned" action="PaameldingServlet">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text" onkeyup="fornavnSjekk();" 
					name="fornavn" value="${fornavn}" /> 
					<font color="red">${fornavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text" onkeyup="etternavnSjekk();"
					name="etternavn" value="${etternavn}" /> 
					<font color="red">${etternavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text" onkeyup="mobilSjekk();"
					name="mobil" value="${mobil}" /> 
					<font color="red">${mobilFeilmelding}</font>					
			</div>
			
			<div class="pure-control-group tooltip">
				<label for="password">Passord:</label> <input type="password" onkeyup="passordSjekk();"
					name="passord" value="${passord}" /> 
					
					 <span class="tooltiptext">Passord Regler: <br>
                        <span style="color: #ff0000">Rød(Svak)</span> : Inneholder bare små bokstaver. <br>
                        <span style="color: #FFFF00">Gul(Middels)</span>: Inneholder små og store bokstaver, men ingen tall eller spesialtegn. <br>
                        <span style="color: #00FF00">Grønn(Sterk)</span>: Inneholder små og store bokstaver, i tillegg til tall og/eller spesialtegn
                </span>					
					<font color="red">${passordFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input onkeyup="passordRepetertSjekk();"
					type="password" name="passordRepetert"
					value="${passordRepetert}" /> 
					<font color="red">${passordRepetertFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann"
					 />mann
				<input type="radio" name="kjonn" value="kvinne"
					 />kvinne
				<font color="red">${kjonnFeilmelding}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
</body>
</html>