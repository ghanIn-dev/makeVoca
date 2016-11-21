<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>ViewWord</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


</head>
<body>


	<h1>Output jenkins check 12345</h1>

		<div class=container>
			<table class="table">

				<tr>
					<td align="center">영어</td>
					<td align="center">뜻</td>
					<td align="center">중복</td>
					<td align="center"></td>

				</tr>

					<c:forEach var="vocaList" items="${viewword}" varStatus="varStatus">
					<tr>
						<td align="center">${vocaList.voca}</td>
						<td align="center">${vocaList.mean}</td>
						<td align="center">${vocaList.count}</td>
					
					
						<td align="center"><a href="del?voca=<c:out value="${vocaList.voca}"/>"><span
								class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
					</tr>
				</c:forEach>


			</table>
		</div>





	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>