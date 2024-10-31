// 슬라이드 인덱스 초기화
let slideIndex = 0;

// 슬라이드 자동 전환 함수
function showSlides() {
    const slidesContainer = document.querySelector('.slider-container');
    slideIndex++;

    // 두 개씩 보이는 슬라이드를 반복해서 넘기도록 설정
    if (slideIndex >= 2) { // 슬라이드의 총 그룹 수에 따라 반복 설정
        slideIndex = 0;
    }

    // 슬라이드 이동
    slidesContainer.style.transform = `translateX(-${slideIndex * 50}%)`;
}

// 3초마다 슬라이드 전환
setInterval(showSlides, 6000);