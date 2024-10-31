<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" href="css/yunyoung.css">
</head>
<body>
<div class="login-container">
    
    <button type="button"  class="gosignup-button">
    <a href="signUp.do" class="no-underline" >
    회원가입
    </a>
    </button>
    
  <div class="login-header">
    <h1 class="login-logo">Login</h1>
  </div>
  
  <form class="login-form" method="post" action="login_ok.do">
    <input type="text" placeholder="아이디" id="userid" name="userid">
    <input type="password" placeholder="비밀번호" id="userpwd" name="userpwd">
    <button type="submit" >로그인</button>
    <div class="social-buttons">
      <button type="button" >네이버 간편 로그인</button>
      <button type="button" >구글 간편 로그인</button>
    </div>
    <br>
    <a href="findPwd.do" class="forgot-password">비밀번호 찾기</a>
  </form>

</div>
</body>
</html>