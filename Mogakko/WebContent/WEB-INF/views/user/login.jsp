<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %> 
<c:set var = 'root' value = "${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>프로젝트-moggak</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<!-- 구글 로그인 관련 -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script>
	function init() {
		  console.log('init');
	  gapi.load('auth2', function() {
		  console.log('auth2');
	  var gauth = gapi.auth2.init({
		  client_id:'979152736167-8qsgm0f60l99ut8d2n2vav23atg9532j.apps.googleusercontent.com'
	 	 })
	  gauth.then(function(){
		  console.log('googleAuth success');		  
	  }, function(){
		  console.log('googleAuth fail');		  
		   
	  	});
	  
	  });
	}

	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	}
</script>

<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>

</head>
<body>

<c:import url = "/WEB-INF/views/include/top_menu.jsp"/>	 

<div class="container" style="margin-top:100px; margin-bottom:150px;">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<c:if test="${fail==true}">
						<div class="alert alert-danger">
							<h3>로그인 실패</h3>
							<p>아이디 비밀번호를 확인해주세요</p>
						</div>		
					</c:if>			
					<form:form action="${root}user/login_pro" method = "post" modelAttribute="temLoginUserBean">
						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<form:input path="user_id" class="form-control"/>	
							<form:errors path="user_id" style ='color:red'/>						
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class="form-control"/>	
							<form:errors path="user_pw" style ='color:red'/>							
						</div>
						<div class="form-group text-right">
							<form:button class="btn btn-primary">로그인</form:button>
							<a href="${root }user/join" class="btn btn-danger">회원가입</a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<c:import url = "/WEB-INF/views/include/bottom_info.jsp"/>	

</body>
</html>








