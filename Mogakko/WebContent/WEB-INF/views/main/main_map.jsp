<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<c:set var = 'root' value = "${pageContext.request.contextPath}/"/>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
	<title>프로젝트-mogak</title>
	<!-- Bootstrap CDN -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<style>	
	  body{
	 	padding-top: 70px;
	 	
	 	} 
	 </style>
	<title>프로젝트-mogak</title>
</head>

<body>	
	<c:import url = "/WEB-INF/views/include/top_menu.jsp"/>	
	

	<div id="map" style="width:100%;height:100vh;"></div>

	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8099663361f4953ff78764c9fff573c5&libraries=clusterer"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(37.555155, 126.970554), // 지도의 중심좌표
		        level: 6, // 지도의 확대 레벨
		        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
		    }; 

		// 지도를 생성한다 
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
	    // 마커 클러스터러를 생성합니다 
	    var clusterer = new kakao.maps.MarkerClusterer({
	        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
	        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
	        minLevel: 10 // 클러스터 할 최소 지도 레벨 
	    });
		
		var data = [
			[37.555155, 126.970554, '<div style="padding: 5px">내용</div>'],
			[37.559238, 126.979363, '<div style="padding: 5px">내용2</div>'],
			[37.565702, 126.977800, '<div style="padding: 5px">내용3</div>'],
		]
		
		var markers =[];
		for(var i =0; i<data.length; i++){
			
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
			    position: new kakao.maps.LatLng(data[i][0], data[i][1] ),
			    map: map //마커를 표시할 지도 객체
			});
			
			
		
				
			// 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({		    
			    content : data[i][2] 
			});
			  
			markers.push(marker); // 매번 생성된 마커들이 markers라는 변수 안에 들어가게 된다. 
						
			// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		    kakao.maps.event.addListener(
		    		marker, 
		    		'mouseover', 
		    		makeOverListener(map, marker, infowindow)
		    		);
		    kakao.maps.event.addListener(
		    		marker, 
		    		'mouseout', 
		    		makeOutListener(infowindow)
		    		);
		}
		
		//클러스터러에 마커들을 추가합니다.
		clusterer.addMarkers(markers);		

		 // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	    function makeOverListener(map, marker, infowindow) {
	        return function() {
	            infowindow.open(map, marker);
	        };
	    }

	    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	    function makeOutListener(infowindow) {
	        return function() {
	            infowindow.close();
	        };
	    }
	</script>
	
	
	
	
	


	

	
	
</body>

</html>




























