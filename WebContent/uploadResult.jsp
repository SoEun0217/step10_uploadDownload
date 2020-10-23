<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드 결과</h1>
<h3>
작성자 : ${name} <br>
제목 :  ${subject} <br>
첨부파일 이름(fileSystemName) : ${systemfileName} <br>
첨부파일 이름(getOriginalFileName) :  ${originalFileNameme} <br>

파일 크기 : ${fileSize} , <fmt:formatNumber value="${fileSize}"></fmt:formatNumber>byte <br>
파일 저장 경로 : ${saveDir}
</h3>
</body>
</html>