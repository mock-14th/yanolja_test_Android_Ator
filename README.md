# yanolja_test_Android_Ator
### 2021-0814-라이징테스트 1일차
#### *기획서의 변동 사항*
1. 오늘 기획서를 서버 개발자 분과 상의를 하여 작성하였다. 소셜 로그인의 기능은 우선 순위를 뒤에 두라는 피드백을 받아 반영하였다.

#### *서버 개발자와의 회의록*
1. 1주차에는 로그인, 회원과입과 탈퇴 API를 만들어 주신다고 하였다.
2. 나 또한, 2주차에는 많은 API를 엮을 수 있도록, 구현하고자 하는 UI를 1주차 안에 모두 구현해 두겠다고 말씀드렸다.

#### *오늘 한 일*
1. 전체적인 화면 흐름을 구상했다. 각 UI에 맞는 레이아웃과 위젯을 정리하였다.
2. 메인 화면에 BottomNavigationView를 구성하고, BottomNavigation의 자식 Fragment안에 TabLayout을 ViewPager2와 연결시켰다.
3. AppbarLayout을 이용해  스크롤를 내릴 때 Toolbar가 collapsing 되도록 구현했다.
4. 기획서를 기준으로 15%정도 완료된 것 같다.

#### *개발 도중 발생한 이슈*
1. 야놀자 앱의 화면구성이 bottomNavigation안에 tabLayout으로 되어있어 자식 fragment에서 스크롤 될 때, 부모의 toolbar가 collapsing하도록 하는 것이 어려웠다. 결국 NestedScrollView에 설정해 주던 layout_behavior속성을 viewPager2에 설정해 주면 된다는 것을 알아 해결 하였다.

#### *내일 할 일*
1. Main Activity의 BottomNavigation의 자식 중 HomeFragment를 모두 구현해 보고자 한다.
