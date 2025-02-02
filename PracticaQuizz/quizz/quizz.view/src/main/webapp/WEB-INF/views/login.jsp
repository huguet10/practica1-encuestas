<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
		
<c:choose>
	<c:when test="${mobile}">
	<!-- MOBILE -->
	<head>
		<title>Quizz Movember</title>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<meta name="description" content="Pantalla de acceso al sistema" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" type="text/css" href="resources/css/jquery.alerts.css">
		<link rel="stylesheet" type="text/css" href="resources/js/mobile/jquery.mobile-1.2.0.min.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/generic.css" />
		
		<script type="text/javascript" src="resources/js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.alerts.js"></script>
		<script type="text/javascript" src="resources/js/generic.js"></script>
		<script type="text/javascript" src="resources/js/mobile/jquery.mobile-1.2.0.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
		<script type="text/javascript" src="resources/js/views/login.js"></script>
	</head> 
	<body style="display:none;" onload="login.init('${GUID}');" class="mobile">
		<div data-role="page">
		
			<div data-role="header">
				<h1>Encuestas</h1>
			</div>
		
			<div data-role="content">	
				<form name='f' id='f' action="<c:url value='j_spring_security_check' />" method='POST' data-ajax="false">
					<div data-role="fieldcontain">
						<div class="login">
							<p>
								<span>Usuario:</span><input type='text' name='j_username' id='j_username' value='' class="text ui-widget-content ui-corner-all" data-mini="true" />
							</p>
							<p>
								<span>Contrase&ntilde;a:</span><input type='password' id='password' name='password' class="text ui-widget-content ui-corner-all" data-mini="true" />
								<input type='hidden' id='j_password' name='j_password' />
							</p>
							<p style="text-align:center">
								<a href="#" onclick="javascript:login.validate();" data-role="button" data-inline="true" data-icon="check" data-mini="true" title="Aceptar">Aceptar</a>
								<a href="#" onclick="javascript:$('form#f').reset();" data-role="button" data-inline="true" data-icon="delete" data-mini="true" title="Cancelar">Cancelar</a>
								<a href="#" onclick="javascript:window.location.href='home';" data-role="button" data-inline="true" data-icon="info" data-mini="true" title="An&oacute;nimo">An&oacute;nimo</a>
							</p>
						</div>
						
					</div>
				</form>
					
			</div>
		
			<div data-role="footer" style="position:absolute; bottom:0px; font-size:0.7em;width:100%;text-align:center;">
				Movember S.L [Yamaradax & Huguet Association] &#174;
			</div>
		</div>
	
	</body>
	<script type="text/javascript">
		<c:if test="${not empty error}">
		jAlert('${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}', 'Error');
		</c:if>
	</script>
	<!-- MOBILE -->
	
	
	</c:when>
	<c:otherwise>
	
	
	<!-- WEB -->
	<head>
		<title>Quizz Movember</title>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<meta name="description" content="Pantalla de acceso al sistema" />
		
		<link href="resources/css/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/generic.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/prettify.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="resources/js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.alerts.js"></script>
		<link href="resources/css/jquery.alerts.css" rel="stylesheet" type="text/css">
	    <script src="resources/js/jquery-ui-1.9.1.min.js" type="text/javascript"></script>
		<script src="resources/js/jquery.alerts.js" type="text/javascript"></script>
		<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
		<script type="text/javascript" src="resources/js/views/login.js"></script>
	</head>
	<body class="web">
		<form name='f' id='f' action="<c:url value='j_spring_security_check' />" method='POST'>
			<fieldset class="login">
				<legend>Acceso a Quizz</legend>
					<span>Usuario:</span>
					<input type='text' name='j_username' value='' class="text ui-widget-content ui-corner-all" />
					<span>Contrase&ntilde;a:</span>
					<input type='password' id='password' name='password' class="text ui-widget-content ui-corner-all" data-mini="true" />
					<input type='hidden' id='j_password' name='j_password' />
					<input type="button" id="btn_aceptar" value="Aceptar" class="btn" />
					<input name="reset" type="reset" value="Cancelar" class="btn" />
			</fieldset>
		</form>
	</body>
	<script type="text/javascript">
		<c:if test="${not empty error}">
		jAlert('${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}', 'Error');
		</c:if>
		<c:if test="${noAccess}">
		jAlert('No tiene acceso a la administraci&oacute;n del sistema', 'Acceso prohibido');
		</c:if>
		$('input#btn_aceptar').button().click(function() {
			login.validate();
		});
		$('input[type=reset]').button();
		
		var height = $('body').height;
	</script>
	<!-- WEB -->
	</c:otherwise>
</c:choose>

</html>