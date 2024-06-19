window.onload = function() {
	const topButton = document.getElementById('topBtn');
	const nav = document.querySelector('nav');
	const header = document.querySelector('.top');

	// 요소 존재 여부 확인
	if (!topButton) {
		console.error('No element with ID "topBtn" found.');
		return;
	}
	if (!nav) {
		console.error('No element with tag "nav" found.');
		return;
	}
	if (!header) {
		console.error('No element with class "top" found.');
		return;
	}

	const headerHeight = header.clientHeight / 5;

	// 스크롤 이벤트 핸들러
	function onScroll() {
		const scrollPosition = window.pageYOffset;

		// 내비게이션 고정
		if (headerHeight <= scrollPosition) {
			nav.classList.add('fix');
		} else {
			nav.classList.remove('fix');
		}

		// topButton 표시 또는 숨기기
		if (scrollPosition > 20) {
			topButton.style.display = 'block';
		} else {
			topButton.style.display = 'none';
		}
	}

	// 스크롤 이벤트 리스너 등록
	document.addEventListener('scroll', onScroll, { passive: true });

	// topButton 클릭 시 부드럽게 스크롤 맨 위로 이동
	topButton.onclick = function() {
		window.scrollTo({ top: 0, behavior: 'smooth' });
	};
};