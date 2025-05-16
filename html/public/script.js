const cityDisplay = document.getElementById('city-display');

const cityNames = {
  'saopaulo': '상파울로',
  'paris': '파리',
  'sydney': '시드니',
  'capetown': '케이프타운',
  'vancouver': '벤쿠버',
  'moscow': '모스크바',
  'korea': '한국',
  'beijing': '베이징',
  'newyork': '뉴욕'
};

const cityTime = {
  'saopaulo': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/상-파울로-브라질/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>',
  'paris': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/런던-영국/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>',
  'sydney': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/시드니-오스트레일리아/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>',
  'capetown': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/희망봉/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>',
  'vancouver': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/Vancouver_CA/벤쿠버/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>',
  'moscow': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/모스크바-러시아/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>',
  'korea': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/서울/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>',
  'beijing': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/베이징-중국/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>',
  'newyork': '<iframe width="475" height="250" src="https://vclock.kr/embed/time/뉴욕-미국/#theme=0&ampm=1&showdate=1" frameborder="0" allowfullscreen></iframe>'
};

function showAlert(city) {
  alert(`${cityNames[city]}입니다.`);
}

function showModal(city) {
  // 모달 제목 설정
  document.getElementById('cityModalLabel').textContent = `${cityNames[city]} 현재 시간`;
  
  // 모달 내용에 시계 iframe 추가
  document.getElementById('cityModalBody').innerHTML = cityTime[city];
  
  // 모달 표시
  $('#cityModal').modal('show');
}

function showCityName(city) {
  cityDisplay.textContent = `${cityNames[city]}`;
}

function clearCityName() {
  const citiesInOrder = [
    '파리',
    '모스크바',
    '케이프타운',
    '한국',
    '베이징',
    '시드니',
    '뉴욕',
    '벤쿠버',
    '상파울로'
  ];
  
  cityDisplay.innerHTML = `도시에 마우스를 올려보세요<br>도시 목록: ${citiesInOrder.join(', ')}`;
}

// 폴리곤에 마우스 이벤트 리스너 추가
document.querySelectorAll('polygon').forEach(polygon => {
  polygon.addEventListener('mouseenter', () => {
    showCityName(polygon.id);
  });
  
  polygon.addEventListener('mouseleave', () => {
    clearCityName();
  });
});

// 페이지 로드시 도시 목록 표시
clearCityName();
