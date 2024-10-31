// 가게 메인 사진 슬라이더 기능
let currentSlide = 0;
const slides = document.querySelectorAll('.slide');

function showSlide(index) {
    slides.forEach((slide, idx) => {
        slide.style.display = idx === index ? 'block' : 'none';
    });
}

function nextSlide() {
    currentSlide = (currentSlide + 1) % slides.length;
    showSlide(currentSlide);
}

function prevSlide() {
    currentSlide = (currentSlide - 1 + slides.length) % slides.length;
    showSlide(currentSlide);
}

// 페이지 로드 시 첫 슬라이드 보여주기
document.addEventListener('DOMContentLoaded', () => {
    showSlide(currentSlide);
});

// 찜하기 버튼 기능
let likeCount = 0;
document.getElementById('likeButton').addEventListener('click', () => {
    likeCount++;
    document.getElementById('likeCount').textContent = likeCount;
});

// 리뷰 목록 관리
let reviews = [];
let currentPage = 1;
const reviewsPerPage = 5;

// 샘플 리뷰 데이터 20개 생성
function generateSampleReviews() {
    for (let i = 1; i <= 20; i++) {
        reviews.push({
            author: `사용자${i}`,
            rating: Math.floor(Math.random() * 5) + 1,
            content: `이것은 샘플 리뷰 내용입니다. 리뷰 번호: ${i}`,
            date: `2023-10-${(i % 30) + 1}` // 임의의 날짜
        });
    }
}

// 리뷰 렌더링 함수
function renderReviews() {
    const reviewList = document.getElementById('review-list');
    reviewList.innerHTML = '';

    const startIndex = (currentPage - 1) * reviewsPerPage;
    const endIndex = startIndex + reviewsPerPage;
    const currentReviews = reviews.slice(startIndex, endIndex);

    currentReviews.forEach(review => {
        const reviewItem = document.createElement('div');
        reviewItem.classList.add('review-item');

        reviewItem.innerHTML = `
            <div class="review-header">
                <span class="review-author">${review.author}</span>
                <span class="review-rating">${'★'.repeat(review.rating)}${'☆'.repeat(5 - review.rating)}</span>
            </div>
            <div class="review-date">${review.date}</div>
            <div class="review-content">${review.content}</div>
        `;

        reviewList.appendChild(reviewItem);
    });

    renderPagination();
}

// 페이지네이션 렌더링 함수
function renderPagination() {
    const pagination = document.getElementById('pagination');
    pagination.innerHTML = '';

    const totalPages = Math.ceil(reviews.length / reviewsPerPage);

    // 이전 페이지 버튼
    if (currentPage > 1) {
        const prevButton = document.createElement('button');
        prevButton.textContent = '이전';
        prevButton.addEventListener('click', () => {
            currentPage--;
            renderReviews();
        });
        pagination.appendChild(prevButton);
    }

    // 페이지 번호 버튼
    for (let i = 1; i <= totalPages; i++) {
        const pageButton = document.createElement('button');
        pageButton.textContent = i;

        if (i === currentPage) {
            pageButton.disabled = true;
        }

        pageButton.addEventListener('click', () => {
            currentPage = i;
            renderReviews();
        });

        pagination.appendChild(pageButton);
    }

    // 다음 페이지 버튼
    if (currentPage < totalPages) {
        const nextButton = document.createElement('button');
        nextButton.textContent = '다음';
        nextButton.addEventListener('click', () => {
            currentPage++;
            renderReviews();
        });
        pagination.appendChild(nextButton);
    }
}

// 리뷰 추가 함수
function addReview() {
    const reviewerName = document.getElementById('reviewerName').value;
    const reviewRating = parseInt(document.getElementById('reviewRating').value);
    const reviewText = document.getElementById('reviewText').value;
    const reviewDate = new Date().toISOString().split('T')[0];

    const review = {
        author: reviewerName,
        rating: reviewRating,
        content: reviewText,
        date: reviewDate
    };

    // 서버로 리뷰 데이터 전송 (여기서는 샘플로 바로 추가)
    $.ajax({
        url: '/addReview',
        method: 'POST',
        data: JSON.stringify(review),
        contentType: 'application/json',
        success: function(response) {
            // 성공적으로 저장되었다면 리뷰 목록 갱신
            reviews.unshift(review); // 최신 리뷰를 앞에 추가
            renderReviews();
            // 폼 초기화
            document.getElementById('reviewForm').reset();
        },
        error: function(error) {
            console.error('리뷰 저장 실패:', error);
        }
    });
}

// 리뷰 정렬 함수
function sortReviewsByDate() {
    reviews.sort((a, b) => new Date(b.date) - new Date(a.date));
    currentPage = 1;
    renderReviews();
}

function sortReviewsByRating() {
    reviews.sort((a, b) => b.rating - a.rating);
    currentPage = 1;
    renderReviews();
}

// 초기 리뷰 로드 (샘플 데이터로 대체)
function loadReviews() {
    generateSampleReviews();
    renderReviews();
}

// 페이지 로드 시 리뷰 불러오기
document.addEventListener('DOMContentLoaded', () => {
    loadReviews();
    document.getElementById('reviewCount').textContent = reviews.length;
});

// 리뷰 작성 폼 이벤트 리스너
document.getElementById('reviewForm').addEventListener('submit', function(e) {
    e.preventDefault();
    addReview();
    document.getElementById('reviewCount').textContent = reviews.length;
});

// 네이버 지도 초기화
function initMap() {
    const map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(37.5013068, 127.0396),
        zoom: 16
    });

    const marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(37.5013068, 127.0396),
        map: map
    });
}

naver.maps.onJSContentLoaded = initMap;
