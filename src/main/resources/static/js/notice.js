$(() => {
    // 공지 작성 버튼 클릭하면 실행
    $('#write-notice-btn').on('click', () => {
        const category = $('#category').val();
        const title = $('#title').val();
        const content = $('#content').val();

        // 유효성 검증
        if (!category || !title || !content) {
            alert('모든 항목을 입력하세요.');
            return;
        }
        
        const notice = {
            category: category,
            title: title,
            content: content
        };

        $.ajax({
            url: '/notices',
            type: 'POST',
            data: JSON.stringify(notice),
            contentType: 'application/json',
            success: () => {
                alert('공지를 작성하였습니다.');
                location.href = '/notices';
            },
            error: (xhr, status, error) => {
                alert(`공지 작성 실패: ${error}`);
            }
        });
    });
});