<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="account-settings" class="section">
    	<div class="email-info">
            <h3>이메일 정보</h3>
            <input type="email" value="whdid3766@gmail.com" readonly>
            <button class="email-verify-button">이메일 인증</button>
            <p>이메일 변경은 변경한 이메일로 인증 요청 메일이 발송되고 해당 이메일을 통해 인증을 정상적으로 완료한 후 최종적으로 반영됩니다.</p>
         </div>

         <div class="social-connect">
             <h3>소셜계정 연동</h3>
             <p>사용하시는 소셜 및 인증 제공자들과 계정을 연동하고 손쉽게 로그인하세요.</p>
             <div class="social-connect-buttons">
                 <button>카카오 연결하기</button>
                 <button>구글 연결하기</button>
                 <button>메타 연결하기</button>
                 <button>네이버 연결하기</button>
             </div>
         </div>

         <div class="security-settings">
             <h3>비밀번호설정</h3>
             <div class="security-setting-item">
             	<label for="current_password">현재 비밀번호</label>
              <input type="text" id="current_password">
                 
              <label for="new_password">새 비밀번호</label>
              <input type="text" id="new_password">

              <label for="new_password_verify">비밀번호 확인</label>
              <input type="text" id="new_password_verify">
                 <button>수정</button>
             </div>
         </div>
	</div>
</body>
</html>