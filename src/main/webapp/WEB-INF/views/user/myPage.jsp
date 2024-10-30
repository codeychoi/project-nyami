<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>페이지 이름</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script>
        function openTab(event, tabName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("section");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tab");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(tabName).style.display = "block";
            event.currentTarget.className += " active";
        }

        document.addEventListener("DOMContentLoaded", function() {
            document.getElementById("defaultTab").click();
        });
    </script>
</head>
<body>
    <div class="container">
        <!-- 헤더 부분 -->
        <div class="header">
            <h2>마이페이지</h2>
            <button class="logout-button">로그아웃</button>
        </div>

        <div class="content">
            <!-- 사이드바: 프로필 사진과 이름 표시 -->
            <div class="sidebar">
                <div class="profile-pic"></div>
                <div class="profile-name">야미</div>
                <br><br>
                <div><button class="upload-button">사진 업로드</button></div>
            </div>

            <!-- 메인 콘텐츠 부분 -->
            <div class="main-content">
                <!-- 탭 메뉴 -->
                <div class="tabs">
                    <button class="tab" id="defaultTab" onclick="openTab(event, 'my-check')">내 활동</button>
                    <button class="tab" onclick="openTab(event, 'profile')">프로필</button>
                    <button class="tab" onclick="openTab(event, 'account-settings')">계정 정보</button>
                </div>
                
                <div class="expanded-content">
	                <!-- 내 활동 섹션 -->
	                <jsp:include page="myCheck.jsp" />
	                <!-- 프로필 섹션 -->
	    			<jsp:include page="profile.jsp" />
	    			<!-- 계정 정보 섹션 -->
	    			<jsp:include page="accountSettings.jsp" />    
                </div>
            </div>
        </div>
    </div>
</body>
</html>