# yanolja_test_Android_Ator
### 2021-0814-라이징테스트 1일차
#### *기획서의 변동 사항*
1. 오늘 기획서를 서버 개발자 분과 상의를 하여 작성하였다. 소셜 로그인의 기능은 우선 순위를 뒤에 두라는 개발 리더의 피드백을 받아 기획서에 반영하였다.

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

***
### 2021-0815-라이징테스트 2일차
#### *오늘 한 일*
1. tabLayout의 indicator의 길이를 tab의 글자 길이 만큼 되도록 구현했다.
2. Horizontal과 Grid RecyclerView를 이용하여 HomeFragment의 RecommendFragment의 UI를 구현하였다.

#### *개발 도중 발생한 이슈*
1. 화면 구성이 fragment안에 fragment가 담기고 자식 뷰에서 스크롤 또는 스와핑을 진행하면 부모뷰의 fragment가 동작하는 이슈를 발견하였다. 아직 해당 오류는 처리하지 못하였다.
2. 1번과 비슷한 문제로, 자식 fragment의 viewpager를 스크롤 할 시 부모 fragment가 스와핑 되는 현상이다. 아직 처리하지 못하였다.
3. 포커싱과 스크롤을 막는 공부가 많이 필요할 듯 싶다.

#### *내일 할 일*
1. 오늘 발생항 이슈에서 생각보다 너무 많은 시간을 투자해 버렸다. 원래 목표했던 HomeFragment의 RecommendFragment를 구현해보고자 하는 목표를 달성하지 못하였기 때문에 먼저 화면을 다 만들고 포커싱에 대한 이슈를 잡아보려 한다.
2. 이슈가 빠르게 잡힌다면, 로그인과 회원가입 UI를 구현할 계획이다.




***
### 2021-0816-라이징테스트 3일차
#### *오늘 한 일*
1. Home Fragment 완성(2개의 리사이클러 뷰 , 1개의 뷰페이저, 핸들러를 이용한 광고배너 뷰페이저 자동스크롤, Imageview에 어두운 배경을 입혀 하얀 글씨가 잘 보이도록 구성)
2. chip스타일의 tabLayout과 viewPager를 연결함(단, 문제가 있음)
3. 어제의 이슈 해결


#### *개발 도중 발생한 이슈*
1. chip모양의 tabLayout과 viewPager를 연결하는 것까지는 해결하였지만, TagLayout의 TabItem들의 간격을 주는 방법을 아무리 찾아도 못찾았다. 정 안되면, chipGroup과 viewPager를 연결하는 방법으로 시도해보려 한다.


#### *지금까지의 이슈 해결*
1. 자식 view에서 수평 스크롤을 진행할 시 부모의 viewPager가 작동되던 문제가 있었다. 해결한 방법은 자식의 스크롤되는(recycler view 또는 viewPager)의 터치리스너를 이용해 터치가 될 때 부모 viewPager의 isUserEnabled를 false로 돌려 부모의 viewPager가 작동되는 문제를 막아 해결하였다. 정말 많은 시간을 잡아 먹었다..... 이 녀석 때문에 계획이 많이 꼬였다. 그래도 해결해서 다행ㅎ


#### *내일 할 일*
1. 내일은 1차 피드백이 있는 날이다. 따라서, My 야놀자 fragment와 로그인,회원가입 폼을 만들어 로그인,회원가입 API까지 적용해 보려 한다.

