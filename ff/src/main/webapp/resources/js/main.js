window.onload = function () {
	const slide_wrap = document.querySelector('.slide_wrap');
	const slider_box = slide_wrap.querySelector('.slider_box');
	const slider = slide_wrap.querySelector('.slider');
	const slideLis = slider.querySelectorAll('li');
	const nextButton = slide_wrap.querySelector('.arrow .next');
	const prevButton = slide_wrap.querySelector('.arrow .prev');
	const topButton = document.getElementById('topBtn');

	/* 클론 */
	const cloneFirst = slideLis[0].cloneNode(true);
	const cloneLast = slideLis[slideLis.length - 1].cloneNode(true);
	slider.insertBefore(cloneLast, slideLis[0]);
	slider.appendChild(cloneFirst);

	/* 주요 변수 초기화 */
	let currentIdx = 1;
	let translate = -slideLis[0].clientWidth;
	const speedTime = 500;
	let autoSlideInterval;

	/* CSSOM 셋업 */
	const sliderCloneLis = slider.querySelectorAll('li');
	const liWidth = slideLis[0].clientWidth;
	const sliderWidth = liWidth * sliderCloneLis.length;
	slider.style.width = `${sliderWidth}px`;
	slider.style.transform = `translateX(${translate}px)`;

	/* 리스너 설치하기 */
	nextButton.addEventListener('click', moveSlide);
	prevButton.addEventListener('click', moveSlide);

	/* 슬라이드 실행 */
	function move(D) {
		currentIdx += D;
		translate += -liWidth * D;
		slider.style.transform = `translateX(${translate}px)`;
		slider.style.transition = `all ${speedTime}ms ease`;
	}

	/* 클릭 버튼 */
	function moveSlide(event) {
		event.preventDefault();
		stopAutoSlide();
		if (event.target.closest('a').classList.contains('next')) {
			move(1);
			if (currentIdx === sliderCloneLis.length - 1) {
				setTimeout(() => {
					slider.style.transition = 'none';
					currentIdx = 1;
					translate = -liWidth;
					slider.style.transform = `translateX(${translate}px)`;
				}, speedTime);
			}
		} else if (event.target.closest('a').classList.contains('prev')) {
			move(-1);
			if (currentIdx === 0) {
				setTimeout(() => {
					slider.style.transition = 'none';
					currentIdx = sliderCloneLis.length - 2;
					translate = -(liWidth * currentIdx);
					slider.style.transform = `translateX(${translate}px)`;
				}, speedTime);
			}
		}
		startAutoSlide();
	}

	function sliding() {
		move(1);
		if (currentIdx === sliderCloneLis.length - 1) {
			setTimeout(() => {
				slider.style.transition = 'none';
				currentIdx = 1;
				translate = -liWidth;
				slider.style.transform = `translateX(${translate}px)`;
			}, speedTime);
		}
	}

	function startAutoSlide() {
		stopAutoSlide(); // 먼저 멈추고 시작하여 중복 방지
		autoSlideInterval = setInterval(sliding, 2500);
	}

	function stopAutoSlide() {
		clearInterval(autoSlideInterval);
	}

	/* 마우스 오버/리브 이벤트 */
	slider_box.addEventListener('mouseenter', stopAutoSlide);
	slider_box.addEventListener('mouseleave', startAutoSlide);

	startAutoSlide();

	function navigo() {
		const header = document.querySelector('.top');
		if (!header) {
			console.error('No element with class "top" found.');
			return;
		}
		const headerHeight = header.clientHeight / 5;
		document.addEventListener('scroll', onScroll, { passive: true });
		function onScroll() {
			const scrollPosition = window.pageYOffset;
			const nav = document.querySelector('nav');
			if (headerHeight <= scrollPosition) {
				nav.classList.add('fix');
			} else {
				nav.classList.remove('fix');
			}
		}
	}
	navigo();

	/* 스크롤에 따라 topButton 보이기 */
	window.onscroll = function () {
		scrollFunction();
	};

	function scrollFunction() {
		if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
			topButton.style.display = 'block';
		} else {
			topButton.style.display = 'none';
		}
	}

	/* topButton 클릭 시 부드럽게 스크롤 맨 위로 이동 */
	topButton.onclick = function () {
		window.scrollTo({ top: 0, behavior: 'smooth' });
	};
};
