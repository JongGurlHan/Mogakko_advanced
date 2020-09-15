<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<c:set var = 'root' value = "${pageContext.request.contextPath}/"/>
    
    
<!-- 상단 메뉴 부분 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top shadow-lg">
	
	<a class="navbar-brand" href="${root}">mogakko</a> 
	
	<!-- 동적메뉴구성 -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
	        data-target="#navMenu">
		<span class="navbar-toggler-icon"></span>        
	</button>
	
	<div class="collapse navbar-collapse" id="navMenu">
		<ul class="navbar-nav">		
			<li class="nav-item">
				<a href="${root}main/main_map" class="nav-link">지도로 보기</a>
			</li> 
			<li class="nav-item">
				<a href="${root}main/main_bulletin" class="nav-link">게시판으로 보기</a>
			</li> 
		</ul>	
		
		
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a href="${root}board/write?board_info_idx=1" class="nav-link">모각코만들기</a>
			</li>		
		
			<c:choose>
				<c:when test="${loginUserBean.userLogin == true }">
					<li class="nav-item">
						<a href="${root}user/modify" class="nav-link">정보수정</a>
					</li>
					<li class="nav-item">
						<a href="${root}user/logout" class="nav-link">로그아웃</a>
					</li>			
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a href="${root}user/login" class="nav-link">로그인</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
		
	</div>
</nav>

<div class="inner-container">